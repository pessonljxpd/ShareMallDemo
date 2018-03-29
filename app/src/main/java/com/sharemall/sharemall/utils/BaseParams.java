package com.sharemall.sharemall.utils;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

public class BaseParams
{
	private static BaseParams instance = new BaseParams();

	private BaseParams()
	{
	}

	public static BaseParams getInstance()
	{
		return instance;
	}

	/**
	 * ��������
	 * 
	 * @return ����
	 */
	public Map<String, String> getBaseParams(Activity activity)
	{
		return getBaseParams(0, activity);
	}

	/**
	 * ��������
	 * 
	 * @return ����
	 */
	public Map<String, String> getBaseParams(int action, Activity activity)
	{
		Map<String, String> params = new HashMap<String, String>();
		// �ӿ�����
		params.put("Action", action + "");
		// �û�ID
	
		// �ֻ���
		params.put("Mobile", Tools.trim(Tools.getUserPhoneNumber(activity)));
	
		// ʱ���
		params.put("Time", System.currentTimeMillis() + "");
		// �豸���
		params.put("DeviceID", getImieStatus(activity));
		// ����ϵͳ����
		params.put("OS", "1");
		// System.out.println("���壺" + Build.BOARD);
		// System.out.println("androidϵͳ�����̣�" + Build.BRAND);
		// System.out.println("�豸������" + Build.DEVICE);
		// System.out.println("��ʾ��������" + Build.DISPLAY);
		// System.out.println("Ӳ�����ƣ�" + Build.FINGERPRINT);
		// System.out.println("Ӳ�������̣�" + Build.MANUFACTURER);
		// System.out.println("�汾��" + Build.MODEL);
		// System.out.println("�ֻ������̣�" + Build.PRODUCT);

		// ����ϵͳ�汾��
		params.put("UA", Build.MODEL + "[" + Build.VERSION.RELEASE + "]");
		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		// �ֱ���
		params.put("Screen", metrics.heightPixels + "X" + metrics.widthPixels);
		return params;
	}

	/**
	 * ��ȡ�ֻ�Ψһʶ����
	 * 
	 * @return �ֻ�Ψһʶ����
	 */
	public String getImieStatus(Context context)
	{
		SharedPreferences sp = context.getSharedPreferences("config",
		        Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		String deviceId = sp.getString("IDID", "").trim();

		if (Tools.isEmpty(deviceId))
		{
			// ���config�ļ���û�д洢IDID������Ҫ���»�ȡIDID,���ȿ���deviceId
			TelephonyManager tm = (TelephonyManager) context
			        .getSystemService(Context.TELEPHONY_SERVICE);
			deviceId = tm != null ? Tools.trim(tm.getDeviceId()) : "";

			// ���û�л�ȡ��deviceId,��ͨ��getMyUUID��ȡ
			if (Tools.isEmpty(deviceId))
			{
				
			}

			// ���浽config�ļ���
			editor.putString("IDID", deviceId);
			editor.commit();
		}
		return Tools.trim(deviceId);
	}
}
