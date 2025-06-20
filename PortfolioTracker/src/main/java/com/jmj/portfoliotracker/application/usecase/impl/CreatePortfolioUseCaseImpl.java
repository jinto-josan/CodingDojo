package com.jmj.portfoliotracker.application.usecase.impl;

import com.jmj.portfoliotracker.application.exception.ApplicationException;
import com.jmj.portfoliotracker.application.usecase.CreatePortfolioUseCase;
import com.jmj.portfoliotracker.application.usecase.ValidatePortfolioUseCase;
import com.jmj.portfoliotracker.common.ErrorCode;
import com.jmj.portfoliotracker.domain.entity.Portfolio;
import com.jmj.portfoliotracker.domain.port.PortfolioPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreatePortfolioUseCaseImpl implements CreatePortfolioUseCase {

    ValidatePortfolioUseCase validatePortfolioUseCase;
    PortfolioPort portfolioPort;

    public CreatePortfolioUseCaseImpl(ValidatePortfolioUseCase validatePortfolioUseCase, PortfolioPort portfolioPort){
        this.portfolioPort=portfolioPort;
        this.validatePortfolioUseCase=validatePortfolioUseCase;
    }

    @Override
    public Optional<Portfolio> execute(String name) {
        Portfolio portfolio=new Portfolio(name);
        if(validatePortfolioUseCase.validateForCreation(portfolio))
            return portfolioPort.updatePortfolio(portfolio);
        throw new ApplicationException(ErrorCode.PORTFOLIO_ALREADY_EXISTS,name);
    }

}
