package com.bwie.test.liuhaifeng20171118.model.home;

import com.bwie.test.liuhaifeng20171118.model.bean.MyBean;
import com.bwie.test.liuhaifeng20171118.model.bean.News;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 刘海峰.9:05
 */

public interface ApiService {
    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio")
    Observable<MyBean> getNoParams();
    @GET("wap/data/news/txs/page_{pages}.json")
    Observable<List<News>> getdatas(@Path("pages") int pages) ;

}
