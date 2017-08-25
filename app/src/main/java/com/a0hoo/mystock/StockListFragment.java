package com.a0hoo.mystock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.a0hoo.mystock.models.Stock;

import java.util.ArrayList;

public class StockListFragment extends ListFragment {
    private ArrayList<Stock> mStocks;

    public ArrayList<Stock> getStocks() {
        return mStocks;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStocks = StockManager.get().getStocks();
        //mStocks.add(new Stock("00001", "삼성전자", 10000, 100, 10, true, false));
        //mStocks.add(new Stock("00002", "LG전자", 5000, 10, 1, false, false));

        StockAdapter adapter = new StockAdapter(mStocks);
        setListAdapter(adapter);
    }

    public void notifyDataSetChanged() {
        ((ArrayAdapter<Stock>)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Stock stock = (Stock)l.getItemAtPosition(position);

        Intent i = new Intent(getActivity(), StockActivity.class);
        i.putExtra(StockFragment.EXTRA_STOCK_CODE, stock.getStockCode());
        startActivity(i);
    }

    public class StockAdapter extends ArrayAdapter<Stock> {
        public StockAdapter(ArrayList<Stock> stocks) {
            super(getActivity(), 0, stocks);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_stock, null);
            }

            Stock stock = getItem(position);

            TextView nameTextView = (TextView)convertView.findViewById(R.id.stock_list_item_nameTextView);
            nameTextView.setText(stock.getName());
            TextView priceTextView = (TextView)convertView.findViewById(R.id.stock_list_item_priceTextView);
            priceTextView.setText(String.valueOf(stock.getCurrentPrice()));

            return convertView;
        }
    }
}
