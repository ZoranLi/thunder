package com.alibaba.baichuan.android.auth;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.AlibcContext.Environment;
import com.umeng.message.proguard.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

public final class d {
    public static final d a = new d("1", AgooConstants.REPORT_NOT_ENCRYPT, "添加商品到您的淘宝购物车");
    private static Map c;
    private static Map d;
    private static Map e;
    public String b;
    private String f;
    private String g;

    private d() {
    }

    public static String a(String str) {
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(str)) {
            stringBuilder = new StringBuilder("访问您淘宝账号信息的权限(");
        } else {
            Object obj = c.get(str) == null ? "" : ((d) c.get(str)).b;
            if (TextUtils.isEmpty(obj)) {
                obj = d == null ? "" : (String) d.get(str);
            }
            if (!TextUtils.isEmpty(obj)) {
                return obj;
            }
            stringBuilder = new StringBuilder("访问您淘宝账号信息的权限(");
        }
        stringBuilder.append(str);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    public static synchronized void a(String str, String str2) {
        synchronized (d.class) {
            if (d == null) {
                d = new HashMap();
            }
            d.put(str, str2);
        }
    }

    public static synchronized void a(String str, Set set) {
        synchronized (d.class) {
            if (e == null) {
                e = new HashMap();
            }
            e.put(str, set);
        }
    }

    public static synchronized Set b(String str) {
        synchronized (d.class) {
            if (d == null) {
                return null;
            }
            Set set = (Set) e.get(str);
            return set;
        }
    }

    private d(String str, String str2, String str3) {
        this.f = str;
        this.b = str3;
        this.g = str2;
        synchronized (this) {
            if (c == null) {
                c = new ConcurrentHashMap();
            }
        }
        c.put(AlibcContext.g == Environment.TEST ? this.g : this.f, this);
    }
}
