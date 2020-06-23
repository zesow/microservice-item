package com.gus.microservice.item.domain.entity.lol;

import lombok.Data;

@Data
public class MiniSeriesDTO {

    private int losses;
    private String progress;
    private int target;
    private int wins;
}
