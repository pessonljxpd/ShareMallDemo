package com.sharemall.sharemall.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.OrderListAdapter;
import com.sharemall.sharemall.adapter.OrderListChildAdapter;
import com.sharemall.sharemall.adapter.OrderViewPagerAdapter;
import com.sharemall.sharemall.base.BaseActivity;
import com.sharemall.sharemall.base.BaseLoadActivity;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.beans.OrderInfoItem;
import com.sharemall.sharemall.fragment.OrderListFragment;
import com.sharemall.sharemall.utils.ConstantUtil;

import java.util.ArrayList;
import java.util.List;


public class OrderdetailActivity extends BaseLoadActivity<JasonResult>{


    private ListView lv_order_childitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_order_detail);
        lv_order_childitem = (ListView) findViewById(R.id.lv_order_childitem);
        List<OrderInfoItem> list = new ArrayList<>();
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        list.add(new OrderInfoItem());
        lv_order_childitem.setAdapter(new OrderListChildAdapter(list));
    }


    @Override
    protected void loadFinished(int action, JasonResult arg1) {

    }

    @Override
    public Loader<JasonResult> onCreateLoader(int arg0, Bundle arg1) {
        return null;
    }
}
