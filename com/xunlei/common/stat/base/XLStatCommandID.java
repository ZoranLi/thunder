package com.xunlei.common.stat.base;

public final class XLStatCommandID {
    public static final int XLCID_360_LOGIN = 100005;
    public static final int XLCID_360_LOGIN_AUTH = 100501;
    public static final int XLCID_360_LOGIN_BIND = 100502;
    public static final int XLCID_ACC_LOGIN = 103000;
    public static final int XLCID_ACTIVE = 100009;
    public static final int XLCID_ALICT_CONTRACT = 301001;
    public static final int XLCID_ALICT_DISCONTRACT = 301003;
    public static final int XLCID_ALICT_QUERY = 301002;
    public static final int XLCID_ALIPAY_LOGIN = 100006;
    public static final int XLCID_ALIPAY_LOGIN_AUTH = 100601;
    public static final int XLCID_ALIPAY_LOGIN_BIND = 100602;
    public static final int XLCID_ALIPAY_LOGIN_ERROR = 100603;
    public static final int XLCID_CHANNEL_PING = 100500;
    public static final int XLCID_DEVICE_INFO_LOGIN = 106000;
    public static final int XLCID_FAST_LOGIN = 200007;
    public static final int XLCID_GET_VCODE = 200003;
    public static final int XLCID_H5_BINDPHONE = 100012;
    public static final int XLCID_KEY_LOGIN = 102000;
    public static final int XLCID_LOGIN = 100000;
    public static final int XLCID_LOGIN_PHONE_CODE = 200005;
    public static final int XLCID_LOGOUT = 100008;
    public static final int XLCID_MAIL_REG = 200001;
    public static final int XLCID_MOB_REG = 200000;
    public static final int XLCID_NAME_REG = 200002;
    public static final int XLCID_PAY_ALI = 300001;
    public static final int XLCID_PAY_BD = 300003;
    public static final int XLCID_PAY_NB = 300002;
    public static final int XLCID_PAY_PRICE = 300004;
    public static final int XLCID_PAY_WX = 300000;
    public static final int XLCID_PHONE_CODE_ACPTTVER = 200010;
    public static final int XLCID_PHONE_CODE_REQTACPT = 200009;
    public static final int XLCID_PHONE_CODE_REQTVER = 200011;
    public static final int XLCID_PHONE_CODE_TIME = 200008;
    public static final int XLCID_PHONE_CODE_VERTRELT = 200012;
    public static final int XLCID_PRE_VERIFY_CODE = 100010;
    public static final int XLCID_QQ_LOGIN = 100011;
    public static final int XLCID_QQ_LOGIN_AUTH = 100701;
    public static final int XLCID_QQ_LOGIN_BIND = 100702;
    public static final int XLCID_QQ_LOGIN_ERROR = 100703;
    public static final int XLCID_REG_PHONE_CODE = 200006;
    public static final int XLCID_RENREN_LOGIN = 100004;
    public static final int XLCID_RENREN_LOGIN_AUTH = 100401;
    public static final int XLCID_RENREN_LOGIN_BIND = 100402;
    public static final int XLCID_SESSION_LOGIN = 104000;
    public static final int XLCID_SINA_LOGIN = 100002;
    public static final int XLCID_SINA_LOGIN_AUTH = 100201;
    public static final int XLCID_SINA_LOGIN_BIND = 100202;
    public static final int XLCID_SINA_LOGIN_ERROR = 100203;
    public static final int XLCID_TOKEN_LOGIN = 105000;
    public static final int XLCID_UID_LOGIN = 101000;
    public static final int XLCID_USER_INFO = 100007;
    public static final int XLCID_VERIFY_CODE = 200004;
    public static final int XLCID_WXCT_CONTRACT = 302001;
    public static final int XLCID_WXCT_DISCONTRACT = 302003;
    public static final int XLCID_WXCT_QUERY = 302002;
    public static final int XLCID_WX_LOGIN = 100001;
    public static final int XLCID_WX_LOGIN_AUTH = 100101;
    public static final int XLCID_WX_LOGIN_BIND = 100102;
    public static final int XLCID_WX_LOGIN_ERROR = 100103;
    public static final int XLCID_XM_LOGIN = 100003;
    public static final int XLCID_XM_LOGIN_AUTH = 100301;
    public static final int XLCID_XM_LOGIN_BIND = 100302;
    public static final int XLCID_XM_LOGIN_ERROR = 100303;

    public static final String getReportCommand(int i) {
        if (XLCID_LOGIN == i) {
            return "login";
        }
        if (XLCID_UID_LOGIN == i) {
            return "login_uid";
        }
        if (XLCID_KEY_LOGIN == i) {
            return "loginkey";
        }
        if (XLCID_ACC_LOGIN == i) {
            return "login_account";
        }
        if (XLCID_SESSION_LOGIN == i) {
            return "sessionlogin";
        }
        if (XLCID_TOKEN_LOGIN == i) {
            return "login_token";
        }
        if (XLCID_DEVICE_INFO_LOGIN == i) {
            return "login_device";
        }
        if (XLCID_WX_LOGIN == i) {
            return "login_wx";
        }
        if (XLCID_WX_LOGIN_AUTH == i) {
            return "login_wx_auth";
        }
        if (XLCID_WX_LOGIN_BIND == i) {
            return "unionlogin";
        }
        if (XLCID_WX_LOGIN_ERROR == i) {
            return "login_wx_error";
        }
        if (XLCID_SINA_LOGIN == i) {
            return "login_sina";
        }
        if (XLCID_SINA_LOGIN_AUTH == i) {
            return "login_sina_auth";
        }
        if (XLCID_SINA_LOGIN_BIND == i) {
            return "unionlogin";
        }
        if (XLCID_SINA_LOGIN_ERROR == i) {
            return "login_sina_error";
        }
        if (XLCID_XM_LOGIN == i) {
            return "login_xm";
        }
        if (XLCID_XM_LOGIN_AUTH == i) {
            return "login_xm_auth";
        }
        if (XLCID_XM_LOGIN_BIND == i) {
            return "unionlogin";
        }
        if (XLCID_XM_LOGIN_ERROR == i) {
            return "login_xm_error";
        }
        if (XLCID_RENREN_LOGIN == i) {
            return "login_rr";
        }
        if (XLCID_RENREN_LOGIN_AUTH == i) {
            return "login_rr_auth";
        }
        if (XLCID_RENREN_LOGIN_BIND == i) {
            return "unionlogin";
        }
        if (XLCID_360_LOGIN == i) {
            return "login_360";
        }
        if (XLCID_360_LOGIN_AUTH == i) {
            return "login_360_auth";
        }
        if (XLCID_360_LOGIN_BIND == i) {
            return "unionlogin";
        }
        if (XLCID_ALIPAY_LOGIN == i) {
            return "login_ali";
        }
        if (XLCID_ALIPAY_LOGIN_AUTH == i) {
            return "login_ali_auth";
        }
        if (XLCID_ALIPAY_LOGIN_BIND == i) {
            return "unionlogin";
        }
        if (XLCID_ALIPAY_LOGIN_ERROR == i) {
            return "login_ali_error";
        }
        if (XLCID_QQ_LOGIN == i) {
            return "login_qq";
        }
        if (XLCID_CHANNEL_PING == i) {
            return "ping";
        }
        if (XLCID_QQ_LOGIN_AUTH == i) {
            return "login_qq_auth";
        }
        if (XLCID_QQ_LOGIN_BIND == i) {
            return "unionlogin";
        }
        if (XLCID_QQ_LOGIN_ERROR == i) {
            return "login_qq_error";
        }
        if (XLCID_USER_INFO == i) {
            return "getuserinfo";
        }
        if (XLCID_LOGOUT == i) {
            return "logout";
        }
        if (XLCID_ACTIVE == i) {
            return "active_user";
        }
        if (XLCID_PRE_VERIFY_CODE == i) {
            return "pre_verify_code";
        }
        if (XLCID_H5_BINDPHONE == i) {
            return "H5bindPhoneNum";
        }
        if (XLCID_MOB_REG == i) {
            return "reg_mobile";
        }
        if (XLCID_MAIL_REG == i) {
            return "reg_mail";
        }
        if (XLCID_NAME_REG == i) {
            return "reg_name";
        }
        if (XLCID_GET_VCODE == i) {
            return "get_verify_code";
        }
        if (XLCID_VERIFY_CODE == i) {
            return "verify_code";
        }
        if (XLCID_LOGIN_PHONE_CODE == i) {
            return "send_login_msg";
        }
        if (XLCID_REG_PHONE_CODE == i) {
            return "send_reg_msg";
        }
        if (XLCID_FAST_LOGIN == i) {
            return "fast_login";
        }
        if (XLCID_PHONE_CODE_TIME == i) {
            return "send_msg_time";
        }
        if (XLCID_PHONE_CODE_REQTACPT == i) {
            return "send_receive_msg_time";
        }
        if (XLCID_PHONE_CODE_ACPTTVER == i) {
            return "receive_verify_msg_time";
        }
        if (XLCID_PHONE_CODE_REQTVER == i) {
            return "request_verify_msg_time";
        }
        if (XLCID_PHONE_CODE_VERTRELT == i) {
            return "verify_msg_time";
        }
        if (300000 == i) {
            return "pay_wx";
        }
        if (XLCID_PAY_ALI == i) {
            return "pay_ali";
        }
        if (XLCID_PAY_NB == i) {
            return "pay_ali_nb";
        }
        if (XLCID_PAY_BD == i) {
            return "pay_bd";
        }
        if (XLCID_PAY_PRICE == i) {
            return "pay_get_price";
        }
        if (XLCID_ALICT_CONTRACT == i) {
            return "contract_ali";
        }
        if (XLCID_ALICT_QUERY == i) {
            return "contract_ali_query";
        }
        if (XLCID_ALICT_DISCONTRACT == i) {
            return "contract_ali_disc";
        }
        if (XLCID_WXCT_CONTRACT == i) {
            return "contract_wx";
        }
        if (XLCID_WXCT_QUERY == i) {
            return "contract_wx_query";
        }
        return XLCID_WXCT_DISCONTRACT == i ? "contract_wx_disc" : String.valueOf(i);
    }
}
