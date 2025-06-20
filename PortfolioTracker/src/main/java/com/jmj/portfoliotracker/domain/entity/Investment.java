package com.jmj.portfoliotracker.domain.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface Investment {

    LocalDateTime getStartDate();
    LocalDateTime getEndDate();
    BigDecimal getPrincipal();
    InvestmentType getInvestmentType();
    BigDecimal getReturns();
    UUID getId();

    default UUID generateUUId(){
        return UUID.randomUUID();
    }

}
