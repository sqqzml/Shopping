package com.example.androidtest19.view;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttp {
    private OkHttpClient okHttpClient=new OkHttpClient();

    private OkHttp(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .callTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
    //getInstance的方法
    public static OkHttp getInstance(){
        return OkHolder.okHttp;
    }
     static class OkHolder{
        private final  static OkHttp okHttp=new OkHttp();
    }

    //使用异步的get 和post的方法
    public void getAsync(String mUrl, Callback callback){
        Request request = new Request.Builder().url(mUrl).build();
       okHttpClient.newCall(request).enqueue(callback);
    }
    //使用异步post的方法
   public void postAsync(String mUrl,String page,Callback callback){
       FormBody formBody = new FormBody.Builder().add("page", page).build();
       Request request = new Request.Builder().url(mUrl).post(formBody).build();
       okHttpClient.newCall(request).enqueue(callback);
   }
}
