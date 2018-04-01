package com.sharemall.sharemall.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * 加载图片（双缓冲机制）
 *
 * @author Shelly
 */
public class ImageUtil {
    /**
     * 缓存池
     */
    private LruCache<String, Bitmap> bitmapCache;

    private Map<String, ImageTask> tasks;

    /**
     * 缩放级别
     */
    private int inSampleSize = 5;

    /**
     * 构造方法
     */
    public ImageUtil() {
        // 获取系统分配给每个应用程序的最大内存，每个应用系统分配32M
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int mCacheSize = maxMemory / 8;
        // 给LruCache分配1/8 4M
        bitmapCache = new LruCache<String, Bitmap>(mCacheSize) {
            // 必须重写此方法，来测量Bitmap的大小
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }

        };
        tasks = new HashMap<String, ImageUtil.ImageTask>();
    }

    /**
     * 设置缩放级别
     *
     * @param inSampleSize 缩放级别
     */
    public void setInSampleSize(int inSampleSize) {
        this.inSampleSize = inSampleSize;
    }

    /**
     * 下载图片返回Bitmap对象
     *
     * @param imageUrl      地址
     * @param imageCallback 回调地址
     * @return bitmap对象
     */
    public Bitmap loadBitmap(final String imageUrl,
            final BitmapCallback imageCallback) {
        return loadBitmap(imageUrl, imageCallback, 0);
    }

    /**
     * 下载图片返回Bitmap对象
     *
     * @param imageUrl      地址
     * @param imageCallback 回调地址
     * @return bitmap对象
     */
    public Bitmap loadBitmap(final String imageUrl,
            final BitmapCallback imageCallback, int rect) {
        if (Tools.isEmpty(imageUrl)) {
            return null;
        }
        // 当前缓存存在图片并读取
        Bitmap bitmap = bitmapCache.get(imageUrl);
        // 当前缓存不存在图片或存在图片但以被系统回收，读取本地缓存并将图片重新加入当前缓存
        if (bitmap == null) {
            bitmap = getBitmapCache(Tools.getLocoalImagePath(imageUrl), rect);
        }
        // 如果当前缓存或者是本地缓存读取到图片
        if (bitmap != null) {
            bitmapCache.put(imageUrl, bitmap);
            return bitmap;
        }

        ImageTask imageTask = new ImageTask(rect, imageCallback);
        imageTask.executeOnExecutor(Executors.newCachedThreadPool(), imageUrl);
        tasks.put(imageUrl, imageTask);
        // 图片无任何缓存，网络加载图片并加入当前缓存和本地缓存
        // setBitmapHandler(imageUrl, imageCallback, rect);
        return null;
    }

    /**
     * 加载本地图片
     *
     * @param imagePath 图片地址
     * @param rect      图片长度
     * @return
     */
    public Bitmap loadBitmapFromLocal(String imagePath, int rect) {
        if (Tools.isEmpty(imagePath)) {
            return null;
        }
        // 当前缓存存在图片并读取
        Bitmap bitmap = bitmapCache.get(imagePath);
        // 当前缓存不存在图片或存在图片但以被系统回收，读取本地缓存并将图片重新加入当前缓存
        if (bitmap == null) {
            bitmap = getBitmapCache(imagePath, rect);
        }
        // 如果当前缓存或者是本地缓存读取到图片
        if (bitmap != null) {
            bitmapCache.put(imagePath, bitmap);
            return bitmap;
        }
        return null;
    }

    /**
     * 加载图片
     *
     * @param imageView   图片控件
     * @param imageUrl    图片地址
     * @param rect        图片大小
     * @param defultImage 默认图片ID
     */
    public void loadBitmap(final ImageView imageView, String imageUrl,
            int rect, final int defultImage) {
        loadBitmap(imageView, imageUrl, rect, defultImage, 0);
    }

    /**
     * 加载图片
     *
     * @param imageView   图片控件
     * @param imageUrl    图片地址
     * @param rect        图片大小
     * @param defultImage 默认图片ID
     */
    public void loadBitmap(final ImageView imageView, String imageUrl,
            int rect, final int defultImage, final int range) {
        if (Tools.isEmpty(imageUrl)) {
            setDefultImage(imageView, defultImage);
        } else {
            Bitmap bitmap = loadBitmap(imageUrl, new BitmapCallback() {
                @Override
                public void imageLoaded(Bitmap imageBitmap, String imageUrl) {
                    if (imageBitmap != null) {
                        if (range > 0) {
                            imageView.setImageBitmap(Tools
                                    .getRoundedCornerBitmap(imageBitmap, range));
                        } else {
                            imageView.setImageBitmap(imageBitmap);
                        }
                    } else {
                        setDefultImage(imageView, defultImage);
                    }
                }
            }, rect);

            if (bitmap != null) {
                if (range > 0) {
                    imageView.setImageBitmap(Tools.getRoundedCornerBitmap(
                            bitmap, range));
                } else {
                    imageView.setImageBitmap(bitmap);
                }
            } else {
                setDefultImage(imageView, defultImage);
            }
        }
    }

    private void setDefultImage(ImageView imageView, int defultImage) {
        if (defultImage > 0) {
            imageView.setImageResource(defultImage);
        } else {
            imageView.setImageBitmap(null);
        }
    }

    /**
     * 读取本地图片缓存
     *
     * @param filePath 图片本地路径
     * @param rect
     * @return
     */
    private Bitmap getBitmapCache(String filePath, int rect) {
        if (Tools.isHasSDCard() && !Tools.isEmpty(filePath)) {
            File file = new File(filePath);

            if (file.exists() && file.length() > 0) {
                Bitmap bitmap = null;
                if (rect != 0) {
                    bitmap = Tools.getBitmap(filePath, rect, true);
                } else {
                    Options opts = new Options();
                    opts.inSampleSize = inSampleSize;
                    bitmap = BitmapFactory.decodeFile(filePath, opts);
                    bitmap = Tools.rotaingImageView(
                            Tools.readPictureDegree(filePath), bitmap);
                }
                return bitmap;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private class ImageTask extends AsyncTask<String, Integer, Bitmap> {
        private String imageUrl;
        private int rect;
        private BitmapCallback imageCallback;

        public ImageTask(int rect, BitmapCallback imageCallback) {
            this.rect = rect;
            this.imageCallback = imageCallback;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            imageUrl = params[0];
            Bitmap bitmap = loadImageBFromUrl(imageUrl, rect);
            if (!Tools.isEmpty(imageUrl) && bitmap != null) {
                bitmapCache.put(imageUrl, bitmap);
                return bitmap;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (isCancelled()) {
                return;
            }
            imageCallback.imageLoaded(result, imageUrl);
        }
    }

    // /**
    // * 设置bitmap触发器
    // *
    // * @param imageUrl
    // * 图片地址
    // * @param imageCallback
    // * 回调接口
    // */
    // private void setBitmapHandler(final String imageUrl,
    // final BitmapCallback imageCallback, final int rect)
    // {
    // final Handler handler = new Handler()
    // {
    // public void handleMessage(Message message)
    // {
    // imageCallback.imageLoaded((Bitmap) message.obj, imageUrl);
    // }
    // };
    // new Thread()
    // {
    // public void run()
    // {
    // Bitmap bitmap = loadImageBFromUrl(imageUrl, rect);
    // if (!Tools.isEmpty(imageUrl) && bitmap != null)
    // {
    // bitmapCache.put(imageUrl, bitmap);
    // }
    // Message message = handler.obtainMessage(0, bitmap);
    // handler.sendMessage(message);
    // }
    // }.start();
    // }

    /**
     * 下载图片生成Bitmap对象
     *
     * @param url 图片地址
     * @return bitmap对象
     */
    public Bitmap loadImageBFromUrl(String url, int rect) {
        URL m;
        InputStream i = null;
        Bitmap bitmap = null;
        try {
            m = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) m.openConnection();
            conn.setConnectTimeout(30000);
            conn.setRequestMethod("GET");

            i = conn.getInputStream();

            String filePath = createFileCache(url, i);

            if (!Tools.isEmpty(filePath)) {
                if (rect != 0) {
                    bitmap = Tools.getBitmap(filePath, rect, true);
                } else {
                    Options opts = new Options();
                    opts.inSampleSize = inSampleSize;
                    bitmap = BitmapFactory.decodeFile(filePath, opts);
                    bitmap = Tools.rotaingImageView(
                            Tools.readPictureDegree(filePath), bitmap);
                }
            } else {
                Options opts = new Options();
                opts.inSampleSize = inSampleSize;
                bitmap = BitmapFactory.decodeStream(i, null, opts);
            }

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    /**
     * 创建文件缓存
     *
     * @param imageUrl 图片地址
     * @param i        输入流
     */
    private String createFileCache(String imageUrl, InputStream i) {
        if (i != null && Tools.isHasSDCard()) {
            File dir = new File(FileCacheUtil.getPicsFileDir());

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filePath = FileCacheUtil.getPicFilePath(Tools
                    .parserImageName(imageUrl));

            File file = new File(filePath);

            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();

                FileOutputStream fos = new FileOutputStream(file);

                int len = 0;
                byte[] temp = new byte[1024];

                while ((len = i.read(temp)) != -1) {
                    fos.write(temp, 0, len);
                }

                fos.close();

                return filePath;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        } else {
            return null;
        }
    }

    /**
     * 清理图片缓存
     */
    public void clearPicsCache() {
        File file = new File(FileCacheUtil.getPicsFileDir());
        deleteFile(file);
    }

    /**
     * 回收缓存数据
     */
    public void recyleCache() {
        if (bitmapCache != null) {
            Map<String, Bitmap> cache = bitmapCache.snapshot();
            for (Map.Entry<String, Bitmap> entry : cache.entrySet()) {
                Bitmap bitmap = entry.getValue();
                if (bitmap != null) {
                    bitmap.recycle();
                    bitmap = null;
                }
            }
        }

        if (tasks != null) {
            for (Map.Entry<String, ImageTask> entry : tasks.entrySet()) {
                ImageTask task = entry.getValue();
                if (task != null) {
                    task.cancel(true);
                }
            }
        }
    }

    /**
     * 删除文件
     *
     * @param file 文件
     */
    private void deleteFile(File file) {
        if (file.exists()) { // 判断文件是否存在

            if (file.isFile()) { // 判断是否是文件

                file.delete(); // delete()方法 你应该知道 是删除的意思;

            } else if (file.isDirectory()) { // 否则如果它是一个目录

                File files[] = file.listFiles(); // 声明目录下所有的文件 files[];

                for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件

                    this.deleteFile(files[i]); // 把每个文件 用这个方法进行迭代

                }

            }

            file.delete();
        }
    }

    /**
     * 回调接口
     *
     * @author wanghl-a
     */
    public interface BitmapCallback {
        public void imageLoaded(Bitmap imageBitmap, String imageUrl);
    }

}