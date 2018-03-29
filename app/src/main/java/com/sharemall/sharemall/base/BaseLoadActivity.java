package com.sharemall.sharemall.base;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

/**
 * ��ҪLoading�Ļ���
 * 


 * 
 * @param <L>
 *            ��������
 */
public abstract class BaseLoadActivity<L> extends BaseActivity implements
        LoaderCallbacks<L>
{

	/**
	 * �������
	 * 
	 * @param action
	 *            ��ʾ
	 * @param arg1
	 *            ����
	 */
	protected abstract void loadFinished(int action, L arg1);

	public abstract Loader<L> onCreateLoader(int arg0, Bundle arg1);

	public void onLoadFinished(Loader<L> arg0, L arg1)
	{
		int action = arg0.getId();
		getSupportLoaderManager().destroyLoader(action);
		loadFinished(action, arg1);
	}

	public void onLoaderReset(Loader<L> arg0)
	{

	}

}
