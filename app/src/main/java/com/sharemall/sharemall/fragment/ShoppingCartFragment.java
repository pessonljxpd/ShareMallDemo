package com.sharemall.sharemall.fragment;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.CartExpandableListAdapter;
import com.sharemall.sharemall.base.BaseLoadFragment;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.utils.DensityUtil;
import com.sharemall.sharemall.view.AmountView;


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
		View view = inflater.inflate(R.layout.main, container, false);
		//创建一个BaseExpandableListAdapter对象
		ExpandableListAdapter adapter = new CartExpandableListAdapter(getContext());
		ExpandableListView expandListView = (ExpandableListView) view.findViewById(R.id.list);
		expandListView.setAdapter(adapter);
		return view;
	}
	  @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);




	}
	@Override
	protected void loadFinished(int action, JasonResult arg1) {
		
		
	}

	@Override
	public Loader<JasonResult> onCreateLoader(int arg0, Bundle arg1) {
		
		return null;
	}
}
