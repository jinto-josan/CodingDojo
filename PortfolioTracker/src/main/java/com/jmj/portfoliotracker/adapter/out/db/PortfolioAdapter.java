package com.jmj.portfoliotracker.adapter.out.db;

import com.jmj.portfoliotracker.domain.entity.Investment;
import com.jmj.portfoliotracker.domain.entity.Portfolio;
import com.jmj.portfoliotracker.domain.port.PortfolioPort;

import java.math.BigDecimal;
import java.util.Optional;

public class PortfolioAdapter implements PortfolioPort {
    @Override
    public Optional<Portfolio> getPortfolioByName(String portfolioName) {
        return Optional.empty();
    }

    @Override
    public Optional<Portfolio> updatePortfolio(Portfolio portfolio) {
        return Optional.empty();
    }

    @Override
    public void deletePortfolio(Portfolio portfolio) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void addInvestmentToPortfolio(Portfolio portfolio, Investment investment) {
        throw new UnsupportedOperationException();


    }

    @Override
    public void sellInvestmentFromPortfolio(Portfolio portfolio, String investmentId) {
        throw new UnsupportedOperationException();

    }

    @Override
    public BigDecimal calculatePortfolioReturns(Portfolio portfolio) {
        return null;
    }
}
