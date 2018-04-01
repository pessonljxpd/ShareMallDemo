package com.sharemall.sharemall.itf;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.sharemall.sharemall.beans.UserInfo;

/**
 * sharePreference操作工厂
 *
 * @author Shelly
 */
public interface ISharePreferenceFactory {

    /**
     * getSharedPreferences
     *
     * @return
     */
    SharedPreferences getSharedPreferences();

    /**
     * getEditor
     *
     * @return
     */
    Editor getEditor();

    /**
     * 是否去导航页面
     *
     * @return
     */
    boolean isGoToGuide();

    /**
     * 完成导航
     */
    void finishGuide();

    /**
     * 是否去导航页面
     *
     * @return
     */
    boolean showFunctionGuide();

    /**
     * 完成导航
     */
    void finishFunctionGuide();

    void setUser(UserInfo info);

    UserInfo getUser();

    /**
     * 设置账号
     *
     * @param userName 账号
     */
    void setUserName(String userName);

    /**
     * 获取密码
     *
     * @return 密码
     */
    String getUserName();

    /**
     * 设置密码
     *
     * @param password 密码
     */
    void setPassword(String password);

    /**
     * 获取密码
     *
     * @return 密码
     */
    String getPassword();

    /**
     * 设置记住密码
     *
     * @param isRememberPassword 是否记住密码
     */
    void setRememberPassword(boolean isRememberPassword);

    /**
     * 是否记住密码
     *
     * @return 是否记住密码
     */
    boolean isRememberPassword();

    /**
     * 设置是否自动登录
     *
     * @param isAutoLogin 是否自动登录
     */
    void setAutoLogin(boolean isAutoLogin);

    /**
     * 是否自动登录
     *
     * @return 是否自动登录
     */
    boolean isAutoLogin();


    /**
     * 设置默认联系人
     *
     * @param linkman 默认联系人
     */
    void setLinkman(String linkman);

    /**
     * 获取默认联系人
     *
     * @return 默认联系人
     */
    String getLinkman();

    /**
     * 设置默认联系电话
     *
     * @param contactTele 默认联系电话
     */
    void setContactTele(String contactTele);

    /**
     * 获取默认联系电话
     *
     * @return 默认联系电话
     */
    String getContactTele();

    /**
     * 设置是否保存设置
     *
     * @param isSaveSetting 是否保存设置
     */
    void setSaveSetting(boolean isSaveSetting);

    /**
     * 是否保存设置
     *
     * @return 是否保存设置
     */
    boolean isSaveSetting();


}
