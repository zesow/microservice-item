package com.gus.microservice.item.domain.entity.lol;

import lombok.Data;

import java.util.List;

@Data
public class MatchlistDto {

    private int startIndex;
    private int totalGames;
    private int endIndex;
    private List<MatchReferenceDto> matches;
}
