package com.sharemall.sharemall;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.sharemall.sharemall.beans.UserInfo;
import com.sharemall.sharemall.itf.ISharePreferenceFactory;
import com.sharemall.sharemall.utils.BaseShareference;
import com.sharemall.sharemall.utils.DensityUtil;
import com.sharemall.sharemall.utils.ImageUtil;


public class MyApplication extends Application {
    private static MyApplication instance = null;
    /**
     * �Ƿ��¼
     */
    public boolean isLogin = false;

    /**
     * Ӧ���Ƿ��������
     */
    public boolean isAppUpdate = false;

    public boolean isModify = false;

    /**
     * �û���Ϣ
     */
    private UserInfo user;


    public boolean isReceivered = false;

    private ISharePreferenceFactory sharePreferenceFactory;

    @Override
    public void onCreate() {
        sharePreferenceFactory = new BaseShareference(this);
        instance = this;

        super.onCreate();
    }

    public static MyApplication getInstance() {
        return instance != null ? instance : new MyApplication();
    }

    public void setUser(UserInfo user) {
        this.user = user;
        sharePreferenceFactory.setUser(user != null ? user : new UserInfo());
    }

    public UserInfo getUser() {
        if (user == null) {
            user = sharePreferenceFactory.getUser();
            if (user == null) {
                user = new UserInfo();
            }
            isLogin = true;
        }
        if (user.userID > 0) {
            isLogin = true;
        } else {
            isLogin = false;
        }
        return user;
    }

    /**
     * ��ʼ���û�ͷ��
     *
     * @param context      ������
     * @param imagePath    ͷ���ַ
     * @param iv_user_icon ͷ��ؼ�
     */
    public static void initUserIcon(Context context, ImageUtil imageUtil,
            String imagePath, final ImageView iv_user_icon, int dipSize) {
        imageUtil.loadBitmap(iv_user_icon, imagePath,
                DensityUtil.dip2px(context, dipSize), R.drawable.defaut,
                DensityUtil.dip2px(context, 7));
    }

}
