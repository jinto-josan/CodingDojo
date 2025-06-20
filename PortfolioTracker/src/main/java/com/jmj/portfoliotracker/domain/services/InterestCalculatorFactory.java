package com.jmj.portfoliotracker.domain.services;

import com.jmj.portfoliotracker.domain.entity.InterestCalculator;
import com.jmj.portfoliotracker.domain.entity.InterestType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;

public class InterestCalculatorFactory {

    private InterestCalculatorFactory() {
        // Private constructor to prevent instantiation
    }

    public static InterestCalculator getInterestCalculator(InterestType type){
        return switch (type) {
            case SIMPLE_INTEREST -> (principal, rate, startDate, endDate) ->
                    principal.multiply(rate).multiply(BigDecimal.valueOf(startDate.until(endDate, ChronoUnit.MONTHS) /12)).divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN);
            case COMPOUND_INTEREST -> (principal, rate,startDate,endDate) ->
                    principal.multiply(BigDecimal.ONE.subtract(
                        BigDecimal.ONE.add(
                                rate.divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN).divide(BigDecimal.valueOf(12), RoundingMode.HALF_DOWN)
                                .multiply(BigDecimal.valueOf(startDate.until(endDate, ChronoUnit.MONTHS))))
                        .pow((int) startDate.until(endDate, ChronoUnit.MONTHS))));
            default -> throw new IllegalArgumentException("Unknown interest type: " + type);
        };
    }
}
