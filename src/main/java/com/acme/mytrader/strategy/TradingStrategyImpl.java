package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.model.Security;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor

public class TradingStrategyImpl {
    private final ExecutionService executionService;
    private final PriceSource priceSource;


    public void buyStocks(List<Security> securities) throws InterruptedException {
        securities.stream().map(
                p -> new PriceListenerImpl(p.getSecurity(), p.getPrice(), p.getQuantity(),
                        executionService, false)).forEach(priceSource::addPriceListener);
        Thread thread = new Thread(priceSource);
        thread.start();
        thread.join();
        securities.stream().map(
                p -> new PriceListenerImpl(p.getSecurity(), p.getPrice(), p.getQuantity(),
                        executionService, false)).forEach(priceSource::removePriceListener);
    }

}
