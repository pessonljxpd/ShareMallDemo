package com.sharemall.sharemall.utils;

import android.os.Environment;

/**
 * �ļ����湤����
 * 
 * @author wanghl-a
 * 
 */
public class FileCacheUtil
{
	/**
	 * ��Ŀ¼
	 */
	private static final String FILE_PATH_HEADER = Environment
	        .getExternalStorageDirectory().getAbsolutePath() + "/guangcai/";

	/**
	 * ͼƬ�ļ�Ŀ¼
	 * 
	 * @return
	 */
	public static String getPicsFileDir()
	{
		return FILE_PATH_HEADER + "pics/";
	}

	/**
	 * ��ȡͼƬ�ļ�·��
	 * 
	 * @param fileName
	 *            �ļ�����
	 * @return ͼƬ�ļ�·��
	 */
	public static String getPicFilePath(String fileName)
	{
		return getPicsFileDir() + fileName;
	}

	/**
	 * �����ļ�Ŀ¼
	 * 
	 * @return
	 */
	public static String getVoiceFileDir()
	{
		return FILE_PATH_HEADER + "voice/";
	}

	/**
	 * ��ȡ�����ļ�·��
	 * 
	 * @param fileName
	 *            �ļ�����
	 * @return ͼƬ�ļ�·��
	 */
	public static String getVoiceFilePath(String fileName)
	{
		return getVoiceFileDir() + fileName;
	}
}
