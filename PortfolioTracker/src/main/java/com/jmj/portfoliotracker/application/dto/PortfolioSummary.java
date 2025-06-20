package com.jmj.portfoliotracker.application.dto;

import com.jmj.portfoliotracker.domain.entity.InvestmentType;
import lombok.Builder;


import java.math.BigDecimal;
import java.util.Map;


@Builder
public record PortfolioSummary(
        String name,
        String description,
        BigDecimal totalValue,
        BigDecimal totalInvestment,
        BigDecimal totalProfitLoss,
        BigDecimal totalProfitLossPercentage,
        Map<InvestmentType, Integer> investmentTypeCounts,
        BigDecimal riskScore
) {
}
