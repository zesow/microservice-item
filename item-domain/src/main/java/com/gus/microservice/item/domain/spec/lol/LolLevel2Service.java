package com.gus.microservice.item.domain.spec.lol;

import com.gus.microservice.item.domain.entity.lol.LeagueEntryDTO;
import com.gus.microservice.item.domain.entity.lol.MatchlistDto;
import com.gus.microservice.item.domain.entity.lol.SummonerDTO;

import java.io.IOException;
import java.util.Set;

public interface LolLevel2Service {

    SummonerDTO summonersByName(String id) throws IOException;

    MatchlistDto matchlistsByAccount(String encryptedAccountId) throws IOException;

    Set<LeagueEntryDTO> userInfoByEncryptedSummonerId(String encryptedSummonerId) throws IOException;
}
