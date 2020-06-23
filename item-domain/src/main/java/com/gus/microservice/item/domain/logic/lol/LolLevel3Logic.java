package com.gus.microservice.item.domain.logic.lol;

import com.gus.microservice.item.domain.entity.lol.LeagueEntryDTO;
import com.gus.microservice.item.domain.entity.lol.MatchlistDto;
import com.gus.microservice.item.domain.entity.lol.SummonerDTO;
import com.gus.microservice.item.domain.spec.lol.LolLevel2Service;
import com.gus.microservice.item.domain.spec.lol.LolLevel3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

            SummonerDTO summonerDTO = this.lolLevel2Service.summonersByName(id);

            MatchlistDto matchlistDto = this.lolLevel2Service.matchlistsByAccount(summonerDTO.getAccountId());

            result.put("matchlistDto", matchlistDto);


        } catch (IOException e) {
            result.replace("returnCode", "500");
            result.replace("returnMsg", e.getCause());
        } catch (ResponseStatusException ex) {
            result.replace("returnCode", "500");
            result.replace("returnMsg", ex.getStatus());
        }


        return result;
    }

    @Override
    public Map<String, Object> findUserInfo(String id) {
        Map<String, Object> result = new HashMap<>();
        result.put("returnCode", "200");
        result.put("returnMsg", "정상 처리 완료!");

        try {

            SummonerDTO summonerDTO = this.lolLevel2Service.summonersByName(id);

            Set<LeagueEntryDTO> leagueEntryDTOSet = this.lolLevel2Service.userInfoByEncryptedSummonerId(summonerDTO.getId());

            result.put("leagueEntryDTOSet", leagueEntryDTOSet);

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
