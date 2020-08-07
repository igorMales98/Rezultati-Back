package com.scores.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ZemljaDTO {

    private Long id;
    private String naziv;
    private Set<LigaDTO> lige;
}
