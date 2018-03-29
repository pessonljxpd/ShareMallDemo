package com.sharemall.sharemall.base;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


/**
 * Fragment����
 * 

 * 
 */
public class BaseFragment extends Fragment implements OnClickListener,
        IntentListener
{

	private static final boolean DEBUG = false;

	/**
	 * ģ̬
	 */
	public MyProgressBar mProgressBar;

	private IntentListener intentFactory;
	private BaseActivity baseActivity;
	

	public void onAttach(Activity activity)
	{
		if (DEBUG)
			System.out.println("fragment��ʼonAttach");
	
		super.onAttach(activity);
	}

	public void onCreate(Bundle savedInstanceState)
	{
		if (DEBUG)
			System.out.println("fragment��ʼonCreate");
		super.onCreate(savedInstanceState);
		intentFactory = new FragmentIntentFactory(this);
		baseActivity = getBaseActivity();
		mProgressBar = new MyProgressBar(getActivity());
	}

	/**
	 * ����EditText���룬����ܳ���length�ĳ���
	 * 
	 * @param et
	 *            EditText�ؼ�
	 * @param length
	 *            ���Ƴ���
	 */
	public void limitEditTextLength(final EditText et, final int length)
	{
		if (baseActivity != null)
			baseActivity.limitEditTextLength(et, length);
	}

	/**
	 * �������������fragment
	 * 
	 * @param fragment
	 */
	public void addFragment(BaseFragment fragment)
	{
		intentFactory.addFragment(fragment);
	}

	/**
	 * �滻���������fragment
	 * 
	 * @param newFragment
	 */
	public void replaceFragment(BaseFragment newFragment)
	{
		intentFactory.replaceFragment(newFragment);
	}

	/**
	 * fragment�滻
	 * 
	 * @param newFragment
	 *            ��Ƭ
	 * @param addToBackStack
	 *            �Ƿ񱣴��ջ��Ϣ
	 */
	public void replaceFragment(BaseFragment newFragment, boolean addToBackStack)
	{
		intentFactory.replaceFragment(newFragment, addToBackStack);
	}

	/**
	 * fragment�滻
	 * 
	 * @param contentID
	 *            ����ID
	 * @param newFragment
	 *            ��Ƭ
	 * @param addToBackStack
	 *            �Ƿ񱣴��ջ��Ϣ
	 */
	public void replaceFragment(int contentID, BaseFragment newFragment,
	        boolean addToBackStack)
	{
		intentFactory.replaceFragment(contentID, newFragment, addToBackStack);
	}

	/**
	 * ȥ�ü�ͼƬ
	 * 
	 * @param path
	 *            ͼƬ��ַ
	 * @param requestUri
	 *            �ü��ص���ַ
	 * @param size
	 *            �ü���С
	 */
	public void goToCropImage(String path, Uri requestUri, int size)
	{
		intentFactory.goToCropImage(path, requestUri, size);
	}

	public void goToView(String path)
	{
		intentFactory.goToView(path);
	}

	/**
	 * ͨ����ַ�鿴ͼƬ
	 * 
	 * @param path
	 *            ͼƬ��ַ
	 */
	public void goToView(String path, Class<?> cls)
	{
		intentFactory.goToView(path, cls);
	}

	/**
	 * ������ҳ����ת
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 */
	public void goToOthers(Class<?> cls)
	{
		intentFactory.goToOthers(cls);
	}

	/**
	 * ҳ����ת���رյ�ǰҳ��
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 */
	public void goToOthersF(Class<?> cls)
	{
		intentFactory.goToOthersF(cls);
	}

	/**
	 * ��������ҳ����ת
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 * @param bundle
	 *            ����
	 */
	public void goToOthers(Class<?> cls, Bundle bundle)
	{
		intentFactory.goToOthers(cls, bundle);
	}

	/**
	 * ��������ҳ����ת���رյ�ǰҳ��
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 * @param bundle
	 *            ����
	 */
	public void goToOthersF(Class<?> cls, Bundle bundle)
	{
		intentFactory.goToOthersF(cls, bundle);
	}

	/**
	 * ���ص���ҳ����ת
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 * @param bundle
	 *            ����
	 * @param requestCode
	 *            ������
	 */
	public void goToOthersForResult(Class<?> cls, Bundle bundle, int requestCode)
	{
		intentFactory.goToOthersForResult(cls, bundle, requestCode);
	}

	/**
	 * ���ûص�
	 * 
	 * @param cls
	 *            �ص���ҳ��
	 * @param bundle
	 *            ����
	 * @param resultCode
	 *            ������
	 */
	public void backForResult(Class<?> cls, Bundle bundle, int resultCode)
	{
		intentFactory.backForResult(cls, bundle, resultCode);
	}

	/**
	 * ��ĳһҳ�涥��
	 * 
	 * @param bundle
	 *            ����
	 */
	public void upToHome(Class<?> cls, Bundle bundle)
	{
		intentFactory.upToHome(cls, bundle);
	}

	/**
	 * ��ĳһҳ�涥��
	 */
	public void upToHome(Class<?> cls)
	{
		intentFactory.upToHome(cls);
	}

	public void homeAction()
	{
		intentFactory.homeAction();
	}

	/**
	 * ��ת����ҳ
	 * 
	 * @param url
	 *            ��ҳ��ַ
	 */
	public void goToWeb(String url)
	{
		intentFactory.goToWeb(url);
	}

	/**
	 * ��绰
	 * 
	 * @param telePhoneNum
	 *            �绰����
	 */
	public void goToCall(String telePhoneNum)
	{
		intentFactory.goToCall(telePhoneNum);
	}

	/**
	 * ��װӦ��
	 * 
	 * @param file
	 */
	public void installApp(File file)
	{
		intentFactory.installApp(file);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		Bundle bundle = null;
		if (data != null)
		{
			bundle = data.getBundleExtra(BaseActivity.PARAM_INTENT);
			if (bundle == null)
			{
				bundle = data.getExtras();
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
		onActivityResult(requestCode, resultCode, bundle);
	}

	/**
	 * ҳ��ص�����
	 * 
	 * @param requestCode
	 *            ������
	 * @param resultCode
	 *            ������
	 * @param data
	 *            ����
	 */
	protected void onActivityResult(int requestCode, int resultCode, Bundle data)
	{

	}

	public void onActivityCreated(Bundle savedInstanceState)
	{
		if (DEBUG)
			System.out.println("fragment��ʼonActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	public void onStart()
	{
		if (DEBUG)
			System.out.println("fragment��ʼonStart");
		super.onStart();
	}




	public void onDestroyView()
	{
		if (DEBUG)
			System.out.println("fragment��ʼonDestroyView");
		super.onDestroyView();
	}

	public void onDestroy()
	{
		if (DEBUG)
			System.out.println("fragment��ʼonDestroy");
		super.onDestroy();
	}


	public void onClick(View v)
	{
	}

	/**
	 * ��ȡActivity�������
	 * 
	 * @return BaseActivity����
	 */
	public BaseActivity getBaseActivity()
	{
		try
		{
			return (BaseActivity) getActivity();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
