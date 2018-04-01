package com.sharemall.sharemall.base.net;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.alibaba.fastjson.JSON;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Http协议工具类
 *
 * @author zenglinkui
 */
public class HttpUtil {
    /**
     * HttpUtil对象
     */
    private static HttpUtil instance = new HttpUtil();

    /**
     * 私有化构造器
     */
    private HttpUtil() {
    }

    /**
     * 获取HttpUtil对象
     *
     * @return HttpUtil对象
     */
    public static HttpUtil getInstance() {
        return instance;
    }

    /**
     * HttpGet方式
     *
     * @param url    地址
     * @param params 参数
     * @return JSONObject对象
     * @throws JSONException
     * @throws Exception
     */
    public JSONObject httpGet(String url, Map<String, String> params) throws JSONException, Exception {
        return new JSONObject(httpGet(url, params, new DefaultHttpClient()));
    }

    /**
     * HttpPost
     *
     * @param url    地址
     * @param params 参数
     * @param obj    post对象
     * @return JSONObject对象
     * @throws JSONException
     * @throws Exception
     */
    public JSONObject httpPost(String url, Map<String, String> params,
            Object obj) throws JSONException, Exception {
        return new JSONObject(httpPost(url, params, new DefaultHttpClient(),
                obj));
    }

    /**
     * HttpPost
     *
     * @param url    地址
     * @param params 参数
     * @param b      图片字节数组
     * @return JSONObject对象
     * @throws JSONException
     * @throws Exception
     */
    public JSONObject httpPost(String url, Map<String, String> params, byte[] b)
            throws JSONException, Exception {
        return new JSONObject(httpPost(url, params, new DefaultHttpClient(), b));
    }

    /**
     * HttpGet方式
     *
     * @param url    地址
     * @param params 参数
     * @param client DefaultHttpClient对象
     * @return Json字符串
     * @throws Exception
     */
    @SuppressLint("UseValueOf")
    private String httpGet(String url, Map<String, String> params, DefaultHttpClient client) throws Exception {
        String result = null;
        int statusCode = 0;
        HttpGet getMethod = new HttpGet(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().equals("password")
                    || entry.getKey().equals("newPassword")) {
                try {
                    getMethod.addHeader(entry.getKey(),
                            URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                getMethod.addHeader(entry.getKey(), entry.getValue());
            }
        }
        getMethod.getParams().setParameter("http.socket.timeout",
                new Integer(30000));

        try {
            // getMethod.setHeader("User-Agent", USER_AGENT);

            HttpResponse httpResponse = client.execute(getMethod);
            // statusCode == 200 正常
            statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                // 处理返回的httpResponse信息
                result = retrieveInputStream(httpResponse.getEntity());
            } else {
                result = retrieveInputStream(httpResponse.getEntity());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            getMethod.abort();
        }
        return result;
    }

    /**
     * HttpPost
     *
     * @param url    地址
     * @param params 参数
     * @param client DefaultHttpClient对象
     * @param obj    post对象
     * @return json字符串
     * @throws Exception
     */
    @SuppressLint("UseValueOf")
    private String httpPost(String url, Map<String, String> params, DefaultHttpClient client,
            Object obj) throws Exception {
        String result = null;
        int statusCode = 0;
        HttpPost post = new HttpPost(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().equals("password")
                    || entry.getKey().equals("newPassword")) {
                try {
                    post.addHeader(entry.getKey(),
                            URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                post.addHeader(entry.getKey(), entry.getValue());
            }
        }

        post.getParams()
                .setParameter("http.socket.timeout", new Integer(30000));

        try {
            String s = JSON.toJSONString(obj);
            StringEntity entity = new StringEntity(s, "UTF-8");
            post.setEntity(entity);
            HttpResponse r = client.execute(post);
            statusCode = r.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                // 处理返回的httpResponse信息
                result = retrieveInputStream(r.getEntity());
            } else {
                result = retrieveInputStream(r.getEntity());
            }
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
            new Exception(e);
        } finally {
            post.abort();
        }

        return result;
    }

    /**
     * HttpPost
     *
     * @param url    地址
     * @param params 参数
     * @param client DefaultHttpClient对象
     * @param b      图片字节数组
     * @return json字符串
     * @throws Exception
     */
    @SuppressLint("UseValueOf")
    private String httpPost(String url, Map<String, String> params, DefaultHttpClient client,
            byte[] b) throws Exception {
        String result = null;
        int statusCode = 0;
        HttpPost post = new HttpPost(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
            if (entry.getKey().equals("password")
                    || entry.getKey().equals("newPassword")) {
                try {
                    post.addHeader(entry.getKey(),
                            URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                post.addHeader(entry.getKey(), entry.getValue());
            }
        }

        post.getParams()
                .setParameter("http.socket.timeout", new Integer(30000));

        try {
            ByteArrayEntity entity = new ByteArrayEntity(b);
            post.setEntity(entity);
            HttpResponse r = client.execute(post);
            statusCode = r.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                // 处理返回的httpResponse信息
                result = retrieveInputStream(r.getEntity());
            } else {
                result = retrieveInputStream(r.getEntity());
            }
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
            new Exception(e);
        } finally {
            post.abort();
        }

        return result;
    }

    /**
     * 处理httpResponse信息,返回String
     *
     * @param httpEntity
     * @return String
     */
    protected String retrieveInputStream(HttpEntity httpEntity) {

        int length = (int) httpEntity.getContentLength();
        // the number of bytes of the content, or a negative number if unknown.
        // If the content length is known but exceeds Long.MAX_VALUE, a negative
        // number is returned.
        // length==-1，下面这句报错，println needs a message
        if (length < 0) { length = 10000; }
        StringBuffer stringBuffer = new StringBuffer(length);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    httpEntity.getContent(), HTTP.UTF_8);
            char buffer[] = new char[length];
            int count;
            while ((count = inputStreamReader.read(buffer, 0, length - 1)) > 0) {
                stringBuffer.append(buffer, 0, count);
            }
        } catch (UnsupportedEncodingException e) {
        } catch (IllegalStateException e) {
        } catch (IOException e) {
        }
        return stringBuffer.toString();
    }

    /**
     * 下载某个path对应的文件
     *
     * @param path    地址
     * @param pb      进度条
     * @param handler 监控器
     * @return 文件对象
     * @throws Exception
     */
    public File downfile(String path, ProgressBar pb, Handler handler) throws Exception {
        File file = null;
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(30000);
        conn.setRequestMethod("GET");

        int length = conn.getContentLength();
        int code = conn.getResponseCode();
        if (code >= 200 && code < 300) {
            pb.setMax(length);

            InputStream is = conn.getInputStream();
            int index = path.lastIndexOf("/") + 1;

            String filename = path.substring(index, path.length());
            file = new File(Environment.getExternalStorageDirectory(), filename);
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int len = 0;
            int total = 0;

            // 格式化APK总大小
            String formatTotal = String.valueOf((double) length / 1024 / 1024);
            int start = formatTotal.indexOf(".");
            formatTotal = formatTotal.substring(0, start + 2);
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                total += len;
                pb.setProgress(total);

                // 显示当前进度百分比
                int percent = (int) Math.floor((double) total / length * 100);

                Message msg = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString("percent", percent + "%");
                bundle.putInt("currentLength", total);
                bundle.putInt("totalLength", length);
                msg.what = 3;
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
            fos.flush();
            fos.close();
            is.close();
        }
        return file;
    }
}
