package com.sharemall.sharemall.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.base.BaseLoadActivity;
import com.sharemall.sharemall.base.net.DataUtil;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.beans.UserInfo;
import com.sharemall.sharemall.utils.JasonResultLoader;


/**
 * @author Shelly
 */
public class UserLoginActivity extends BaseLoadActivity<JasonResult> {

    @Override
    public int bindLayout() {
        return R.layout.activity_user_login;
    }

    @Override
    public void doBusiness(Context context, Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    protected void loadFinished(int action, JasonResult arg1) {
        UserInfo data = new DataUtil().getData(arg1.data, UserInfo.class);

    }

    @Override
    public Loader<JasonResult> onCreateLoader(int arg0, Bundle arg1) {

        return new JasonResultLoader(this, 1, null, new UserInfo());
    }

}
