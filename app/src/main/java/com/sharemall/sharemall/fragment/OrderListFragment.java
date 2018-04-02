package com.sharemall.sharemall.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.OrderListAdapter;
import com.sharemall.sharemall.base.BaseLoadFragment;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.beans.OrderInfoItem;
import com.sharemall.sharemall.utils.ConstantUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class OrderListFragment extends BaseLoadFragment<JasonResult> {

    private int ordertype;
    private ListView lv_order_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, null);
        lv_order_list = (ListView) view.findViewById(R.id.lv_order_list);
        List<OrderInfoItem> list = new ArrayList<>();
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        lv_order_list.setAdapter(new OrderListAdapter(list));
        ordertype = getArguments().getInt(ConstantUtil.ORDER_TYPE);
        switch (ordertype) {
            case ConstantUtil.ORDER_TYPE_UNPAY:

                break;
            case ConstantUtil.ORDER_TYPE_PAYED:

                break;
            case ConstantUtil.ORDER_TYPE_COMPLETED:

                break;
            case ConstantUtil.ORDER_TYPE_CANCEL:

                break;
            default:
                break;
        }
        Toast.makeText(getContext(), "OrderList" + ordertype, Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    protected void loadFinished(int action, JasonResult arg1) {

    }

    @Override
    public Loader<JasonResult> onCreateLoader(int arg0, Bundle arg1) {
        return null;
    }
}
