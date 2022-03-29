package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PriceListenerImpl implements PriceListener {

    private final String security;
    private final Double price;
    private final Integer quantity;
    private final ExecutionService executionService;
    private boolean tradeExecuteStatus;

    @Override
    public void priceUpdate(String security, double price) {
        if (!tradeExecuteStatus && this.security.equals(security) && price < this.price) {
            executionService.buy(security, price, quantity);
            tradeExecuteStatus = true;
        }
    }
}
