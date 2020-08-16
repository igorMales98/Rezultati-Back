package com.scores.model;

import com.scores.enummeration.PozicijaKosarka;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Kosarkas extends Igrac {

    @Column
    @Enumerated(value = EnumType.STRING)
    private PozicijaKosarka pozcija;

    @ManyToOne
    @JoinColumn(name = "kosarkaski_klub_id")
    private KosarkaskiKlub kosarkaskiKlub;
}
