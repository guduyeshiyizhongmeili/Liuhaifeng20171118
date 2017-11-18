package com.bwie.test.liuhaifeng20171118.model.modle;


import com.bwie.test.liuhaifeng20171118.model.Api.Api;
import com.bwie.test.liuhaifeng20171118.model.bean.MyBean;
import com.bwie.test.liuhaifeng20171118.model.home.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class ProductModel {
    public void getHasParams() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_PATH).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        //通过动态代理得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        //得到Observable
        Observable<MyBean> observable = apiService.getNoParams();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //添加map变换操作符
                .subscribe(new Subscriber<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean produce) {
                        //消费事件
                        shop.result(produce);
                    }
                });
    }


    public Shopping shop;

    public Shopping getShop() {
        return shop;
    }

    public void setShop(Shopping shop) {
        this.shop = shop;
    }

    public interface Shopping {
        void result(MyBean t);
    }
}

