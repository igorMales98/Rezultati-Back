package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacijaDTO {

    private Long id;
    private Float posedDomacin;
    private Float posedGost;
    private Integer suteviDomacin;
    private Integer suteviGost;
    private Integer brojZutihKartonaDomacin;
    private Integer brojZutihKartonaGost;
    private Integer brojCrvenihKartonaDomacin;
    private Integer brojCrvenihKartonaGost;
}
