package com.a0hoo.mystock;

import android.support.v4.app.Fragment;

public class StockActivity extends SingleFragmentActivity {
    public StockFragment stockFragment;

    @Override
    protected Fragment createFragment() {
        stockFragment = new StockFragment();
        return stockFragment;
    }
}
