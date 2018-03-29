package com.sharemall.sharemall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

public class MyListView extends ListView
{
	private static final int MAX_Y_OVERSCROLL_DISTANCE = 200; // �������������

	private Context mContext;
	private int mMaxYOverscrollDistance; // ����������

	public MyListView(Context context)
	{
		super(context);
		this.mContext = context;
		initBounceScrollView();
	}

	public MyListView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		this.mContext = context;
		initBounceScrollView();
	}

	public MyListView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		this.mContext = context;
		initBounceScrollView();
	}

	private void initBounceScrollView()
	{
		final DisplayMetrics metrics = mContext.getResources()
		        .getDisplayMetrics();
		final float density = metrics.density;

		mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);
	}

	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
	        int scrollY, int scrollRangeX, int scrollRangeY,
	        int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent)
	{
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY,
		        scrollRangeX, scrollRangeY, maxOverScrollX,
		        mMaxYOverscrollDistance, isTouchEvent);
	}

	// public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	// {
	// // ����ģʽ����ÿ��child�ĸ߶ȺͿ��
	// int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
	// MeasureSpec.AT_MOST);
	// super.onMeasure(widthMeasureSpec, expandSpec);
	// }
}
