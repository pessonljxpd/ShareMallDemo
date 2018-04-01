package com.sharemall.sharemall.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shelly
 */
public class BaseParams {
    private static BaseParams instance = new BaseParams();

    private BaseParams() {
    }

    public static BaseParams getInstance() {
        return instance;
    }

    /**
     * 基本参数
     *
     * @return 参数
     */
    public Map<String, String> getBaseParams(Activity activity) {
        return getBaseParams(0, activity);
    }

    /**
     * 基本参数
     *
     * @return 参数
     */
    public Map<String, String> getBaseParams(int action, Activity activity) {
        Map<String, String> params = new HashMap<String, String>();
        // 接口类型
        params.put("Action", action + "");
        // 用户ID

        // 手机号
        params.put("Mobile", Tools.trim(Tools.getUserPhoneNumber(activity)));

        // 时间戳
        params.put("Time", System.currentTimeMillis() + "");
        // 设备编号
        params.put("DeviceID", getImieStatus(activity));
        // 操作系统类型
        params.put("OS", "1");
        // System.out.println("主板：" + Build.BOARD);
        // System.out.println("android系统定制商：" + Build.BRAND);
        // System.out.println("设备参数：" + Build.DEVICE);
        // System.out.println("显示屏参数：" + Build.DISPLAY);
        // System.out.println("硬件名称：" + Build.FINGERPRINT);
        // System.out.println("硬件制造商：" + Build.MANUFACTURER);
        // System.out.println("版本：" + Build.MODEL);
        // System.out.println("手机制造商：" + Build.PRODUCT);

        // 操作系统版本号
        params.put("UA", Build.MODEL + "[" + Build.VERSION.RELEASE + "]");
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        // 分辨率
        params.put("Screen", metrics.heightPixels + "X" + metrics.widthPixels);
        return params;
    }

    /**
     * 获取手机唯一识别码
     *
     * @return 手机唯一识别码
     */
    public String getImieStatus(Context context) {
        SharedPreferences sp = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        String deviceId = sp.getString("IDID", "").trim();

        if (Tools.isEmpty(deviceId)) {
            // 如果config文件中没有存储IDID，则需要重新获取IDID,首先考虑deviceId
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = tm != null ? Tools.trim(tm.getDeviceId()) : "";

            // 如果没有获取到deviceId,则通过getMyUUID获取
            if (Tools.isEmpty(deviceId)) {

            }

            // 保存到config文件中
            editor.putString("IDID", deviceId);
            editor.commit();
        }
        return Tools.trim(deviceId);
    }
}
