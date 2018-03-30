package com.sharemall.sharemall.utils;

public class ConstantUtil
{
	/**
	 * ���ձ�ʾ
	 */
	public static final int TAKE_PHOTOS = 1;

	/**
	 * ѡ��ͼƬ��ʾ
	 */
	public static final int SELECT_PICS = 2;

	/**
	 * �ü�ͼƬ��ʾ
	 */
	public static final int CROP_PIC = 3;

	/**
	 * �б���ʱ�䣨��λ�����룩
	 */
	public static final long LIST_ANIMATION_TIME = 10;

	/**
	 * 未支付订单
	 */
	public static  final int ORDER_TYPE_UNPAY = 101;
	/**
	 * 已支付订单
	 */
	public static  final int ORDER_TYPE_PAYED = 102;
	/**
	 * 已完成订单
	 */
	public static  final int ORDER_TYPE_COMPLETED = 103;
	/**、
	 * 已取消订单
	 */
	public static  final int ORDER_TYPE_CANCEL = 104;
	/**、
	 * 订单类型传递数据的key
	 */
	public static  final String ORDER_TYPE = "ORDER_TYPE";
}
