package com.bwie.test.liuhaifeng20171118.view;


import com.bwie.test.liuhaifeng20171118.model.bean.MyBean;
import com.bwie.test.liuhaifeng20171118.model.bean.News;

import java.util.List;


public interface ProduceView {
    void  Sucess(MyBean produce);
    void showSuccess(List<News> list);
}
