package com.acme.mytrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Security {

    private final String security;
    private final Double price;
    private final Integer quantity;
}
