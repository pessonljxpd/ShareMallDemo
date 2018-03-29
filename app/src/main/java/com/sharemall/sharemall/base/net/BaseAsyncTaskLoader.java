package com.sharemall.sharemall.base.net;

import java.util.Map;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.sharemall.sharemall.utils.UriUtil;

/**
 * �첽Loader����
 * @param <D>
 *            ����
 */
public abstract class BaseAsyncTaskLoader<D> extends AsyncTaskLoader<D>
{
	/**
	 * ���ݴ�������
	 */
	protected DataUtil mDataUtil = new DataUtil();

	/**
	 * ���ݶ���
	 */
	protected D mData;

	/**
	 * ������
	 */
	protected Context context;

	/**
	 * ��ַ
	 */
	protected String url;

	/**
	 * ����
	 */
	protected Map<String, String> params;

	/**
	 * �ϴ�����
	 */
	protected Object obj;

	/**
	 * ���췽��
	 * 
	 * @param context
	 *            ������
	 */
	public BaseAsyncTaskLoader(Context context)
	{
		super(context);
		this.context = context;
	}

	/**
	 * ���췽��
	 * 
	 * @param context
	 *            ������
	 * @param action
	 *            ��Ӧ��
	 * @param params
	 *            ����
	 * @param obj
	 *            Post�ϴ�����
	 */
	public BaseAsyncTaskLoader(Context context, int action,
	        Map<String, String> params, Object obj)
	{
		super(context);
		this.context = context;
		this.url = UriUtil.getUriBase();
		this.params = params;
		this.params.put("Action", action + "");
		this.obj = obj;
	}

	/**
	 * ��̨����
	 */
	@Override
	public abstract D loadInBackground();

	/**
	 * ���ݽ��
	 */
	@Override
	public void deliverResult(D data)
	{
		mData = data;
		if (isStarted())
		{
			super.deliverResult(data);
		}
	};

	/**
	 * ��ʼLoading
	 */
	@Override
	protected void onStartLoading()
	{
		if (mData != null)
		{
			deliverResult(mData);
		}

		if (takeContentChanged() || mData == null)
		{
			forceLoad();
		}
	}

	/**
	 * ����Loading
	 */
	@Override
	protected void onStopLoading()
	{
		cancelLoad();
	}
}
