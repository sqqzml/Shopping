package com.example.androidtest19.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.androidtest19.R;
import com.example.androidtest19.adapter.MoreAdapter;
import com.example.androidtest19.adapter.MyBeatyAdapter;
import com.example.androidtest19.presenter.MyBeautyBean;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recy;
    private ArrayList<MyBeautyBean> mList = new ArrayList<>();
    private int[] mImages = {R.mipmap.ic_launcher, R.mipmap.a, R.mipmap.ccc};
    private MyBeatyAdapter myBeatyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
        //设置shipeiq
        MoreAdapter moreAdapter = new MoreAdapter(mList,this);
        recy.setAdapter(moreAdapter);



    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            new MyBeautyBean("hahha"+i,mImages[i%mImages.length]);
        }
    }


    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recy.setLayoutManager(staggeredGridLayoutManager);
         
        //默认动画
        recy.setItemAnimator(new DefaultItemAnimator());
    }
}
