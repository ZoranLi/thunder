package com.qiniu.android.http;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.message.proguard.k;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;

/* compiled from: UserAgent */
public final class r {
    private static r c = new r();
    public final String a;
    public final String b;

    private r() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(random.nextInt(999));
        this.a = stringBuilder.toString();
        String str = this.a;
        this.b = String.format("QiniuAndroid/%s (%s; %s; %s", new Object[]{"7.3.9", b(), c(), str});
    }

    public static r a() {
        return c;
    }

    private static java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.VERSION.RELEASE;	 Catch:{ Throwable -> 0x0010 }
        if (r0 != 0) goto L_0x0007;	 Catch:{ Throwable -> 0x0010 }
    L_0x0004:
        r0 = "-";	 Catch:{ Throwable -> 0x0010 }
        return r0;	 Catch:{ Throwable -> 0x0010 }
    L_0x0007:
        r0 = r0.trim();	 Catch:{ Throwable -> 0x0010 }
        r0 = com.qiniu.android.d.f.a(r0);	 Catch:{ Throwable -> 0x0010 }
        return r0;
    L_0x0010:
        r0 = "-";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.r.b():java.lang.String");
    }

    private static java.lang.String c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x003d }
        r0 = r0.trim();	 Catch:{ Throwable -> 0x003d }
        r1 = android.os.Build.MANUFACTURER;	 Catch:{ Throwable -> 0x003d }
        r1 = r1.trim();	 Catch:{ Throwable -> 0x003d }
        r1 = a(r1, r0);	 Catch:{ Throwable -> 0x003d }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x003d }
        if (r2 == 0) goto L_0x0020;	 Catch:{ Throwable -> 0x003d }
    L_0x0016:
        r1 = android.os.Build.BRAND;	 Catch:{ Throwable -> 0x003d }
        r1 = r1.trim();	 Catch:{ Throwable -> 0x003d }
        r1 = a(r1, r0);	 Catch:{ Throwable -> 0x003d }
    L_0x0020:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003d }
        r2.<init>();	 Catch:{ Throwable -> 0x003d }
        if (r1 != 0) goto L_0x0029;	 Catch:{ Throwable -> 0x003d }
    L_0x0027:
        r1 = "-";	 Catch:{ Throwable -> 0x003d }
    L_0x0029:
        r2.append(r1);	 Catch:{ Throwable -> 0x003d }
        r1 = "-";	 Catch:{ Throwable -> 0x003d }
        r2.append(r1);	 Catch:{ Throwable -> 0x003d }
        r2.append(r0);	 Catch:{ Throwable -> 0x003d }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x003d }
        r0 = com.qiniu.android.d.f.a(r0);	 Catch:{ Throwable -> 0x003d }
        return r0;
    L_0x003d:
        r0 = "-";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.r.c():java.lang.String");
    }

    private static String a(String str, String str2) {
        CharSequence toLowerCase = str.toLowerCase(Locale.getDefault());
        if (!(toLowerCase.startsWith("unknown") || toLowerCase.startsWith("alps") || toLowerCase.startsWith(DispatchConstants.ANDROID) || toLowerCase.startsWith("sprd") || toLowerCase.startsWith("spreadtrum") || toLowerCase.startsWith("rockchip") || toLowerCase.startsWith("wondermedia") || toLowerCase.startsWith("mtk") || toLowerCase.startsWith("mt65") || toLowerCase.startsWith("nvidia") || toLowerCase.startsWith("brcm") || toLowerCase.startsWith("marvell"))) {
            if (str2.toLowerCase(Locale.getDefault()).contains(toLowerCase) == null) {
                return str;
            }
        }
        return null;
    }

    public final String a(String str) {
        str = str.trim();
        str = str.substring(0, Math.min(16, str.length()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append("; ");
        stringBuilder.append(str);
        stringBuilder.append(k.t);
        return new String(stringBuilder.toString().getBytes(Charset.forName("ISO-8859-1")));
    }
}
