package com.scores.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Informacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rezultat_id", referencedColumnName = "id")
    private FudbalskiRezultat fudbalskiRezultat;

    @Column
    private Float posedDomacin;

    @Column
    private Float posedGost;

    @Column
    private Integer suteviDomacin;

    @Column
    private Integer suteviGost;

    @Column
    private Integer brojZutihKartonaDomacin;

    @Column
    private Integer brojZutihKartonaGost;

    @Column
    private Integer brojCrvenihKartonaDomacin;

    @Column
    private Integer brojCrvenihKartonaGost;
}
