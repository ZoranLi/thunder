package com.alibaba.baichuan.android.trade;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.adapter.d.a;
import com.alibaba.baichuan.android.trade.utils.i;
import com.ut.device.UTDevice;
import java.util.Arrays;
import java.util.List;

public final class AlibcContext {
    public static volatile Context a = null;
    public static final i b = i.a();
    public static List c = Arrays.asList(new String[]{"isv_code", "scm", "pvid"});
    public static String d = "3.1.1.9";
    public static boolean e = false;
    public static boolean f = false;
    public static volatile Environment g = Environment.ONLINE;
    public static volatile String h = null;
    public static boolean i = false;
    public static volatile boolean j = true;
    public static String[] k = new String[]{"^http(s)?://h5\\.(.*)\\.taobao.com/cm/snap/index\\.html(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/core/detail\\.htm(.*)", "^http(s)?://detail\\.(.*)\\.tmall\\.(com|hk)/item\\.htm(.*)"};
    public static String[] l = new String[]{"^http(s)?://h5\\.(.*)\\.taobao.com/cm/snap/index\\.html(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/core/detail\\.htm(.*)", "^http(s)?://detail\\.(.*)\\.tmall\\.(com|hk)/item\\.htm(.*)", "^http(s)?://shop\\.m\\.taobao\\.com/shop/shop_index\\.htm(.*)", "^http(s)?://s\\.taobao\\.com/(.*)", "^http(s)?://s\\.click\\.taobao\\.com/(.*)"};
    public static String m = "^http(s)?://s\\.click\\.taobao\\.com/(.*)";
    public static String n = null;
    public static String o = null;
    public static String p = null;
    public static String q = null;
    public static String r = null;
    public static String[] s = new String[]{"maliprod.alipay.com/w/trade_pay.do", "maliprod.alipay.com/batch_payment.do", "mclient.alipay.com/w/trade_pay.do", "mclient.alipay.com/batch_payment.do"};
    public static String t = "https://h5.m.taobao.com/";
    private static String u;
    private static String v;

    public enum Environment {
        TEST,
        ONLINE,
        PRE,
        SANDBOX
    }

    public static String a() {
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        String utdid = UTDevice.getUtdid(a);
        v = utdid;
        return utdid;
    }

    public static boolean b() {
        return e;
    }

    public static String c() {
        if (u == null) {
            u = a.a().a;
        }
        return u;
    }
}
