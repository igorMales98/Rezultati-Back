package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LigaDTO {

    private Long id;
    private String naziv;
    private ZemljaDTO zemlja;
    private SportDTO sport;
}
