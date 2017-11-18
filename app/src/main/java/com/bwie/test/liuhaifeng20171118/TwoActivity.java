package com.bwie.test.liuhaifeng20171118;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwie.test.liuhaifeng20171118.model.VideoActivity;
import com.bwie.test.liuhaifeng20171118.model.adapter.Myadpter;
import com.bwie.test.liuhaifeng20171118.model.bean.MyBean;
import com.bwie.test.liuhaifeng20171118.model.bean.News;
import com.bwie.test.liuhaifeng20171118.model.utils.GlideImageLaoder;
import com.bwie.test.liuhaifeng20171118.presenter.NewsPresenter;
import com.bwie.test.liuhaifeng20171118.presenter.ProducePresenter;
import com.bwie.test.liuhaifeng20171118.view.ProduceView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class TwoActivity extends AppCompatActivity implements ProduceView {
    private List<String> titles;
    private List<String> imgs;
    private List<String> urls;
    private RecyclerView mrv;
    private Myadpter md;
    private ProducePresenter producePresenter;
    private Banner mBanner;

    private SwipeRefreshLayout mSwitf;
    private LinearLayoutManager linearLayoutManager;
    private int  page=1;
    private List<News.DataBean> list1;
    private NewsPresenter presenter;
    private List<MyBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        presenter = new NewsPresenter(this);
        presenter.getOk(page);
        initView();
        producePresenter = new ProducePresenter(this);
        producePresenter.product();
        mrv=(RecyclerView)findViewById(R.id.recyc1);
        mSwitf = (SwipeRefreshLayout) findViewById(R.id.switf);
    }

    @Override
    public void Sucess(MyBean produce) {
        imgs = new ArrayList<>();
        titles = new ArrayList<>();
        urls = new ArrayList<>();
        data = produce.getData();

        for(int i = 0; i< data.size(); i++){
            imgs.add(data.get(i).getImage_url());
            titles.add(data.get(i).getContent());

        }
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLaoder());
        //实例化图片集合
        mBanner.setImages(imgs);
        //设置Banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //实例化Title集合
        //设置Banner标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(titles);
        //设置轮播时间
        mBanner.setDelayTime(1000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
       mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String s = data.get(position).getVedio_url();
                Intent intent=new Intent(TwoActivity.this,VideoActivity.class);
                intent.putExtra("url",s);
                startActivity(intent);
            }
        });

        //Banner设置方法全部调用完毕时最后调用
        mBanner.start();


    }

    @Override
    public void showSuccess(final List<News> list) {
        linearLayoutManager = new LinearLayoutManager(this);
        mrv.setLayoutManager(linearLayoutManager);

        list1 = list.get(0).getData();


        md = new Myadpter(this,list1);
        mrv.setAdapter(md);
        md.setOnItemClickListener(new Myadpter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(TwoActivity.this, list1.get(postion).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TwoActivity.this,DownLoadActivity.class);
                startActivity(intent);

            }
        });
        mrv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == list1.size() - 1) {
                    page++;
                    showSuccess(list);
                    md.notifyDataSetChanged();
                }


            }
        });

        mSwitf.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                page++;
                presenter.getOk(page);
                md.notifyDataSetChanged();
                mSwitf.setRefreshing(false);

            }
        });




    }

    private void initView() {
        mBanner = (Banner) findViewById(R.id.banner);
    }

}
