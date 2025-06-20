package com.jmj.portfoliotracker.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    PORTFOLIO_ALREADY_EXISTS("P0001","Portfolio already exists {}");

    private final String code;
    private final String message;
}
