package com.sharemall.sharemall.beans;

/**
 * 服务器返回的json数据类型
 * @author Shelly
 */
public class JasonResult {
    /**
     * 响应码（0：成功，1：失败）
     */
    public int code;

    /**
     * code=1时显示给用户的信息
     */
    public String message;

    /**
     * 返回的数据
     */
    public String data;

}
