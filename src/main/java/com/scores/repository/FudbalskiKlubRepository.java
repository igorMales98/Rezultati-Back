package com.scores.repository;

import com.scores.model.FudblaskiKlub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FudbalskiKlubRepository extends JpaRepository<FudblaskiKlub, Long> {
    List<FudblaskiKlub> findByLigaId(Long ligaId);
}
