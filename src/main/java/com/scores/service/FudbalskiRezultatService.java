package com.scores.service;

import com.scores.model.FudbalskiRezultat;

import java.util.Date;
import java.util.List;

public interface FudbalskiRezultatService {
    List<FudbalskiRezultat> getAllForToday();
    List<FudbalskiRezultat> getAllForTheDate(Date date);

    Integer getBodovi(Long ligaId, Long sezonaId, Long klubId);
    List<FudbalskiRezultat> getRezultatiForKlub(Long ligaId, Long sezonaId, Long klubId);
}
