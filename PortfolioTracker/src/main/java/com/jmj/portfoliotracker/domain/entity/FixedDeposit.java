package com.jmj.portfoliotracker.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class FixedDeposit implements Investment {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal principal;
    private InvestmentType investmentType;
    private InterestCalculator interestCalculator;
    private BigDecimal rate;
    private UUID id;

    FixedDeposit(){
        this.id = generateUUId();
    }

    @Override
    public BigDecimal getReturns() {
        return interestCalculator.calculateInterest(principal, rate, startDate, endDate);
    }



}
