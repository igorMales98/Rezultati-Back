package com.scores.graphql;

import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/graphql")
public class GrqphQLController {

    @Autowired
    private GraphQLService graphQLService;

    @PostMapping
    public ResponseEntity<Object> executeQuery(@RequestBody String query) {
        try {
            ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
            return new ResponseEntity<>(executionResult, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
