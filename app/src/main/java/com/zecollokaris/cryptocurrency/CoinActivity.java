package com.zecollokaris.cryptocurrency;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zecollokaris.cryptocurrency.Adapter.CoinAdapter;
import com.zecollokaris.cryptocurrency.Interface.ILoadMore;
import com.zecollokaris.cryptocurrency.Model.CoinModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class CoinActivity extends AppCompatActivity {

    List<CoinModel> items = new ArrayList<>();
    CoinAdapter adapter;
    RecyclerView recyclerView;

    OkHttpClient client;
    Request request;


    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coin_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.rootLayout);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                loadFirst10Coin(0);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                items.clear();
                loadFirst10Coin(0);
                setupAdapter();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.coinList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setupAdapter();

    }

    private void setupAdapter() {
        adapter = new CoinAdapter(recyclerView,CoinActivity.this,items);
        recyclerView.setAdapter(adapter);
        adapter.setiLoadMore(new ILoadMore() {
            @Override
            public void onLoadMore() {
                if (items,size() <= 1000)
            }
        });
    }

    private void loadFirst10Coin(int i) {
    }


}
