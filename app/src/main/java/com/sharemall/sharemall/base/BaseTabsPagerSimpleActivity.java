package com.sharemall.sharemall.base;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

import com.sharemall.sharemall.R;


public abstract class BaseTabsPagerSimpleActivity extends BaseActivity
        implements OnTabChangeListener,IntentListener
{
	protected TabHost mTabHost;
	protected TabWidget mTabWidget;
	protected int currentIndex;
	private FrameLayout container;

	private List<BaseFragment> fragments;
	private List<FrameLayout> containers; 
	private List<Integer> containerIDs;
	private List<Boolean> isLoadContents;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_tabs_pager_simple_activity);
		container = (FrameLayout) findViewById(R.id.simple_fragment);
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		mTabWidget = mTabHost.getTabWidget();
		mTabWidget.setDividerDrawable(null);
		mTabHost.setOnTabChangedListener(this);

		fragments = new ArrayList<BaseFragment>();
		isLoadContents = new ArrayList<Boolean>();
		containerIDs = new ArrayList<Integer>();
		containers = new ArrayList<FrameLayout>();

		addTabs();

		if (savedInstanceState != null)
		{
			currentIndex = savedInstanceState.getInt("currentIndex");
			if (currentIndex != 0)
			{
				setTabChange(currentIndex);
			}
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		outState.putInt("currentIndex", currentIndex);
		super.onSaveInstanceState(outState);
	}

	/**
	 * ����Tab�л�
	 * 
	 * @param tabIndex
	 *            �л���Tab�±�
	 */
	protected void setTabChange(int tabIndex)
	{
		mTabHost.setCurrentTab(tabIndex);
	}

	/**
	 * ��ȡ��ǰTab�±�
	 * 
	 * @return Tab�±�
	 */
	protected int getTabPosition()
	{
		return currentIndex;
	}

	/**
	 * ������Ҫʵ��add tab�ķ���
	 * �磺mTabsAdapter.addTab(mTabHost.newTabSpec("custom").setIndicator
	 * ("Custom"), LoaderCourseListSupport.CourseListFragment.class, null);
	 */
	protected abstract void addTabs();

	/**
	 * ���Tab��ҳ��
	 * 
	 * @param tabText
	 *            Tab��������
	 * @param type
	 *            Tab����
	 * @param cls
	 *            TabҳClass����
	 * @param bundle
	 *            ���ݲ���
	 */
	protected void addTab(View tabView, BaseFragment fragment, Bundle bundle,
	        Integer containerID)
	{
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
	public void onTabChanged(String tabId)
	{
		currentIndex = mTabHost.getCurrentTab();

		for (int i = 0; i < isLoadContents.size(); i++)
		{
			if (currentIndex == i)
			{
				if (!isLoadContents.get(i))
				{
					replaceFragment(containerIDs.get(i),
					        fragments.get(currentIndex), true);
					isLoadContents.set(i, true);
				}
				containers.get(i).setVisibility(View.VISIBLE);
			}
			else
			{
				containers.get(i).setVisibility(View.GONE);
			}
		}

	}

	public static class DummyTabFactory implements TabHost.TabContentFactory
	{
		private final Context mContext;

		public DummyTabFactory(Context context)
		{
			mContext = context;
		}

		@Override
		public View createTabContent(String tag)
		{
			View v = new View(mContext);
			v.setMinimumWidth(0);
			v.setMinimumHeight(0);
			return v;
		}
	}
}
