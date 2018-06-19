package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class d {

    public static class a {
        public int a = -1;
        public int b = -1;
        public String c = "";
        public String d = "0";
        public String e = null;
    }

    private static class b {
        public String a;
        public String b;

        private b() {
            this.a = "";
            this.b = "";
        }
    }

    public static int a(android.content.Context r6, java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.String> r8, com.tencent.smtt.sdk.WebView r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r6 != 0) goto L_0x0004;
    L_0x0002:
        r6 = 3;
        return r6;
    L_0x0004:
        r0 = a(r7);
        if (r0 != 0) goto L_0x0018;
    L_0x000a:
        r0 = new java.lang.StringBuilder;
        r1 = "http://";
        r0.<init>(r1);
        r0.append(r7);
        r7 = r0.toString();
    L_0x0018:
        r0 = 2;
        r7 = android.net.Uri.parse(r7);	 Catch:{ Exception -> 0x0147 }
        if (r7 != 0) goto L_0x0020;
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = a(r6);
        r2 = r1.a;
        r3 = -1;
        r4 = 4;
        if (r2 != r3) goto L_0x002b;
    L_0x002a:
        return r4;
    L_0x002b:
        r2 = r1.a;
        r3 = 33;
        if (r2 != r0) goto L_0x0037;
    L_0x0031:
        r2 = r1.b;
        if (r2 >= r3) goto L_0x0037;
    L_0x0035:
        r6 = 5;
        return r6;
    L_0x0037:
        r2 = new android.content.Intent;
        r5 = "android.intent.action.VIEW";
        r2.<init>(r5);
        r5 = r1.a;
        if (r5 != r0) goto L_0x0089;
    L_0x0042:
        r0 = r1.b;
        if (r0 < r3) goto L_0x0055;
    L_0x0046:
        r0 = r1.b;
        r3 = 39;
        if (r0 > r3) goto L_0x0055;
    L_0x004c:
        r0 = "com.tencent.mtt";
        r1 = "com.tencent.mtt.MainActivity";
    L_0x0050:
        r2.setClassName(r0, r1);
        goto L_0x00e2;
    L_0x0055:
        r0 = r1.b;
        r3 = 40;
        if (r0 < r3) goto L_0x0066;
    L_0x005b:
        r0 = r1.b;
        r3 = 45;
        if (r0 > r3) goto L_0x0066;
    L_0x0061:
        r0 = "com.tencent.mtt";
        r1 = "com.tencent.mtt.SplashActivity";
        goto L_0x0050;
    L_0x0066:
        r0 = r1.b;
        r1 = 46;
        if (r0 < r1) goto L_0x00e2;
    L_0x006c:
        r2 = new android.content.Intent;
        r0 = "com.tencent.QQBrowser.action.VIEW";
        r2.<init>(r0);
        r0 = a(r6, r7);
        if (r0 == 0) goto L_0x00e2;
    L_0x0079:
        r1 = r0.a;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00e2;
    L_0x0081:
        r1 = r0.b;
        r0 = r0.a;
        r2.setClassName(r1, r0);
        goto L_0x00e2;
    L_0x0089:
        r3 = r1.a;
        r5 = 1;
        if (r3 != r5) goto L_0x00a0;
    L_0x008e:
        r3 = r1.b;
        if (r3 != r5) goto L_0x0097;
    L_0x0092:
        r0 = "com.tencent.qbx5";
        r1 = "com.tencent.qbx5.MainActivity";
        goto L_0x0050;
    L_0x0097:
        r1 = r1.b;
        if (r1 != r0) goto L_0x00e2;
    L_0x009b:
        r0 = "com.tencent.qbx5";
        r1 = "com.tencent.qbx5.SplashActivity";
        goto L_0x0050;
    L_0x00a0:
        r0 = r1.a;
        if (r0 != 0) goto L_0x00cc;
    L_0x00a4:
        r0 = r1.b;
        r3 = 6;
        if (r0 < r4) goto L_0x00b2;
    L_0x00a9:
        r0 = r1.b;
        if (r0 > r3) goto L_0x00b2;
    L_0x00ad:
        r0 = "com.tencent.qbx";
        r1 = "com.tencent.qbx.SplashActivity";
        goto L_0x0050;
    L_0x00b2:
        r0 = r1.b;
        if (r0 <= r3) goto L_0x00e2;
    L_0x00b6:
        r2 = new android.content.Intent;
        r0 = "com.tencent.QQBrowser.action.VIEW";
        r2.<init>(r0);
        r0 = a(r6, r7);
        if (r0 == 0) goto L_0x00e2;
    L_0x00c3:
        r1 = r0.a;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00e2;
    L_0x00cb:
        goto L_0x0081;
    L_0x00cc:
        r2 = new android.content.Intent;
        r0 = "com.tencent.QQBrowser.action.VIEW";
        r2.<init>(r0);
        r0 = a(r6, r7);
        if (r0 == 0) goto L_0x00e2;
    L_0x00d9:
        r1 = r0.a;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00e2;
    L_0x00e1:
        goto L_0x0081;
    L_0x00e2:
        r2.setData(r7);
        if (r8 == 0) goto L_0x010d;
    L_0x00e7:
        r7 = r8.keySet();
        if (r7 == 0) goto L_0x010d;
    L_0x00ed:
        r7 = r7.iterator();
    L_0x00f1:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x010d;
    L_0x00f7:
        r0 = r7.next();
        r0 = (java.lang.String) r0;
        r1 = r8.get(r0);
        r1 = (java.lang.String) r1;
        r3 = android.text.TextUtils.isEmpty(r1);
        if (r3 != 0) goto L_0x00f1;
    L_0x0109:
        r2.putExtra(r0, r1);
        goto L_0x00f1;
    L_0x010d:
        r7 = "loginType";	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r8 = d(r6);	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r2.putExtra(r7, r8);	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r7 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r2.addFlags(r7);	 Catch:{ ActivityNotFoundException -> 0x0146 }
        if (r9 == 0) goto L_0x0141;	 Catch:{ ActivityNotFoundException -> 0x0146 }
    L_0x011d:
        r7 = new android.graphics.Point;	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r8 = r9.getScrollX();	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r0 = r9.getScrollY();	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r7.<init>(r8, r0);	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r8 = "AnchorPoint";	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r2.putExtra(r8, r7);	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r7 = new android.graphics.Point;	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r8 = r9.getContentWidth();	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r9 = r9.getContentHeight();	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r7.<init>(r8, r9);	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r8 = "ContentSize";	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r2.putExtra(r8, r7);	 Catch:{ ActivityNotFoundException -> 0x0146 }
    L_0x0141:
        r6.startActivity(r2);	 Catch:{ ActivityNotFoundException -> 0x0146 }
        r6 = 0;
        return r6;
    L_0x0146:
        return r4;
    L_0x0147:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.d.a(android.content.Context, java.lang.String, java.util.HashMap, com.tencent.smtt.sdk.WebView):int");
    }

    public static int a(android.content.Context r4, java.lang.String r5, java.util.HashMap<java.lang.String, java.lang.String> r6, java.lang.String r7, com.tencent.smtt.sdk.WebView r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = 0;
        r2 = r4.getPackageManager();	 Catch:{ Throwable -> 0x001d }
        if (r2 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001d }
    L_0x000c:
        r3 = "com.tencent.mtt";	 Catch:{ Throwable -> 0x001d }
        r2 = r2.getPackageInfo(r3, r1);	 Catch:{ Throwable -> 0x001d }
        if (r2 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001d }
    L_0x0014:
        r2 = r2.versionCode;	 Catch:{ Throwable -> 0x001d }
        r3 = 601000; // 0x92ba8 float:8.4218E-40 double:2.969335E-318;
        if (r2 <= r3) goto L_0x001d;
    L_0x001b:
        r2 = 1;
        goto L_0x001e;
    L_0x001d:
        r2 = r1;
    L_0x001e:
        r3 = "UTF-8";	 Catch:{ Exception -> 0x0028 }
        r3 = java.net.URLEncoder.encode(r5, r3);	 Catch:{ Exception -> 0x0028 }
        if (r2 == 0) goto L_0x0027;
    L_0x0026:
        r5 = r3;
    L_0x0027:
        r1 = r2;
    L_0x0028:
        if (r1 == 0) goto L_0x002d;
    L_0x002a:
        r1 = ",encoded=1";
        goto L_0x002f;
    L_0x002d:
        r1 = "";
    L_0x002f:
        r2 = "mttbrowser://url=";
        r0.append(r2);
        r0.append(r5);
        r5 = ",product=TBS,packagename=";
        r0.append(r5);
        r5 = r4.getPackageName();
        r0.append(r5);
        r5 = ",from=";
        r0.append(r5);
        r0.append(r7);
        r5 = ",version=3.3.0.1004";
        r0.append(r5);
        r0.append(r1);
        r5 = r0.toString();
        r4 = a(r4, r5, r6, r8);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.d.a(android.content.Context, java.lang.String, java.util.HashMap, java.lang.String, com.tencent.smtt.sdk.WebView):int");
    }

    public static com.tencent.smtt.sdk.a.d.a a(android.content.Context r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r9.getApplicationContext();
        r1 = "x5_proxy_setting";
        r2 = 0;
        r0 = r0.getSharedPreferences(r1, r2);
        r1 = "qb_install_status";
        r0 = r0.getBoolean(r1, r2);
        r1 = new com.tencent.smtt.sdk.a.d$a;
        r1.<init>();
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = r9.getPackageManager();	 Catch:{ Exception -> 0x0105 }
        r3 = 0;
        r4 = 2;
        r5 = "com.tencent.mtt";	 Catch:{ NameNotFoundException -> 0x0066 }
        r5 = r0.getPackageInfo(r5, r2);	 Catch:{ NameNotFoundException -> 0x0066 }
        r1.a = r4;	 Catch:{ NameNotFoundException -> 0x0067 }
        r3 = "com.tencent.mtt";	 Catch:{ NameNotFoundException -> 0x0067 }
        r1.e = r3;	 Catch:{ NameNotFoundException -> 0x0067 }
        r3 = "ADRQB_";	 Catch:{ NameNotFoundException -> 0x0067 }
        r1.c = r3;	 Catch:{ NameNotFoundException -> 0x0067 }
        if (r5 == 0) goto L_0x0067;	 Catch:{ NameNotFoundException -> 0x0067 }
    L_0x0031:
        r3 = r5.versionCode;	 Catch:{ NameNotFoundException -> 0x0067 }
        r6 = 420000; // 0x668a0 float:5.88545E-40 double:2.075076E-318;	 Catch:{ NameNotFoundException -> 0x0067 }
        if (r3 <= r6) goto L_0x0067;	 Catch:{ NameNotFoundException -> 0x0067 }
    L_0x0038:
        r3 = r5.versionCode;	 Catch:{ NameNotFoundException -> 0x0067 }
        r1.b = r3;	 Catch:{ NameNotFoundException -> 0x0067 }
        r3 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0067 }
        r3.<init>();	 Catch:{ NameNotFoundException -> 0x0067 }
        r6 = r1.c;	 Catch:{ NameNotFoundException -> 0x0067 }
        r3.append(r6);	 Catch:{ NameNotFoundException -> 0x0067 }
        r6 = r5.versionName;	 Catch:{ NameNotFoundException -> 0x0067 }
        r7 = "\\.";	 Catch:{ NameNotFoundException -> 0x0067 }
        r8 = "";	 Catch:{ NameNotFoundException -> 0x0067 }
        r6 = r6.replaceAll(r7, r8);	 Catch:{ NameNotFoundException -> 0x0067 }
        r3.append(r6);	 Catch:{ NameNotFoundException -> 0x0067 }
        r3 = r3.toString();	 Catch:{ NameNotFoundException -> 0x0067 }
        r1.c = r3;	 Catch:{ NameNotFoundException -> 0x0067 }
        r3 = r5.versionName;	 Catch:{ NameNotFoundException -> 0x0067 }
        r6 = "\\.";	 Catch:{ NameNotFoundException -> 0x0067 }
        r7 = "";	 Catch:{ NameNotFoundException -> 0x0067 }
        r3 = r3.replaceAll(r6, r7);	 Catch:{ NameNotFoundException -> 0x0067 }
        r1.d = r3;	 Catch:{ NameNotFoundException -> 0x0067 }
        return r1;
    L_0x0066:
        r5 = r3;
    L_0x0067:
        r3 = "com.tencent.qbx";	 Catch:{ NameNotFoundException -> 0x0078 }
        r3 = r0.getPackageInfo(r3, r2);	 Catch:{ NameNotFoundException -> 0x0078 }
        r1.a = r2;	 Catch:{ NameNotFoundException -> 0x0079 }
        r5 = "com.tencent.qbx";	 Catch:{ NameNotFoundException -> 0x0079 }
        r1.e = r5;	 Catch:{ NameNotFoundException -> 0x0079 }
        r5 = "ADRQBX_";	 Catch:{ NameNotFoundException -> 0x0079 }
        r1.c = r5;	 Catch:{ NameNotFoundException -> 0x0079 }
        goto L_0x00d6;
    L_0x0078:
        r3 = r5;
    L_0x0079:
        r5 = "com.tencent.qbx5";	 Catch:{ NameNotFoundException -> 0x008d }
        r5 = r0.getPackageInfo(r5, r2);	 Catch:{ NameNotFoundException -> 0x008d }
        r3 = 1;
        r1.a = r3;	 Catch:{ NameNotFoundException -> 0x008c }
        r3 = "com.tencent.qbx5";	 Catch:{ NameNotFoundException -> 0x008c }
        r1.e = r3;	 Catch:{ NameNotFoundException -> 0x008c }
        r3 = "ADRQBX5_";	 Catch:{ NameNotFoundException -> 0x008c }
        r1.c = r3;	 Catch:{ NameNotFoundException -> 0x008c }
    L_0x008a:
        r3 = r5;
        goto L_0x00d6;
    L_0x008c:
        r3 = r5;
    L_0x008d:
        r5 = "com.tencent.mtt";	 Catch:{ NameNotFoundException -> 0x009f }
        r5 = r0.getPackageInfo(r5, r2);	 Catch:{ NameNotFoundException -> 0x009f }
        r3 = "com.tencent.mtt";	 Catch:{ NameNotFoundException -> 0x009e }
        r1.e = r3;	 Catch:{ NameNotFoundException -> 0x009e }
        r1.a = r4;	 Catch:{ NameNotFoundException -> 0x009e }
        r3 = "ADRQB_";	 Catch:{ NameNotFoundException -> 0x009e }
        r1.c = r3;	 Catch:{ NameNotFoundException -> 0x009e }
        goto L_0x008a;
    L_0x009e:
        r3 = r5;
    L_0x009f:
        r5 = "com.tencent.mtt.x86";	 Catch:{ Exception -> 0x00b1 }
        r5 = r0.getPackageInfo(r5, r2);	 Catch:{ Exception -> 0x00b1 }
        r3 = "com.tencent.mtt.x86";	 Catch:{ Exception -> 0x00b0 }
        r1.e = r3;	 Catch:{ Exception -> 0x00b0 }
        r1.a = r4;	 Catch:{ Exception -> 0x00b0 }
        r3 = "ADRQB_";	 Catch:{ Exception -> 0x00b0 }
        r1.c = r3;	 Catch:{ Exception -> 0x00b0 }
        goto L_0x008a;
    L_0x00b0:
        r3 = r5;
    L_0x00b1:
        r5 = "http://mdc.html5.qq.com/mh?channel_id=50079&u=";	 Catch:{ Exception -> 0x00d6 }
        r5 = android.net.Uri.parse(r5);	 Catch:{ Exception -> 0x00d6 }
        r9 = a(r9, r5);	 Catch:{ Exception -> 0x00d6 }
        if (r9 == 0) goto L_0x00d6;	 Catch:{ Exception -> 0x00d6 }
    L_0x00bd:
        r5 = r9.b;	 Catch:{ Exception -> 0x00d6 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x00d6 }
        if (r5 != 0) goto L_0x00d6;	 Catch:{ Exception -> 0x00d6 }
    L_0x00c5:
        r5 = r9.b;	 Catch:{ Exception -> 0x00d6 }
        r0 = r0.getPackageInfo(r5, r2);	 Catch:{ Exception -> 0x00d6 }
        r9 = r9.b;	 Catch:{ Exception -> 0x00d5 }
        r1.e = r9;	 Catch:{ Exception -> 0x00d5 }
        r1.a = r4;	 Catch:{ Exception -> 0x00d5 }
        r9 = "ADRQB_";	 Catch:{ Exception -> 0x00d5 }
        r1.c = r9;	 Catch:{ Exception -> 0x00d5 }
    L_0x00d5:
        r3 = r0;
    L_0x00d6:
        if (r3 == 0) goto L_0x0105;
    L_0x00d8:
        r9 = r3.versionCode;	 Catch:{ Exception -> 0x0105 }
        r1.b = r9;	 Catch:{ Exception -> 0x0105 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0105 }
        r9.<init>();	 Catch:{ Exception -> 0x0105 }
        r0 = r1.c;	 Catch:{ Exception -> 0x0105 }
        r9.append(r0);	 Catch:{ Exception -> 0x0105 }
        r0 = r3.versionName;	 Catch:{ Exception -> 0x0105 }
        r2 = "\\.";	 Catch:{ Exception -> 0x0105 }
        r4 = "";	 Catch:{ Exception -> 0x0105 }
        r0 = r0.replaceAll(r2, r4);	 Catch:{ Exception -> 0x0105 }
        r9.append(r0);	 Catch:{ Exception -> 0x0105 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0105 }
        r1.c = r9;	 Catch:{ Exception -> 0x0105 }
        r9 = r3.versionName;	 Catch:{ Exception -> 0x0105 }
        r0 = "\\.";	 Catch:{ Exception -> 0x0105 }
        r2 = "";	 Catch:{ Exception -> 0x0105 }
        r9 = r9.replaceAll(r0, r2);	 Catch:{ Exception -> 0x0105 }
        r1.d = r9;	 Catch:{ Exception -> 0x0105 }
    L_0x0105:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.d.a(android.content.Context):com.tencent.smtt.sdk.a.d$a");
    }

    private static b a(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                bVar.a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
            }
        }
        return bVar;
    }

    public static boolean a(Context context, long j, long j2) {
        a a = a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a.d).longValue() >= j) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return ((long) a.b) >= j2 ? true : z;
    }

    public static boolean a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        try {
            String str3;
            Uri fromFile;
            StringBuilder stringBuilder;
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (hashMap != null) {
                Set<String> keySet = hashMap.keySet();
                if (keySet != null) {
                    for (String str4 : keySet) {
                        String str5 = (String) hashMap.get(str4);
                        if (!TextUtils.isEmpty(str5)) {
                            intent.putExtra(str4, str5);
                        }
                    }
                }
            }
            File file = new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i == 0) {
                str3 = "key_reader_sdk_path";
            } else {
                if (i == 1) {
                    str3 = "key_reader_sdk_url";
                }
                intent.putExtra("key_reader_sdk_format", str2);
                fromFile = Uri.fromFile(file);
                stringBuilder = new StringBuilder("mtt/");
                stringBuilder.append(str2);
                intent.setDataAndType(fromFile, stringBuilder.toString());
                intent.putExtra("loginType", d(context.getApplicationContext()));
                if (bundle != null) {
                    intent.putExtra("key_reader_sdk_extrals", bundle);
                }
                context.startActivity(intent);
                return true;
            }
            intent.putExtra(str3, str);
            intent.putExtra("key_reader_sdk_format", str2);
            fromFile = Uri.fromFile(file);
            stringBuilder = new StringBuilder("mtt/");
            stringBuilder.append(str2);
            intent.setDataAndType(fromFile, stringBuilder.toString());
            intent.putExtra("loginType", d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(android.content.Context r4, java.lang.String r5, java.util.HashMap<java.lang.String, java.lang.String> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = android.net.Uri.parse(r5);
        r0 = new android.content.Intent;
        r1 = "android.intent.action.VIEW";
        r0.<init>(r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);
        r1 = "video/*";
        r0.setDataAndType(r5, r1);
        if (r6 == 0) goto L_0x003d;
    L_0x0017:
        r5 = r6.keySet();
        if (r5 == 0) goto L_0x003d;
    L_0x001d:
        r5 = r5.iterator();
    L_0x0021:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r1 = r5.next();
        r1 = (java.lang.String) r1;
        r2 = r6.get(r1);
        r2 = (java.lang.String) r2;
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 != 0) goto L_0x0021;
    L_0x0039:
        r0.putExtra(r1, r2);
        goto L_0x0021;
    L_0x003d:
        r5 = 1;
        r6 = 0;
        r1 = "loginType";	 Catch:{ Throwable -> 0x0059 }
        r2 = d(r4);	 Catch:{ Throwable -> 0x0059 }
        r0.putExtra(r1, r2);	 Catch:{ Throwable -> 0x0059 }
        r1 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0059 }
        r2 = "com.tencent.mtt";	 Catch:{ Throwable -> 0x0059 }
        r3 = "com.tencent.mtt.browser.video.H5VideoThrdcallActivity";	 Catch:{ Throwable -> 0x0059 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0059 }
        r0.setComponent(r1);	 Catch:{ Throwable -> 0x0059 }
        r4.startActivity(r0);	 Catch:{ Throwable -> 0x0059 }
        r1 = r5;
        goto L_0x005a;
    L_0x0059:
        r1 = r6;
    L_0x005a:
        if (r1 != 0) goto L_0x0069;
    L_0x005c:
        r1 = 0;
        r0.setComponent(r1);	 Catch:{ Throwable -> 0x0064 }
        r4.startActivity(r0);	 Catch:{ Throwable -> 0x0064 }
        return r5;
    L_0x0064:
        r4 = move-exception;
        r4.printStackTrace();
        return r6;
    L_0x0069:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.d.a(android.content.Context, java.lang.String, java.util.HashMap):boolean");
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        str = str.trim();
        int indexOf = str.toLowerCase().indexOf(HttpConstant.SCHEME_SPLIT);
        int indexOf2 = str.toLowerCase().indexOf(46);
        return (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) ? str.toLowerCase().contains(HttpConstant.SCHEME_SPLIT) : false;
    }

    public static boolean b(Context context) {
        return a(context).a != -1;
    }

    public static boolean c(Context context) {
        a a = a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a.d).longValue() >= 6001500) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return a.b >= 601500 ? true : z;
    }

    private static int d(Context context) {
        String str = context.getApplicationInfo().processName;
        return str.equals("com.tencent.mobileqq") ? 13 : str.equals("com.qzone") ? 14 : str.equals("com.tencent.WBlog") ? 15 : str.equals("com.tencent.mm") ? 24 : 26;
    }
}
