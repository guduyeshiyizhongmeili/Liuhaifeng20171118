package com.bwie.test.liuhaifeng20171118.presenter;


import com.bwie.test.liuhaifeng20171118.model.bean.MyBean;
import com.bwie.test.liuhaifeng20171118.model.modle.ProductModel;
import com.bwie.test.liuhaifeng20171118.view.ProduceView;

public class ProducePresenter implements ProductModel.Shopping {
    private ProductModel productModel;
    private ProduceView produceView;

    public ProducePresenter(ProduceView produceView) {
        this.produceView = produceView;
        productModel = new ProductModel();
        productModel.setShop(this);

    }

    public void product() {
        productModel.getHasParams();
    }

    @Override
    public void result(MyBean t) {
        produceView.Sucess(t);
    }
}
