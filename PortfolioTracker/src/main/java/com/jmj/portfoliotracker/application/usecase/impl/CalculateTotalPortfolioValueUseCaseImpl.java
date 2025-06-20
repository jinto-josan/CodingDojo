package com.jmj.portfoliotracker.application.usecase.impl;

import com.jmj.portfoliotracker.application.usecase.CalculateTotalPortfolioValueUseCase;
import com.jmj.portfoliotracker.domain.entity.Investment;
import com.jmj.portfoliotracker.domain.entity.Portfolio;
import com.jmj.portfoliotracker.domain.port.PortfolioPort;

import java.math.BigDecimal;

public class CalculateTotalPortfolioValueUseCaseImpl implements CalculateTotalPortfolioValueUseCase {

    PortfolioPort portfolioPort;
    public BigDecimal execute(Portfolio portfolio){

        return portfolioPort.getPortfolioByName(portfolio.getName())
                .orElseThrow(() -> new IllegalArgumentException("Portfolio not found"))
                .getInvestments()
                .stream()
                .map(Investment::getReturns)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
