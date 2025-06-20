package com.jmj.portfoliotracker.application.exception;

import com.jmj.portfoliotracker.common.ErrorCode;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException{

    private final String code;

    public ApplicationException(ErrorCode errorCode){
        super(errorCode.getMessage());
        code=errorCode.getCode();
    }
    public ApplicationException( ErrorCode errorCode, String... params){
        super(String.format(errorCode.getMessage(),params));
        code=errorCode.getCode();
    }
}
