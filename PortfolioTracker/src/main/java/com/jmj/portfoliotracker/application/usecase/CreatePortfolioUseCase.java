package com.jmj.portfoliotracker.application.usecase;

import com.jmj.portfoliotracker.domain.entity.Portfolio;

import java.util.Optional;

public interface CreatePortfolioUseCase {
    Optional<Portfolio> execute(String name);
}
