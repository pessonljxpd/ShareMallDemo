package com.sharemall.sharemall.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.sharemall.sharemall.MyApplication;
import com.sharemall.sharemall.beans.UserInfo;
import com.sharemall.sharemall.itf.ISharePreferenceFactory;


public class BaseShareference implements ISharePreferenceFactory {
    private SharedPreferences sp;

    private Editor editor;

    @SuppressLint("CommitPrefEdits")
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
     * �Ƿ�ȥ����ҳ��
     *
     * @return
     */
    @Override
    public boolean isGoToGuide() {
        return sp.getBoolean("isShowGuide_1.1.0", true);
    }

    /**
     * ��ɵ���
     */
    @Override
    public void finishGuide() {
        editor.putBoolean("isShowGuide_1.1.0", false);
        editor.commit();
    }

    /**
     * �Ƿ�ȥ����ҳ��
     *
     * @return
     */
    @Override
    public boolean showFunctionGuide() {
        return sp.getBoolean("showFunctionGuide", true);
    }

    /**
     * ��ɵ���
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
     * �����˺�
     */
    @Override
    public void setUserName(String userName) {
        editor.putString("userName", Tools.trim(userName));
        editor.commit();
    }

    /**
     * ��ȡ�˺�
     */
    @Override
    public String getUserName() {
        return sp.getString("userName", "");
    }

    /**
     * ��������
     */
    @Override
    public void setPassword(String password) {
        editor.putString("password", Tools.trim(password));
        editor.commit();
    }

    /**
     * ��ȡ����
     */
    @Override
    public String getPassword() {
        return sp.getString("password", "");
    }

    /**
     * �����Ƿ��ס����
     */
    @Override
    public void setRememberPassword(boolean isRememberPassword) {
        editor.putBoolean(getUserName() + "isRememberPassword",
                isRememberPassword);
        editor.commit();
    }

    /**
     * �Ƿ��ס����
     */
    @Override
    public boolean isRememberPassword() {
        return sp.getBoolean(getUserName() + "isRememberPassword", true);
    }

    /**
     * �����Ƿ��Զ���¼
     */
    @Override
    public void setAutoLogin(boolean isAutoLogin) {
        editor.putBoolean(getUserName() + "isAutoLogin", isAutoLogin);
        editor.commit();
    }

    /**
     * �Ƿ��Զ���¼
     */
    @Override
    public boolean isAutoLogin() {
        return sp.getBoolean(getUserName() + "isAutoLogin", true);
    }

    /**
     * ����Ĭ����������
     */
    public void setDefultCity(String defultCity) {
        editor.putString("defultCity", defultCity);
        // editor.putString(MyApplication.getInstance().user != null ?
        // MyApplication.getInstance().user.userID
        // + "defultCity" : "defultCity", defultCity);
        editor.commit();
    }

    /**
     * ����Ĭ����������ID
     */
    public void setDefultCityID(String defultCityID) {
        editor.putString("defultCityID", defultCityID);
        // editor.putString(MyApplication.getInstance().user != null ?
        // MyApplication.getInstance().user.userID
        // + "defultCityID" : "defultCityID", defultCityID);
        editor.commit();
    }


    /**
     * ����Ĭ�Ϲ������ڵ�
     */
    public void setProjectArea(String projectArea) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "projectArea", projectArea);
        editor.commit();
    }

    /**
     * ��ȡĬ�Ϲ������ڵ�
     */
    public String getProjectArea() {
        return sp.getString(MyApplication.getInstance().getUser().userID
                + "projectArea", "");
    }

    /**
     * ����Ĭ����ϵ��
     */
    @Override
    public void setLinkman(String linkman) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "linkman", linkman);
        editor.commit();
    }

    /**
     * ��ȡĬ����ϵ��
     */
    @Override
    public String getLinkman() {
        return sp.getString(MyApplication.getInstance().getUser().userID
                + "linkman", "");
    }

    /**
     * ��ȡĬ����ϵ�绰
     */
    @Override
    public void setContactTele(String contactTele) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "contactTele", contactTele);
        editor.commit();
    }

    /**
     * ��ȡĬ����ϵ�绰
     */
    @Override
    public String getContactTele() {
        return sp.getString(MyApplication.getInstance().getUser().userID
                + "contactTele", "");
    }

    /**
     * �����Ƿ񱣴�����
     */
    @Override
    public void setSaveSetting(boolean isSaveSetting) {
        editor.putBoolean(MyApplication.getInstance().getUser().userID
                + "isSaveSetting", isSaveSetting);
        editor.commit();
    }

    /**
     * �Ƿ񱣴�����
     */
    @Override
    public boolean isSaveSetting() {
        return sp.getBoolean(MyApplication.getInstance().getUser().userID
                + "isSaveSetting", true);
    }

    /**
     * ���ù������ڵ�ID
     */
    public void setProjectAreaID(String projectAreaID) {
        editor.putString(MyApplication.getInstance().getUser().userID
                + "projectAreaID", projectAreaID);
        editor.commit();
    }

    /**
     * ��ȡ�������ڵ�ID
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
