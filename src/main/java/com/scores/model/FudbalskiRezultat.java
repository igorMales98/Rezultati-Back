package com.scores.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FudbalskiRezultat {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDateTime vremeOdrzavanjaUtakmice;

    @ManyToOne
    private FudblaskiKlub domacin;

    @ManyToOne
    private FudblaskiKlub gost;

    @ManyToOne
    private Liga liga;

    @ManyToOne
    private Sezona sezona;

    @Column
    private Short goloviDomacin;

    @Column
    private Short goloviGost;

}
