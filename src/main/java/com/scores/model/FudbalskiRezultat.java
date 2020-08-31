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

    @OneToOne(mappedBy = "fudbalskiRezultat")
    private Informacija informacija;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVremeOdrzavanjaUtakmice() {
        return vremeOdrzavanjaUtakmice;
    }

    public void setVremeOdrzavanjaUtakmice(LocalDateTime vremeOdrzavanjaUtakmice) {
        this.vremeOdrzavanjaUtakmice = vremeOdrzavanjaUtakmice;
    }

    public FudblaskiKlub getDomacin() {
        return domacin;
    }

    public void setDomacin(FudblaskiKlub domacin) {
        this.domacin = domacin;
    }

    public FudblaskiKlub getGost() {
        return gost;
    }

    public void setGost(FudblaskiKlub gost) {
        this.gost = gost;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public Sezona getSezona() {
        return sezona;
    }

    public void setSezona(Sezona sezona) {
        this.sezona = sezona;
    }

    public Short getGoloviDomacin() {
        return goloviDomacin;
    }

    public void setGoloviDomacin(Short goloviDomacin) {
        this.goloviDomacin = goloviDomacin;
    }

    public Short getGoloviGost() {
        return goloviGost;
    }

    public void setGoloviGost(Short goloviGost) {
        this.goloviGost = goloviGost;
    }
}
