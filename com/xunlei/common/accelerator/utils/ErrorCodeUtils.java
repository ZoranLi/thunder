package com.xunlei.common.accelerator.utils;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

public final class ErrorCodeUtils {
    public static final int XLA_ACCOUNT_CHECK_SESSION_402 = 717;
    public static final int XLA_ACCOUNT_CHECK_SESSION_403 = 718;
    public static final int XLA_ACCOUNT_CHECK_SESSION_FAILED = 715;
    public static final int XLA_ACCOUNT_SDK_ERROR = 9;
    public static final int XLA_ACCOUNT_TIMEOUT = 714;
    public static final int XLA_ALLOC_ERROR = 501;
    public static final int XLA_ALREADY_SPEEDUP = 719;
    public static final int XLA_ALREADY_SPEEDUP_IN_ANOTHER_NETWORK = 720;
    public static final int XLA_ALREADY_UPGRADED = 812;
    public static final int XLA_AUTOTRY_OUT_OF_FREQUENCY = 721;
    public static final int XLA_DEVICE_KICKED = 708;
    public static final int XLA_ENCODE_ERR = 4;
    public static final int XLA_FSM_NOT_ENOUGH = 710;
    public static final int XLA_HTTP_ERR = 2;
    public static final int XLA_INTERNAL_ERROR = 500;
    public static final int XLA_IP_UNLEGAL_ERROR = 520;
    public static final int XLA_IS_QUERYING_PORTAL = 8;
    public static final int XLA_JSON_ERR = 5;
    public static final int XLA_KEEP_ALIVE_ERR = 6;
    public static final int XLA_KUAINIAO_VIP = 13;
    public static final int XLA_MOBILE_NETWORK = 11;
    public static final int XLA_NET_ERR = 3;
    public static final int XLA_NORMAL_USER_BUSY_TIME = 709;
    public static final int XLA_NOT_EXIST_CHANNEL = 513;
    public static final int XLA_NO_NETWORK = 10;
    public static final int XLA_OPERATE_DIAL_ACCT_NULL = 514;
    public static final int XLA_PARAMETER_ERROR = 502;
    public static final int XLA_PAY_SUCCESS = -1000;
    public static final int XLA_REDIS_ERROR = 504;
    public static final int XLA_REPEATED_PACKAGE = 711;
    public static final int XLA_RESP_TRY_CONTACT_ERROR = 705;
    public static final int XLA_RESP_TRY_FINISHED = 704;
    public static final int XLA_SEND_TO_PROXY_FAILED = 707;
    public static final int XLA_SERVER_CONFIGURE_ERROR = 521;
    public static final int XLA_STATUS_LOADING = 2222;
    public static final int XLA_SUCCESS = 0;
    public static final int XLA_SUPER_VIP = 12;
    public static final int XLA_TEL_PROXY_TIMEOUT = 712;
    public static final int XLA_TIMEOUT_ERROR = 503;
    public static final int XLA_TRY_COUNT_NOT_ENOUGH_ERROR = 508;
    public static final int XLA_TRY_SERVER_TIMEOUT = 716;
    public static final int XLA_TRY_TIME_OUT_ERR = 7;
    public static final int XLA_UID_UNLEGAL_ERROR = 518;
    public static final int XLA_UNINNIT_ERROR = 1;
    public static final int XLA_UNKNOWN_ERROR = -1;
    public static final int XLA_UNKOWN = 722;
    public static final int XLA_VIPSERVER_ERROR = 505;
    public static final int XLA_VIP_TIMEOUT = 713;

    public static String getErrorDesc(int i) {
        String str = "未知错误";
        switch (i) {
            case 0:
                return "成功";
            case 1:
                return "未初始化错误";
            case 2:
                return "Http错误";
            case 3:
                return "网络错误";
            case 4:
                return "ENCODE错误";
            case 5:
                return "JSON错误";
            case 6:
                return "心跳错误";
            case 7:
                return "试用超时错误";
            case 8:
                return "正在查询portal";
            case 9:
                return "帐号sdk错误";
            case 10:
                return "当前无网络，请检查网络连接";
            case 11:
                return "当前为移动网络，请在wifi环境下使用";
            case 12:
                return "您已经是超级会员，无需使用体验卡";
            case 13:
                return "您已经是快鸟会员，无需使用体验卡";
            default:
                switch (i) {
                    case 502:
                        return "参数错误";
                    case 503:
                        return "服务器请求出错";
                    default:
                        switch (i) {
                            case 513:
                                return "通道不存在时间到或者电信代理服务器返回错误状态内存记录已被清除";
                            case XLA_OPERATE_DIAL_ACCT_NULL /*514*/:
                                return "电信返回宽带账号为空";
                            default:
                                switch (i) {
                                    case XLA_IP_UNLEGAL_ERROR /*520*/:
                                        return "ip不在加速范围";
                                    case XLA_SERVER_CONFIGURE_ERROR /*521*/:
                                        return "查找接口服务器配置失败";
                                    default:
                                        switch (i) {
                                            case 704:
                                                return "当次试用时间结束";
                                            case 705:
                                                return "与试用服务器交互出错";
                                            default:
                                                switch (i) {
                                                    case XLA_SEND_TO_PROXY_FAILED /*707*/:
                                                        return "发送请求到代理服务器";
                                                    case XLA_DEVICE_KICKED /*708*/:
                                                        return "设备被踢";
                                                    case XLA_NORMAL_USER_BUSY_TIME /*709*/:
                                                        return "闲时变成忙时";
                                                    case XLA_FSM_NOT_ENOUGH /*710*/:
                                                        return "内部状态机耗光";
                                                    case XLA_REPEATED_PACKAGE /*711*/:
                                                        return "客户端请求太频繁,设备有未处理完请求";
                                                    case XLA_TEL_PROXY_TIMEOUT /*712*/:
                                                        return "电信代理服务器超时";
                                                    case XLA_VIP_TIMEOUT /*713*/:
                                                        return "vip服务器超时";
                                                    case XLA_ACCOUNT_TIMEOUT /*714*/:
                                                        return "账号服务器超时";
                                                    case XLA_ACCOUNT_CHECK_SESSION_FAILED /*715*/:
                                                        return "session验证失败";
                                                    case XLA_TRY_SERVER_TIMEOUT /*716*/:
                                                        return "试用服务器超时";
                                                    case XLA_ACCOUNT_CHECK_SESSION_402 /*717*/:
                                                        return "sessionid 被踢客户端需提示用户被踢";
                                                    case XLA_ACCOUNT_CHECK_SESSION_403 /*718*/:
                                                        return "sessionid 超时客户端需自动重新登录";
                                                    case XLA_ALREADY_SPEEDUP /*719*/:
                                                        return "已提速";
                                                    case XLA_ALREADY_SPEEDUP_IN_ANOTHER_NETWORK /*720*/:
                                                        return "已在其它宽带网络提速";
                                                    case XLA_AUTOTRY_OUT_OF_FREQUENCY /*721*/:
                                                        return "自动试用超出每天的试用频次";
                                                    default:
                                                        switch (i) {
                                                            case -1000:
                                                                return "支付成功";
                                                            case 500:
                                                                return "内部服务器队列已满";
                                                            case 508:
                                                                return "试用次数已用完";
                                                            case XLA_UID_UNLEGAL_ERROR /*518*/:
                                                                return "非合法会员";
                                                            case XLA_ALREADY_UPGRADED /*812*/:
                                                                return "当前网络已被提速";
                                                            case XLA_STATUS_LOADING /*2222*/:
                                                                return "正在请求服务器,请稍候...";
                                                            default:
                                                                return str;
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static String parseLink(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return getErrorDesc(i);
        }
        if (str.contains("@@") == 0) {
            return str;
        }
        i = str.split("@@");
        if (i[0].contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            return i[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0];
        }
        return i[0];
    }

    public static String getChangeClientType(String str) {
        if (str.startsWith("pc-xlnetacc")) {
            return "PC客户端";
        }
        if (str.startsWith("android-swjsq")) {
            return "android快鸟客户端";
        }
        if (str.startsWith("ios")) {
            return "ios快鸟客户端";
        }
        if (str.startsWith("android-shouleiknplugin")) {
            return "android手雷客户端";
        }
        if (str.startsWith("pc-xlknplugin")) {
            return "迅雷7快鸟插件";
        }
        if (str.startsWith("pc-xlkngsplugin")) {
            return "迅雷7光速插件";
        }
        if (str.startsWith("pc-xl9knplugin")) {
            return "迅雷9快鸟插件";
        }
        if (str.startsWith("router-xiaomi_xlknplugin")) {
            return "小米路由插件";
        }
        if (str.startsWith("router-dlsuite_xlknplugin")) {
            return "下载宝插件";
        }
        if (str.startsWith("router-dcdn_xlknplugin")) {
            return "赚钱宝插件";
        }
        return str.startsWith("TV-xiaomi_xlknplugin") != null ? "TV客户端" : "在其他端";
    }
}
