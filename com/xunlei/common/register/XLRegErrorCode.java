package com.xunlei.common.register;

public final class XLRegErrorCode {
    public static final int PSW_FORMAT_ERR = 801;
    public static final int REG_ACCOUNT_EIXST = 704;
    public static final int REG_API_ERROR = 500;
    public static final int REG_EXIST = 201;
    public static final int REG_FORMAT_ERR_PARAM = 301;
    public static final int REG_FROM_BLACK = 402;
    public static final int REG_INVALID_CMD = 407;
    public static final int REG_INVALID_LOGIN = 404;
    public static final int REG_INVALID_PHONE = 700;
    public static final int REG_INVALID_SIGN = 408;
    public static final int REG_INVALID_VERIFY = 600;
    public static final int REG_INVALID_VERIFY_1 = 601;
    public static final int REG_IP_ABNORMAL = 403;
    public static final int REG_IP_CONTROL = 400;
    public static final int REG_JSON_ERROR = -2;
    public static final int REG_MAIL_EIXST = 702;
    public static final int REG_MODIFY_ERROR = 405;
    public static final int REG_MODIFY_TIMEOUT = 406;
    public static final int REG_NEED_VERIFY = 409;
    public static final int REG_NET_ERROR = -1;
    public static final int REG_NOT_ENOUGH_PARAM = 300;
    public static final int REG_PHONE_EIXST = 703;
    public static final int REG_SEND_SMS_FREQ = 401;
    public static final int REG_SIMPLE_PSW = 701;
    public static final int REG_SUCCEED = 200;

    public static String getErrorDesc(int i) {
        return i == 200 ? "成功" : i == 201 ? "已经注册过了，可以直接登录" : i == 300 ? "缺少参数" : i == 301 ? "参数格式有误" : i == 400 ? "ip 被访问控制机制屏蔽" : i == 401 ? "同个手机发短信过于频繁" : i == 402 ? "from 不在白名单内" : i == 403 ? "注册网关返回 506(ip异常)" : i == 404 ? "登录态验证不通过" : i == 405 ? "修改初始密码时查不到对应记录" : i == 406 ? "修改初始密码时超时" : i == 407 ? "命令不存在" : i == 408 ? "签名校验不通过" : i == 409 ? "需要拉取验证码" : i == 500 ? "接口崩溃" : i == 600 ? "验证码错误" : i == 601 ? "注册网关返回 507(验证码错误)" : i == 700 ? "登录手机不存在，但安全手机存在" : i == 701 ? "密码太过简单" : i == 702 ? "邮箱已被注册" : i == 703 ? "手机已被注册" : i == 704 ? "帐号已被注册" : i == 801 ? "密码格式错误" : i == -1 ? "当前网络不可用，请稍后注册" : i == -2 ? "json解析错误" : "未知错误";
    }
}
