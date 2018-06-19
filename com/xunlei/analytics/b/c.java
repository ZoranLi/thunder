package com.xunlei.analytics.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.analytics.c.b;
import com.xunlei.analytics.c.d;
import com.xunlei.analytics.config.a;
import java.util.HashMap;
import java.util.Map.Entry;

public class c {
    private static final char[] a = new char[]{'\n', '\t'};

    public static b a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        d dVar = new d();
        dVar.a(d.a(context).a());
        dVar.b(b.c(context));
        dVar.c(b.b(context));
        dVar.d(VERSION.RELEASE);
        dVar.e("31");
        dVar.f(Build.MODEL);
        dVar.i(a.c());
        dVar.j(b.a());
        dVar.k(e.a());
        dVar.n(b.a(context));
        dVar.m(String.valueOf(b.d(context)));
        dVar.a(hashMap);
        return new b(a.a(), str, str2, System.currentTimeMillis(), dVar);
    }

    private static String a(d dVar, String str) {
        if (dVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pub_guid=");
        stringBuilder.append(a(dVar.a()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_mac=");
        stringBuilder.append(a(dVar.b()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_imei=");
        stringBuilder.append(a(dVar.c()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_os=");
        stringBuilder.append(a(dVar.d()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_sdkversion=");
        stringBuilder.append(a(dVar.e()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_phonetype=");
        stringBuilder.append(a(dVar.f()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_longitude=");
        stringBuilder.append(a(dVar.g()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_dimension=");
        stringBuilder.append(a(dVar.h()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_channelid=");
        stringBuilder.append(a(dVar.i()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_ip=");
        stringBuilder.append(a(dVar.j()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_session_id=");
        stringBuilder.append(a(dVar.k()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (str != "2") {
            stringBuilder.append("pub_pageid=");
            stringBuilder.append(a(dVar.l()));
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        stringBuilder.append("pub_network=");
        stringBuilder.append(a(dVar.m()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append("pub_sv=");
        stringBuilder.append(a(dVar.n()));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (dVar.o() != null) {
            for (Entry entry : dVar.o().entrySet()) {
                String str2 = (String) entry.getKey();
                str = (String) entry.getValue();
                stringBuilder.append(str2);
                stringBuilder.append("=");
                stringBuilder.append(a(str));
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        if (a.h() != null) {
            for (Entry entry2 : a.h().entrySet()) {
                str2 = (String) entry2.getKey();
                str = (String) entry2.getValue();
                stringBuilder.append(str2);
                stringBuilder.append("=");
                stringBuilder.append(a(str));
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private static String a(String str) {
        str = b.a(str);
        return str == null ? "" : str;
    }

    private static String a(String str, char c) {
        return (str == null || str.indexOf(c) == -1) ? str : str.replace(String.valueOf(c), String.valueOf(c));
    }

    private static String a(String str, char[] cArr) {
        if (cArr != null) {
            for (char a : cArr) {
                str = a(str, a);
            }
        }
        return str;
    }

    public static String b(Context context, String str, String str2, HashMap<String, String> hashMap) {
        b a = a(context, str, str2, hashMap);
        str = a(a.e(), str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(a.a(), a));
        stringBuilder.append("\t");
        stringBuilder.append(a(a.b(), a));
        stringBuilder.append("\t");
        stringBuilder.append(a(a.c(), a));
        stringBuilder.append("\t");
        stringBuilder.append(a.d());
        stringBuilder.append("\t");
        stringBuilder.append(a(str, a));
        return stringBuilder.toString();
    }
}
