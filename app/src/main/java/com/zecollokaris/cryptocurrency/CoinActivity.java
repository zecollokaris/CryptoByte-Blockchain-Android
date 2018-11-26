package com.zecollokaris.cryptocurrency;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zecollokaris.cryptocurrency.Adapter.CoinAdapter;
import com.zecollokaris.cryptocurrency.Interface.ILoadMore;
import com.zecollokaris.cryptocurrency.Model.CoinModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CoinActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    @BindView(R.id.coinToolbar) Toolbar toolbar;
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
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Price Indication");
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

        drawer =  findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_dashboard:
                Intent intent=new Intent(getBaseContext(),CoinActivity.class);
                startActivity(intent);
                drawer.closeDrawer(GravityCompat.START);
                return  true;

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                return  true;

            case R.id.nav_favorites:
                Intent intent2=new Intent(this,FavouritesActivity.class);
                startActivity(intent2);
                drawer.closeDrawer(GravityCompat.START);
                return  true;

            case R.id.navmpesa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MpesaFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                return  true;
        }


        return false;
    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    private void setupAdapter() {
        adapter = new CoinAdapter(recyclerView,CoinActivity.this,items);
        recyclerView.setAdapter(adapter);
        adapter.setiLoadMore(new ILoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size() <= 1000)//Max Size is 1000 coins
                {
                   loadNext10coin(items.size());
                }
                else
                {
                    Toast.makeText(CoinActivity.this, "Max items is 1000", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadNext10coin(int index) {
        client = new OkHttpClient();
        request = new Request.Builder().url(String.format("https://api.coinmarketcap.com/v1/ticker/?start=%d&limit=10",index))
                .build();

        swipeRefreshLayout.setRefreshing(true);
        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(CoinActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String body = response.body().string();
                        Gson gson = new Gson();
                        final List<CoinModel> newitems = gson.fromJson(body,new TypeToken<List<CoinModel>>(){}.getType());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                items.addAll(newitems);
                                adapter.setLoaded();
                                adapter.updateData(items);
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                });
    }

    private void loadFirst10Coin(int index) {
        client = new OkHttpClient();
        request = new Request.Builder().url(String.format("https://api.coinmarketcap.com/v1/ticker/?start=%d&limit=10",index))
                .build();

        swipeRefreshLayout.setRefreshing(true);
        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
//                        Toast.makeText(CoinActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String body = response.body().string();
                        Gson gson = new Gson();
                        final List<CoinModel> newItems = gson.fromJson(body,new TypeToken<List<CoinModel>>(){}.getType());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.updateData(newItems);

                            }
                        });
                    }
                });

        if (swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public  boolean  onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.coinmenu,menu);
       return  super.onCreateOptionsMenu(menu);
    }


    @Override
    public  boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.btnLogout:
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(CoinActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return  true;
    }

}
