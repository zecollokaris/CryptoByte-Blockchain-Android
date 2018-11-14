package com.zecollokaris.cryptocurrency;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.zecollokaris.cryptocurrency.Adapter.CoinAdapter;
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

        swipeRefreshLayout = (SwipeRefreshLayout)

    }
}
