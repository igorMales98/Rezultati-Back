package com.scores.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FudblaskiKlub extends Klub {

    @ManyToMany
    @JoinTable(name = "fudbalski_klub_lige", joinColumns = @JoinColumn(name = "fudbalski_klub_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "liga_id", referencedColumnName = "id"))
    private Set<Liga> lige;

    @OneToMany(mappedBy = "fudblaskiKlub")
    private Set<Fudbaler> fudbaleri;

}
