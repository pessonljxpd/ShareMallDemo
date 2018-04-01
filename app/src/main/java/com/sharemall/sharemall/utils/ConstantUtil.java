package com.sharemall.sharemall.utils;

public class ConstantUtil {
    /**
     * 拍照标示
     */
    public static final int TAKE_PHOTOS = 1;

    /**
     * 选择图片标示
     */
    public static final int SELECT_PICS = 2;

    /**
     * 裁剪图片标示
     */
    public static final int CROP_PIC = 3;

    /**
     * 列表动画时间（单位：毫秒）
     */
    public static final long LIST_ANIMATION_TIME = 10;

    /**
     * 未支付订单
     */
    public static final int ORDER_TYPE_UNPAY = 101;
    /**
     * 已支付订单
     */
    public static final int ORDER_TYPE_PAYED = 102;
    /**
     * 已完成订单
     */
    public static final int ORDER_TYPE_COMPLETED = 103;
    /**
     * 、
     * 已取消订单
     */
    public static final int ORDER_TYPE_CANCEL = 104;
    /**
     * 、
     * 订单类型传递数据的key
     */
    public static final String ORDER_TYPE = "ORDER_TYPE";
}
