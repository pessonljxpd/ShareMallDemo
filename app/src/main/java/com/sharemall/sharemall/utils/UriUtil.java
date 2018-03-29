package com.sharemall.sharemall.utils;

/**
 * �ӿڵ�ַ������
 * 
 * 
 */
public class UriUtil
{
	private static final String HTTP_HEAD = "http://";

	// private static final String SERVER_DOMAIN =
	// "192.168.75.88:8080/Supplier";

	// private static final String SERVER_DOMAIN =
	// "192.168.132.224:8080/supplier/Supplier";

	private static final String SERVER_DOMAIN = "app.gldjc.com/gcsupplier/Supplier";

	/**
	 * ��������
	 */
	public static final int SEARCH_ACTION = 101;
	/**
	 * ���������б�
	 */
	public static final int SEARCH_MATERIAL_ACTION = 102;
	/**
	 * ������Ӧ���б�
	 */
	public static final int SEARCH_SUPPLIER_ACTION = 103;
	/**
	 * ��������
	 */
	public static final int MATERIAL_DETAIL_ACTION = 104;
	/**
	 * ��Ӧ������
	 */
	public static final int SUPPLIER_DETAIL_ACTION = 105;
	/**
	 * �������
	 */
	public static final int MATERIAL_TYPE_ACTION = 106;
	/**
	 * ��Ӧ�̲���
	 */
	public static final int SUPPLIER_MATERIAL_ACTION = 107;
	/**
	 * �����Ĺ�Ӧ��
	 */
	public static final int NEAR_SUPPLIER_ACTION = 108;

	/**
	 * ����Ʒ��
	 */
	public static final int MATERIAL_BRAND_ACTION = 109;

	/**
	 * ��Ӧ��ɾ������
	 */
	public static final int SUPPLIER_DELETE_MATERIAL = 110;

	/**
	 * ͼƬѯ��
	 */
	public static final int PIC_ENQUIRY_ACTION = 201;
	/**
	 * ����ѯ��
	 */
	public static final int FORM_ENQUIRY_ACTION = 202;
	/**
	 * ѯ������
	 */
	public static final int ENQUIRY_NUM_ACTION = 203;

	/**
	 * ��¼
	 */
	public static final int LOGIN_ACTION = 301;
	/**
	 * ע��
	 */
	public static final int REGISTER_ACTION = 302;
	/**
	 * �޸��û���Ϣ
	 */
	public static final int UPDATE_INFO_ACTION = 303;
	/**
	 * �޸�����
	 */
	public static final int MODIFY_PWD_ACTION = 304;
	/**
	 * �ҵ�ѯ�۵��б�
	 */
	public static final int ENQUIRY_LIST_ACTION = 305;
	/**
	 * �ҵ�ѯ�۵�����
	 */
	public static final int ENQUIRY_DETAIL_ACTION = 306;
	/**
	 * �����б�
	 */
	public static final int INTEGRAL_LIST_ACTION = 307;
	/**
	 * �û�����
	 */
	public static final int FEEDBACK_ACTION = 308;
	/**
	 * ԭʼѯ�۵�
	 */
	public static final int ORIGINAL_ENQUIRY_ACTION = 309;
	/**
	 * ѯ����ϵ��
	 */
	public static final int ENQUIRY_PROJECT_INFO = 310;
	/**
	 * �˳���¼
	 */
	public static final int EXIT_LOGIN = 311;
	/**
	 * �汾����
	 */
	public static final int APP_UPDATE_ACTION = 312;
	/**
	 * �ҵ���Ѷ�б�
	 */
	public static final int NEWS_LIST_ACTION = 313;
	/**
	 * ���͹���
	 */
	public static final int RELEVANCE_PUSH_ACTION = 314;

	/**
	 * ϵͳ����
	 */
	public static final int NOTICE_ACTION = 315;

	/**
	 * �ϴ��û�ͷ��
	 */
	public static final int UPLOAD_USER_ICON_ACTION = 316;

	/**
	 * �޸��û���Ϣ(�Ա����ڵء����顢����)
	 */
	public static final int UPLOAD_USER_INFO_ACTION = 317;

	/**
	 * �޸��û��ǳ�
	 */
	public static final int UPLOAD_USER_ALIAS_ACTION = 318;

	/**
	 * �޸��û��ֻ�
	 */
	public static final int UPLOAD_USER_TELE_ACTION = 319;

	/**
	 * ��ȡ��֤��
	 */
	public static final int GET_AUTH_CODE_ACTION = 320;

	/**
	 * ��ȡ�û����ֻ���֤��
	 */
	public static final int GET_USER_BIND_AUTH_CODE_ACTION = 321;

	/**
	 * �˻���
	 */
	public static final int USER_BIND_ACTION = 322;

	/**
	 * �˻����
	 */
	public static final int USER_UNBIND_ACTION = 323;

	/**
	 * ϵͳ��Ϣ�б�
	 */
	public static final int MSG_SYSTEM_LIST_ACTION = 324;

	/**
	 * ��ȡϵͳ��Ϣ״̬
	 */
	public static final int MSG_READ_SYSTEM_ACTION = 325;

	/**
	 * ��¼ҳ�� ��ȡ��֤��
	 */
	public static final int ACCOUNT_CALL_PHONE_CODE_ACTION = 326;

	/**
	 * ��¼ҳ�� ��֤��֤��
	 */
	public static final int ACCOUNT_CALL_PHONE_RESET_CODE_ACTION = 327;

	/**
	 * ��¼ҳ�� ��������
	 */
	public static final int ACCOUNT_CALL_PHONE_RESET_PASSWORD_CODE_ACTION = 328;

	/**
	 * ��Ϣ��ʡ��
	 */
	public static final int PRICE_PROVINCE_ACTION = 401;
	/**
	 * ��Ϣ�۳���
	 */
	public static final int PRICE_CITY_ACTION = 402;
	/**
	 * ��Ϣ�۵���
	 */
	public static final int PRICE_AREA_ACTION = 403;
	/**
	 * ��Ϣ������
	 */
	public static final int PRICE_YEAR_ACTION = 404;
	/**
	 * ��Ϣ������
	 */
	public static final int PRICE_PERIOD_ACTION = 405;
	/**
	 * ��Ϣ���б�
	 */
	public static final int PRICE_SCAN_ACTION = 406;

	/**
	 * ��Ӧ�̸��¼۸�
	 */
	public static final int SUPPLIER_UPDATE_PRICE = 408;

	/**
	 * ��Ӧ��ɾ���۸�
	 */
	public static final int SUPPLIER_DELETE_PRICE = 409;

	/**
	 * ��Ӧ�̼۸��б�
	 */
	public static final int SUPPLIER_PRICE_LIST = 410;

	/**
	 * ������Ϣ�б�
	 */
	public static final int INFO_PROJECT_ACTION = 411;

	/**
	 * �ɹ��б�
	 */
	public static final int INFO_PURCHASE_DIDDING_ACTION = 412;

	/**
	 * �������̻�
	 */
	public static final int NEAR_INFO_ACTION = 413;

	/**
	 * ���ͶԻ�
	 */
	public static final int CHAT_SEND_ACTION = 511;

	/**
	 * ˽�˶Ի��б�
	 */
	public static final int CHAT_LIST_ACTION = 512;

	/**
	 * �Ի������б�
	 */
	public static final int CHAT_DETAIL_LIST_ACTION = 513;

	/**
	 * �ղع�Ӧ��
	 */
	public static final int COLLECT_SUPPLIER_ACTION = 601;
	/**
	 * �ղز�Ʒ
	 */
	public static final int COLLECT_MATERIAL_ACTION = 602;
	/**
	 * �ղع�Ӧ���б�
	 */
	public static final int COLLECT_SUPPLIER_LIST_ACTION = 603;
	/**
	 * �ղز�Ʒ�б�
	 */
	public static final int COLLECT_MATERIAL_LIST_ACTION = 604;
	/**
	 * ɾ���ղع�Ӧ��
	 */
	public static final int DELETE_COLLECT_SUPPLIER_ACTION = 605;
	/**
	 * ɾ���ղز���
	 */
	public static final int DELETE_COLLECT_MATERIAL_ACTION = 606;

	/**
	 * ��ȡ������
	 */
	public static final int GET_INVITATION_CODE_ACTION = 701;

	/**
	 * �Ƿ�����
	 */
	public static final int IS_INVITATED_ACTION = 702;

	/**
	 * �ύ������
	 */
	public static final int SUBMIT_INVITATION_CODE_ACTION = 703;

	/**
	 * �û��齱
	 */
	public static final int USER_DRAW_ACTION = 704;

	/**
	 * �û��齱�б�
	 */
	public static final int USER_DRAW_LIST_ACTION = 705;

	/**
	 * ��ɫͨ��
	 */
	public static final int BANNER_ACTION = 706;

	/**
	 * ��ȡɹ��Ƭ�û���Ϣ
	 */
	public static final int GET_IMAGE_USER_INFO = 707;

	/**
	 * ɹ��Ƭ
	 */
	public static final int UPLOAD_IMAGE = 708;

	/**
	 * ��ȡ��Ƭ�б�
	 */
	public static final int GET_IMAGE_LIST = 709;

	/**
	 * ϲ����Ƭ
	 */
	public static final int LOVE_IMAGE = 710;

	/**
	 * ���Ʒ
	 */
	public static final int IMAGE_DRAW_ACTION = 711;

	/**
	 * ���л��Ʒ
	 */
	public static final int IMAGE_ALL_DRAW_ACTION = 712;

	/**
	 * ������̬
	 */
	public static final int PUBLISH_DYNAMIC_ACTION = 801;

	/**
	 * ���۶�̬
	 */
	public static final int COMMENT_DYNAMIC_ACTION = 802;

	/**
	 * �޶�̬
	 */
	public static final int GOOD_DYNAMIC_ACTION = 803;

	/**
	 * ��̬�б�
	 */
	public static final int DYNAMIC_LIST_ACTION = 804;

	/**
	 * ��̬�����б�
	 */
	public static final int DYNAMIC_COMMENT_LIST_ACTION = 805;

	/**
	 * ��ȡ�ҵĶ�̬�б�
	 */
	public static final int MY_DYNAMIC_LIST_ACTION = 806;

	/**
	 * ת����̬
	 */
	public static final int TRANSPOND_DYNAMIC_ACTION = 807;

	/**
	 * ת���ҵĶ�̬�б�
	 */
	public static final int TRANSPOND_ME_LIST_ACTION = 808;

	/**
	 * �����ҵĶ�̬�б�
	 */
	public static final int COMMENT_ME_LIST_ACTION = 809;

	/**
	 * ���ҵĶ�̬�б�
	 */
	public static final int GOOD_ME_LIST_ACTION = 810;

	/**
	 * �ҵ������б�
	 */
	public static final int MY_COMMENT_LIST_ACTION = 811;

	/**
	 * �ҵ����б�
	 */
	public static final int MY_GOOD_LIST_ACTION = 812;

	/**
	 * �ظ�����
	 */
	public static final int REPLY_COMMENT_ACTION = 813;

	/**
	 * ɾ������
	 */
	public static final int DELETE_COMMENT_ACTION = 814;

	/**
	 * ɾ����̬
	 */
	public static final int DELETE_DYNAMIC_ACTION = 815;

	/**
	 * ��ȡ�û���Ϣ
	 */
	public static final int GET_USER_INFO_ACTION = 820;

	/**
	 * �������Ȧ
	 */
	public static final int SHARE_TO_GLDJC_CIRCLE_ACTION = 821;

	/**
	 * ��ť���
	 */
	public static final int CLICK_TYPE_ACTION = 901;

	/**
	 * ��ļ۵���
	 */
	public static final int GLDJC_AREA_ACTION = 902;

	/**
	 * ��ļ����
	 */
	public static final int GLDJC_YEARS_ACTION = 903;

	/**
	 * ��ļ�����
	 */
	public static final int GLDJC_PERIOD_ACTION = 904;

	/**
	 * ��ļ��б�
	 */
	public static final int GLDJC_LIST_ACTION = 905;

	/**
	 * �����ӿڵ�ַ
	 * 
	 * @return
	 */
	public static String getUriBase()
	{
		return HTTP_HEAD + SERVER_DOMAIN;
	}

	public static final String APP_URL = "http://app.gldjc.com";

	public static final String ACTIVITY_URL = "http://huodong.gldjc.com";

	private static String SUPPLIER_HEADER = "http://t.gldjc.com/supplier_site/";

	public static String getSupplierShareUrl(int supplierID)
	{
		return SUPPLIER_HEADER + supplierID;
	}

	public static String getMaterialShareUrl(int supplierID, int materialID)
	{
		return getSupplierShareUrl(supplierID) + "/products/" + materialID
		        + ".html";
	}
}
