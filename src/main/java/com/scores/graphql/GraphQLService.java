package com.scores.graphql;

import com.scores.graphql.datafetcher.*;
import com.scores.model.Klub;
import graphql.GraphQL;
import graphql.TypeResolutionEnvironment;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLService {

    @Value("classpath:rezultati.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllZemljaDataFetcher allZemljaDataFetcher;

    @Autowired
    private ZemljaDataFetcher zemljaDataFetcher;

    @Autowired
    private FudbalskiKluboviDataFetcher fudbalskiKluboviDataFetcher;

    @Autowired
    private RezultatiForDateDataFetcher rezultatiForDateDataFetcher;

    @Autowired
    private BodoviDataFetcher bodoviDataFetcher;

    @Autowired
    private RezultatiForKlubDataFetcher rezultatiForKlubDataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allZemlja", allZemljaDataFetcher)
                        .dataFetcher("zemlja", zemljaDataFetcher)
                        .dataFetcher("fudbalskiKlubovi", fudbalskiKluboviDataFetcher)
                        .dataFetcher("rezultatiForDate", rezultatiForDateDataFetcher)
                        .dataFetcher("bodovi", bodoviDataFetcher)
                        .dataFetcher("rezultatiForKlub", rezultatiForKlubDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
