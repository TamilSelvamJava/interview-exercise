package com.acme.mytrader.price;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
@Getter
public class PriceSourceImpl implements  PriceSource {

    private List<PriceListener> priceListeners = new ArrayList<>();

    private static final List<String> SECURITIES = Arrays
            .asList("IBM", "DELL");

    private static final double MIN_RANGE = 1.00;
    private static final double MAX_RANGE = 100.00;

    @Override
    public void addPriceListener(PriceListener listener) {
        this.priceListeners.add(listener);
    }

    @Override
    public void removePriceListener(PriceListener listener) {
        this.priceListeners.remove(listener);
    }

    @Override
    public void run() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            String security = SECURITIES.get(threadLocalRandom.nextInt(SECURITIES.size()));
            double price = MIN_RANGE + (MAX_RANGE - MIN_RANGE) * threadLocalRandom.nextDouble();
            priceListeners.forEach(priceListener -> priceListener.priceUpdate(security, price));
        }
    }
}
