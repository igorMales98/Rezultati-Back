package com.scores.model;

import com.scores.enummeration.PozicijaFudbal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Fudbaler extends Igrac {

    @Column
    @Enumerated(value = EnumType.STRING)
    private PozicijaFudbal pozicija;

    @ManyToOne
    @JoinColumn(name = "fudbalski_klub_id")
    private FudblaskiKlub fudblaskiKlub;
}
