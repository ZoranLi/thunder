package com.alibaba.sdk.android.feedback.util;

import android.os.Environment;

public interface j {
    public static final String a;
    public static final String b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append("/alibaba/WXOPENIM/相册");
        a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append("/alibaba/WXOPENIM/file");
        b = stringBuilder.toString();
    }
}
