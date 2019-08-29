package com.kys.graphql.api.exception;

import com.kys.graphql.api.constants.ErrorCode;

public class AuthorNotFoundException extends ApiException {

    public AuthorNotFoundException() {
        super(ErrorCode.CD_A001);
    }
}
