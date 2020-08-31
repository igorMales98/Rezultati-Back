package com.scores.graphql.datafetcher;

import com.scores.model.Zemlja;
import com.scores.repository.ZemljaRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZemljaDataFetcher implements DataFetcher<Zemlja> {

    @Autowired
    private ZemljaRepository zemljaRepository;

    @Override
    public Zemlja get(DataFetchingEnvironment dataFetchingEnvironment) {
        String id = dataFetchingEnvironment.getArgument("id");
        return zemljaRepository.getOne(Long.parseLong(id));
    }
}
