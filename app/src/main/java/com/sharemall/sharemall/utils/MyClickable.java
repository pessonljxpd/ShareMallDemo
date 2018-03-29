package com.sharemall.sharemall.utils;

import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public class MyClickable extends ClickableSpan
{
	private final OnClickListener listener;

	public MyClickable(OnClickListener listener)
	{
		this.listener = listener;
	}

	public void onClick(View widget)
	{
		listener.onClick(widget);
	}

}
