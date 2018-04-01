package com.sharemall.sharemall.utils;

import android.os.Environment;

/**
 * 文件缓存工具类
 *
 * @author wanghl-a
 */
public class FileCacheUtil {
    /**
     * 根目录
     */
    private static final String FILE_PATH_HEADER = Environment
            .getExternalStorageDirectory().getAbsolutePath() + "/ShareMall/";

    /**
     * 图片文件目录
     *
     * @return
     */
    public static String getPicsFileDir() {
        return FILE_PATH_HEADER + "pics/";
    }

    /**
     * 获取图片文件路径
     *
     * @param fileName 文件名字
     * @return 图片文件路径
     */
    public static String getPicFilePath(String fileName) {
        return getPicsFileDir() + fileName;
    }

    /**
     * 语音文件目录
     *
     * @return
     */
    public static String getVoiceFileDir() {
        return FILE_PATH_HEADER + "voice/";
    }

    /**
     * 获取语音文件路径
     *
     * @param fileName 文件名字
     * @return 图片文件路径
     */
    public static String getVoiceFilePath(String fileName) {
        return getVoiceFileDir() + fileName;
    }
}
