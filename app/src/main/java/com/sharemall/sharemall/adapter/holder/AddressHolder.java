package com.sharemall.sharemall.adapter.holder;

import android.view.View;

import com.sharemall.sharemall.MyApplication;
import com.sharemall.sharemall.R;
import com.sharemall.sharemall.beans.AddressInfo;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class AddressHolder extends BaseHolder<AddressInfo> {
    @Override
    public View initHolderView() {
        View view = View.inflate(MyApplication.getInstance(), R.layout.item_address,null);
        return view;
    }

    @Override
    public void bindData(AddressInfo data) {

    }
}
