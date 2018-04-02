package com.sharemall.sharemall.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sharemall.sharemall.MyApplication;
import com.sharemall.sharemall.R;
import com.sharemall.sharemall.base.BaseTabsPagerSimpleActivity;
import com.sharemall.sharemall.fragment.CategoryFragment;
import com.sharemall.sharemall.fragment.IndexFragment;
import com.sharemall.sharemall.fragment.UserAccountFragment;
import com.sharemall.sharemall.fragment.ShoppingCartFragment;


/**
 * @author Shelly
 */
public class MainActivity extends BaseTabsPagerSimpleActivity {

    private static final int INDEX_PAGE = 0;
    private static final int CATEGORY_PAGE = 1;
    private static final int SHOPPING_CART_PAGE = 2;
    private static final int MINE_PAGE = 3;

    @Override
    protected void addTabs() {
        addTab(initTabView(R.string.main_tab_info, R.drawable.tab_info_selector), new IndexFragment(), null,
                R.id.simple_fragment_1);
        addTab(initTabView(R.string.main_tab_shop, R.drawable.tab_shop_selector), new CategoryFragment(), null,
                R.id.simple_fragment_2);
        addTab(initTabView(R.string.main_tab_message, R.drawable.tab_message_selector), new ShoppingCartFragment(),
                null, R.id.simple_fragment_3);
        addTab(initTabView(R.string.main_tab_account, R.drawable.tab_account_selector), new UserAccountFragment(),
                null, R.id.simple_fragment_4);
    }

    private View initTabView(int tabText, int tabIcon) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tabview, null);
        TextView tv_tab = view.findViewById(R.id.tv_tab);
        ImageView iv_tab = view.findViewById(R.id.iv_tab);
        tv_tab.setText(tabText);
        iv_tab.setImageResource(tabIcon);

        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        super.onTabChanged(tabId);
        if (currentIndex == SHOPPING_CART_PAGE) {
            if (!MyApplication.getInstance().isLogin) {
                goToOthers(UserLoginActivity.class);
            }
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_tabs_pager_simple_fragment;
    }

    @Override
    public void doBusiness(Context context, Bundle savedInstanceState) {
        super.doBusiness(context, savedInstanceState);
    }

    @Override
    public void widgetClick(View v) {

    }
}
