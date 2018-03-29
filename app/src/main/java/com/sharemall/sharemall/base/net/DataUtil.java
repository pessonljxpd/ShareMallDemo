package com.sharemall.sharemall.base.net;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sharemall.sharemall.beans.JasonResult;
import com.sharemall.sharemall.utils.Tools;

/**
 * ���ݴ�������
 *
 * @author wanghl-a
 */
public class DataUtil {
    /**
     * GSON������
     */
    private GsonBuilder mGsonBuilder;
    /**
     * GSONת����
     */
    private Gson mGson;

    /**
     * ���캯��
     */
    public DataUtil() {
        mGsonBuilder = new GsonBuilder();
        mGson = mGsonBuilder.create();
    }

    /**
     * POST��ʽ
     *
     * @param url    ��ַ
     * @param params ����
     * @param obj    post����
     * @return JasonResult����
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
     * POST��ʽ
     *
     * @param url    ��ַ
     * @param params ����
     * @param byte[] ͼƬ
     * @return JasonResult����
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
     * ͼƬѯ��
     *
     * @param url    ��ַ
     * @param params ����
     * @param info   PicEnquiryInfo����
     * @return JasonResult����
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
