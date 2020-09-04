package com.scores.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/graphql")
public class GrqphQLController {

    @Autowired
    private GraphQLService graphQLService;

    @PostMapping
    public ResponseEntity<Object> executeQuery(@RequestBody GraphQLQuery query) {
        System.out.println("e usao je i upit je " + query.toString());

        String queryWithoutParams = query.getQuery().substring(6);
        System.out.println("query bez param ke " + queryWithoutParams);

        String bezdolara = queryWithoutParams.replace("$", "");
        System.out.println("bez dolara" + bezdolara);

        if (!query.getVariables().isEmpty()) {
            for (Map.Entry<String, String> variable : query.getVariables().entrySet()) {
                bezdolara = bezdolara.replaceFirst("String", variable.getValue());
            }
        }

        System.out.println("e sad je " + bezdolara);

        if (bezdolara.contains("bodovi")) {
            bezdolara = bezdolara.substring(0, bezdolara.length() - 14);
            System.out.println("e sad je ako su bodovi " + bezdolara);
        }

        try {
            ExecutionResult executionResult = graphQLService.getGraphQL().execute("{" + bezdolara + "}");
            return new ResponseEntity<>(executionResult, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

class GraphQLQuery {

    private String operationName;
    private Map<String, String> variables;
    private String query;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Map<String, String> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, String> variables) {
        this.variables = variables;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "GraphQLQuery{" +
                "operationName='" + operationName + '\'' +
                ", variables=" + variables +
                ", query='" + query + '\'' +
                '}';
    }
}
