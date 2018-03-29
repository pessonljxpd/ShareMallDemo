package com.sharemall.sharemall.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sharemall.sharemall.MyApplication;
import com.sharemall.sharemall.R;
import com.sharemall.sharemall.base.BaseTabsPagerSimpleActivity;
import com.sharemall.sharemall.fragment.MainAccountFragment;

public class MainActivity extends BaseTabsPagerSimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void addTabs() {

        addTab(initTabView(R.string.main_tab_info, R.drawable.tab_info_selector),
                new MainAccountFragment(), null, R.id.simple_fragment_1);
        addTab(initTabView(R.string.main_tab_shop, R.drawable.tab_shop_selector),
                new MainAccountFragment(), null, R.id.simple_fragment_2);
        addTab(initTabView(R.string.main_tab_message,
                R.drawable.tab_message_selector), new MainAccountFragment(),
                null, R.id.simple_fragment_3);
        addTab(initTabView(R.string.main_tab_account,
                R.drawable.tab_account_selector), new MainAccountFragment(),
                null, R.id.simple_fragment_4);
    }

    private View initTabView(int tabText, int tabIcon) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tabview,
                null);
        TextView tv_tab = (TextView) view.findViewById(R.id.tv_tab);
        ImageView iv_tab = (ImageView) view.findViewById(R.id.iv_tab);
        tv_tab.setText(tabText);
        iv_tab.setImageResource(tabIcon);

        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub
        super.onTabChanged(tabId);
        if (currentIndex == 2) {
            if (MyApplication.getInstance().isLogin == false) {
                goToOthers(UserLoginActivity.class);
            }
        }
    }

}
