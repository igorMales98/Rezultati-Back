package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class InformacijaDTO {

    private Long id;
    private Set<FudbalerDTO> strelci;
    private Float posedDomacin;
    private Float posedGost;
    private Integer suteviDomacin;
    private Integer suteviGost;
}
