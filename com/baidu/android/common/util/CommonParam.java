package com.baidu.android.common.util;

import android.content.Context;

public class CommonParam {
    private static final boolean DEBUG = false;
    private static final String TAG = "CommonParam";

    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
