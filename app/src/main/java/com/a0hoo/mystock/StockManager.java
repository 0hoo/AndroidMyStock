package com.a0hoo.mystock;

import android.support.annotation.Nullable;

import com.a0hoo.mystock.models.Stock;
import java.util.ArrayList;

public class StockManager {

    private static StockManager sStockManager;
    private ArrayList<Stock> mStocks;

    public StockManager() {
        mStocks = new ArrayList<Stock>();
    }

    public static StockManager get() {
        if (sStockManager == null) {
            sStockManager = new StockManager();
        }
        return sStockManager;
    }

    public ArrayList<Stock> getStocks() {
        return mStocks;
    }

    @Nullable
    public Stock getStock(String code) {
        for (Stock stock : mStocks) {
            if (stock.getStockCode().equals(code)) {
                return stock;
            }
        }
        return null;
    }
}