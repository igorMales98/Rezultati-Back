package com.scores.model;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class Igrac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private LocalDate datumRodjenja;

    @ManyToOne
    private Zemlja zemljaRodjenja;
}
