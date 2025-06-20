package com.jmj.portfoliotracker.application.usecase.impl;

import com.jmj.portfoliotracker.application.usecase.ValidatePortfolioUseCase;
import com.jmj.portfoliotracker.domain.entity.Portfolio;
import com.jmj.portfoliotracker.domain.port.PortfolioPort;
import org.springframework.stereotype.Component;

@Component
public class ValidatePortfolioUseCaseImpl implements ValidatePortfolioUseCase {

    private final PortfolioPort portfolioPort;

    public ValidatePortfolioUseCaseImpl(PortfolioPort portfolioPort){
        this.portfolioPort=portfolioPort;
    }

    @Override
    public boolean validateForCreation(Portfolio portfolio) {
        return portfolioPort.getPortfolioByName(portfolio.getName())
                .isEmpty();
    }

    @Override
    public boolean validateForDeletion(Portfolio portfolio) {
        return portfolioPort.getPortfolioByName(portfolio.getName())
                .isPresent();
    }
}
