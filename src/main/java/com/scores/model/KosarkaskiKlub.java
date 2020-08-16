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
public class KosarkaskiKlub extends Klub {

    @OneToMany(mappedBy = "kosarkaskiKlub")
    private Set<Kosarkas> kosarkasi;

}
