package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrenerDTO {

    private Long id;
    private String ime;
    private String prezime;
    private LocalDate godinjaRodjenja;
    private ZemljaDTO zemlja;
    private SportDTO sport;
}
