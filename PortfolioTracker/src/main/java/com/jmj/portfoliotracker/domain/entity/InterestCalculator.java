package com.jmj.portfoliotracker.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface InterestCalculator {
    BigDecimal calculateInterest(BigDecimal principal, BigDecimal rate, LocalDateTime startDate, LocalDateTime endDate);
}
