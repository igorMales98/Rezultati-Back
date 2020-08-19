package com.scores.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FudblaskiKlub extends Klub {

    @ManyToOne
    private Liga liga;

    @OneToMany(mappedBy = "fudblaskiKlub")
    private Set<Fudbaler> fudbaleri;

}
