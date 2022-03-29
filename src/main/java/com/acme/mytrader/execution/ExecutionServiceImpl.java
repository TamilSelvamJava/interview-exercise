package com.acme.mytrader.execution;

public class ExecutionServiceImpl  implements ExecutionService{
    private final Integer executionServiceId;

    public ExecutionServiceImpl(Integer executionServiceId) {
        this.executionServiceId = executionServiceId;
    }

    @Override
    public void buy(String security, double price, int volume) {
        System.out.println("Buy Price: " + price +" volumes: "+volume +" securities: "+security);
    }

    @Override
    public void sell(String security, double price, int volume) {
        System.out.println("Sell Price: " + price +" volumes: "+volume +" securities: "+security);
    }
}
