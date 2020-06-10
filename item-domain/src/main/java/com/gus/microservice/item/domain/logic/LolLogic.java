package com.gus.microservice.item.domain.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gus.microservice.item.domain.spec.LolService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LolLogic implements LolService {

    private String API_KEY = "RGAPI-8e59c818-afdc-451b-8f48-d8fd8e158547";

    @Override
    public Map<String, Object> findUserMatchHistoryByUsername(String id) {

        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> result = new HashMap<>();
        result.put("returnCode", "200");
        result.put("returnMsg", "정상 처리 완료!");

        try {
            StringBuilder url = new StringBuilder();
            url
                    .append("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/")
                    .append(id)
                    .append("?api_key=")
                    .append(API_KEY);

            Request request = new Request.Builder().url(url.toString()).build();
            Response response = client.newCall(request).execute();
            String byNameString = response.body().string();

            if (response.code() == 200) {
                Map<String, String> byNameMap = mapper.readValue(byNameString, Map.class);
                String encryptedAccountId = byNameMap.get("accountId");

                url = new StringBuilder();
                url
                        .append("https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/")
                        .append(encryptedAccountId)
                        .append("?api_key=")
                        .append(API_KEY);

                request = new Request.Builder().url(url.toString()).build();
                response = client.newCall(request).execute();

                String byAccountString = response.body().string();

                if (response.code() == 200) {
                    Map<String, Object> byAccountMap = mapper.readValue(byAccountString, Map.class);
                    List<Map<String, Object>> matches = (List<Map<String, Object>>) byAccountMap.get("matches");

                    for(Map<String,Object> match : matches) {
                        Long timestamp = (Long)match.get("timestamp");
                        Date date = new Date(timestamp);
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String bb = format.format(date);

                        match.put("formattedTimestamp", bb);
                    }


                    result.put("matches", matches);
                }

            }


        } catch (IOException e) {
            result.replace("returnCode", "500");
            result.replace("returnMsg", e.getCause());
        }


        return result;
    }
}
