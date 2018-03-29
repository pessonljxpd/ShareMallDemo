package com.sharemall.sharemall.utils;

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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

/**
 * ����ͼƬ��˫������ƣ�
 * 
 */
public class ImageUtil
{
	/**
	 * �����
	 */
	private LruCache<String, Bitmap> bitmapCache;

	private Map<String, ImageTask> tasks;

	/**
	 * ���ż���
	 */
	private int inSampleSize = 5;

	/**
	 * ���췽��
	 */
	public ImageUtil()
	{
		// ��ȡϵͳ�����ÿ��Ӧ�ó��������ڴ棬ÿ��Ӧ��ϵͳ����32M
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		int mCacheSize = maxMemory / 8;
		// ��LruCache����1/8 4M
		bitmapCache = new LruCache<String, Bitmap>(mCacheSize)
		{
			// ������д�˷�����������Bitmap�Ĵ�С
			protected int sizeOf(String key, Bitmap value)
			{
				return value.getRowBytes() * value.getHeight();
			}

		};
		tasks = new HashMap<String, ImageTask>();
	}

	/**
	 * �������ż���
	 * 
	 * @param inSampleSize
	 *            ���ż���
	 */
	public void setInSampleSize(int inSampleSize)
	{
		this.inSampleSize = inSampleSize;
	}

	/**
	 * ����ͼƬ����Bitmap����
	 * 
	 * @param imageUrl
	 *            ��ַ
	 * @param imageCallback
	 *            �ص���ַ
	 * @return bitmap����
	 */
	public Bitmap loadBitmap(final String imageUrl,
	        final BitmapCallback imageCallback)
	{
		return loadBitmap(imageUrl, imageCallback, 0);
	}

	/**
	 * ����ͼƬ����Bitmap����
	 * 
	 * @param imageUrl
	 *            ��ַ
	 * @param imageCallback
	 *            �ص���ַ
	 * @return bitmap����
	 */
	public Bitmap loadBitmap(final String imageUrl,
	        final BitmapCallback imageCallback, int rect)
	{
		if (Tools.isEmpty(imageUrl))
		{
			return null;
		}
		// ��ǰ�������ͼƬ����ȡ
		Bitmap bitmap = bitmapCache.get(imageUrl);
		// ��ǰ���治����ͼƬ�����ͼƬ���Ա�ϵͳ���գ���ȡ���ػ��沢��ͼƬ���¼��뵱ǰ����
		if (bitmap == null)
		{
			bitmap = getBitmapCache(Tools.getLocoalImagePath(imageUrl), rect);
		}
		// �����ǰ��������Ǳ��ػ����ȡ��ͼƬ
		if (bitmap != null)
		{
			bitmapCache.put(imageUrl, bitmap);
			return bitmap;
		}

		ImageTask imageTask = new ImageTask(rect, imageCallback);
		imageTask.executeOnExecutor(Executors.newCachedThreadPool(), imageUrl);
		tasks.put(imageUrl, imageTask);
		// ͼƬ���κλ��棬�������ͼƬ�����뵱ǰ����ͱ��ػ���
		// setBitmapHandler(imageUrl, imageCallback, rect);
		return null;
	}

	/**
	 * ���ر���ͼƬ
	 * 
	 * @param imagePath
	 *            ͼƬ��ַ
	 * @param rect
	 *            ͼƬ����
	 * @return
	 */
	public Bitmap loadBitmapFromLocal(String imagePath, int rect)
	{
		if (Tools.isEmpty(imagePath))
		{
			return null;
		}
		// ��ǰ�������ͼƬ����ȡ
		Bitmap bitmap = bitmapCache.get(imagePath);
		// ��ǰ���治����ͼƬ�����ͼƬ���Ա�ϵͳ���գ���ȡ���ػ��沢��ͼƬ���¼��뵱ǰ����
		if (bitmap == null)
		{
			bitmap = getBitmapCache(imagePath, rect);
		}
		// �����ǰ��������Ǳ��ػ����ȡ��ͼƬ
		if (bitmap != null)
		{
			bitmapCache.put(imagePath, bitmap);
			return bitmap;
		}
		return null;
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param imageView
	 *            ͼƬ�ؼ�
	 * @param imageUrl
	 *            ͼƬ��ַ
	 * @param rect
	 *            ͼƬ��С
	 * @param defultImage
	 *            Ĭ��ͼƬID
	 */
	public void loadBitmap(final ImageView imageView, String imageUrl,
	        int rect, final int defultImage)
	{
		loadBitmap(imageView, imageUrl, rect, defultImage, 0);
	}

	/**
	 * ����ͼƬ
	 * 
	 * @param imageView
	 *            ͼƬ�ؼ�
	 * @param imageUrl
	 *            ͼƬ��ַ
	 * @param rect
	 *            ͼƬ��С
	 * @param defultImage
	 *            Ĭ��ͼƬID
	 */
	public void loadBitmap(final ImageView imageView, String imageUrl,
	        int rect, final int defultImage, final int range)
	{
		if (Tools.isEmpty(imageUrl))
		{
			setDefultImage(imageView, defultImage);
		}
		else
		{
			Bitmap bitmap = loadBitmap(imageUrl, new BitmapCallback()
			{
				public void imageLoaded(Bitmap imageBitmap, String imageUrl)
				{
					if (imageBitmap != null)
					{
						if (range > 0)
						{
							imageView.setImageBitmap(Tools
							        .getRoundedCornerBitmap(imageBitmap, range));
						}
						else
						{
							imageView.setImageBitmap(imageBitmap);
						}
					}
					else
					{
						setDefultImage(imageView, defultImage);
					}
				}
			}, rect);

			if (bitmap != null)
			{
				if (range > 0)
				{
					imageView.setImageBitmap(Tools.getRoundedCornerBitmap(
					        bitmap, range));
				}
				else
				{
					imageView.setImageBitmap(bitmap);
				}
			}
			else
			{
				setDefultImage(imageView, defultImage);
			}
		}
	}

	private void setDefultImage(ImageView imageView, int defultImage)
	{
		if (defultImage > 0)
		{
			imageView.setImageResource(defultImage);
		}
		else
		{
			imageView.setImageBitmap(null);
		}
	}

	/**
	 * ��ȡ����ͼƬ����
	 * 
	 * @param imageUrl
	 *            ͼƬ����·��
	 * @return
	 */
	private Bitmap getBitmapCache(String filePath, int rect)
	{
		if (Tools.isHasSDCard() && !Tools.isEmpty(filePath))
		{
			File file = new File(filePath);

			if (file.exists() && file.length() > 0)
			{
				Bitmap bitmap = null;
				if (rect != 0)
				{
					bitmap = Tools.getBitmap(filePath, rect, true);
				}
				else
				{
					Options opts = new Options();
					opts.inSampleSize = inSampleSize;
					bitmap = BitmapFactory.decodeFile(filePath, opts);
					bitmap = Tools.rotaingImageView(
					        Tools.readPictureDegree(filePath), bitmap);
				}
				return bitmap;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	private class ImageTask extends AsyncTask<String, Integer, Bitmap>
	{
		private String imageUrl;
		private int rect;
		private BitmapCallback imageCallback;

		public ImageTask(int rect, BitmapCallback imageCallback)
		{
			this.rect = rect;
			this.imageCallback = imageCallback;
		}

		protected Bitmap doInBackground(String... params)
		{
			imageUrl = params[0];
			Bitmap bitmap = loadImageBFromUrl(imageUrl, rect);
			if (!Tools.isEmpty(imageUrl) && bitmap != null)
			{
				bitmapCache.put(imageUrl, bitmap);
				return bitmap;
			}
			return null;
		}

		protected void onPostExecute(Bitmap result)
		{
			if (isCancelled())
			{
				return;
			}
			imageCallback.imageLoaded(result, imageUrl);
		}
	}

	// /**
	// * ����bitmap������
	// *
	// * @param imageUrl
	// * ͼƬ��ַ
	// * @param imageCallback
	// * �ص��ӿ�
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
	 * ����ͼƬ����Bitmap����
	 * 
	 * @param url
	 *            ͼƬ��ַ
	 * @return bitmap����
	 */
	public Bitmap loadImageBFromUrl(String url, int rect)
	{
		URL m;
		InputStream i = null;
		Bitmap bitmap = null;
		try
		{
			m = new URL(url);

			HttpURLConnection conn = (HttpURLConnection) m.openConnection();
			conn.setConnectTimeout(30000);
			conn.setRequestMethod("GET");

			i = conn.getInputStream();

			String filePath = createFileCache(url, i);

			if (!Tools.isEmpty(filePath))
			{
				if (rect != 0)
				{
					bitmap = Tools.getBitmap(filePath, rect, true);
				}
				else
				{
					Options opts = new Options();
					opts.inSampleSize = inSampleSize;
					bitmap = BitmapFactory.decodeFile(filePath, opts);
					bitmap = Tools.rotaingImageView(
					        Tools.readPictureDegree(filePath), bitmap);
				}
			}
			else
			{
				Options opts = new Options();
				opts.inSampleSize = inSampleSize;
				bitmap = BitmapFactory.decodeStream(i, null, opts);
			}

		} catch (MalformedURLException e1)
		{
			e1.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return bitmap;
	}

	/**
	 * �����ļ�����
	 * 
	 * @param imageUrl
	 *            ͼƬ��ַ
	 * @param i
	 *            ������
	 */
	private String createFileCache(String imageUrl, InputStream i)
	{
		if (i != null && Tools.isHasSDCard())
		{
			File dir = new File(FileCacheUtil.getPicsFileDir());

			if (!dir.exists())
			{
				dir.mkdirs();
			}

			String filePath = FileCacheUtil.getPicFilePath(Tools
			        .parserImageName(imageUrl));

			File file = new File(filePath);

			try
			{
				if (file.exists())
				{
					file.delete();
				}
				file.createNewFile();

				FileOutputStream fos = new FileOutputStream(file);

				int len = 0;
				byte[] temp = new byte[1024];

				while ((len = i.read(temp)) != -1)
				{
					fos.write(temp, 0, len);
				}

				fos.close();

				return filePath;

			} catch (Exception e)
			{
				e.printStackTrace();
				return null;
			}

		}
		else
		{
			return null;
		}
	}

	/**
	 * ����ͼƬ����
	 */
	public void clearPicsCache()
	{
		File file = new File(FileCacheUtil.getPicsFileDir());
		deleteFile(file);
	}

	/**
	 * ���ջ�������
	 */
	public void recyleCache()
	{
		if (bitmapCache != null)
		{
			Map<String, Bitmap> cache = bitmapCache.snapshot();
			for (Map.Entry<String, Bitmap> entry : cache.entrySet())
			{
				Bitmap bitmap = entry.getValue();
				if (bitmap != null)
				{
					bitmap.recycle();
					bitmap = null;
				}
			}
		}

		if (tasks != null)
		{
			for (Map.Entry<String, ImageTask> entry : tasks.entrySet())
			{
				ImageTask task = entry.getValue();
				if (task != null)
				{
					task.cancel(true);
				}
			}
		}
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param file
	 *            �ļ�
	 */
	private void deleteFile(File file)
	{
		if (file.exists())
		{ // �ж��ļ��Ƿ����

			if (file.isFile())
			{ // �ж��Ƿ����ļ�

				file.delete(); // delete()���� ��Ӧ��֪�� ��ɾ������˼;

			}
			else if (file.isDirectory())
			{ // �����������һ��Ŀ¼

				File files[] = file.listFiles(); // ����Ŀ¼�����е��ļ� files[];

				for (int i = 0; i < files.length; i++)
				{ // ����Ŀ¼�����е��ļ�

					this.deleteFile(files[i]); // ��ÿ���ļ� ������������е���

				}

			}

			file.delete();
		}
	}

	/**
	 * �ص��ӿ�
	 * 
	 * @author wanghl-a
	 * 
	 */
	public interface BitmapCallback
	{
		public void imageLoaded(Bitmap imageBitmap, String imageUrl);
	}

}