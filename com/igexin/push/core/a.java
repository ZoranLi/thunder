package com.igexin.push.core;

import android.os.Environment;

public class a {
    public static final String a;
    public static final String b;
    public static int c = 0;
    public static int d = 2;
    public static int e = 3;
    public static int f = 4;
    public static int g = 5;
    public static int h = 6;
    public static int i = 7;
    public static int j = 8;
    public static int k = 0;
    public static int l = 1;
    public static int m = 2;
    public static String n = "com.igexin.sdk.PushService";
    public static String o = "com.igexin.sdk.coordinator.SdkMsgService";
    public static String p = "com.igexin.sdk.coordinator.GexinMsgService";
    public static String q = "com.igexin.sdk.GTPushService";

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory());
        stringBuilder.append("/Sdk/ImgCache/");
        a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory());
        stringBuilder.append("/Sdk/WebCache/");
        b = stringBuilder.toString();
    }
}
