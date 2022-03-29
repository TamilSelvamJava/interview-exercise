package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSourceImpl;
import org.junit.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

public class PriceListnerTest {

    @Test
    public void addPriceListener() {
        PriceListener priceListener = Mockito.mock(PriceListener.class);
        PriceSourceImpl priceSource = new PriceSourceImpl();
        priceSource.addPriceListener(priceListener);
        assertThat(priceSource.getPriceListeners()).hasSize(1);
    }

    @Test
    public void removePriceListener() {
        PriceListener priceListener1 = Mockito.mock(PriceListener.class);
        PriceListener priceListener2 = Mockito.mock(PriceListener.class);
        PriceSourceImpl priceSource = new PriceSourceImpl();
        priceSource.addPriceListener(priceListener1);
        priceSource.addPriceListener(priceListener2);
        priceSource.removePriceListener(priceListener2);
        assertThat(priceSource.getPriceListeners()).hasSize(1);
    }


}
