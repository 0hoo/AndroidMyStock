package com.a0hoo.mystock;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.a0hoo.mystock.models.Stock;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class StockActivityTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(StockActivity.class);

    StockActivity activity;

    @Before
    public void setup() {
        activity = (StockActivity) mActivityRule.getActivity();
    }

    @Test
    public void fragment_set_stock_update_text_views() {
        Stock stock = new Stock("00111", "A", 15000, 100, 1.0, true, false);

        activity.stockFragment.setStock(stock);

        TextView nameTextView = activity.stockFragment.getView().findViewById(R.id.stock_nameTextView);
        TextView codeTextView = activity.stockFragment.getView().findViewById(R.id.stock_codeTextView);

        Assert.assertEquals(stock.getName(), nameTextView.getText());
        Assert.assertEquals(stock.getStockCode(), codeTextView.getText());
    }
}