package com.gus.microservice.item.domain.logic.lol;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import com.gus.microservice.item.domain.spec.lol.LolLevel2Service;
import com.gus.microservice.item.domain.spec.lol.LolLevel3Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LolLevel3Logic implements LolLevel3Service {

    @Autowired
    private LolLevel2Service lolLevel2Service;

//    public LolLevel3Logic(ServiceLifecycle serviceLifecycle) {
//        this.lolLevel2Service = serviceLifecycle.requestLolLevel2Service();
//    }

    @Override
    public Map<String, Object> findUserMatchHistoryByUsername(String id) {

        Map<String, Object> result = new HashMap<>();
        result.put("returnCode", "200");
        result.put("returnMsg", "정상 처리 완료!");

        try {

            String encryptedAccountId = this.lolLevel2Service.summonersByName(id);

            List<Map<String, Object>> matches = this.lolLevel2Service.matchlistsByAccount(encryptedAccountId);

            for (Map<String, Object> match : matches) {
                Long timestamp = (Long) match.get("timestamp");
                Date date = new Date(timestamp);
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String bb = format.format(date);

                match.put("formattedTimestamp", bb);
            }


            result.put("matches", matches);


        } catch (IOException e) {
            result.replace("returnCode", "500");
            result.replace("returnMsg", e.getCause());
        } catch (ResponseStatusException ex) {
            result.replace("returnCode", "500");
            result.replace("returnMsg", ex.getStatus());
        }


        return result;
    }
}
