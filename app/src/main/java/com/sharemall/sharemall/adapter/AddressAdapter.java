package com.sharemall.sharemall.adapter;

import com.sharemall.sharemall.adapter.holder.AddressHolder;
import com.sharemall.sharemall.adapter.holder.BaseHolder;
import com.sharemall.sharemall.beans.AddressInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class AddressAdapter extends BasicAdapter<AddressInfo> {
    public AddressAdapter(ArrayList<AddressInfo> list) {
        super(list);
    }

    @Override
    protected BaseHolder<AddressInfo> getHolder(int position) {
        return new AddressHolder();
    }
}
