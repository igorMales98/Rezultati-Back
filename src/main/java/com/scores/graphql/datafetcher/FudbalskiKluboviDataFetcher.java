package com.scores.graphql.datafetcher;

import com.scores.model.FudblaskiKlub;
import com.scores.repository.FudbalskiKlubRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FudbalskiKluboviDataFetcher implements DataFetcher<List<FudblaskiKlub>> {

    @Autowired
    private FudbalskiKlubRepository fudbalskiKlubRepository;

    @Override
    public List<FudblaskiKlub> get(DataFetchingEnvironment dataFetchingEnvironment) {
        String ligaId = dataFetchingEnvironment.getArgument("ligaId");
        String sezonaId = dataFetchingEnvironment.getArgument("sezonaId");

        return fudbalskiKlubRepository.findByLigaIdAndSezonaId(Long.parseLong(ligaId), Long.parseLong(sezonaId));
    }
}
