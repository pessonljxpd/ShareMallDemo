package com.sharemall.sharemall.adapter.holder;

import android.view.View;

import com.sharemall.sharemall.MyApplication;
import com.sharemall.sharemall.R;
import com.sharemall.sharemall.beans.OrderInfoItem;
import com.sharemall.sharemall.view.ChildLiistView;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class OrderListChildHolder extends BaseHolder<OrderInfoItem> {

    @Override
    public View initHolderView() {
        View view = View.inflate(MyApplication.getInstance(), R.layout.item_order_child,null);

        return view;
    }

    @Override
    public void bindData(OrderInfoItem data) {

    }
}
