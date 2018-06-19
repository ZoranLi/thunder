package com.alibaba.sdk.android.feedback.util;

public interface IWxCallback {
    public static final int ERROR = 0;
    public static final int ERROR_INVALID_CMDID = 3;
    public static final int ERROR_INVALID_LOGINSTATE = 2;
    public static final int ERROR_INVALID_PARAMS = 6;
    public static final int ERROR_NETWORK_ERROR = 8;
    public static final int ERROR_NETWORK_NULL = 1;
    public static final int ERROR_NO_EXIST_SDCARD = 15;
    public static final int ERROR_OOM = 12;
    public static final int ERROR_PARAM_ERR = 11;
    public static final int ERROR_POOL_FULL = 13;
    public static final int ERROR_REQ_NOT_ALLOWED = 4;
    public static final int ERROR_SERVER_ERR = 255;
    public static final int ERROR_TIME_OUT = 9;
    public static final int ERROR_TOKEN_SAME = 10;
    public static final int ERROR_TOKEN_UNAVAIL = 7;
    public static final int ERROR_UNPACK_ERR = 254;
    public static final int ERROR_VALID_FAIL = 5;

    void onError(int i, String str);

    void onProgress(int i);

    void onSuccess(Object... objArr);
}
