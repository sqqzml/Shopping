package com.example.androidtest19.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidtest19.MyData;
import com.example.androidtest19.R;
import com.example.androidtest19.view.Main2Activity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> implements View.OnClickListener {

    private Context context;
    private List<MyData.DataBean> list;

    public MyAdapter(Context context, List<MyData.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<MyData.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_one, null);
        MyViewholder myViewholder = new MyViewholder(view);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder myViewholder, int i) {
        myViewholder.title.setText(list.get(i).getAuthor_name());
        myViewholder.pj.setText(list.get(i).getCategory());
        Glide.with(context).load(list.get(i).getThumbnail_pic_s02()).into(myViewholder.img);
        myViewholder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Main2Activity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
      setonClick.onClick(v,(int)v.getTag());
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;
        private  TextView pj;

        public MyViewholder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            pj=itemView.findViewById(R.id.pj);
        }
    }
    public interface setonClick{
        void onClick(View v,int postition);
    }
    public setonClick setonClick;

    public void setSetonClick(MyAdapter.setonClick setonClick) {
        this.setonClick = setonClick;
    }
}

