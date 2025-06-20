package com.jmj.portfoliotracker.application.usecase;

import com.jmj.portfoliotracker.domain.entity.Portfolio;

public interface ValidatePortfolioUseCase {
    boolean validateForCreation(Portfolio portfolio);
    boolean validateForDeletion(Portfolio portfolio);
}
