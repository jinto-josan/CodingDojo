package com.jmj.portfoliotracker.domain.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Portfolio {
    @NonNull
    private String name;
    @EqualsAndHashCode.Exclude
    private List<Investment> investments;
    private LocalDate creationDate;
}
