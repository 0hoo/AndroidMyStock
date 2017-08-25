package com.a0hoo.mystock.models;

public class Stock {
    private String stockCode;
    private String name;
    private double currentPrice;
    private double priceDiff;
    private double rateDiff;
    private boolean isPriceUp;
    private boolean isPriceKeep;
    private int quantity;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getPriceDiff() {
        return priceDiff;
    }

    public void setPriceDiff(double priceDiff) {
        this.priceDiff = priceDiff;
    }

    public double getRateDiff() {
        return rateDiff;
    }

    public void setRateDiff(double rateDiff) {
        this.rateDiff = rateDiff;
    }

    public boolean isPriceUp() {
        return isPriceUp;
    }

    public void setPriceUp(boolean priceUp) {
        isPriceUp = priceUp;
    }

    public boolean isPriceKeep() {
        return isPriceKeep;
    }

    public void setPriceKeep(boolean priceKeep) {
        isPriceKeep = priceKeep;
    }

    public Stock(String stockCode, String name, double currentPrice, double priceDiff, double rateDiff, boolean isPriceUp, boolean isPriceKeep) {
        this.stockCode = stockCode;
        this.name = name;
        this.currentPrice = currentPrice;
        this.priceDiff = priceDiff;
        this.rateDiff = rateDiff;
        this.isPriceUp = isPriceUp;
        this.isPriceKeep = isPriceKeep;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return this.quantity * this.currentPrice;
    }

    @Override
    public String toString() {
        return name;
    }
}
