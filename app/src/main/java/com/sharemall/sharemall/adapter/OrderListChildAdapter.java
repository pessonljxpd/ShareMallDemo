package com.sharemall.sharemall.adapter;

import com.sharemall.sharemall.adapter.holder.BaseHolder;
import com.sharemall.sharemall.adapter.holder.OrderListChildHolder;
import com.sharemall.sharemall.adapter.holder.OrderListHolder;
import com.sharemall.sharemall.beans.OrderInfoItem;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2018/3/30 0030
 */

public class OrderListChildAdapter extends BasicAdapter<OrderInfoItem> {
    public OrderListChildAdapter(List<OrderInfoItem> list) {
        super(list);
    }

    @Override
    protected BaseHolder<OrderInfoItem> getHolder(int position) {
        return new OrderListChildHolder();
    }
}
