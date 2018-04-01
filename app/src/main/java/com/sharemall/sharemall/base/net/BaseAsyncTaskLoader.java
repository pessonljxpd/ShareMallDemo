package com.sharemall.sharemall.base.net;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.sharemall.sharemall.utils.UriUtil;

import java.util.Map;

/**
 * 异步Loader基类
 *
 * @param <D> 对象
 * @author Shelly
 */
public abstract class BaseAsyncTaskLoader<D> extends AsyncTaskLoader<D> {
    /**
     * 数据处理工具类
     */
    protected DataUtil mDataUtil = new DataUtil();

    /**
     * 数据对象
     */
    protected D mData;

    /**
     * 上下文
     */
    protected Context context;

    /**
     * 地址
     */
    protected String url;

    /**
     * 参数
     */
    protected Map<String, String> params;

    /**
     * 上传参数
     */
    protected Object obj;

    /**
     * 构造方法
     *
     * @param context 上下文
     */
    public BaseAsyncTaskLoader(Context context) {
        super(context);
        this.context = context;
    }

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param action  响应码
     * @param params  参数
     * @param obj     Post上传数据
     */
    public BaseAsyncTaskLoader(Context context, int action,
            Map<String, String> params, Object obj) {
        super(context);
        this.context = context;
        this.url = UriUtil.getUriBase();
        this.params = params;
        this.params.put("Action", action + "");
        this.obj = obj;
    }

    /**
     * 后台处理
     */
    public abstract D loadInBackground();

    /**
     * 传递结果
     */
    @Override
    public void deliverResult(D data) {
        mData = data;
        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    ;

    /**
     * 开始Loading
     */
    @Override
    protected void onStartLoading() {
        if (mData != null) {
            deliverResult(mData);
        }

        if (takeContentChanged() || mData == null) {
            forceLoad();
        }
    }

    /**
     * 结束Loading
     */
    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}
