package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IgracDTO {

    protected Long id;
    protected String ime;
    protected String prezime;
    protected LocalDate datumRodjenja;
    protected ZemljaDTO zemljaRodjenja;
}
