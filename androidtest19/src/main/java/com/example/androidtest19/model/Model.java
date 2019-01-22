package com.example.androidtest19.model;

import com.example.androidtest19.callBack.MyCallBack;

public interface Model {
    void  requestData(String mUrl, String page,MyCallBack myCallBack);
}

