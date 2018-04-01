package com.sharemall.sharemall.utils;

import android.content.Context;

import com.sharemall.sharemall.base.net.BaseAsyncTaskLoader;
import com.sharemall.sharemall.beans.JasonResult;

import java.util.Map;


/**
 * 服务器后台请求Loader
 * @author Shelly
 */
public class JasonResultLoader extends BaseAsyncTaskLoader<JasonResult> {
    //传json
    //返json

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param action  接口标示
     * @param params  Header参数
     * @param obj     Body对象
     */
    public JasonResultLoader(Context context, int action,
            Map<String, String> params, Object obj) {
        super(context, action, params, obj);
    }

    /**
     * 后台处理
     */
    @Override
    public JasonResult loadInBackground() {
        return mDataUtil.postJasonResult(url, params, obj);
    }

}
