package com.sharemall.sharemall.fragment;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.activity.AddressListActivity;

import com.sharemall.sharemall.activity.OrderListActivity;
import com.sharemall.sharemall.activity.OrderdetailActivity;
import com.sharemall.sharemall.base.BaseLoadFragment;
import com.sharemall.sharemall.beans.JasonResult;


/**
 * �˻���ҳ
 * 
 */
public class MainAccountFragment extends BaseLoadFragment<JasonResult>
{
	private TextView tv_user_alias, tv_user_name;
	private ImageView iv_user_icon;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_account, container, false);
	    View tv_cooperation = view.findViewById(R.id.tv_cooperation);
		tv_cooperation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				goToOthers(AddressListActivity.class);
			}
		});
		View tv_about_us = view.findViewById(R.id.tv_about_us);
		tv_about_us.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				goToOthers(OrderListActivity.class);
			}
		});
		View tv_app_update = view.findViewById(R.id.tv_app_update);
		tv_app_update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				goToOthers(OrderdetailActivity.class);
			}
		});
		return view;
	}
	  @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getLoaderManager().restartLoader(1, null, this);
	}
	@Override
	protected void loadFinished(int action, JasonResult arg1) {
		
		
	}

	@Override
	public Loader<JasonResult> onCreateLoader(int arg0, Bundle arg1) {
		
		return null;
	}
}
