package com.sharemall.sharemall.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.sharemall.sharemall.MyApplication;
import com.sharemall.sharemall.beans.UserInfo;
import com.sharemall.sharemall.itf.ISharePreferenceFactory;


/**
 * @author Shelly
 */
public class BaseShareference implements ISharePreferenceFactory {
    private SharedPreferences sp;

    private Editor editor;

    public BaseShareference(Context context) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    @Override
    public Editor getEditor() {
        return editor;
    }

    @Override
    public SharedPreferences getSharedPreferences() {
        return sp;
    }

    /**
     * 是否去导航页面
     *
     * @return
     */
    @Override
    public boolean isGoToGuide() {
        return sp.getBoolean("isShowGuide_1.1.0", true);
    }

    /**
     * 完成导航
     */
    @Override
    public void finishGuide() {
        editor.putBoolean("isShowGuide_1.1.0", false);
        editor.commit();
    }

    /**
     * 是否去导航页面
     *
     * @return
     */
    @Override
    public boolean showFunctionGuide() {
        return sp.getBoolean("showFunctionGuide", true);
    }

    /**
     * 完成导航
     */
    @Override
    public void finishFunctionGuide() {
        editor.putBoolean("showFunctionGuide", false);
        editor.commit();
    }

    @Override
    public UserInfo getUser() {
        return new Gson().fromJson(sp.getString("user", ""), UserInfo.class);
    }

    @Override
    public void setUser(UserInfo info) {
        editor.putString("user", new Gson().toJson(info));
        editor.commit();
    }

    /**
     * 设置账号
     */
    @Override
    public void setUserName(String userName) {
        editor.putString("userName", Tools.trim(userName));
        editor.commit();
    }

    /**
     * 获取账号
     */
    @Override
    public String getUserName() {
        return sp.getString("userName", "");
    }

    /**
     * 设置密码
     */
    @Override
    public void setPassword(String password) {
        editor.putString("password", Tools.trim(password));
        editor.commit();
    }

    /**
     * 获取密码
     */
    @Override
    public String getPassword() {
        return sp.getString("password", "");
    }

    /**
     * 设置是否记住密码
     */
    @Override
    public void setRememberPassword(boolean isRememberPassword) {
        editor.putBoolean(getUserName() + "isRememberPassword",
                isRememberPassword);
        editor.commit();
    }

    /**
     * 是否记住密码
     */
    @Override
    public boolean isRememberPassword() {
        return sp.getBoolean(getUserName() + "isRememberPassword", true);
    }

    /**
     * 设置是否自动登录
     */
    @Override
    public void setAutoLogin(boolean isAutoLogin) {
        editor.putBoolean(getUserName() + "isAutoLogin", isAutoLogin);
        editor.commit();
    }

    /**
     * 是否自动登录
     */
    @Override
    public boolean isAutoLogin() {
        return sp.getBoolean(getUserName() + "isAutoLogin", true);
    }

    /**
     * 设置默认搜索城市
     */
    public void setDefultCity(String defultCity) {
        editor.putString("defultCity", defultCity);
        // editor.putString(MyApplication.getInstance().user != null ?
        // MyApplication.getInstance().user.userID
        // + "defultCity" : "defultCity", defultCity);
        editor.commit();
    }

    /**
     * 设置默认搜索城市ID
     */
    public void setDefultCityID(String defultCityID) {
        editor.putString("defultCityID", defultCityID);
        // editor.putString(MyApplication.getInstance().user != null ?
        // MyApplication.getInstance().user.userID
        // + "defultCityID" : "defultCityID", defultCityID);
        editor.commit();
    }


    /**
     * 设置默认工程所在地
     */
    public void setProjectArea(String projectArea) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "projectArea", projectArea);
        editor.commit();
    }

    /**
     * 获取默认工程所在地
     */
    public String getProjectArea() {
        return sp.getString(MyApplication.getInstance().getUser().userID
                + "projectArea", "");
    }

    /**
     * 设置默认联系人
     */
    @Override
    public void setLinkman(String linkman) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "linkman", linkman);
        editor.commit();
    }

    /**
     * 获取默认联系人
     */
    @Override
    public String getLinkman() {
        return sp.getString(MyApplication.getInstance().getUser().userID
                + "linkman", "");
    }

    /**
     * 获取默认联系电话
     */
    @Override
    public void setContactTele(String contactTele) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "contactTele", contactTele);
        editor.commit();
    }

    /**
     * 获取默认联系电话
     */
    @Override
    public String getContactTele() {
        return sp.getString(MyApplication.getInstance().getUser().userID
                + "contactTele", "");
    }

    /**
     * 设置是否保存设置
     */
    @Override
    public void setSaveSetting(boolean isSaveSetting) {
        editor.putBoolean(MyApplication.getInstance().getUser().userID
                + "isSaveSetting", isSaveSetting);
        editor.commit();
    }

    /**
     * 是否保存设置
     */
    @Override
    public boolean isSaveSetting() {
        return sp.getBoolean(MyApplication.getInstance().getUser().userID
                + "isSaveSetting", true);
    }

    /**
     * 设置工程所在地ID
     */
    public void setProjectAreaID(String projectAreaID) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "projectAreaID", projectAreaID);
        editor.commit();
    }

    /**
     * 获取工程所在地ID
     */
    public String getProjectAreaID() {
        return sp.getString(MyApplication.getInstance().getUser().userID
                + "projectAreaID", "");
    }

    public void setInfoPriceCityName(String infoPriceCityName) {
        editor.putString("infoPriceCityName", infoPriceCityName);
        editor.commit();
    }


}
