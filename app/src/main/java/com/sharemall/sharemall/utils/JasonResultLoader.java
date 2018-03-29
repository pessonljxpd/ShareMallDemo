package com.sharemall.sharemall.utils;

import java.util.Map;

import android.content.Context;

import com.sharemall.sharemall.base.net.BaseAsyncTaskLoader;
import com.sharemall.sharemall.beans.JasonResult;


/**
 * ��������̨����Loader
 */
public class JasonResultLoader extends BaseAsyncTaskLoader<JasonResult> {
    //��json
    //��json

    /**
     * ���췽��
     *
     * @param context ������
     * @param action  �ӿڱ�ʾ
     * @param params  Header����
     * @param obj     Body����
     */
    public JasonResultLoader(Context context, int action,
            Map<String, String> params, Object obj) {
        super(context, action, params, obj);
    }

    /**
     * ��̨����
     */
    public JasonResult loadInBackground() {
        return mDataUtil.postJasonResult(url, params, obj);
    }

}
