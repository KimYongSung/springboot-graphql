package com.kys.graphql.api.exception;

import com.kys.graphql.api.constants.ErrorCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return errorCode.toString();
    }
}
