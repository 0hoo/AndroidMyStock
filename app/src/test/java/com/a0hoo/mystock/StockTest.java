package com.a0hoo.mystock;

import com.a0hoo.mystock.models.Stock;

import org.junit.Assert;
import org.junit.Test;

public class StockTest {
    @Test
    public void stock_init_setFields() {
        Stock stock = new Stock("00001", "삼성전자", 10000, 100, 10, true, false);
        Assert.assertNotNull(stock);
        Assert.assertEquals("00001", stock.getStockCode());
        Assert.assertEquals("삼성전자", stock.getName());
        Assert.assertEquals(10000, stock.getCurrentPrice(), 0.001);
        Assert.assertEquals(100, stock.getPriceDiff(), 0.001);
        Assert.assertEquals(10, stock.getRateDiff(), 0.001);
        Assert.assertEquals(true, stock.isPriceUp());
        Assert.assertEquals(false, stock.isPriceKeep());
    }

    @Test
    public void stock_setQuantity_getValue() {
        Stock stock = new Stock("00001", "삼성전자", 10000, 100, 10, true, false);
        stock.setQuantity(10);
        Assert.assertEquals(10000 * 10, stock.getValue(), 0.001);
    }

    @Test
    public void stock_toString_return_name() {
        Stock stock = new Stock("00001", "삼성전자", 10000, 100, 10, true, false);
        Assert.assertEquals(stock.getName(), stock.toString());
    }
}
