package com.gus.microservice.item.domain.logic.lol;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gus.microservice.item.domain.spec.lol.LolLevel2Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LolLevel2Logic implements LolLevel2Service {

    @Value("${apikey.lol}")
    private String API_KEY;

    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String summonersByName(String id) throws ResponseStatusException, IOException {
        StringBuilder url = new StringBuilder();
        url
                .append("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/")
                .append(id)
                .append("?api_key=")
                .append(API_KEY);

        Request request = new Request.Builder().url(url.toString()).build();
        Response response = client.newCall(request).execute();

        if (response.code() != 200) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not 200 OK");
        }

        String byNameString = response.body().string();
        Map<String, String> byNameMap = mapper.readValue(byNameString, Map.class);
        String encryptedAccountId = byNameMap.get("accountId");


        return encryptedAccountId;
    }

    @Override
    public List<Map<String, Object>> matchlistsByAccount(String encryptedAccountId) throws ResponseStatusException, IOException {
        StringBuilder url = new StringBuilder();
        url
                .append("https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/")
                .append(encryptedAccountId)
                .append("?api_key=")
                .append(API_KEY);

        Request request = new Request.Builder().url(url.toString()).build();
        Response response = client.newCall(request).execute();

        if (response.code() != 200) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not 200 OK");
        }

        String byAccountString = response.body().string();

        Map<String, Object> byAccountMap = mapper.readValue(byAccountString, Map.class);
        List<Map<String, Object>> matches = (List<Map<String, Object>>) byAccountMap.get("matches");

        return matches;
    }
}
