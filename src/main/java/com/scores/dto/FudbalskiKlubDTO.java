package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FudbalskiKlubDTO extends KlubDTO {

    private Set<LigaDTO> lige;
    private Set<FudbalerDTO> fudbaleri;
}
