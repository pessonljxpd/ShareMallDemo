package com.sharemall.sharemall.fragment;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.base.BaseLoadFragment;
import com.sharemall.sharemall.beans.JasonResult;


/**
 * �˻���ҳ
 * 
 */
public class ShoppingCartFragment extends BaseLoadFragment<JasonResult>
{
	private TextView tv_user_alias, tv_user_name;
	private ImageView iv_user_icon;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
	
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
