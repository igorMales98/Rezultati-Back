package com.scores.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FudblaskiKlub extends Klub {

    @OneToMany(mappedBy = "fudblaskiKlub")
    private Set<Fudbaler> fudbaleri;

}
