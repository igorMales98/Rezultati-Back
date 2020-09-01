package com.scores.graphql.datafetcher;

import com.scores.model.FudbalskiRezultat;
import com.scores.repository.FudbalskiRezultatRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RezultatiForKlubDataFetcher implements DataFetcher<List<FudbalskiRezultat>> {

    @Autowired
    private FudbalskiRezultatRepository fudbalskiRezultatRepository;

    @Override
    public List<FudbalskiRezultat> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Long ligaId = Long.parseLong(dataFetchingEnvironment.getArgument("ligaId"));
        Long sezonaId = Long.parseLong(dataFetchingEnvironment.getArgument("sezonaId"));
        Long klubId = Long.parseLong(dataFetchingEnvironment.getArgument("klubId"));
        return fudbalskiRezultatRepository.getForBodovi(ligaId, sezonaId, klubId);
    }
}
