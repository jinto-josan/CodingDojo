package com.jmj.portfoliotracker.domain.port;

import com.jmj.portfoliotracker.domain.entity.Investment;
import com.jmj.portfoliotracker.domain.entity.Portfolio;
import java.math.BigDecimal;
import java.util.Optional;

public interface PortfolioPort {

    Optional<Portfolio> getPortfolioByName(String portfolioName);
    Optional<Portfolio> updatePortfolio(Portfolio portfolio);
    void deletePortfolio(Portfolio portfolio);
    void addInvestmentToPortfolio(Portfolio portfolio, Investment investment);
    void sellInvestmentFromPortfolio(Portfolio portfolio, String investmentId);
    BigDecimal calculatePortfolioReturns(Portfolio portfolio);


}
