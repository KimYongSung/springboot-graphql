package com.kys.graphql;

import graphql.ExecutionResult;

public interface GraphqlUseCase {

    ExecutionResult execute(String query);
}
