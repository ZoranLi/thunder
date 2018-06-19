package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.f.d;
import com.alipay.apmobilesecuritysdk.f.g;
import com.alipay.apmobilesecuritysdk.f.h;
import com.alipay.apmobilesecuritysdk.f.i;
import com.alipay.b.a.a.c.a.b;
import com.alipay.b.a.a.c.a.c;
import java.util.Map;

public final class a {
    private Context a;
    private com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    private int c = 4;

    public a(Context context) {
        this.a = context;
    }

    public static String a(Context context) {
        String b = b(context);
        return com.alipay.b.a.a.a.a.a(b) ? h.c(context) : b;
    }

    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = com.alipay.apmobilesecuritysdk.f.i.a(r3);	 Catch:{ Throwable -> 0x0019 }
        r1 = com.alipay.b.a.a.a.a.a(r0);	 Catch:{ Throwable -> 0x0019 }
        if (r1 != 0) goto L_0x000b;	 Catch:{ Throwable -> 0x0019 }
    L_0x000a:
        return r0;	 Catch:{ Throwable -> 0x0019 }
    L_0x000b:
        r2 = com.alipay.apmobilesecuritysdk.f.g.a(r2, r3);	 Catch:{ Throwable -> 0x0019 }
        com.alipay.apmobilesecuritysdk.f.i.a(r3, r2);	 Catch:{ Throwable -> 0x0019 }
        r3 = com.alipay.b.a.a.a.a.a(r2);	 Catch:{ Throwable -> 0x0019 }
        if (r3 != 0) goto L_0x0019;
    L_0x0018:
        return r2;
    L_0x0019:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private static boolean a() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new java.text.SimpleDateFormat;
        r1 = "yyyy-MM-dd HH:mm:ss";
        r0.<init>(r1);
        r1 = 2;
        r2 = new java.lang.String[r1];
        r3 = "2016-11-10 2016-11-11";
        r4 = 0;
        r2[r4] = r3;
        r3 = "2016-12-11 2016-12-12";
        r5 = 1;
        r2[r5] = r3;
        r6 = java.lang.Math.random();
        r8 = 4627448617123184640; // 0x4038000000000000 float:0.0 double:24.0;
        r6 = r6 * r8;
        r8 = 4633641066610819072; // 0x404e000000000000 float:0.0 double:60.0;
        r6 = r6 * r8;
        r6 = r6 * r8;
        r3 = (int) r6;
        r3 = r3 * r5;
        r6 = r4;
    L_0x0022:
        if (r6 >= r1) goto L_0x0084;
    L_0x0024:
        r7 = r2[r6];	 Catch:{ Exception -> 0x0084 }
        r8 = " ";	 Catch:{ Exception -> 0x0084 }
        r7 = r7.split(r8);	 Catch:{ Exception -> 0x0084 }
        if (r7 == 0) goto L_0x0081;	 Catch:{ Exception -> 0x0084 }
    L_0x002e:
        r8 = r7.length;	 Catch:{ Exception -> 0x0084 }
        if (r8 != r1) goto L_0x0081;	 Catch:{ Exception -> 0x0084 }
    L_0x0031:
        r8 = new java.util.Date;	 Catch:{ Exception -> 0x0084 }
        r8.<init>();	 Catch:{ Exception -> 0x0084 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0084 }
        r9.<init>();	 Catch:{ Exception -> 0x0084 }
        r10 = r7[r4];	 Catch:{ Exception -> 0x0084 }
        r9.append(r10);	 Catch:{ Exception -> 0x0084 }
        r10 = " 00:00:00";	 Catch:{ Exception -> 0x0084 }
        r9.append(r10);	 Catch:{ Exception -> 0x0084 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0084 }
        r9 = r0.parse(r9);	 Catch:{ Exception -> 0x0084 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0084 }
        r10.<init>();	 Catch:{ Exception -> 0x0084 }
        r7 = r7[r5];	 Catch:{ Exception -> 0x0084 }
        r10.append(r7);	 Catch:{ Exception -> 0x0084 }
        r7 = " 23:59:59";	 Catch:{ Exception -> 0x0084 }
        r10.append(r7);	 Catch:{ Exception -> 0x0084 }
        r7 = r10.toString();	 Catch:{ Exception -> 0x0084 }
        r7 = r0.parse(r7);	 Catch:{ Exception -> 0x0084 }
        r10 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0084 }
        r10.setTime(r7);	 Catch:{ Exception -> 0x0084 }
        r7 = 13;	 Catch:{ Exception -> 0x0084 }
        r10.add(r7, r3);	 Catch:{ Exception -> 0x0084 }
        r7 = r10.getTime();	 Catch:{ Exception -> 0x0084 }
        r9 = r8.after(r9);	 Catch:{ Exception -> 0x0084 }
        if (r9 == 0) goto L_0x0081;	 Catch:{ Exception -> 0x0084 }
    L_0x007a:
        r7 = r8.before(r7);	 Catch:{ Exception -> 0x0084 }
        if (r7 == 0) goto L_0x0081;
    L_0x0080:
        return r5;
    L_0x0081:
        r6 = r6 + 1;
        goto L_0x0022;
    L_0x0084:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a():boolean");
    }

    private b b(Map<String, String> map) {
        try {
            com.alipay.apmobilesecuritysdk.f.b c;
            Context context = this.a;
            c cVar = new c();
            String str = "";
            String str2 = "";
            String str3 = "";
            String a = com.alipay.apmobilesecuritysdk.e.a.a();
            String a2 = com.alipay.b.a.a.a.a.a(map, "rpcVersion", "");
            String a3 = a(context, com.alipay.b.a.a.a.a.a(map, "appName", ""));
            com.alipay.apmobilesecuritysdk.f.c c2 = d.c(context);
            com.alipay.apmobilesecuritysdk.f.c b = d.b();
            if (c2 != null) {
                str = c2.a();
                str3 = c2.c();
            }
            if (com.alipay.b.a.a.a.a.a(str)) {
                c = com.alipay.apmobilesecuritysdk.f.a.c(context);
                if (c != null) {
                    str = c.a();
                    str3 = c.c();
                }
            }
            if (b != null) {
                str2 = b.a();
            }
            if (com.alipay.b.a.a.a.a.a(str2)) {
                c = com.alipay.apmobilesecuritysdk.f.a.b();
                if (c != null) {
                    str2 = c.a();
                }
            }
            cVar.a(DispatchConstants.ANDROID);
            cVar.c(str);
            cVar.b(str2);
            cVar.d(a3);
            cVar.e(a);
            cVar.g(str3);
            cVar.f(a2);
            cVar.a(e.a(context, map));
            return com.alipay.b.a.a.c.d.a(this.a, this.b.c()).a(cVar);
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    private static java.lang.String b(android.content.Context r2) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = com.alipay.apmobilesecuritysdk.f.i.b();	 Catch:{ Throwable -> 0x0033 }
        r1 = com.alipay.b.a.a.a.a.a(r0);	 Catch:{ Throwable -> 0x0033 }
        if (r1 != 0) goto L_0x000b;	 Catch:{ Throwable -> 0x0033 }
    L_0x000a:
        return r0;	 Catch:{ Throwable -> 0x0033 }
    L_0x000b:
        r0 = com.alipay.apmobilesecuritysdk.f.d.b(r2);	 Catch:{ Throwable -> 0x0033 }
        if (r0 == 0) goto L_0x001f;	 Catch:{ Throwable -> 0x0033 }
    L_0x0011:
        com.alipay.apmobilesecuritysdk.f.i.a(r0);	 Catch:{ Throwable -> 0x0033 }
        r0 = r0.a();	 Catch:{ Throwable -> 0x0033 }
        r1 = com.alipay.b.a.a.a.a.b(r0);	 Catch:{ Throwable -> 0x0033 }
        if (r1 == 0) goto L_0x001f;	 Catch:{ Throwable -> 0x0033 }
    L_0x001e:
        return r0;	 Catch:{ Throwable -> 0x0033 }
    L_0x001f:
        r2 = com.alipay.apmobilesecuritysdk.f.a.b(r2);	 Catch:{ Throwable -> 0x0033 }
        if (r2 == 0) goto L_0x0033;	 Catch:{ Throwable -> 0x0033 }
    L_0x0025:
        com.alipay.apmobilesecuritysdk.f.i.a(r2);	 Catch:{ Throwable -> 0x0033 }
        r2 = r2.a();	 Catch:{ Throwable -> 0x0033 }
        r0 = com.alipay.b.a.a.a.a.b(r2);	 Catch:{ Throwable -> 0x0033 }
        if (r0 == 0) goto L_0x0033;
    L_0x0032:
        return r2;
    L_0x0033:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.b(android.content.Context):java.lang.String");
    }

    public final int a(Map<String, String> map) {
        try {
            String a;
            int i;
            com.alipay.b.a.a.c.a.a b;
            int i2;
            String a2;
            int i3;
            StringBuilder stringBuilder;
            com.alipay.b.a.a.c.b.a a3;
            Context context;
            NetworkInfo networkInfo;
            ConnectivityManager connectivityManager;
            StringBuilder stringBuilder2;
            com.alipay.apmobilesecuritysdk.c.a.a(this.a, com.alipay.b.a.a.a.a.a(map, com.alipay.sdk.cons.b.c, ""), com.alipay.b.a.a.a.a.a(map, "utdid", ""), a(this.a));
            String a4 = com.alipay.b.a.a.a.a.a(map, "appName", "");
            b(this.a);
            a(this.a, a4);
            i.a();
            int i4 = 0;
            if (!a()) {
                e.a();
                if ((com.alipay.b.a.a.a.a.a(e.b(this.a, map), i.c()) ^ 1) == 0) {
                    a = com.alipay.b.a.a.a.a.a(map, com.alipay.sdk.cons.b.c, "");
                    String a5 = com.alipay.b.a.a.a.a.a(map, "utdid", "");
                    if (!com.alipay.b.a.a.a.a.b(a) || com.alipay.b.a.a.a.a.a(a, i.d())) {
                        if (!com.alipay.b.a.a.a.a.b(a5) || com.alipay.b.a.a.a.a.a(a5, i.e())) {
                            if (i.a(this.a, a4)) {
                                if (!com.alipay.b.a.a.a.a.a(a(this.a, a4))) {
                                    if (com.alipay.b.a.a.a.a.a(b(this.a))) {
                                    }
                                    i = 0;
                                    if (i != 0) {
                                        com.alipay.apmobilesecuritysdk.b.a.a().b();
                                        com.alipay.apmobilesecuritysdk.e.a.b();
                                        b = b((Map) map);
                                        i2 = 2;
                                        if (b != null) {
                                            if (b.a) {
                                                if ("APPKEY_ERROR".equals(b.b)) {
                                                    i2 = 3;
                                                }
                                            } else if (!com.alipay.b.a.a.a.a.a(b.c)) {
                                                i2 = 1;
                                            }
                                        }
                                        if (i2 != 1) {
                                            h.a(this.a, "1".equals(b.h));
                                            if (b.j == null) {
                                            }
                                            h.b(this.a, b.j == null ? "0" : b.j);
                                            i.c(e.b(this.a, map));
                                            i.a(a4, b.d);
                                            i.b(b.c);
                                            i.d(b.e);
                                            a = com.alipay.b.a.a.a.a.a(map, com.alipay.sdk.cons.b.c, "");
                                            if (com.alipay.b.a.a.a.a.b(a)) {
                                            }
                                            a = i.d();
                                            i.e(a);
                                            a2 = com.alipay.b.a.a.a.a.a(map, "utdid", "");
                                            if (com.alipay.b.a.a.a.a.b(a2)) {
                                            }
                                            a2 = i.e();
                                            i.f(a2);
                                            i.a();
                                            d.a(this.a, i.g());
                                            d.a();
                                            com.alipay.apmobilesecuritysdk.f.a.a(this.a, new com.alipay.apmobilesecuritysdk.f.b(i.b(), i.c(), i.f()));
                                            com.alipay.apmobilesecuritysdk.f.a.a();
                                            g.a(this.a, a4, i.a(a4));
                                            g.a();
                                            h.a(this.a, a4, System.currentTimeMillis());
                                        } else {
                                            if (i2 != 3) {
                                                i3 = 1;
                                            } else {
                                                if (b != null) {
                                                    a2 = "Server error, returned null";
                                                } else {
                                                    stringBuilder = new StringBuilder("Server error, result:");
                                                    stringBuilder.append(b.b);
                                                    a2 = stringBuilder.toString();
                                                }
                                                com.alipay.apmobilesecuritysdk.c.a.a(a2);
                                                if (com.alipay.b.a.a.a.a.a(a(this.a, a4))) {
                                                    i3 = 4;
                                                }
                                            }
                                            this.c = i3;
                                            a3 = com.alipay.b.a.a.c.d.a(this.a, this.b.c());
                                            context = this.a;
                                            networkInfo = null;
                                            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                            if (connectivityManager != null) {
                                                networkInfo = connectivityManager.getActiveNetworkInfo();
                                            }
                                            i4 = 1;
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append(context.getFilesDir().getAbsolutePath());
                                            stringBuilder2.append("/log/ap");
                                            new com.alipay.b.a.a.e.b(stringBuilder2.toString(), a3).a();
                                            return this.c;
                                        }
                                    }
                                    i3 = 0;
                                    this.c = i3;
                                    a3 = com.alipay.b.a.a.c.d.a(this.a, this.b.c());
                                    context = this.a;
                                    networkInfo = null;
                                    connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                    if (connectivityManager != null) {
                                        networkInfo = connectivityManager.getActiveNetworkInfo();
                                    }
                                    i4 = 1;
                                    stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(context.getFilesDir().getAbsolutePath());
                                    stringBuilder2.append("/log/ap");
                                    new com.alipay.b.a.a.e.b(stringBuilder2.toString(), a3).a();
                                    return this.c;
                                }
                            }
                        }
                    }
                }
            } else if (!com.alipay.b.a.a.a.a.a(a(this.a, a4))) {
                if (com.alipay.b.a.a.a.a.a(b(this.a))) {
                }
                i = 0;
                if (i != 0) {
                    com.alipay.apmobilesecuritysdk.b.a.a().b();
                    com.alipay.apmobilesecuritysdk.e.a.b();
                    b = b((Map) map);
                    i2 = 2;
                    if (b != null) {
                        if (b.a) {
                            if (com.alipay.b.a.a.a.a.a(b.c)) {
                                i2 = 1;
                            }
                        } else if ("APPKEY_ERROR".equals(b.b)) {
                            i2 = 3;
                        }
                    }
                    if (i2 != 1) {
                        if (i2 != 3) {
                            if (b != null) {
                                stringBuilder = new StringBuilder("Server error, result:");
                                stringBuilder.append(b.b);
                                a2 = stringBuilder.toString();
                            } else {
                                a2 = "Server error, returned null";
                            }
                            com.alipay.apmobilesecuritysdk.c.a.a(a2);
                            if (com.alipay.b.a.a.a.a.a(a(this.a, a4))) {
                                i3 = 4;
                            }
                        } else {
                            i3 = 1;
                        }
                        this.c = i3;
                        a3 = com.alipay.b.a.a.c.d.a(this.a, this.b.c());
                        context = this.a;
                        networkInfo = null;
                        connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager != null) {
                            networkInfo = connectivityManager.getActiveNetworkInfo();
                        }
                        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
                            i4 = 1;
                        }
                        if (i4 != 0 && h.b(context)) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(context.getFilesDir().getAbsolutePath());
                            stringBuilder2.append("/log/ap");
                            new com.alipay.b.a.a.e.b(stringBuilder2.toString(), a3).a();
                        }
                        return this.c;
                    }
                    h.a(this.a, "1".equals(b.h));
                    h.b(this.a, b.j == null ? "0" : b.j);
                    i.c(e.b(this.a, map));
                    i.a(a4, b.d);
                    i.b(b.c);
                    i.d(b.e);
                    a = com.alipay.b.a.a.a.a.a(map, com.alipay.sdk.cons.b.c, "");
                    if (com.alipay.b.a.a.a.a.b(a) || com.alipay.b.a.a.a.a.a(a, i.d())) {
                        a = i.d();
                    } else {
                        i.e(a);
                    }
                    i.e(a);
                    a2 = com.alipay.b.a.a.a.a.a(map, "utdid", "");
                    if (com.alipay.b.a.a.a.a.b(a2) || com.alipay.b.a.a.a.a.a(a2, i.e())) {
                        a2 = i.e();
                    } else {
                        i.f(a2);
                    }
                    i.f(a2);
                    i.a();
                    d.a(this.a, i.g());
                    d.a();
                    com.alipay.apmobilesecuritysdk.f.a.a(this.a, new com.alipay.apmobilesecuritysdk.f.b(i.b(), i.c(), i.f()));
                    com.alipay.apmobilesecuritysdk.f.a.a();
                    g.a(this.a, a4, i.a(a4));
                    g.a();
                    h.a(this.a, a4, System.currentTimeMillis());
                }
                i3 = 0;
                this.c = i3;
                a3 = com.alipay.b.a.a.c.d.a(this.a, this.b.c());
                context = this.a;
                networkInfo = null;
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                }
                i4 = 1;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(context.getFilesDir().getAbsolutePath());
                stringBuilder2.append("/log/ap");
                new com.alipay.b.a.a.e.b(stringBuilder2.toString(), a3).a();
                return this.c;
            }
            i = 1;
            if (i != 0) {
                com.alipay.apmobilesecuritysdk.b.a.a().b();
                com.alipay.apmobilesecuritysdk.e.a.b();
                b = b((Map) map);
                i2 = 2;
                if (b != null) {
                    if (b.a) {
                        if (com.alipay.b.a.a.a.a.a(b.c)) {
                            i2 = 1;
                        }
                    } else if ("APPKEY_ERROR".equals(b.b)) {
                        i2 = 3;
                    }
                }
                if (i2 != 1) {
                    if (i2 != 3) {
                        if (b != null) {
                            stringBuilder = new StringBuilder("Server error, result:");
                            stringBuilder.append(b.b);
                            a2 = stringBuilder.toString();
                        } else {
                            a2 = "Server error, returned null";
                        }
                        com.alipay.apmobilesecuritysdk.c.a.a(a2);
                        if (com.alipay.b.a.a.a.a.a(a(this.a, a4))) {
                            i3 = 4;
                        }
                    } else {
                        i3 = 1;
                    }
                    this.c = i3;
                    a3 = com.alipay.b.a.a.c.d.a(this.a, this.b.c());
                    context = this.a;
                    networkInfo = null;
                    connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        networkInfo = connectivityManager.getActiveNetworkInfo();
                    }
                    i4 = 1;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(context.getFilesDir().getAbsolutePath());
                    stringBuilder2.append("/log/ap");
                    new com.alipay.b.a.a.e.b(stringBuilder2.toString(), a3).a();
                    return this.c;
                }
                h.a(this.a, "1".equals(b.h));
                if (b.j == null) {
                }
                h.b(this.a, b.j == null ? "0" : b.j);
                i.c(e.b(this.a, map));
                i.a(a4, b.d);
                i.b(b.c);
                i.d(b.e);
                a = com.alipay.b.a.a.a.a.a(map, com.alipay.sdk.cons.b.c, "");
                if (com.alipay.b.a.a.a.a.b(a)) {
                }
                a = i.d();
                i.e(a);
                a2 = com.alipay.b.a.a.a.a.a(map, "utdid", "");
                if (com.alipay.b.a.a.a.a.b(a2)) {
                }
                a2 = i.e();
                i.f(a2);
                i.a();
                d.a(this.a, i.g());
                d.a();
                com.alipay.apmobilesecuritysdk.f.a.a(this.a, new com.alipay.apmobilesecuritysdk.f.b(i.b(), i.c(), i.f()));
                com.alipay.apmobilesecuritysdk.f.a.a();
                g.a(this.a, a4, i.a(a4));
                g.a();
                h.a(this.a, a4, System.currentTimeMillis());
            }
            i3 = 0;
            this.c = i3;
            a3 = com.alipay.b.a.a.c.d.a(this.a, this.b.c());
            context = this.a;
            networkInfo = null;
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            i4 = 1;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context.getFilesDir().getAbsolutePath());
            stringBuilder2.append("/log/ap");
            new com.alipay.b.a.a.e.b(stringBuilder2.toString(), a3).a();
        } catch (Throwable e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        return this.c;
    }
}
