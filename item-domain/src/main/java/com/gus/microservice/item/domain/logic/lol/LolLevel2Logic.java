package com.gus.microservice.item.domain.logic.lol;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gus.microservice.item.domain.entity.lol.LeagueEntryDTO;
import com.gus.microservice.item.domain.entity.lol.MatchReferenceDto;
import com.gus.microservice.item.domain.entity.lol.MatchlistDto;
import com.gus.microservice.item.domain.entity.lol.SummonerDTO;
import com.gus.microservice.item.domain.spec.lol.LolLevel2Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class LolLevel2Logic implements LolLevel2Service {

    @Value("${apikey.lol}")
    private String API_KEY;

    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public SummonerDTO summonersByName(String id) throws ResponseStatusException, IOException {
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
        SummonerDTO summonerDTO = mapper.readValue(byNameString, SummonerDTO.class);

        return summonerDTO;
    }

    @Override
    public MatchlistDto matchlistsByAccount(String encryptedAccountId) throws ResponseStatusException, IOException {
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

        MatchlistDto matchlistDto = mapper.readValue(byAccountString, MatchlistDto.class);

        List<MatchReferenceDto> matches = matchlistDto.getMatches();

        for(MatchReferenceDto match : matches) {
            Long timestamp = match.getTimestamp();
            Date date = new Date(timestamp);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ft = format.format(date);

            match.setFormattedTimestamp(ft);
        }

        return matchlistDto;
    }

    @Override
    public Set<LeagueEntryDTO> userInfoByEncryptedSummonerId(String encryptedSummonerId) throws ResponseStatusException, IOException  {
        StringBuilder url = new StringBuilder();
        url
                .append("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/")
                .append(encryptedSummonerId)
                .append("?api_key=")
                .append(API_KEY);

        Request request = new Request.Builder().url(url.toString()).build();
        Response response = client.newCall(request).execute();

        if (response.code() != 200) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not 200 OK");
        }

        String byUserInfoString = response.body().string();

        Set<LeagueEntryDTO> leagueEntryDTOSet = mapper.readValue(byUserInfoString, Set.class);

        return leagueEntryDTOSet;
    }
}
