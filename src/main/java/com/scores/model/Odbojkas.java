package com.scores.model;

import com.scores.enummeration.PozicijaOdbojka;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Odbojkas extends Igrac {

    @Column
    @Enumerated(value = EnumType.STRING)
    private PozicijaOdbojka pozicija;

    @ManyToOne
    @JoinColumn(name = "odbojkaski_klub_id")
    private OdbojkaskiKlub odbojkaskiKlub;
}
