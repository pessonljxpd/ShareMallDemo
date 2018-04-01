package com.sharemall.sharemall.utils;

/**
 * 接口地址工具类
 *
 * @author Shelly
 */
public class UriUtil {

    private static final String HTTP_HEAD = "http://";

    // private static final String SERVER_DOMAIN ="192.168.75.88:8080/Supplier";

    // private static final String SERVER_DOMAIN ="192.168.132.224:8080/supplier/Supplier";

    private static final String SERVER_DOMAIN = "app.gldjc.com/gcsupplier/Supplier";

    /**
     * 搜索条数
     */
    public static final int SEARCH_ACTION = 101;
    /**
     * 搜索材料列表
     */
    public static final int SEARCH_MATERIAL_ACTION = 102;
    /**
     * 搜索供应商列表
     */
    public static final int SEARCH_SUPPLIER_ACTION = 103;
    /**
     * 材料详情
     */
    public static final int MATERIAL_DETAIL_ACTION = 104;
    /**
     * 供应商详情
     */
    public static final int SUPPLIER_DETAIL_ACTION = 105;
    /**
     * 材料类别
     */
    public static final int MATERIAL_TYPE_ACTION = 106;
    /**
     * 供应商材料
     */
    public static final int SUPPLIER_MATERIAL_ACTION = 107;
    /**
     * 附近的供应商
     */
    public static final int NEAR_SUPPLIER_ACTION = 108;

    /**
     * 材料品牌
     */
    public static final int MATERIAL_BRAND_ACTION = 109;

    /**
     * 供应商删除材料
     */
    public static final int SUPPLIER_DELETE_MATERIAL = 110;

    /**
     * 图片询价
     */
    public static final int PIC_ENQUIRY_ACTION = 201;
    /**
     * 文字询价
     */
    public static final int FORM_ENQUIRY_ACTION = 202;
    /**
     * 询价条数
     */
    public static final int ENQUIRY_NUM_ACTION = 203;

    /**
     * 登录
     */
    public static final int LOGIN_ACTION = 301;
    /**
     * 注册
     */
    public static final int REGISTER_ACTION = 302;
    /**
     * 修改用户信息
     */
    public static final int UPDATE_INFO_ACTION = 303;
    /**
     * 修改密码
     */
    public static final int MODIFY_PWD_ACTION = 304;
    /**
     * 我的询价单列表
     */
    public static final int ENQUIRY_LIST_ACTION = 305;
    /**
     * 我的询价单详情
     */
    public static final int ENQUIRY_DETAIL_ACTION = 306;
    /**
     * 积分列表
     */
    public static final int INTEGRAL_LIST_ACTION = 307;
    /**
     * 用户反馈
     */
    public static final int FEEDBACK_ACTION = 308;
    /**
     * 原始询价单
     */
    public static final int ORIGINAL_ENQUIRY_ACTION = 309;
    /**
     * 询价联系人
     */
    public static final int ENQUIRY_PROJECT_INFO = 310;
    /**
     * 退出登录
     */
    public static final int EXIT_LOGIN = 311;
    /**
     * 版本升级
     */
    public static final int APP_UPDATE_ACTION = 312;
    /**
     * 我的资讯列表
     */
    public static final int NEWS_LIST_ACTION = 313;
    /**
     * 推送关联
     */
    public static final int RELEVANCE_PUSH_ACTION = 314;

    /**
     * 系统公告
     */
    public static final int NOTICE_ACTION = 315;

    /**
     * 上传用户头像
     */
    public static final int UPLOAD_USER_ICON_ACTION = 316;

    /**
     * 修改用户信息(性别、所在地、心情、姓名)
     */
    public static final int UPLOAD_USER_INFO_ACTION = 317;

    /**
     * 修改用户昵称
     */
    public static final int UPLOAD_USER_ALIAS_ACTION = 318;

    /**
     * 修改用户手机
     */
    public static final int UPLOAD_USER_TELE_ACTION = 319;

    /**
     * 获取验证码
     */
    public static final int GET_AUTH_CODE_ACTION = 320;

    /**
     * 获取用户绑定手机验证码
     */
    public static final int GET_USER_BIND_AUTH_CODE_ACTION = 321;

    /**
     * 账户绑定
     */
    public static final int USER_BIND_ACTION = 322;

    /**
     * 账户解绑
     */
    public static final int USER_UNBIND_ACTION = 323;

    /**
     * 系统消息列表
     */
    public static final int MSG_SYSTEM_LIST_ACTION = 324;

    /**
     * 读取系统消息状态
     */
    public static final int MSG_READ_SYSTEM_ACTION = 325;

    /**
     * 登录页面 获取验证码
     */
    public static final int ACCOUNT_CALL_PHONE_CODE_ACTION = 326;

    /**
     * 登录页面 验证验证码
     */
    public static final int ACCOUNT_CALL_PHONE_RESET_CODE_ACTION = 327;

    /**
     * 登录页面 重置密码
     */
    public static final int ACCOUNT_CALL_PHONE_RESET_PASSWORD_CODE_ACTION = 328;

    /**
     * 信息价省市
     */
    public static final int PRICE_PROVINCE_ACTION = 401;
    /**
     * 信息价城市
     */
    public static final int PRICE_CITY_ACTION = 402;
    /**
     * 信息价地区
     */
    public static final int PRICE_AREA_ACTION = 403;
    /**
     * 信息价年限
     */
    public static final int PRICE_YEAR_ACTION = 404;
    /**
     * 信息价期数
     */
    public static final int PRICE_PERIOD_ACTION = 405;
    /**
     * 信息价列表
     */
    public static final int PRICE_SCAN_ACTION = 406;

    /**
     * 供应商更新价格
     */
    public static final int SUPPLIER_UPDATE_PRICE = 408;

    /**
     * 供应商删除价格
     */
    public static final int SUPPLIER_DELETE_PRICE = 409;

    /**
     * 供应商价格列表
     */
    public static final int SUPPLIER_PRICE_LIST = 410;

    /**
     * 工程信息列表
     */
    public static final int INFO_PROJECT_ACTION = 411;

    /**
     * 采购列表
     */
    public static final int INFO_PURCHASE_DIDDING_ACTION = 412;

    /**
     * 附近的商机
     */
    public static final int NEAR_INFO_ACTION = 413;

    /**
     * 发送对话
     */
    public static final int CHAT_SEND_ACTION = 511;

    /**
     * 私人对话列表
     */
    public static final int CHAT_LIST_ACTION = 512;

    /**
     * 对话详情列表
     */
    public static final int CHAT_DETAIL_LIST_ACTION = 513;

    /**
     * 收藏供应商
     */
    public static final int COLLECT_SUPPLIER_ACTION = 601;
    /**
     * 收藏产品
     */
    public static final int COLLECT_MATERIAL_ACTION = 602;
    /**
     * 收藏供应商列表
     */
    public static final int COLLECT_SUPPLIER_LIST_ACTION = 603;
    /**
     * 收藏产品列表
     */
    public static final int COLLECT_MATERIAL_LIST_ACTION = 604;
    /**
     * 删除收藏供应商
     */
    public static final int DELETE_COLLECT_SUPPLIER_ACTION = 605;
    /**
     * 删除收藏材料
     */
    public static final int DELETE_COLLECT_MATERIAL_ACTION = 606;

    /**
     * 获取邀请码
     */
    public static final int GET_INVITATION_CODE_ACTION = 701;

    /**
     * 是否被邀请
     */
    public static final int IS_INVITATED_ACTION = 702;

    /**
     * 提交邀请码
     */
    public static final int SUBMIT_INVITATION_CODE_ACTION = 703;

    /**
     * 用户抽奖
     */
    public static final int USER_DRAW_ACTION = 704;

    /**
     * 用户抽奖列表
     */
    public static final int USER_DRAW_LIST_ACTION = 705;

    /**
     * 绿色通道
     */
    public static final int BANNER_ACTION = 706;

    /**
     * 获取晒照片用户信息
     */
    public static final int GET_IMAGE_USER_INFO = 707;

    /**
     * 晒照片
     */
    public static final int UPLOAD_IMAGE = 708;

    /**
     * 获取照片列表
     */
    public static final int GET_IMAGE_LIST = 709;

    /**
     * 喜欢照片
     */
    public static final int LOVE_IMAGE = 710;

    /**
     * 活动奖品
     */
    public static final int IMAGE_DRAW_ACTION = 711;

    /**
     * 所有活动奖品
     */
    public static final int IMAGE_ALL_DRAW_ACTION = 712;

    /**
     * 发布动态
     */
    public static final int PUBLISH_DYNAMIC_ACTION = 801;

    /**
     * 评论动态
     */
    public static final int COMMENT_DYNAMIC_ACTION = 802;

    /**
     * 赞动态
     */
    public static final int GOOD_DYNAMIC_ACTION = 803;

    /**
     * 动态列表
     */
    public static final int DYNAMIC_LIST_ACTION = 804;

    /**
     * 动态评论列表
     */
    public static final int DYNAMIC_COMMENT_LIST_ACTION = 805;

    /**
     * 获取我的动态列表
     */
    public static final int MY_DYNAMIC_LIST_ACTION = 806;

    /**
     * 转发动态
     */
    public static final int TRANSPOND_DYNAMIC_ACTION = 807;

    /**
     * 转发我的动态列表
     */
    public static final int TRANSPOND_ME_LIST_ACTION = 808;

    /**
     * 评论我的动态列表
     */
    public static final int COMMENT_ME_LIST_ACTION = 809;

    /**
     * 赞我的动态列表
     */
    public static final int GOOD_ME_LIST_ACTION = 810;

    /**
     * 我的评论列表
     */
    public static final int MY_COMMENT_LIST_ACTION = 811;

    /**
     * 我的赞列表
     */
    public static final int MY_GOOD_LIST_ACTION = 812;

    /**
     * 回复评论
     */
    public static final int REPLY_COMMENT_ACTION = 813;

    /**
     * 删除评论
     */
    public static final int DELETE_COMMENT_ACTION = 814;

    /**
     * 删除动态
     */
    public static final int DELETE_DYNAMIC_ACTION = 815;

    /**
     * 获取用户信息
     */
    public static final int GET_USER_INFO_ACTION = 820;

    /**
     * 分享到广材圈
     */
    public static final int SHARE_TO_GLDJC_CIRCLE_ACTION = 821;

    /**
     * 按钮点击
     */
    public static final int CLICK_TYPE_ACTION = 901;

    /**
     * 广材价地区
     */
    public static final int GLDJC_AREA_ACTION = 902;

    /**
     * 广材价年份
     */
    public static final int GLDJC_YEARS_ACTION = 903;

    /**
     * 广材价期数
     */
    public static final int GLDJC_PERIOD_ACTION = 904;

    /**
     * 广材价列表
     */
    public static final int GLDJC_LIST_ACTION = 905;

    /**
     * 基础接口地址
     *
     * @return
     */
    public static String getUriBase() {
        return HTTP_HEAD + SERVER_DOMAIN;
    }

    public static final String APP_URL = "http://app.gldjc.com";

    public static final String ACTIVITY_URL = "http://huodong.gldjc.com";

    private static String SUPPLIER_HEADER = "http://t.gldjc.com/supplier_site/";

    public static String getSupplierShareUrl(int supplierID) {
        return SUPPLIER_HEADER + supplierID;
    }

    public static String getMaterialShareUrl(int supplierID, int materialID) {
        return getSupplierShareUrl(supplierID) + "/products/" + materialID + ".html";
    }
}
