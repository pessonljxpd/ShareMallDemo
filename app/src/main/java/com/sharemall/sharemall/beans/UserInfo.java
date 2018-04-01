package com.sharemall.sharemall.beans;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author wanghl-a
 */
public class UserInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserInfo() {
    }

    public UserInfo(int userID, String alias, String topImagePath,
            String gender, String address, String sign) {
        this.userID = userID;
        this.alias = alias;
        this.topImagePath = topImagePath;
        this.gender = gender;
        this.address = address;
        this.sign = sign;
    }

    /**
     * 用户账号
     */
    public String userName;

    /**
     * 用户密码（加密后）
     */
    public String password;

    /**
     * 新密码（修改密码时使用）
     */
    public String newPassword;

    /**
     * 用户ID
     */
    public int userID;

    /**
     * 提供商ID
     */
    public int supplierID;

    /**
     * 用户昵称
     */
    public String alias;

    /**
     * 头像路径
     */
    public String topImagePath;

    /**
     * 性别
     */
    public String gender;

    /**
     * 所在地
     */
    public String address;

    /**
     * 所在地code
     */
    public String areaCode;

    /**
     * 个性签名
     */
    public String sign;

    /**
     * 用户真实姓名
     */
    public String realName;

    /**
     * 手机号
     */
    public String cellPhone;

    /**
     * 用户反馈联系方式
     */
    public String email;

    /**
     * 反馈
     */
    public String feedback;

    /**
     * 反馈地区
     */
    public String feedBackArea;

    /**
     * 是否是VIP会员
     */
    public boolean vip;

    /**
     * 是否是真的VIP会员
     */
    public boolean isRealVip;

    /**
     * 是否在试用期
     */
    public boolean expireTime;

    /**
     * 询价条数
     */
    public int enquiryNum;

    /**
     * 应用标示
     */
    public String appid;

    /**
     * 通道标识
     */
    public String channel_id;

    /**
     * 用户标识
     */
    public String user_id;

    /**
     * 注册方式(0:普通注册;1:手机号注册)
     */
    public int registerType;

    /**
     * 手机验证码
     */
    public String validateCode;

    /**
     * 重置密码手机验证码
     */
    public String resetPasswordCode;


    /**
     * 绑定类型(1:手机;2:QQ)
     */
    public int bindType;

    /**
     * QQUID
     */
    public String qqUid;

    /**
     * QQ昵称
     */
    public String qqNickName;

    /**
     * 是否绑定QQ
     */
    public int bindQQ;

    /**
     * 是否绑定手机
     */
    public int bindCellPhone;

    /**
     * 积分字段
     */
    public int point;

    /**
     * 未读系统消息条数
     */
    public int unReadSysMessageNumber;

    /**
     * 未读私人消息条数
     */
    public int unReadChatNumber;

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
