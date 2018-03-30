package com.sharemall.sharemall.activity;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.widget.ListView;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.AddressAdapter;
import com.sharemall.sharemall.base.BaseLoadActivity;
import com.sharemall.sharemall.beans.AddressInfo;
import com.sharemall.sharemall.beans.JasonResult;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class AddressListActivity extends BaseLoadActivity<JasonResult> {
   private ListView lv_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        lv_address = (ListView) findViewById(R.id.lv_address);
        ArrayList<AddressInfo> infos = new  ArrayList<AddressInfo>();
        infos.add(new AddressInfo());
        infos.add(new AddressInfo());
        infos.add(new AddressInfo());
        infos.add(new AddressInfo());
        lv_address.setAdapter(new AddressAdapter(infos));
    }

    @Override
    protected void loadFinished(int action, JasonResult arg1) {

    }

    @Override
    public Loader onCreateLoader(int arg0, Bundle arg1) {
        return null;
    }
}
