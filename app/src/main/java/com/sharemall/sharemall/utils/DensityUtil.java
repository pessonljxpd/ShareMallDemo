package com.sharemall.sharemall.utils;

import android.content.Context;

/**
 * ��λת��������
 * 
 * @author zenglinkui
 * 
 */
public class DensityUtil
{
	/**
	 * dipת��px
	 * 
	 * @param context
	 *            ������
	 * @param dpValue
	 *            dipֵ
	 * @return pxֵ
	 */
	public static int dip2px(Context context, float dpValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * pxת��dip
	 * 
	 * @param context
	 *            ������
	 * @param pxValue
	 *            pxֵ
	 * @return dipֵ
	 */
	public static int px2dip(Context context, float pxValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
}
