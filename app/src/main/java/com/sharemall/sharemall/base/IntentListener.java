package com.sharemall.sharemall.base;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;



/**
 * ��ת�ӿ�
 * 
 * @author wanghl-a
 * 
 */
public interface IntentListener
{
	/**
	 * �������������fragment
	 * 
	 * @param fragment
	 */
	public void addFragment(BaseFragment fragment);

	/**
	 * �滻���������fragment
	 * 
	 * @param newFragment
	 */
	public void replaceFragment(BaseFragment newFragment);

	/**
	 * fragment�滻
	 * 
	 * @param newFragment
	 *            ��Ƭ
	 * @param addToBackStack
	 *            �Ƿ񱣴��ջ��Ϣ
	 */
	public void replaceFragment(BaseFragment newFragment, boolean addToBackStack);

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
            boolean addToBackStack);

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
	public void goToCropImage(String path, Uri requestUri, int size);

	/**
	 * ͨ����ַ�鿴ͼƬ
	 * 
	 * @param path
	 *            ͼƬ��ַ
	 */
	public void goToView(String path);

	/**
	 * ͨ����ַ�鿴ͼƬ
	 * 
	 * @param path
	 *            ͼƬ��ַ
	 */
	public void goToView(String path, Class<?> cls);

	/**
	 * ������ҳ����ת
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 */
	public void goToOthers(Class<?> cls);

	/**
	 * ҳ����ת���رյ�ǰҳ��
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 */
	public void goToOthersF(Class<?> cls);

	/**
	 * ��������ҳ����ת
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 * @param bundle
	 *            ����
	 */
	public void goToOthers(Class<?> cls, Bundle bundle);

	/**
	 * ��������ҳ����ת���رյ�ǰҳ��
	 * 
	 * @param cls
	 *            ��ת��ҳ��
	 * @param bundle
	 *            ����
	 */
	public void goToOthersF(Class<?> cls, Bundle bundle);

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
	public void goToOthersForResult(Class<?> cls, Bundle bundle, int requestCode);

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
	public void backForResult(Class<?> cls, Bundle bundle, int resultCode);

	/**
	 * ��ĳһҳ�涥��
	 * 
	 * @param bundle
	 *            ����
	 */
	public void upToHome(Class<?> cls, Bundle bundle);

	/**
	 * ��ĳһҳ�涥��
	 */
	public void upToHome(Class<?> cls);

	/**
	 * ģ��home���¼�
	 */
	public void homeAction();

	/**
	 * ��ת����ҳ
	 * 
	 * @param url
	 *            ��ҳ��ַ
	 */
	public void goToWeb(String url);

	/**
	 * ��绰
	 * 
	 * @param telePhoneNum
	 *            �绰����
	 */
	public void goToCall(String telePhoneNum);

	/**
	 * ��װӦ��
	 * 
	 * @param file
	 */
	public void installApp(File file);

}
