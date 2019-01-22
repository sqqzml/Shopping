package com.example.androidtest19.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.androidtest19.R;
import com.example.androidtest19.presenter.MyBeautyBean;

import java.util.ArrayList;
import java.util.Random;

public class MyBeatyAdapter extends RecyclerView.Adapter<MyBeatyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MyBeautyBean> mList;

    public MyBeatyAdapter(Context context, ArrayList<MyBeautyBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_two, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MyBeautyBean beautyBean = mList.get(i);
        ViewGroup.LayoutParams params = viewHolder.itemView.getLayoutParams();
        Random random = new Random();
        int height = random.nextInt(300) + 300;
        params.height = height;
        viewHolder.itemView.setLayoutParams(params);
        viewHolder.mImage.setImageResource(beautyBean.getImage());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.img);
        }
    }
}
