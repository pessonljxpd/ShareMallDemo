package com.sharemall.sharemall.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

    private Context mContext;

    private Toolbar mToolbarContainer;
    private RecyclerView mRecyclerView;
    private Banner mBanner;
    private List<MultipleItem> mData;

    private int mAnchorHeight;
    private ToolBarBackgroundController mToolBarBackgroundController;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().restartLoader(1, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);

        mToolbarContainer = view.findViewById(R.id.toolbar);
        mRecyclerView = view.findViewById(R.id.rv_list);

        initToolbarContainer();

        mData = DataServer.getMultipleItemData();
        MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(mContext, mData);
        GridLayoutManager manager = new GridLayoutManager(mContext, 4);
        mRecyclerView.setLayoutManager(manager);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return mData.get(position).getSpanSize();
            }
        });

        mRecyclerView.addOnScrollListener(new OnScrollColorChangeListener());

        mRecyclerView.setAdapter(multipleItemAdapter);

        View headerView = initHeaderView();

        multipleItemAdapter.addHeaderView(headerView);

        return view;
    }

    @Override
    public int setTitleBar() {
        return R.id.toolbar;
    }

    private void initToolbarContainer() {
        mToolbarContainer.setBackgroundColor(Color.TRANSPARENT);
        mToolBarBackgroundController = new ToolBarBackgroundController(mToolbarContainer);
    }

    private View initHeaderView() {
        final View headerView = LayoutInflater.from(mContext)
                .inflate(R.layout.header_fragment_index, (ViewGroup) mRecyclerView.getParent(), false);
        mBanner = headerView.findViewById(R.id.banner);

        headerView.post(new Runnable() {
            @Override
            public void run() {
                mAnchorHeight = headerView.getMeasuredHeight() - mToolbarContainer.getMeasuredHeight();
            }
        });

        Log.d("mAnchorHeight", "mAnchorHeight = " + mAnchorHeight);

        setBanner(mBanner);
        return headerView;
    }

    private void setBanner(Banner banner) {
        List<String> imageUrl = new ArrayList<>();
        imageUrl.add("http://img3.imgtn.bdimg.com/it/u=3823223463,3047520970&fm=23&gp=0.jpg");
        imageUrl.add("http://img.hc360.com/auto-a/info/images/200803/8998419-10.jpg");
        imageUrl.add("http://img.ichemo.cn/model/5188ebc96c74dd.jpg");
        banner.setImageLoader(new GlideImageLoader())
                .setImages(imageUrl)
                .setDelayTime(3000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
    }

    private class OnScrollColorChangeListener extends RecyclerView.OnScrollListener {

        private boolean isTrans = true;
        private int y = 0;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (mAnchorHeight != 0) {
                y += dy;
                boolean needTrans = y <= mAnchorHeight;
                if (needTrans != isTrans) {
                    isTrans = needTrans;
                    mToolBarBackgroundController.setTransparent(needTrans);
                } else {
                    if (y / mAnchorHeight < 1) {
                        mToolbarContainer.setBackgroundColor(getResources().getColor(R.color.dull_blue));
                        mToolbarContainer.getBackground().setAlpha((int) ((float) y / mAnchorHeight * 255));
                    }
                }
            }
        }
    }

    public class ToolBarBackgroundController {

        private View layoutToolbar;

        public ToolBarBackgroundController(View layoutToolbar) {
            this.layoutToolbar = layoutToolbar;
            layoutToolbar.setBackgroundColor(Color.TRANSPARENT);
        }

        public void setTransparent(boolean needTransparent) {
            if (!needTransparent) {
                layoutToolbar.setBackgroundColor(getResources().getColor(R.color.dull_blue));
            }
        }
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
