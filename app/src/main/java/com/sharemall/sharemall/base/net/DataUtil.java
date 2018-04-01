package com.sharemall.sharemall.base.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.utils.Tools;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 数据处理工具类
 *
 * @author wanghl-a
 */
public class DataUtil {
    /**
     * GSON建立者
     */
    private GsonBuilder mGsonBuilder;
    /**
     * GSON转换类
     */
    private Gson mGson;

    /**
     * 构造函数
     */
    public DataUtil() {
        mGsonBuilder = new GsonBuilder();
        mGson = mGsonBuilder.create();
    }

    /**
     * POST方式
     *
     * @param url    地址
     * @param params 参数
     * @param obj    post对象
     * @return JasonResult对象
     */
    public JasonResult postJasonResult(String url, Map<String, String> params,
            Object obj) {
        JasonResult jasonResult = null;
        try {
            JSONObject jo = HttpUtil.getInstance().httpPost(url, params, obj);
            if (jo != null) {
                jasonResult = mGson.fromJson(jo.toString(), JasonResult.class);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jasonResult;
    }

    /**
     * POST方式
     *
     * @param url    地址
     * @param params 参数
     * @param b      图片
     * @return JasonResult对象
     */
    public JasonResult postJasonResult(String url, Map<String, String> params,
            byte[] b) {
        JasonResult jasonResult = null;
        try {
            JSONObject jo = HttpUtil.getInstance().httpPost(url, params, b);
            if (jo != null) {
                jasonResult = mGson.fromJson(jo.toString(), JasonResult.class);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jasonResult;
    }

    public <T> T getDataInfo(String url, Map<String, String> params,
            Object info, Class<T> cls) {
        JasonResult jasonResult = postJasonResult(url, params, info);
        return jasonResult != null && jasonResult.code == 0 ? mGson.fromJson(
                Tools.trim(jasonResult.data), cls) : null;
    }

    public <T> T getData(String result, Class<T> cls) {
        try {
            return mGson.fromJson(Tools.trim(result), cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 图片询价
     *
     * @param url    地址
     * @param params 参数
     * @param list   PicEnquiryInfo对象
     * @return JasonResult对象
     */
    public JasonResult picEnquiry(String url, Map<String, String> params,
            List<byte[]> list) {
        JasonResult result = null;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                result = postJasonResult(url, params, list.get(i));
            }
        }
        return result;
    }
}
