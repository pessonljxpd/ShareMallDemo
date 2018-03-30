package com.sharemall.sharemall.adapter.holder;

import android.view.View;

import com.sharemall.sharemall.MyApplication;
import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.OrderListChildAdapter;
import com.sharemall.sharemall.beans.AddressInfo;
import com.sharemall.sharemall.beans.OrderInfoItem;
import com.sharemall.sharemall.view.ChildLiistView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class OrderListHolder extends BaseHolder<OrderInfoItem> {
    private ChildLiistView listView;
    @Override
    public View initHolderView() {
        View view = View.inflate(MyApplication.getInstance(), R.layout.item_order,null);
        listView =  (ChildLiistView)view.findViewById(R.id.lv_order_childitem);
        return view;
    }

    @Override
    public void bindData(OrderInfoItem data) {
        List<OrderInfoItem> list = new ArrayList<>();
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
     listView.setAdapter(new OrderListChildAdapter(list));
    }
}
