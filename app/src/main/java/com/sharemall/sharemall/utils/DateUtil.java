package com.sharemall.sharemall.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
	public static SimpleDateFormat sdfyyyy_MM_dd = new SimpleDateFormat(
	        "yyyy-MM-dd");
	public static SimpleDateFormat sdfyyyy_MM_dd_HH_mm_ss = new SimpleDateFormat(
	        "yyyy-MM-dd HH:mm:ss");

	public static SimpleDateFormat sdfyyyy_MM_dd_HH_mm = new SimpleDateFormat(
	        "yyyy��MM��dd�� HH:mm");
	public static SimpleDateFormat sdfyyyy_MM_dd_HH = new SimpleDateFormat(
	        "yyyy��MM��dd�� HH:00");

	public static SimpleDateFormat sdfHH_mm = new SimpleDateFormat("HH:mm");
	public static SimpleDateFormat sdfMM_dd = new SimpleDateFormat("MM_dd");

	/**
	 * return yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getDate_yyyy_MM_dd()
	{
		return sdfyyyy_MM_dd.format(new Date());
	}

	public static String getDate_HH_mm()
	{
		return sdfHH_mm.format(new Date());
	}

	/**
	 * return yyyy_MM_dd_HH_mm_ss
	 * 
	 * @return
	 */
	public static String getDate_yyyy_MM_dd_HH_mm_ss()
	{
		return sdfyyyy_MM_dd_HH_mm_ss.format(new Date());
	}

	/**
	 * 
	 * @param dateString
	 * @return ��1970�������
	 */
	public static long getDate(String dateString, SimpleDateFormat format)
	{
		long time = 0;
		Date date = null;
		try
		{
			date = format.parse(dateString);
			time = (date.getTime() - format.parse("1970-1-1 0:0:0").getTime()) / 1000;
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		return time;
	}

	/**
	 * �ɷ��ػ������������������ʱ��
	 * 
	 * @param s
	 * @return
	 */
	public static String getDateString(long s, SimpleDateFormat format)
	{
		Calendar c = Calendar.getInstance();
		int offset = c.getTimeZone().getRawOffset();
		c.setTime(new Date(s * 1000 - offset));
		Date dt = c.getTime();
		String str = format.format(dt);
		return str;
	}

	/**
	 * �ɺ����������������ʱ��
	 * 
	 * @param s
	 * @param format
	 * @return
	 */
	public static String getDateString(long ms)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(ms));
		Date dt = c.getTime();
		String str = sdfyyyy_MM_dd_HH_mm.format(dt);
		return str;
	}

	/**
	 * �з��ػ������������������������
	 * 
	 * @param second
	 * @return
	 */
	public static long getRealSecond(long s)
	{
		Calendar c = Calendar.getInstance();
		// int offset = c.getTimeZone().getRawOffset();
		// c.setTime(new Date(s * 1000 - offset));
		c.setTime(new Date(s * 1000));
		long timeInMillis = c.getTimeInMillis();
		return timeInMillis / 1000;
	}

	/**
	 * �����ĳһ���Ѿ��ϴ�����ʱ��
	 * 
	 * @param s
	 * @return
	 */
	public static String distanceTime(long second)
	{
		long realSecond = getRealSecond(second); // ���������ػ�������ʵʱ��
		long currentSecond = System.currentTimeMillis() / 1000; // ����ʱ��
		long disSecond = currentSecond - realSecond; // �����ڵ�ʱ��
		String result = null;

		int oneDay = 86400; // һ��
		int oneHour = 3600; // һСʱ
		int oneMonth = 2592000; // һ����

		if (disSecond < oneHour)
		{ // ������ǰ
			if (disSecond < 60)
			{
				result = "1����ǰ";
			}
			else
			{
				result = disSecond / 60 + "����ǰ";
			}
		}
		else if (disSecond >= oneHour && disSecond < oneDay)
		{ // ��Сʱǰ
			result = disSecond / oneHour + "Сʱǰ";
		}
		else if (disSecond >= oneDay && disSecond < oneMonth)
		{ // ����ǰ
			result = disSecond / oneDay + "��ǰ";
		}
		else
		{
			result = "һ����ǰ";
		}
		return result;
	}

	/**
	 * ��ʼ�����Ȧʱ��
	 * 
	 * @param milliseconds
	 *            ����
	 * @return
	 */
	public static String initCircleDate(long milliseconds)
	{
		Calendar currentDate = Calendar.getInstance();
		Calendar systemDate = Calendar.getInstance();
		currentDate.setTime(new Date());
		systemDate.setTime(new Date(milliseconds));
		long realSecond = milliseconds / 1000; // ���������ػ�������ʵʱ��
		long currentSecond = System.currentTimeMillis() / 1000; // ����ʱ��
		int oneHour = 3600; // һСʱ

		if (currentDate.get(Calendar.YEAR) == systemDate.get(Calendar.YEAR))
		{
			if (currentDate.get(Calendar.MONTH) == systemDate
			        .get(Calendar.MONTH)
			        && currentDate.get(Calendar.DAY_OF_MONTH) == systemDate
			                .get(Calendar.DAY_OF_MONTH))
			{
				long disSecond = currentSecond - realSecond; // �����ڵ�ʱ��
				if (disSecond < oneHour)
				{ // ������ǰ
					if (disSecond < 60)
					{
						return "�ո�";
					}
					else
					{
						return disSecond / 60 + "����ǰ";
					}
				}
				else
				{ // ��Сʱǰ
					return disSecond / oneHour + "Сʱǰ";
				}
			}
			else if (currentDate.get(Calendar.MONTH) == systemDate
			        .get(Calendar.MONTH)
			        && currentDate.get(Calendar.DAY_OF_MONTH) == systemDate
			                .get(Calendar.DAY_OF_MONTH) + 1)
			{
				return "���� "
				        + new SimpleDateFormat("HH��mm��").format(new Date(
				                milliseconds));
			}
			else if (currentDate.get(Calendar.MONTH) == systemDate
			        .get(Calendar.MONTH)
			        && currentDate.get(Calendar.DAY_OF_MONTH) == systemDate
			                .get(Calendar.DAY_OF_MONTH) + 2)
			{
				return "ǰ�� "
				        + new SimpleDateFormat("HH��mm��").format(new Date(
				                milliseconds));
			}
			else
			{
				return new SimpleDateFormat("MM��dd�� HH��mm��").format(new Date(
				        milliseconds));
			}
		}
		else
		{
			return new SimpleDateFormat("yyyy��MM��dd�� HH��mm��").format(new Date(
			        milliseconds));
		}
	}

	/**
	 * �õ���1970�������
	 * 
	 * @param s
	 * @return
	 */
	public static long getSecond(long s)
	{
		Date date = new Date(s);
		String dateString = sdfyyyy_MM_dd_HH_mm_ss.format(date);
		return getDate(dateString, sdfyyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * �������ڵ�����
	 */
	public static long getSecond(String date)
	{
		int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]) - 1;
		int day = Integer.parseInt(date.split("-")[2]);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis() / 1000;
	}

	/**
	 * �ɷ��ص������������
	 * 
	 */
	public static String getBirthDay(long s)
	{
		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);
		int offset = c.getTimeZone().getRawOffset();
		c.setTime(new Date(s * 1000 - offset));
		return currentYear - c.get(Calendar.YEAR) + "��";
	}

	/**
	 * �õ����յĵ��·ݺ�����
	 * 
	 * @param s
	 * @return
	 */
	public static int[] getBirth(long s)
	{
		int[] birthArray = new int[2];
		Calendar c = Calendar.getInstance();
		int offset = c.getTimeZone().getRawOffset();
		c.setTime(new Date(s * 1000 - offset));

		birthArray[0] = c.get(Calendar.MONDAY);
		birthArray[1] = c.get(Calendar.DAY_OF_MONTH);
		return birthArray;
	}

	/**
	 * �õ�ĳһ��Ŀ�ʼʱ��(type=1���� type == 2���� type ==3 �����)
	 */
	public static long getStartTime(int type)
	{

		Calendar calendar = Calendar.getInstance();

		switch (type)
		{
			case 1: // ����
				calendar.set(Calendar.DAY_OF_MONTH,
				        calendar.get(Calendar.DAY_OF_MONTH) + 1);
				break;
			case 2: // ����
				calendar.set(Calendar.DAY_OF_MONTH,
				        calendar.get(Calendar.DAY_OF_MONTH) + 2);
				break;
			case 3:// �����
				calendar.set(Calendar.DAY_OF_MONTH,
				        calendar.get(Calendar.DAY_OF_MONTH) + 3);
				break;
		}
		calendar.set(Calendar.HOUR_OF_DAY, 0); // Сʱ
		calendar.set(Calendar.MINUTE, 0); // ��
		calendar.set(Calendar.SECOND, 0); // ��
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTimeInMillis() / 1000;
	}
}