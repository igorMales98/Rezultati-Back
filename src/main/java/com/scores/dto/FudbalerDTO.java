package com.scores.dto;

import com.scores.enummeration.PozicijaFudbal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FudbalerDTO extends IgracDTO {

    private PozicijaFudbal pozicija;

}
