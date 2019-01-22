package com.example.androidtest19.presenter;

import com.example.androidtest19.callBack.MyCallBack;
import com.example.androidtest19.model.MyModel;
import com.example.androidtest19.view.MyView;

public class MyPresenter implements Presenter {
    private MyView myView;
    private MyModel myModel;

    public MyPresenter(MyView myView) {
        this.myView=myView;
        myModel = new MyModel();
    }

    @Override
    public void getRequest(String mUrl,String page) {
      myModel.requestData(mUrl, page, new MyCallBack() {
          @Override
          public void Success(Object data) {
              myView.Success(data);
          }
      });
    }
    //防止内存泄漏
    public void OnDedatch(){
        if (myView!=null){
            myView=null;
        }
        if (myModel!=null){
            myModel=null;
        }
    }
}
