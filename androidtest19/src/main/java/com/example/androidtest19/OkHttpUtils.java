package com.example.androidtest19;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {
    private OkHttpClient okHttpClient=new OkHttpClient();

    public static OkHttpUtils getInsatance(){
        return OkHolder.okhttputils;
    }
 /*   static class OkHolder {
        private static final OkHttpUtils okUtils = new OkHttpUtils();
    }*/
    public static class OkHolder{
      private static final OkHttpUtils okhttputils=  new OkHttpUtils();
    }
   /* public void getAsync(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public void postAsync( String url,String page, Callback callback) {
        RequestBody body = new FormBody.Builder().add("page", page).build();
        Request request = new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(callback);
    }*/
   public void getAsync(String Url,Callback callback){
       Request request = new Request.Builder().url(Url).build();
       okHttpClient.newCall(request).enqueue(callback);
   }
   public void postAsync(String url,String page,Callback callback){
       FormBody formBody = new FormBody.Builder().add("page", page).build();
       Request request = new Request.Builder().url(url).post(formBody).build();
       okHttpClient.newCall(request).enqueue(callback);
   }
}
