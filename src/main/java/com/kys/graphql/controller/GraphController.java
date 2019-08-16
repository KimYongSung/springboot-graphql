package com.kys.graphql.controller;

import com.kys.graphql.GraphqlUseCase;
import graphql.ExecutionResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graphql")
@AllArgsConstructor
public class GraphController {

    private final GraphqlUseCase useCase;
    
    @PostMapping
    public ResponseEntity<Object> graphByQuery(@RequestBody String query){
        return new ResponseEntity<Object>(useCase.execute(query), HttpStatus.OK);
    }
}
