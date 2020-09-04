package com.scores.graphql.datafetcher;

import com.scores.model.FudbalskiRezultat;
import com.scores.repository.FudbalskiRezultatRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BodoviDataFetcher implements DataFetcher<Integer> {

    @Autowired
    private FudbalskiRezultatRepository fudbalskiRezultatRepository;

    @Override
    public Integer get(DataFetchingEnvironment dataFetchingEnvironment) {
        System.out.println("USAO JE U BODOVE");
        Long ligaId = Long.parseLong(dataFetchingEnvironment.getArgument("ligaId"));
        Long sezonaId = Long.parseLong(dataFetchingEnvironment.getArgument("sezonaId"));
        Long klubId = Long.parseLong(dataFetchingEnvironment.getArgument("klubId"));
        List<FudbalskiRezultat> rezultati = fudbalskiRezultatRepository.getForBodovi(ligaId,
                sezonaId, klubId);

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
}
