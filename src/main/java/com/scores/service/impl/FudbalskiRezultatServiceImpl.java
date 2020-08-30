package com.scores.service.impl;

import com.scores.model.FudbalskiRezultat;
import com.scores.repository.FudbalskiRezultatRepository;
import com.scores.service.FudbalskiRezultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class FudbalskiRezultatServiceImpl implements FudbalskiRezultatService {

    private FudbalskiRezultatRepository fudbalskiRezultatRepository;

    @Autowired
    public FudbalskiRezultatServiceImpl(FudbalskiRezultatRepository fudbalskiRezultatRepository) {
        this.fudbalskiRezultatRepository = fudbalskiRezultatRepository;
    }

    @Override
    public List<FudbalskiRezultat> getAllForToday() {

        Calendar cal = Calendar.getInstance();
        LocalDateTime d1 = getFirstDate(cal);

        LocalDateTime d2 = getSecondDate(cal);

        System.out.println("prvi datum je " + d1);
        System.out.println("prvi datum je " + d2);

        return fudbalskiRezultatRepository.findAllForToday(d1, d2);
    }

    private LocalDateTime getSecondDate(Calendar cal) {
        cal.add(Calendar.DATE, 1);

        Date date2 = cal.getTime();
        return date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private LocalDateTime getFirstDate(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date date1 = cal.getTime();
        return date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public List<FudbalskiRezultat> getAllForTheDate(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        LocalDateTime d1 = getFirstDate(cal);

        LocalDateTime d2 = getSecondDate(cal);

        System.out.println("prvi datum je " + d1);
        System.out.println("prvi datum je " + d2);

        return fudbalskiRezultatRepository.findAllForTheDate(d1, d2);
    }

    @Override
    public Integer getBodovi(Long ligaId, Long sezonaId, Long klubId) {
        List<FudbalskiRezultat> rezultati = this.fudbalskiRezultatRepository.getForBodovi(ligaId, sezonaId, klubId);
        int bodovi = 0;

        for (FudbalskiRezultat fudbalskiRezultat : rezultati) {
            if (fudbalskiRezultat.getGoloviDomacin().equals(fudbalskiRezultat.getGoloviGost())) {
                bodovi += 1;
            } else {
                if (fudbalskiRezultat.getDomacin().getId().equals(klubId) && fudbalskiRezultat.getGoloviDomacin() > fudbalskiRezultat.getGoloviGost()) {
                    bodovi += 3;
                } else if (fudbalskiRezultat.getGost().getId().equals(klubId) && fudbalskiRezultat.getGoloviGost() > fudbalskiRezultat.getGoloviDomacin()) {
                    bodovi += 3;
                }
            }
        }
        return bodovi;
    }

    @Override
    public List<FudbalskiRezultat> getRezultatiForKlub(Long ligaId, Long sezonaId, Long klubId) {
        return fudbalskiRezultatRepository.getForBodovi(ligaId, sezonaId, klubId);
    }
}
