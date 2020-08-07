package com.scores.repository;

import com.scores.model.Zemlja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZemljaRepository extends JpaRepository<Zemlja, Long> {
}
