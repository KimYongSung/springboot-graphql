package com.kys.graphql.api.exception;

import com.kys.graphql.api.constants.ErrorCode;

public class BookNotFoundException extends ApiException {

    public BookNotFoundException() {
        super(ErrorCode.CD_B001);
    }
}
