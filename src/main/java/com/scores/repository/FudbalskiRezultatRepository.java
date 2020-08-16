package com.scores.repository;

import com.scores.model.FudbalskiRezultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FudbalskiRezultatRepository extends JpaRepository<FudbalskiRezultat, Long> {
}
