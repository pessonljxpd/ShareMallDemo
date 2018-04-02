package com.sharemall.sharemall.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.ListView;

import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.AddressAdapter;
import com.sharemall.sharemall.base.BaseLoadActivity;
import com.sharemall.sharemall.beans.AddressInfo;
import com.sharemall.sharemall.beans.JasonResult;

import java.util.ArrayList;

/**
 * @author Administrator
 * @date 2018/3/30 0030
 */
public class AddressListActivity extends BaseLoadActivity<JasonResult> {
    private ListView lv_address;

    @Override
    public int bindLayout() {
        return R.layout.activity_address;
    }

    @Override
    public void doBusiness(Context context, Bundle savedInstanceState) {
        lv_address = findViewById(R.id.lv_address);
        ArrayList<AddressInfo> infos = new ArrayList<>();
        infos.add(new AddressInfo());
        infos.add(new AddressInfo());
        infos.add(new AddressInfo());
        infos.add(new AddressInfo());
        lv_address.setAdapter(new AddressAdapter(infos));
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    protected void loadFinished(int action, JasonResult arg1) {

    }

    @Override
    public Loader onCreateLoader(int arg0, Bundle arg1) {
        return null;
    }
}
