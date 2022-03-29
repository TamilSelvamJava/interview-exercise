package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionServiceImpl;
import com.acme.mytrader.model.Security;
import com.acme.mytrader.price.PriceSourceImpl;

import static java.util.Arrays.asList;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
    public static void main(String[] args) throws InterruptedException {
        TradingStrategyImpl tradingStrategy = new TradingStrategyImpl(new ExecutionServiceImpl(1),new PriceSourceImpl());
        Security ibm=new Security("IBM",90.00,10);
        Security dell=new Security("dell",80.00,20);

        tradingStrategy.buyStocks(asList(ibm, dell));
    }

}
