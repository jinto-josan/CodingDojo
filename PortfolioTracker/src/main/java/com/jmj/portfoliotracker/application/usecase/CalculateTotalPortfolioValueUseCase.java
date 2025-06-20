package com.jmj.portfoliotracker.application.usecase;

import com.jmj.portfoliotracker.domain.entity.Portfolio;

import java.math.BigDecimal;

public interface CalculateTotalPortfolioValueUseCase {
    public BigDecimal execute(Portfolio portfolio);
}
