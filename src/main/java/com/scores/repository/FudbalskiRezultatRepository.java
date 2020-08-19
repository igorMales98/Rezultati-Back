package com.scores.repository;

import com.scores.model.FudbalskiRezultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface FudbalskiRezultatRepository extends JpaRepository<FudbalskiRezultat, Long> {

    @Query("SELECT fr FROM FudbalskiRezultat fr WHERE fr.vremeOdrzavanjaUtakmice BETWEEN ?1 AND ?2")
    List<FudbalskiRezultat> findAllForToday(LocalDateTime date1, LocalDateTime date2);

    @Query("SELECT fr FROM FudbalskiRezultat fr WHERE fr.vremeOdrzavanjaUtakmice BETWEEN ?1 AND ?2")
    List<FudbalskiRezultat> findAllForTheDate(LocalDateTime d1, LocalDateTime d2);
}
