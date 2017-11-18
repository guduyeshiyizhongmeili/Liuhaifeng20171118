package com.bwie.test.liuhaifeng20171118.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.liuhaifeng20171118.R;
import com.bwie.test.liuhaifeng20171118.model.bean.MyBean;
import com.bwie.test.liuhaifeng20171118.model.bean.News;

import java.util.List;

/**
 * 刘海峰.9:34
 */

/**
 * 刘海峰.9:59
 */

public class Myadpter extends RecyclerView.Adapter {

    List<News.DataBean> list;
    private MyViewHolder myViewHolder;
    private OnItemClickListener  mClickListener;
    private Context mcontext;
    public Myadpter(Context mcontext, List<News.DataBean> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(inflate,mClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(list.get(position).getTitle());
        Glide.with(mcontext).load(list.get(position).getImg()).into(myViewHolder.ima);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mClickListener=listener;
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private OnItemClickListener mListener;
        public final ImageView ima;
        private final TextView textView;

        public MyViewHolder(View itemView,OnItemClickListener  listener) {
            super(itemView);
            mListener=listener;
            //给item设置点击事件
            itemView.setOnClickListener(this);

            //给item设置点击事件

            ima = (ImageView) itemView.findViewById(R.id.image_item);
            textView = (TextView) itemView.findViewById(R.id.title_item);
        }
        @Override
        public void onClick(View v) {
            // getpostion()为Viewholder自带的一个方法，用来获取RecyclerView当前的位置，将此作为参数，传出去
            mListener.onItemClick(v,getPosition());

        }
    }
    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }

}

