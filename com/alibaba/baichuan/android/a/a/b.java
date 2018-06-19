package com.alibaba.baichuan.android.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.alibaba.baichuan.android.a.b.a;

public class b extends a {
    public static String a = "AliBCBase";

    private static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || packageManager.getPackageInfo(str, 0) == null) ? false : true;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public final boolean a(java.lang.String r4, java.lang.String r5, com.alibaba.baichuan.android.a.d r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x0077;
    L_0x0007:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0077;
    L_0x000e:
        r0 = "getDeviceInfo";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0030;
    L_0x0016:
        r4 = new com.alibaba.baichuan.android.a.e;
        r4.<init>();
        r4.a();
        r5 = "model";
        r0 = android.os.Build.MODEL;
        r4.a(r5, r0);
        r5 = "brand";
        r0 = android.os.Build.BRAND;
        r4.a(r5, r0);
        r6.a(r4);
        goto L_0x0075;
    L_0x0030:
        r0 = "isInstalled";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0075;
    L_0x0038:
        r4 = 0;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x004a }
        r0.<init>(r5);	 Catch:{ JSONException -> 0x004a }
        r5 = "apps";	 Catch:{ JSONException -> 0x004a }
        r5 = r0.getJSONArray(r5);	 Catch:{ JSONException -> 0x004a }
        r5 = com.alibaba.baichuan.android.trade.utils.f.a.a(r5);	 Catch:{ JSONException -> 0x004a }
        r4 = r5;
        goto L_0x004d;
    L_0x004a:
        com.alibaba.baichuan.android.trade.utils.g.a.b();
    L_0x004d:
        r5 = new com.alibaba.baichuan.android.a.e;
        r5.<init>();
        if (r4 != 0) goto L_0x0058;
    L_0x0054:
        r6.b(r5);
        goto L_0x0075;
    L_0x0058:
        r0 = r4.length;
        if (r1 >= r0) goto L_0x006f;
    L_0x005b:
        r0 = r3.b;
        r2 = r4[r1];
        r0 = a(r0, r2);
        r2 = r4[r1];
        r0 = java.lang.Boolean.valueOf(r0);
        r5.a(r2, r0);
        r1 = r1 + 1;
        goto L_0x0058;
    L_0x006f:
        r5.a();
        r6.a(r5);
    L_0x0075:
        r4 = 1;
        return r4;
    L_0x0077:
        r4 = new com.alibaba.baichuan.android.a.e;
        r5 = "6";
        r4.<init>(r5);
        r5 = "2";
        r4.a(r5);
        r6.b(r4);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.a.a.b.a(java.lang.String, java.lang.String, com.alibaba.baichuan.android.a.d):boolean");
    }
}
