package com.a0hoo.mystock;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.ListFragment;
import android.widget.ListView;
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
public class StockListActivityTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(StockListActivity.class);

    StockListActivity activity;

    @Before
    public void setup() {
        activity = (StockListActivity) mActivityRule.getActivity();
    }

    @After
    public void teardown() {
        StockManager.get().getStocks().clear();
    }

    @Test
    public void acitivty_should_have_fragment() {
        Assert.assertNotNull(activity.stockListFragment);
    }

    @Test
    public void fragment_should_be_list_fragment() {
        Assert.assertThat(activity.stockListFragment, instanceOf(ListFragment.class));
        Assert.assertTrue(activity.stockListFragment instanceof ListFragment);
    }

    @Test
    public void fragment_shoud_have_listview() {
        Assert.assertNotNull(activity.stockListFragment.getListView());
    }

    @Test
    public void listview_count_zero() {
        Assert.assertEquals(0, activity.stockListFragment.getListView().getCount());
    }

    @Test
    public void fragment_should_have_stocks() {
        Assert.assertEquals(0, activity.stockListFragment.getStocks().size());
    }

    @Test
    public void listview_should_reflect_stocks() {
        Assert.assertEquals(0, activity.stockListFragment.getListView().getCount());
        Stock stock = new Stock("00001", "삼성전자", 10000, 100, 10, true, false);
        activity.stockListFragment.getStocks().add(stock);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                activity.stockListFragment.notifyDataSetChanged();
            }
        });
        Assert.assertEquals(1, activity.stockListFragment.getListView().getCount());
    }

    @Test
    public void listview_item_is_stock() {
        Stock stockToTest = new Stock("00001", "삼성전자", 15000, 100, 5, true, false);
        activity.stockListFragment.getStocks().add(stockToTest);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                activity.stockListFragment.notifyDataSetChanged();
            }
        });
        Assert.assertEquals(activity.stockListFragment.getListView().getItemAtPosition(0), stockToTest);
    }

    @Test
    public void shouldShowStockFragmentWhenClicked() {
        StockManager.get().getStocks().add(new Stock("00111", "A", 15000, 100, 1.0, true, false));
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                ListView listView = activity.stockListFragment.getListView();
                listView.performItemClick(listView.getChildAt(0), 0, listView.getAdapter().getItemId(0));
            }
        });

        Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(StockActivity.class.getName(), null, false);
        final StockActivity stockActivity = (StockActivity) getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        Assert.assertNotNull(stockActivity);
        Assert.assertThat(stockActivity, instanceOf(StockActivity.class));

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                getInstrumentation().callActivityOnStart(stockActivity);
                getInstrumentation().callActivityOnResume(stockActivity);

                TextView nameView = stockActivity.stockFragment.getView().findViewById(R.id.stock_nameTextView);
                Assert.assertEquals(StockManager.get().getStocks().get(0).getName(), nameView.getText());
            }
        });
    }
}