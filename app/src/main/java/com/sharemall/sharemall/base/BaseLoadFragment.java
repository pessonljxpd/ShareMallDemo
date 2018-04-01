package com.sharemall.sharemall.base;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

/**
 * 需要Loading的基类
 *
 * @author Shelly
 */
public abstract class BaseLoadFragment<L> extends BaseFragment implements LoaderCallbacks<L> {

    /**
     * 加载完成
     *
     * @param action 标示
     * @param arg1   数据
     */
    protected abstract void loadFinished(int action, L arg1);

    /**
     * onCreateLoader
     * @param arg0
     * @param arg1
     * @return
     */
    @Override
    public abstract Loader<L> onCreateLoader(int arg0, Bundle arg1);

    @Override
    public void onLoadFinished(Loader<L> arg0, L arg1) {
        int action = arg0.getId();
        getLoaderManager().destroyLoader(action);
        loadFinished(action, arg1);
    }

    @Override
    public void onLoaderReset(Loader<L> arg0) {

    }

}
