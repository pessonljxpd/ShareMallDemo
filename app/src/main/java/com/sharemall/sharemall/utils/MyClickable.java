package com.sharemall.sharemall.utils;

import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author Shelly
 */
public class MyClickable extends ClickableSpan {
    private final OnClickListener listener;

    public MyClickable(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View widget) {
        listener.onClick(widget);
    }

}
