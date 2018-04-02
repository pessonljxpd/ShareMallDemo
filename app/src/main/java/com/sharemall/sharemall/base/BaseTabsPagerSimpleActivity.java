package com.sharemall.sharemall.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Shelly
 */
public abstract class BaseTabsPagerSimpleActivity extends BaseActivity implements OnTabChangeListener, IntentListener {
    protected TabHost mTabHost;
    protected TabWidget mTabWidget;
    protected int currentIndex;
    private FrameLayout container;

    private List<BaseFragment> fragments;
    private List<FrameLayout> containers;
    private List<Integer> containerIDs;
    private List<Boolean> isLoadContents;

    /**
     * 绑定布局
     *
     * @return
     */
    @Override
    public abstract int bindLayout();

    @Override
    public void doBusiness(Context context, Bundle savedInstanceState) {
        container = findViewById(R.id.simple_fragment);
        mTabHost = findViewById(android.R.id.tabhost);

        mTabHost.setup();
        mTabWidget = mTabHost.getTabWidget();
        mTabWidget.setDividerDrawable(null);
        mTabHost.setOnTabChangedListener(this);

        fragments = new ArrayList<>();
        isLoadContents = new ArrayList<>();
        containerIDs = new ArrayList<>();
        containers = new ArrayList<>();

        addTabs();

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("currentIndex");
            if (currentIndex != 0) {
                setTabChange(currentIndex);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentIndex", currentIndex);
        super.onSaveInstanceState(outState);
    }

    /**
     * 设置Tab切换
     *
     * @param tabIndex 切换的Tab下标
     */
    protected void setTabChange(int tabIndex) {
        mTabHost.setCurrentTab(tabIndex);
    }

    /**
     * 获取当前Tab下标
     *
     * @return Tab下标
     */
    protected int getTabPosition() {
        return currentIndex;
    }

    /**
     * 子类需要实现add tab的方法
     * 如：mTabsAdapter.addTab(mTabHost.newTabSpec("custom").setIndicator
     * ("Custom"), LoaderCourseListSupport.CourseListFragment.class, null);
     */
    protected abstract void addTabs();

    /**
     * 添加tab子页面
     *
     * @param tabView     Tab导航名称
     * @param fragment    Tab类型
     * @param bundle      Tab页Class对象
     * @param containerID 传递参数
     */
    protected void addTab(View tabView, BaseFragment fragment, Bundle bundle, Integer containerID) {
        isLoadContents.add(false);
        containerIDs.add(containerID);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(containerID);
        frameLayout.setVisibility(View.GONE);
        containers.add(frameLayout);
        container.addView(frameLayout, LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);

        fragment.setArguments(bundle);
        fragments.add(fragment);
        TabSpec tabSpec = mTabHost.newTabSpec(fragment.getClass()
                .getSimpleName());
        tabSpec.setIndicator(tabView);
        tabSpec.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tabSpec);
    }

    @Override
    public void onTabChanged(String tabId) {
        currentIndex = mTabHost.getCurrentTab();

        for (int i = 0; i < isLoadContents.size(); i++) {
            if (currentIndex == i) {
                if (!isLoadContents.get(i)) {
                    replaceFragment(containerIDs.get(i), fragments.get(currentIndex), true);
                    isLoadContents.set(i, true);
                }
                containers.get(i).setVisibility(View.VISIBLE);
            } else {
                containers.get(i).setVisibility(View.GONE);
            }
        }

    }

    public static class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
    }
}
