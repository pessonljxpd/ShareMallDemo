package com.sharemall.sharemall.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.sharemall.sharemall.R;

import java.util.ArrayList;
import java.util.List;

import com.sharemall.sharemall.adapter.OrderViewPagerAdapter;
import com.sharemall.sharemall.base.BaseActivity;
import com.sharemall.sharemall.fragment.OrderListFragment;
import com.sharemall.sharemall.utils.ConstantUtil;


/**
 * @author Shelly
 */
public class OrderListActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private OrderViewPagerAdapter viewPagerAdapter;
    /**
     * TabLayout标签
     */
    private String[] titles = new String[]{"未支付", "已支付", "已完成", "已取消"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int bindLayout() {
        return R.layout.activity_order_list;
    }

    @Override
    public void doBusiness(Context context, Bundle savedInstanceState) {
        init();
    }

    @Override
    public void widgetClick(View v) {

    }

    private void init() {
        tabLayout = findViewById(R.id.tab_layou);
        viewPager = findViewById(R.id.view_pager);
        //设置TabLayout标签的显示方式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //循环注入标签
        for (String tab : titles) {
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        //设置TabLayout点击事件
        tabLayout.setOnTabSelectedListener(this);

        fragments.add(getTypedFragment(ConstantUtil.ORDER_TYPE_UNPAY));
        fragments.add(getTypedFragment(ConstantUtil.ORDER_TYPE_PAYED));
        fragments.add(getTypedFragment(ConstantUtil.ORDER_TYPE_COMPLETED));
        fragments.add(getTypedFragment(ConstantUtil.ORDER_TYPE_CANCEL));

        viewPagerAdapter = new OrderViewPagerAdapter(getSupportFragmentManager(), titles, fragments);

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        viewPager.setCurrentItem(tab.getPosition()
        );
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private OrderListFragment getTypedFragment(int type) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.ORDER_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }
}
