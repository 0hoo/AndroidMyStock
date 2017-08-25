package com.a0hoo.mystock;

import android.support.v4.app.Fragment;

public class StockListActivity extends SingleFragmentActivity {
    public StockListFragment stockListFragment;

    protected Fragment createFragment() {
        stockListFragment = new StockListFragment();
        return stockListFragment;
    }
}
