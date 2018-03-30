package com.sharemall.sharemall.adapter;

import com.sharemall.sharemall.adapter.holder.BaseHolder;
import com.sharemall.sharemall.adapter.holder.OrderListHolder;
import com.sharemall.sharemall.beans.OrderInfoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class OrderListAdapter extends BasicAdapter<OrderInfoItem> {
    public OrderListAdapter(List<OrderInfoItem> list) {
        super(list);
    }

    @Override
    protected BaseHolder<OrderInfoItem> getHolder(int position) {
        return new OrderListHolder();
    }
}
