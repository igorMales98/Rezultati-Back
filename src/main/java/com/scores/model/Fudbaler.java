package com.scores.model;

import com.scores.enummeration.PozicijaFudbal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Fudbaler extends Igrac {

    @Column
    @Enumerated(value = EnumType.STRING)
    private PozicijaFudbal pozicija;
}
