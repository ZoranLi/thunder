package com.xunlei.common.accelerator.http;

import com.xunlei.common.accelerator.config.Config;

public class XLAccelHttpReqInfo {
    public static final String GET_ACCELINFO_INTERFACE = "/v2/bandwidth";
    public static final String GET_TRY_ACCELINFO_INTERFACE = "/v2/query_try_info";
    public static int HTTP_CLIENT_SOCKET_TIMEOUT = 10000;
    public static final String KEEP_ALIVE = "/v2/keepalive";
    public static final String START_ACCEL = "/v2/upgrade";
    public static final String STOP_ACCEL = "/v2/recover";
    public static final String URL_CHECK_ALL_CARDS = "http://api.expcard.swjsq.vip.xunlei.com:10486/v2/getuserallexpcardinfo";
    public static final String URL_CHECK_ALL_CARDS_DEBUG = "http://111.161.24.247:8090/v2/getuserallexpcardinfo";
    public static final String URL_PATH_CHECK_CARD = "/v2/getusingexpcardinfo";
    private static final int XLA_KEEP_ALIVE_TIME_DEBUG = 60000;
    private static final int XLA_KEEP_ALIVE_TIME_RELEASE = 1800000;
    private static final String XLA_PORTAL_DEBUG = "http://api.portal.swjsq.vip.xunlei.com:81/v2/queryportal";
    private static final String XLA_PORTAL_RELEASE = "http://api.portal.swjsq.vip.xunlei.com:81/v2/queryportal";
    private static final String XLA_PORTAL_RELEASE_SECOND = "http://api2.portal.swjsq.vip.xunlei.com:81/v2/queryportal";
    private static final long XLA_RECOVER_QUERY_COUNT_TIME_DEBUG = 120000;
    private static final long XLA_RECOVER_QUERY_COUNT_TIME_RELEASE = 900000;
    private static final int XLA_TRY_INIT_STATUS_TIME_DEBUG = 120000;
    private static final int XLA_TRY_INIT_STATUS_TIME_RELEASE = 1800000;
    private static final int XLA_USER_TRY_TIME_DEBUG = 1;
    private static final int XLA_USER_TRY_TIME_RELEASE = 10;
    private static boolean debug = Config.sIsDebuggable;
    private static String sGetAllCardsHost;
    private static String sPortalHost;

    static {
        if (debug) {
            sPortalHost = "http://api.portal.swjsq.vip.xunlei.com:81/v2/queryportal";
            sGetAllCardsHost = URL_CHECK_ALL_CARDS_DEBUG;
            return;
        }
        sPortalHost = "http://api.portal.swjsq.vip.xunlei.com:81/v2/queryportal";
        sGetAllCardsHost = URL_CHECK_ALL_CARDS;
    }

    public static int getXLKeepAliveTime() {
        if (debug) {
            return XLA_KEEP_ALIVE_TIME_DEBUG;
        }
        return Config.isShoulei() ? 3600000 : 1800000;
    }

    public static int getUserTryTime() {
        return debug ? 1 : 10;
    }

    public static String getPortalAdressSecond() {
        return debug ? XLA_PORTAL_RELEASE_SECOND : XLA_PORTAL_RELEASE_SECOND;
    }

    public static long getRecoverQueryCountTime() {
        return debug ? XLA_RECOVER_QUERY_COUNT_TIME_DEBUG : XLA_RECOVER_QUERY_COUNT_TIME_RELEASE;
    }

    public static int getInitTryStatusTime() {
        return debug ? XLA_TRY_INIT_STATUS_TIME_DEBUG : 1800000;
    }

    public static String getPortalAdress() {
        return sPortalHost;
    }

    public static void setPortalAddress(String str) {
        sPortalHost = str;
    }

    public static String getAllCardAddr() {
        return sGetAllCardsHost;
    }

    public static void setQueryCardsAddress(String str) {
        sGetAllCardsHost = str;
    }
}
