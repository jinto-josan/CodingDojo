package com.jmj.portfoliotracker.application.usecase;

import com.jmj.portfoliotracker.PortfolioGenerator;
import com.jmj.portfoliotracker.application.exception.ApplicationException;
import com.jmj.portfoliotracker.application.usecase.impl.CreatePortfolioUseCaseImpl;
import com.jmj.portfoliotracker.application.usecase.impl.ValidatePortfolioUseCaseImpl;
import com.jmj.portfoliotracker.domain.port.PortfolioPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ValidatePortfolioUseCaseImpl.class, CreatePortfolioUseCaseImpl.class})
class CreatePortfolioUseCaseTest {

    @MockitoBean
    private PortfolioPort port;
    @Autowired
    private CreatePortfolioUseCase createPortfolioUseCase;
    @Test
    void portfolioNamesAreUnique(){
        String name=PortfolioGenerator.BASIC_PORTFOLIO.getName();
        when(port.getPortfolioByName(name))
                .thenReturn(Optional.empty());
        when(port.updatePortfolio(PortfolioGenerator.BASIC_PORTFOLIO))
                .thenReturn(Optional.of(PortfolioGenerator.BASIC_PORTFOLIO));
        createPortfolioUseCase.execute(name);
        when(port.getPortfolioByName(name))
                .thenReturn(Optional.of(PortfolioGenerator.BASIC_PORTFOLIO));
        Assertions.assertThrows(ApplicationException.class,
                ()->createPortfolioUseCase.execute(name),
                ()->"[P0001]: Portfolio already exists "+name
        );

    }
}
