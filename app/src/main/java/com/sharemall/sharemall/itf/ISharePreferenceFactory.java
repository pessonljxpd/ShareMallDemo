package com.sharemall.sharemall.itf;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.sharemall.sharemall.beans.UserInfo;

/**
 * sharePreference��������
 * 
 * 
 */
public interface ISharePreferenceFactory
{

	public SharedPreferences getSharedPreferences();

	public Editor getEditor();

	/**
	 * �Ƿ�ȥ����ҳ��
	 * 
	 * @return
	 */
	public boolean isGoToGuide();

	/**
	 * ��ɵ���
	 */
	public void finishGuide();

	/**
	 * �Ƿ�ȥ����ҳ��
	 * 
	 * @return
	 */
	public boolean showFunctionGuide();

	/**
	 * ��ɵ���
	 */
	public void finishFunctionGuide();

	public void setUser(UserInfo info);

	public UserInfo getUser();

	/**
	 * �����˺�
	 * 
	 * @param userName
	 *            �˺�
	 */
	public void setUserName(String userName);

	/**
	 * ��ȡ����
	 * 
	 * @return ����
	 */
	public String getUserName();

	/**
	 * ��������
	 * 
	 * @param password
	 *            ����
	 */
	public void setPassword(String password);

	/**
	 * ��ȡ����
	 * 
	 * @return ����
	 */
	public String getPassword();

	/**
	 * ���ü�ס����
	 * 
	 * @param isRememberPassword
	 *            �Ƿ��ס����
	 */
	public void setRememberPassword(boolean isRememberPassword);

	/**
	 * �Ƿ��ס����
	 * 
	 * @return �Ƿ��ס����
	 */
	public boolean isRememberPassword();

	/**
	 * �����Ƿ��Զ���¼
	 * 
	 * @param isAutoLogin
	 *            �Ƿ��Զ���¼
	 */
	public void setAutoLogin(boolean isAutoLogin);

	/**
	 * �Ƿ��Զ���¼
	 * 
	 * @return �Ƿ��Զ���¼
	 */
	public boolean isAutoLogin();

	



	/**
	 * ����Ĭ����ϵ��
	 * 
	 * @param linkman
	 *            Ĭ����ϵ��
	 */
	public void setLinkman(String linkman);

	/**
	 * ��ȡĬ����ϵ��
	 * 
	 * @return Ĭ����ϵ��
	 */
	public String getLinkman();

	/**
	 * ����Ĭ����ϵ�绰
	 * 
	 * @param contactTele
	 *            Ĭ����ϵ�绰
	 */
	public void setContactTele(String contactTele);

	/**
	 * ��ȡĬ����ϵ�绰
	 * 
	 * @return Ĭ����ϵ�绰
	 */
	public String getContactTele();

	/**
	 * �����Ƿ񱣴�����
	 * 
	 * @param isSaveSetting
	 *            �Ƿ񱣴�����
	 */
	public void setSaveSetting(boolean isSaveSetting);

	/**
	 * �Ƿ񱣴�����
	 * 
	 * @return �Ƿ񱣴�����
	 */
	public boolean isSaveSetting();

	
	

}
