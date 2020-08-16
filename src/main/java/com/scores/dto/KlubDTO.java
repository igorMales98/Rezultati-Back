package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KlubDTO {

    protected Long id;
    protected String naziv;
    protected ZemljaDTO zemlja;
    protected TrenerDTO trener;
}
