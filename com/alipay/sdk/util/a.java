package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;

public final class a {
    private static final String b = "00:00:00:00:00:00";
    private static a e;
    public String a;
    private String c;
    private String d;

    public static a a(Context context) {
        if (e == null) {
            e = new a(context);
        }
        return e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a(android.content.Context r4) {
        /*
        r3 = this;
        r3.<init>();
        r0 = "phone";
        r0 = r4.getSystemService(r0);	 Catch:{ Exception -> 0x0053 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x0053 }
        r1 = r0.getDeviceId();	 Catch:{ Exception -> 0x0053 }
        r3.b(r1);	 Catch:{ Exception -> 0x0053 }
        r0 = r0.getSubscriberId();	 Catch:{ Exception -> 0x0053 }
        if (r0 == 0) goto L_0x0030;
    L_0x0018:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0053 }
        r1.<init>();	 Catch:{ Exception -> 0x0053 }
        r1.append(r0);	 Catch:{ Exception -> 0x0053 }
        r0 = "000000000000000";
        r1.append(r0);	 Catch:{ Exception -> 0x0053 }
        r0 = r1.toString();	 Catch:{ Exception -> 0x0053 }
        r1 = 0;
        r2 = 15;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0053 }
    L_0x0030:
        r3.c = r0;	 Catch:{ Exception -> 0x0053 }
        r0 = "wifi";
        r4 = r4.getSystemService(r0);	 Catch:{ Exception -> 0x0053 }
        r4 = (android.net.wifi.WifiManager) r4;	 Catch:{ Exception -> 0x0053 }
        r4 = r4.getConnectionInfo();	 Catch:{ Exception -> 0x0053 }
        r4 = r4.getMacAddress();	 Catch:{ Exception -> 0x0053 }
        r3.a = r4;	 Catch:{ Exception -> 0x0053 }
        r4 = r3.a;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x0060;
    L_0x004c:
        r4 = "00:00:00:00:00:00";
        r3.a = r4;
        return;
    L_0x0051:
        r4 = move-exception;
        goto L_0x0061;
    L_0x0053:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ all -> 0x0051 }
        r4 = r3.a;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x0060;
    L_0x005f:
        goto L_0x004c;
    L_0x0060:
        return;
    L_0x0061:
        r0 = r3.a;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x0069:
        r0 = "00:00:00:00:00:00";
        r3.a = r0;
    L_0x006d:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.a.<init>(android.content.Context):void");
    }

    public final String a() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = "000000000000000";
        }
        return this.c;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = "000000000000000";
        }
        return this.d;
    }

    private void a(String str) {
        if (str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("000000000000000");
            str = stringBuilder.toString().substring(0, 15);
        }
        this.c = str;
    }

    private void b(String str) {
        if (str != null) {
            str = str.getBytes();
            int i = 0;
            while (i < str.length) {
                if (str[i] < (byte) 48 || str[i] > (byte) 57) {
                    str[i] = 48;
                }
                i++;
            }
            String str2 = new String(str);
            str = new StringBuilder();
            str.append(str2);
            str.append("000000000000000");
            str = str.toString().substring(0, 15);
        }
        this.d = str;
    }

    private String c() {
        String b = b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("|");
        b = stringBuilder.toString();
        Object a = a();
        if (TextUtils.isEmpty(a)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("000000000000000");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(b);
        stringBuilder2.append(a);
        return stringBuilder2.toString();
    }

    private String d() {
        return this.a;
    }

    public static com.alipay.sdk.util.d b(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "connectivity";
        r1 = r1.getSystemService(r0);
        r1 = (android.net.ConnectivityManager) r1;
        r1 = r1.getActiveNetworkInfo();	 Catch:{ Exception -> 0x002c }
        if (r1 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x002c }
    L_0x000e:
        r0 = r1.getType();	 Catch:{ Exception -> 0x002c }
        if (r0 != 0) goto L_0x001d;	 Catch:{ Exception -> 0x002c }
    L_0x0014:
        r1 = r1.getSubtype();	 Catch:{ Exception -> 0x002c }
        r1 = com.alipay.sdk.util.d.a(r1);	 Catch:{ Exception -> 0x002c }
        return r1;	 Catch:{ Exception -> 0x002c }
    L_0x001d:
        if (r1 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x002c }
    L_0x001f:
        r1 = r1.getType();	 Catch:{ Exception -> 0x002c }
        r0 = 1;	 Catch:{ Exception -> 0x002c }
        if (r1 != r0) goto L_0x0029;	 Catch:{ Exception -> 0x002c }
    L_0x0026:
        r1 = com.alipay.sdk.util.d.WIFI;	 Catch:{ Exception -> 0x002c }
        return r1;	 Catch:{ Exception -> 0x002c }
    L_0x0029:
        r1 = com.alipay.sdk.util.d.NONE;	 Catch:{ Exception -> 0x002c }
        return r1;
    L_0x002c:
        r1 = com.alipay.sdk.util.d.NONE;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.a.b(android.content.Context):com.alipay.sdk.util.d");
    }

    public static String c(Context context) {
        context = a(context);
        String b = context.b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("|");
        b = stringBuilder.toString();
        context = context.a();
        if (TextUtils.isEmpty(context)) {
            context = new StringBuilder();
            context.append(b);
            context.append("000000000000000");
            context = context.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append(context);
            context = stringBuilder.toString();
        }
        return context.substring(0, 8);
    }

    public static java.lang.String d(android.content.Context r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        if (r0 != 0) goto L_0x0005;
    L_0x0002:
        r0 = "";
        return r0;
    L_0x0005:
        r0 = r0.getResources();	 Catch:{ Throwable -> 0x0014 }
        r0 = r0.getConfiguration();	 Catch:{ Throwable -> 0x0014 }
        r0 = r0.locale;	 Catch:{ Throwable -> 0x0014 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.a.d(android.content.Context):java.lang.String");
    }
}
