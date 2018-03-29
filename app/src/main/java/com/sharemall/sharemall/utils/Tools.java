package com.sharemall.sharemall.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.text.style.ForegroundColorSpan;

public class Tools
{
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param text
	 *            ����
	 * @return
	 */
	public static boolean isEmpty(String text)
	{
		return TextUtils.isEmpty(text);
	}

	/**
	 * �����ַ���
	 * 
	 * @param text
	 *            ����
	 * @return
	 */
	public static String trim(String text)
	{
		return isEmpty(text) ? "" : text.trim();
	}

	/**
	 * ��ȡ�滻�ַ���
	 * 
	 * @param data
	 *            �ַ���ԭ��
	 * @param args
	 *            Ҫ�滻�Ĳ���
	 * @return �滻����ַ���
	 */
	public static Spanned getReleaseString(String data, Object[] args)
	{
		String s = String.format(data, args);
		Spanned span = Html.fromHtml(s);
		return span;
	}

	/**
	 * �滻�ַ���ĳһ�ε���ɫ
	 * 
	 * @param data
	 *            ����Դ
	 * @param color
	 *            Ҫ�滻�ɵ���ɫ
	 * @param index
	 *            ��ʼ�±�
	 * @param length
	 *            Ҫ�滻�ĳ���
	 * @return �滻����ַ���
	 */
	public static SpannableString getReleaseColorString(String data, int color,
	        int index, int length)
	{
		SpannableString ss = new SpannableString(data);
		ss.setSpan(new ForegroundColorSpan(color), index, length,
		        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		return ss;
	}
	/**
	 * ��ȡͼƬ���ػ����ַ
	 * 
	 * @param imagePath
	 *            ͼƬ�����ַ
	 * @return
	 */
	public static String getLocoalImagePath(String imagePath)
	{
		return isEmpty(imagePath) || !isHasSDCard() ? null : FileCacheUtil
		        .getPicFilePath(parserImageName(imagePath));
	}
	/**
	 * �ж�����ĵ绰�����ʽ�Ƿ���ȷ
	 * 
	 * @param phoneNumber
	 *            �ַ���
	 * @return
	 */
	public static boolean accountNumberIsTrue(String phoneNumber)
	{
		String regex = "^1[3|4|5|8]\\d{9}$";
		boolean result = phoneNumber.matches(regex);
		return result;
	}

	/**
	 * ��ȡ�û��ֻ�����
	 * 
	 * @param context
	 *            ������
	 * @return
	 */
	public static String getUserPhoneNumber(Context context)
	{
		TelephonyManager telephonyManager = (TelephonyManager) context
		        .getSystemService(Context.TELEPHONY_SERVICE);
		String phoneNumber = telephonyManager.getLine1Number();
		if (!Tools.isEmpty(phoneNumber) && phoneNumber.length() > 11)
		{
			phoneNumber = phoneNumber.substring(phoneNumber.length() - 11,
			        phoneNumber.length());
		}
		return phoneNumber;
	}

	/**
	 * �ж��Ƿ�����GPS
	 * 
	 * @param context
	 *            ������
	 * @return
	 */
	public static boolean isOpenGps(Context context)
	{
		LocationManager locationManager = (LocationManager) context
		        .getSystemService(Context.LOCATION_SERVICE);
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	/**
	 * �ж��Ƿ���������
	 * 
	 * @param context
	 *            ������
	 * @return �Ƿ���������
	 */
	public static boolean isConnectNet(Context context)
	{
		ConnectivityManager conManager = (ConnectivityManager) context
		        .getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conManager == null)
		{
			return false;
		}
		else
		{
			NetworkInfo[] info = conManager.getAllNetworkInfo();
			if (info != null)
			{
				for (int i = 0; i < info.length; i++)
				{
					if (info[i].isConnected())
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * �Ƿ����SDCard
	 * 
	 * @return
	 */
	public static boolean isHasSDCard()
	{
		return Environment.getExternalStorageState().equals(
		        Environment.MEDIA_MOUNTED);
	}

	
	

	
	/**
	 * �ַ����Ƿ����������
	 * 
	 * @param str
	 *            �ַ���
	 * @return
	 */
	public static boolean isNumeric(String str)
	{
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	

	/**
	 * ͨ��Url�����ļ�����
	 * 
	 * @param imageUrl
	 *            ͼƬuri
	 * @return �ļ�����
	 */
	public static String parserImageName(String imageUrl)
	{
		return imageUrl.substring(imageUrl.lastIndexOf("/") + 1,
		        imageUrl.lastIndexOf("."));
	}

	/**
	 * ��ʽ���ļ���С
	 * 
	 * @param context
	 *            ������
	 * 
	 * @param length
	 *            ����
	 * @return
	 */
	public static String formatFileSize(Context context, long length)
	{
		return Formatter.formatFileSize(context, length);
	}

	/**
	 * ��ȡͼƬ����ѡ��ͼƬ�ĵ�ַ
	 * 
	 * @param context
	 *            ������
	 * @param data
	 *            Intent����
	 * @return ͼƬ��ַ
	 */
	public static String getPicPathFormLibs(Context context, Intent data)
	{
		if (data != null)
		{
			Uri uri = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = context.getContentResolver().query(uri,
			        filePathColumn, null, null, null);
			if (cursor != null)
			{
				cursor.moveToFirst();
				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String picturePath = cursor.getString(columnIndex);
				cursor.close();
				return picturePath;
			}
			else
			{
				return null;
			}
		}
		return null;
	}

	/**
	 * ������ת�����ֽ�����
	 * 
	 * @param is
	 * @return
	 */
	public static byte[] streamToBytes(InputStream is)
	{
		ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
		byte[] buffer = new byte[1024];
		int len;
		try
		{
			while ((len = is.read(buffer)) >= 0)
			{
				os.write(buffer, 0, len);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return os.toByteArray();
	}

	/**
	 * ѹ��ͼƬ
	 * 
	 * @param bitmap
	 *            ͼƬ����
	 * @param rect
	 *            ѹ���ĳߴ�
	 * @param isMax
	 *            �Ƿ������
	 * @param isZoomOut
	 *            �Ƿ�Ŵ�
	 * @return
	 */
	public static Bitmap resizeImage(Bitmap bitmap, int rect, boolean isMax,
	        boolean isZoomOut)
	{
		try
		{
			// load the origial Bitmap

			int width = bitmap.getWidth();

			int height = bitmap.getHeight();

			if (!isZoomOut && rect >= width && rect >= height)
			{
				return bitmap;
			}
			int newWidth = 0;
			int newHeight = 0;

			if (isMax || isZoomOut)
			{
				newWidth = width >= height ? rect : rect * width / height;
				newHeight = width <= height ? rect : rect * height / width;
			}
			else
			{
				newWidth = width <= height ? rect : rect * width / height;
				newHeight = width >= height ? rect : rect * height / width;
			}

			if (width >= height)
			{
				if (isMax)
				{
					newWidth = rect;
					newHeight = height * newWidth / width;
				}
				else
				{
					if (isZoomOut)
					{
						newWidth = rect;
						newHeight = height * newWidth / width;
					}
					else
					{
						newHeight = rect;
						newWidth = width * newHeight / height;
					}
				}
			}
			else
			{
				if (!isMax)
				{
					newWidth = rect;
					newHeight = height * newWidth / width;
				}
				else
				{
					newHeight = rect;
					newWidth = width * newHeight / height;
				}
			}

			// calculate the scale
			float scaleWidth = 0f;
			float scaleHeight = 0f;

			scaleWidth = ((float) newWidth) / width;

			scaleHeight = ((float) newHeight) / height;

			Matrix matrix = new Matrix();

			matrix.postScale(scaleWidth, scaleHeight);

			bitmap = Bitmap.createBitmap(bitmap, 0, 0, width,

			height, matrix, true);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return bitmap;

	}

	/**
	 * ѹ��ͼƬ��size
	 * 
	 * @param temp
	 *            ͼƬ��������
	 * @param size
	 *            �ߴ�
	 * @return
	 * @throws IOException
	 */
	public static byte[] revitionImageSize(Bitmap bitmap, int maxRect, int size)
	{
		byte[] b = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try
		{
			bitmap = resizeImage(bitmap, maxRect, true, false);

			if (bitmap == null)
			{
				return null;
			}

			bitmap.compress(Bitmap.CompressFormat.JPEG, 90, os);
			b = os.toByteArray();
			int options = 80;
			while (b.length > size)
			{
				os.reset();
				bitmap.compress(Bitmap.CompressFormat.JPEG, options, os);
				b = os.toByteArray();
				options -= 10;
			}
			os.flush();
			os.close();
			bitmap = BitmapFactory.decodeByteArray(new byte[0], 0, 0);
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		return b;
	}

	/**
	 * ѹ��ͼƬ��size
	 * 
	 * @param temp
	 *            ͼƬ��������
	 * @param size
	 *            �ߴ�
	 * @return
	 * @throws IOException
	 */
	public static Bitmap revitionBitmap(Bitmap bitmap, int maxRect, int size)
	{
		byte[] b = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try
		{
			bitmap = resizeImage(bitmap, maxRect, true, false);

			if (bitmap == null)
			{
				return null;
			}

			bitmap.compress(Bitmap.CompressFormat.JPEG, 90, os);
			b = os.toByteArray();
			int options = 80;
			while (b.length > size)
			{
				os.reset();
				bitmap.compress(Bitmap.CompressFormat.JPEG, options, os);
				b = os.toByteArray();
				options -= 10;
			}
			os.flush();
			os.close();

		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		return bitmap;
	}

	/**
	 * ��ȡͼ��
	 * 
	 * @param filePath
	 *            ����ͼƬ��ַ
	 * @param rect
	 *            ͼƬ�ߴ�
	 * @param isMax
	 *            �Ƿ������
	 * @return
	 */
	public static Bitmap getBitmap(String filePath, int rect, boolean isMax)
	{
		return getBitmap(filePath, rect, isMax, false);
	}

	/**
	 * ��ȡͼ��
	 * 
	 * @param filePath
	 *            ����ͼƬ��ַ
	 * @param rect
	 *            ͼƬ�ߴ�
	 * @param isMax
	 *            �Ƿ������
	 * @param isZoomOut
	 *            �Ƿ�Ŵ�
	 * @return
	 */
	public static Bitmap getBitmap(String filePath, int rect, boolean isMax,
	        boolean isZoomOut)
	{
		InputStream is = null;
		Bitmap photo = null;
		try
		{
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(filePath, opts);

			// �õ�ͼƬԭʼ���
			int photoWidth = opts.outWidth;
			int photoHeight = opts.outHeight;

			// �ж�ͼƬ�Ƿ���Ҫ����
			is = new FileInputStream(filePath);
			opts = new BitmapFactory.Options();

			if (photoWidth > rect || photoHeight > rect)
			{
				if (photoWidth > photoHeight)
				{
					if (isZoomOut)
					{
						opts.inSampleSize = photoWidth / rect;
					}
					else
					{
						opts.inSampleSize = isMax ? photoWidth / rect
						        : photoHeight / rect;
					}
				}
				else
				{
					opts.inSampleSize = !isMax ? photoWidth / rect
					        : photoHeight / rect;
				}
			}
			photo = BitmapFactory.decodeStream(is, null, opts);
			photo = rotaingImageView(Tools.readPictureDegree(filePath), photo);
			photo = resizeImage(photo, rect, isMax, isZoomOut);
			System.out.println("ѹ����ͼƬ�Ŀ�ȣ�" + photo.getWidth());
			System.out.println("ѹ����ͼƬ�ĸ߶ȣ�" + photo.getHeight());
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return photo;
	}

	/**
	 * ���Բ��ͼƬ
	 * 
	 * @param bitmap
	 *            ͼƬ
	 * @param roundPx
	 *            �Ƕ�
	 * @return
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx)
	{
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Bitmap output = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, w, h);
		final RectF rectF = new RectF(rect);
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}

	/**
	 * ��תͼƬ
	 * 
	 * @param angle
	 * @param bitmap
	 * @return Bitmap
	 */
	public static Bitmap rotaingImageView(int angle, Bitmap bitmap)
	{
		if (angle == 0 || bitmap == null)
		{
			return bitmap;
		}
		// ��תͼƬ ����
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
		// �����µ�ͼƬ
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
		        bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizedBitmap;
	}

	/**
	 * ��ȡͼƬ���ԣ���ת�ĽǶ�
	 * 
	 * @param path
	 *            ͼƬ����·��
	 * @return degree��ת�ĽǶ�
	 */
	public static int readPictureDegree(String path)
	{
		int degree = 0;
		try
		{
			ExifInterface exifInterface = new ExifInterface(path);
			int orientation = exifInterface.getAttributeInt(
			        ExifInterface.TAG_ORIENTATION,
			        ExifInterface.ORIENTATION_NORMAL);
			switch (orientation)
			{
				case ExifInterface.ORIENTATION_ROTATE_90:
					degree = 90;
					break;
				case ExifInterface.ORIENTATION_ROTATE_180:
					degree = 180;
					break;
				case ExifInterface.ORIENTATION_ROTATE_270:
					degree = 270;
					break;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return degree;
	}
}
