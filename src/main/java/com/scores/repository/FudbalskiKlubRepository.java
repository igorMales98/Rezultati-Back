package com.scores.repository;

import com.scores.model.FudblaskiKlub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FudbalskiKlubRepository extends JpaRepository<FudblaskiKlub, Long> {

    @Query(value = "SELECT * FROM fudblaski_klub fk WHERE fk.id IN " +
            "(SELECT fkl.fudbalski_klub_id FROM fudbalski_klub_lige fkl WHERE fkl.liga_id = :ligaId AND fkl.sezona_id = :sezonaId)", nativeQuery = true)
    List<FudblaskiKlub> findByLigaIdAndSezonaId(Long ligaId, Long sezonaId);
}
