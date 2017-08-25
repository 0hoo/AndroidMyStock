package com.a0hoo.mystock;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {
    protected Fragment createFragment() {
        return new MainFragment();
    }

    /**
     * Created by 0hoo on 8/25/17.
     */

    public static class StockManager {
    }
}
