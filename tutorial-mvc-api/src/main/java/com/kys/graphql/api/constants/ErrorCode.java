package com.kys.graphql.api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    CD_0000("0000", "SUCCESS")
    ,CD_A001("A001", "Author not found")
    ,CD_B001("B001", "Book not found")
    ;

    private String code;

    private String message;

    @Override
    public String toString() {
        return "[" + code + "] - " + message;
    }
}
