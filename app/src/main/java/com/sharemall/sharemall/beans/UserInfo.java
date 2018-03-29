package com.sharemall.sharemall.beans;

import java.io.Serializable;

/**
 * �û���Ϣ
 * 
 * @author wanghl-a
 * 
 */
public class UserInfo implements Serializable
{
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	public UserInfo()
	{
	}

	public UserInfo(int userID, String alias, String topImagePath,
	        String gender, String address, String sign)
	{
		this.userID = userID;
		this.alias = alias;
		this.topImagePath = topImagePath;
		this.gender = gender;
		this.address = address;
		this.sign = sign;
	}

	/**
	 * �û��˺�
	 */
	public String userName;

	/**
	 * �û����루���ܺ�
	 */
	public String password;

	/**
	 * �����루�޸�����ʱʹ�ã�
	 */
	public String newPassword;

	/**
	 * �û�ID
	 */
	public int userID;

	/**
	 * �ṩ��ID
	 */
	public int supplierID;

	/**
	 * �û��ǳ�
	 */
	public String alias;

	/**
	 * ͷ��·��
	 */
	public String topImagePath;

	/**
	 * �Ա�
	 */
	public String gender;

	/**
	 * ���ڵ�
	 */
	public String address;

	/**
	 * ���ڵ�code
	 */
	public String areaCode;

	/**
	 * ����ǩ��
	 */
	public String sign;

	/**
	 * �û���ʵ����
	 */
	public String realName;

	/**
	 * �ֻ���
	 */
	public String cellPhone;

	/**
	 * �û�������ϵ��ʽ
	 */
	public String email;

	/**
	 * ����
	 */
	public String feedback;

	/**
	 * ��������
	 */
	public String feedBackArea;

	/**
	 * �Ƿ���VIP��Ա
	 */
	public boolean vip;

	/**
	 * �Ƿ������VIP��Ա
	 */
	public boolean isRealVip;

	/**
	 * �Ƿ���������
	 */
	public boolean expireTime;

	/**
	 * ѯ������
	 */
	public int enquiryNum;

	/**
	 * Ӧ�ñ�ʾ
	 */
	public String appid;

	/**
	 * ͨ����ʶ
	 */
	public String channel_id;

	/**
	 * �û���ʶ
	 */
	public String user_id;

	/**
	 * ע�᷽ʽ(0:��ͨע��;1:�ֻ���ע��)
	 */
	public int registerType;

	/**
	 * �ֻ���֤��
	 */
	public String validateCode;
	
	/**
	 * ���������ֻ���֤��
	 */
	public String resetPasswordCode;
	

	/**
	 * ������(1:�ֻ�;2:QQ)
	 */
	public int bindType;

	/**
	 * QQUID
	 */
	public String qqUid;

	/**
	 * QQ�ǳ�
	 */
	public String qqNickName;

	/**
	 * �Ƿ��QQ
	 */
	public int bindQQ;

	/**
	 * �Ƿ���ֻ�
	 */
	public int bindCellPhone;

	/**
	 * �����ֶ�
	 */
	public int point;

	/**
	 * δ��ϵͳ��Ϣ����
	 */
	public int unReadSysMessageNumber;

	/**
	 * δ��˽����Ϣ����
	 */
	public int unReadChatNumber;

	/**
	 * ��Ӧ�루0���ɹ���1��ʧ�ܣ�
	 */
	public int code;

	/**
	 * code=1ʱ��ʾ���û�����Ϣ
	 */
	public String message;

	/**
	 * ���ص�����
	 */
	public String data;
}
