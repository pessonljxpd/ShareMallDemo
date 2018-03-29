package com.sharemall.sharemall.fragment;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.MultipleItemQuickAdapter;
import com.sharemall.sharemall.base.BaseLoadFragment;
import com.sharemall.sharemall.base.net.GlideImageLoader;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.beans.MultipleItem;
import com.sharemall.sharemall.repository.DataServer;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shelly
 */
public class IndexFragment extends BaseLoadFragment<JasonResult> {

    private Banner mBanner;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);

        mBanner = view.findViewById(R.id.banner);
        mRecyclerView = view.findViewById(R.id.rv_list);
        final List<MultipleItem> data = DataServer.getMultipleItemData();
        final MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(getContext(), data);
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(manager);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        multipleItemAdapter.addHeaderView(new ViewPager(getContext()));

        mRecyclerView.setAdapter(multipleItemAdapter);

        setBanner();

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().restartLoader(1, null, this);
    }

    private void setBanner() {
        List<String> imageUrl = new ArrayList<>();
        imageUrl.add("http://img3.imgtn.bdimg.com/it/u=3823223463,3047520970&fm=23&gp=0.jpg");
        imageUrl.add("http://img.hc360.com/auto-a/info/images/200803/8998419-10.jpg");
        imageUrl.add("http://img.ichemo.cn/model/5188ebc96c74dd.jpg");
        mBanner.setImageLoader(new GlideImageLoader())
                .setImages(imageUrl)
                .setDelayTime(3000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();
    }

    @Override
    protected void loadFinished(int action, JasonResult arg1) {
    }

    @Override
    public Loader<JasonResult> onCreateLoader(int arg0, Bundle arg1) {
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }
}
