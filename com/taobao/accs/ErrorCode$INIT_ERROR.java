package com.taobao.accs;

/* compiled from: Taobao */
public enum ErrorCode$INIT_ERROR {
    NO_NETWORK,
    APPKEY_NULL,
    APPSECRET_NULL,
    APPRECEIVER_NULL,
    REQ_TIME_OUT,
    CONN_INVALID,
    NO_CONNECTTION,
    UNKNOWN_ERROR,
    SERVER_TAIR_ERROR,
    SERVER_DEVICEID_INVALID,
    SERVER_APPKEY_INVALID,
    SERVER_PACKAGENAME_INVALID,
    SUCCESS;

    public final int getErrorCode() {
        return ordinal() + 1000;
    }
}
