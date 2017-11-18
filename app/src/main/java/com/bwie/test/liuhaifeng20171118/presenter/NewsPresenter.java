package com.bwie.test.liuhaifeng20171118.presenter;

import com.bwie.test.liuhaifeng20171118.model.bean.News;
import com.bwie.test.liuhaifeng20171118.model.modle.NewsModel;
import com.bwie.test.liuhaifeng20171118.view.ProduceView;

import java.util.List;

/**
 * 刘海峰.11:31
 */

public class NewsPresenter implements NewsModel.Shopping {
    ProduceView iview;
    NewsModel imodel;

    public NewsPresenter(ProduceView iview) {
        this.iview = iview;
        imodel = new NewsModel();
        imodel.setShop(this);
    }

    public void getOk(int url) {
        imodel.getHasParams( url);


    }

    @Override
    public void result(List<News> t) {
        iview.showSuccess(t);
    }
}
