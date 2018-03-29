package com.sharemall.sharemall.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * �Զ���TextView
 * 
 * @author hailongw
 * 
 */
public class MyTextView extends TextView
{

	private static final String NAMESPACE = "http://www.ywlx.net/apk/res/easymobi";
	private static final String ATTR_ROTATE = "rotate";
	private static final int DEFAULTVALUE_DEGREES = 0;
	private int degrees;

	public MyTextView(Context context)
	{
		super(context);
	}

	public MyTextView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		degrees = attrs.getAttributeIntValue(NAMESPACE, ATTR_ROTATE,
		        DEFAULTVALUE_DEGREES);
	}

	protected void onDraw(Canvas canvas)
	{
		canvas.rotate(degrees, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
		super.onDraw(canvas);
	}

	public boolean isFocused()
	{
		return true;
	}
}
