package com.zecollokaris.cryptocurrency.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zecollokaris.cryptocurrency.R;
import com.squareup.picasso.Picasso;
import com.zecollokaris.cryptocurrency.Interface.ILoadMore;
import com.zecollokaris.cryptocurrency.Model.CoinModel;


import java.util.List;

//THIS WILL BE USED TO INFLATE THE DISPLAY!
public class CoinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ILoadMore iLoadMore;
    boolean isLoading;
    Activity activity;
    List<CoinModel> items;

    int visibleThreshold = 5, lastVisibleItem,totalItemCount;

    public CoinAdapter(RecyclerView recyclerView,Activity activity, List<CoinModel> items) {
        this.activity = activity;
        this.items = items;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem+visibleThreshold)){
                    if(iLoadMore != null)
                        iLoadMore.onLoadMore();
                    isLoading =true;
                }
            }
        });
    }


    public void setiLoadMore(ILoadMore iLoadMore) {
        this.iLoadMore = iLoadMore;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.coin_layout,viewGroup, false);
        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CoinModel item = items.get(position);
        CoinViewHolder holderItem = (CoinViewHolder)holder;

        float usd=Float.parseFloat(item.getPrice_usd());
        Log.d("USD",Float.toString(usd));

        usd=(usd*1000000);
        Log.d("ROUNDUSD",Float.toString(usd));
        float round= (float) (Math.round(usd)/1000000.0);
        Log.d("ROUND",Float.toString(round));

        holderItem.coin_name.setText(item.getName());
        holderItem.coin_symbol.setText(item.getSymbol());
        holderItem.coin_price.setText(Float.toString(round));
        holderItem.seven_days_change.setText(item.getPercent_change_7d()+"%");

        //Load Images (Picasso)
        Picasso.with(activity)
                .load(new StringBuilder("https://res.cloudinary.com/dxi90ksom/image/upload/")
                .append(item.getSymbol().toLowerCase()).append(".png").toString())
                .into(holderItem.coin_icon);
//▼▾▲▴
//        This section of code Change the color of text to Red incase of a drop and Green incase of a rise!

        try {
            //Percent_change_1h
            if(item.getPercent_change_1h().contains("-")){
                String data=item.getPercent_change_1h().replace("-","▼");
                holderItem.one_hour_change.setTextColor(Color.parseColor("#FF0000"));
                holderItem.one_hour_change.setText(data);
            }
            else if(!item.getPercent_change_1h().contains("-")) {

                String data = "▲";
                data = data.concat(item.getPercent_change_1h());
                holderItem.one_hour_change.setTextColor(Color.parseColor("#32CD32"));
                holderItem.one_hour_change.setText(data);
            }

            //Percent_change_24h
            if(item.getPercent_change_24h().contains("-")){
                String data=item.getPercent_change_24h().replace("-","▼");
                holderItem.twenty_hours_change.setTextColor(Color.parseColor("#FF0000"));
                holderItem.twenty_hours_change.setText(data);
            }
            else if(!item.getPercent_change_24h().contains("-")){

                String data="▲";
                data=data.concat(item.getPercent_change_24h());
                holderItem.twenty_hours_change.setTextColor(Color.parseColor("#32CD32"));
                holderItem.twenty_hours_change.setText(data);

            }

            //Percent_change_7d
            if(item.getPercent_change_7d().contains("-")){
                String data=item.getPercent_change_7d().replace("-","▼");
                holderItem.seven_days_change.setTextColor(Color.parseColor("#FF0000"));
                holderItem.seven_days_change.setText(data);
            }
            else if(!item.getPercent_change_7d().contains("-")){

                String data="▲";
                data=data.concat(item.getPercent_change_7d());
                holderItem.seven_days_change.setTextColor(Color.parseColor("#32CD32"));
                holderItem.seven_days_change.setText(data);

            }
        }
        catch(Exception e){
            Log.d("Color_Error",e.getMessage());
        }

    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setLoaded() {isLoading = false;}

    public void updateData(List<CoinModel> coinModels){

        this.items = coinModels;
        notifyDataSetChanged();
    }
}
