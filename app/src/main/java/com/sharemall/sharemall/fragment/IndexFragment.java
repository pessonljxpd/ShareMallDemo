package com.sharemall.sharemall.fragment;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sharemall.sharemall.R;
import com.sharemall.sharemall.adapter.MultipleItemQuickAdapter;
import com.sharemall.sharemall.base.BaseLoadFragment;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.beans.MultipleItem;
import com.sharemall.sharemall.repository.DataServer;

import java.util.List;

/**
 * @author Shelly
 */
public class IndexFragment extends BaseLoadFragment<JasonResult> {

    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);

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
        mRecyclerView.setAdapter(multipleItemAdapter);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
