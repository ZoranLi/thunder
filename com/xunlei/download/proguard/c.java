package com.xunlei.download.proguard;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.umeng.message.proguard.k;

/* compiled from: Constants */
public class c {
    public static final int A = 30;
    public static final int B = 86400;
    public static final int C = 5;
    public static final int D = 30;
    static final boolean E = false;
    public static final boolean F = true;
    public static final boolean G = false;
    public static final String H = "com.android.providers.downloads.documents";
    public static final String I = "downloads";
    private static final boolean J = false;
    private static final boolean K = false;
    public static final String a = "DownloadManager";
    public static final String b = "method";
    public static final String c = "otaupdate";
    public static final String d = "no_system";
    public static final String e = "etag";
    public static final String f = "uid";
    public static final String g = "scanned";
    public static final String h = "android.intent.action.DOWNLOAD_WAKEUP";
    public static final String i = "android.intent.action.DOWNLOAD_OPEN";
    public static final String j = "android.intent.action.DOWNLOAD_LIST";
    public static final String k = "android.intent.action.DOWNLOAD_HIDE";
    public static final String l = "downloadfile";
    public static final String m = ".html";
    public static final String n = ".txt";
    public static final String o = ".bin";
    public static final String p = "com.android.providers.downloads";
    public static final String q = "-";
    public static final String r;
    public static final String s = "recovery";
    public static final String t;
    public static final String u = "application/vnd.android.package";
    public static final int v = 4096;
    public static final int w = 4096;
    public static final long x = 1500;
    public static final int y = 1000;
    public static final int z = 5;

    static {
        StringBuilder stringBuilder = new StringBuilder("/");
        stringBuilder.append(Environment.DIRECTORY_DOWNLOADS);
        r = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        int i = 1;
        int isEmpty = TextUtils.isEmpty(VERSION.RELEASE) ^ 1;
        int isEmpty2 = TextUtils.isEmpty(Build.ID) ^ 1;
        if (!"REL".equals(VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) {
            i = 0;
        }
        stringBuilder.append("AndroidDownloadManager");
        if (isEmpty != 0) {
            stringBuilder.append("/");
            stringBuilder.append(VERSION.RELEASE);
        }
        stringBuilder.append(" (Linux; U; Android");
        if (isEmpty != 0) {
            stringBuilder.append(" ");
            stringBuilder.append(VERSION.RELEASE);
        }
        if (!(i == 0 && isEmpty2 == 0)) {
            stringBuilder.append(h.b);
            if (i != 0) {
                stringBuilder.append(" ");
                stringBuilder.append(Build.MODEL);
            }
            if (isEmpty2 != 0) {
                stringBuilder.append(" Build/");
                stringBuilder.append(Build.ID);
            }
        }
        stringBuilder.append(k.t);
        t = stringBuilder.toString();
    }
}
