package com.bwie.test.liuhaifeng20171118.model.modle;

import com.bwie.test.liuhaifeng20171118.model.Api.Api;
import com.bwie.test.liuhaifeng20171118.model.bean.News;
import com.bwie.test.liuhaifeng20171118.model.home.ApiService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 刘海峰.11:26
 */

public class NewsModel {
    public void getHasParams(int url) {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        //通过动态代理得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        //得到Observable
        Observable<List<News>> observable = apiService.getdatas(url);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //添加map变换操作符
                .subscribe(new Subscriber<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<News> produce) {
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
        void result(List<News> t);
    }
}
