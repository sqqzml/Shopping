package com.example.androidtest19.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtest19.R;
import com.example.androidtest19.presenter.MyBeautyBean;

import java.util.ArrayList;

public class MoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private ArrayList<MyBeautyBean> mList;
    private Context context;
    private final int ONE_ITEM = 1;
    private final int TWO_ITEM = 2;

    public MoreAdapter(ArrayList<MyBeautyBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    public MoreAdapter(ArrayList<MyBeautyBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    //参数2就是布局type类型
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
       switch (viewType) {
            case ONE_ITEM:
                view = View.inflate(viewGroup.getContext(), R.layout.item_one, null);
                holder = new OneHolder(view);
                break;
            case TWO_ITEM:
                view = View.inflate(viewGroup.getContext(), R.layout.item_two, null);
                holder = new TwoHolder(view);
                break;
        }

        view.setOnClickListener(this);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyBeautyBean bean = mList.get(i);
        //判断前一个参数是否是后一个参数的一个实例
        if (viewHolder instanceof OneHolder) {
            ((OneHolder) viewHolder).mName.setText(bean.getName());
            // ((OneHolder) viewHolder).itemView.setTag(i);
        } else {
            ((TwoHolder) viewHolder).mImage.setImageResource(bean.getImage());
            //  ((TwoHolder) viewHolder).itemView.setTag(i);
        }
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //显示几种布局
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 1) {
            return ONE_ITEM;
        } else {
            return TWO_ITEM;
        }
    }


    class OneHolder extends RecyclerView.ViewHolder {
        private TextView mName;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.title);
        }
    }

    class TwoHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.img);
        }
    }

    public interface ItemClick {
        void setOnItem(View v, int position);
    }

    private ItemClick itemClick;

    public void setOnItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public void onClick(View v) {
        if (itemClick != null) {
            itemClick.setOnItem(v, (int) v.getTag());
        }
    }
}
