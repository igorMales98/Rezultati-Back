package com.scores.graphql.datafetcher;

import com.scores.model.Zemlja;
import com.scores.repository.ZemljaRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllZemljaDataFetcher implements DataFetcher<List<Zemlja>> {

    @Autowired
    private ZemljaRepository zemljaRepository;

    @Override
    public List<Zemlja> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return zemljaRepository.findAll();
    }
}
