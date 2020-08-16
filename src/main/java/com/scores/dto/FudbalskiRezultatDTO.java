package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FudbalskiRezultatDTO {

    private Long id;
    private LocalDateTime vremeOdrzavanjaUtakmice;
    private FudbalskiKlubDTO domacin;
    private FudbalskiKlubDTO gost;
}
