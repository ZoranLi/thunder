package com.ali.auth.third.core.config;

import java.util.HashMap;
import java.util.Map;

public final class a {
    public static boolean a = false;
    public static final b b = new b();
    public static String c = null;
    public static String e = "http://login.taobao.com/minisdk/login.htm";
    public static String f = "http://login.m.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s";
    public static String g = "https://accountlink.taobao.com/sdkUnbind.htm";
    public static String h = "((https|http)://)login.m.taobao.com/login.htm(.*),((https|http)://)login.tmall.com(.*),((https|http)://)login.taobao.com/member/login.jhtml(.*)";
    public static int i = 0;
    public static String j = "";
    public static final Map<String, String> k = new HashMap();
    private static final a l = new a();
    public Environment d;

    static {
        StringBuilder stringBuilder = new StringBuilder("android_");
        stringBuilder.append(b.toString());
        c = stringBuilder.toString();
    }

    private a() {
    }

    public static a a() {
        return l;
    }

    public static int b() {
        return i;
    }
}
