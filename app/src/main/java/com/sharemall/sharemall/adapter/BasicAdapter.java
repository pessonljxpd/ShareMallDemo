package com.sharemall.sharemall.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sharemall.sharemall.adapter.holder.BaseHolder;

import java.util.List;

public abstract class BasicAdapter<T> extends BaseAdapter {
    protected List<T> list;

    public BasicAdapter(List<T> list) {
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1.初始化holder
        BaseHolder<T> holder = null;
        if (convertView == null) {
            holder = getHolder(position);// 需要一个不固定的holder
        } else {
            holder = (BaseHolder) convertView.getTag();
        }
        // 3.绑定数据
        holder.bindData(list.get(position));


        return holder.getHolderView();
    }

    protected abstract BaseHolder<T> getHolder(int position);

}