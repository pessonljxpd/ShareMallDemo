package com.sharemall.sharemall.activity;

import android.os.Bundle;
import android.support.v4.content.Loader;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.base.BaseLoadActivity;
import com.sharemall.sharemall.base.net.DataUtil;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.beans.UserInfo;
import com.sharemall.sharemall.utils.JasonResultLoader;


public class UserLoginActivity extends BaseLoadActivity<JasonResult> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_user_login);
		
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
