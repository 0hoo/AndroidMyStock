package com.a0hoo.mystock;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a0hoo.mystock.models.Stock;

public class StockFragment extends Fragment {
    public static final String EXTRA_STOCK_CODE = "StockCode";
    private Stock mStock;
    private TextView mNameTextView;
    private TextView mCodeTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stockCode = getActivity().getIntent().getStringExtra(EXTRA_STOCK_CODE);
        mStock = StockManager.get().getStock(stockCode);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stock, container, false);
        
        mNameTextView = (TextView)v.findViewById(R.id.stock_nameTextView);
        mCodeTextView = (TextView)v.findViewById(R.id.stock_codeTextView);

        if (mStock != null) {
            mNameTextView.setText(mStock.getName());
            mCodeTextView.setText(mStock.getStockCode());
        }
        
        return v;
    }

    public void setStock(Stock stock) {
        this.mStock = stock;

        TextView nameTextView = getView().findViewById(R.id.stock_nameTextView);
        if (nameTextView != null) {
            nameTextView.setText(stock.getName());
        }
        TextView codeTextView = getView().findViewById(R.id.stock_codeTextView);
        if (codeTextView != null) {
            codeTextView.setText(stock.getStockCode());
        }
    }
}
