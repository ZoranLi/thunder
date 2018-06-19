package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.c;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.e;
import com.alipay.sdk.widget.a;

public class AuthTask {
    static final Object a = e.class;
    private static final int b = 73;
    private Activity c;
    private a d;

    public AuthTask(Activity activity) {
        this.c = activity;
        b a = b.a();
        Context context = this.c;
        c.a();
        a.a(context);
        com.alipay.sdk.app.statistic.a.a(activity);
        this.d = new a(activity, a.c);
    }

    private e.a a() {
        return new a(this);
    }

    private void b() {
        if (this.d != null) {
            this.d.a();
        }
    }

    private void c() {
        if (this.d != null) {
            this.d.b();
        }
    }

    public synchronized java.lang.String auth(java.lang.String r5, boolean r6) {
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
        r4 = this;
        monitor-enter(r4);
        if (r6 == 0) goto L_0x000a;
    L_0x0003:
        r4.b();	 Catch:{ all -> 0x0007 }
        goto L_0x000a;	 Catch:{ all -> 0x0007 }
    L_0x0007:
        r5 = move-exception;	 Catch:{ all -> 0x0007 }
        goto L_0x008b;	 Catch:{ all -> 0x0007 }
    L_0x000a:
        r6 = com.alipay.sdk.sys.b.a();	 Catch:{ all -> 0x0007 }
        r0 = r4.c;	 Catch:{ all -> 0x0007 }
        com.alipay.sdk.data.c.a();	 Catch:{ all -> 0x0007 }
        r6.a(r0);	 Catch:{ all -> 0x0007 }
        r6 = com.alipay.sdk.app.h.a();	 Catch:{ all -> 0x0007 }
        r0 = r4.c;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r1 = new com.alipay.sdk.sys.a;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r2 = r4.c;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r1 = r1.a(r5);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r2 = a(r0);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        if (r2 == 0) goto L_0x0050;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
    L_0x002d:
        r2 = new com.alipay.sdk.util.e;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r3 = new com.alipay.sdk.app.a;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r2.<init>(r0, r3);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r2 = r2.a(r1);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r3 = "failed";	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        r3 = android.text.TextUtils.equals(r2, r3);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        if (r3 != 0) goto L_0x0050;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
    L_0x0043:
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        if (r0 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
    L_0x0049:
        r0 = com.alipay.sdk.app.h.a();	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        goto L_0x0054;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
    L_0x004e:
        r6 = r2;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
        goto L_0x0055;	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
    L_0x0050:
        r0 = r4.b(r0, r1);	 Catch:{ Exception -> 0x007a, all -> 0x0067 }
    L_0x0054:
        r6 = r0;
    L_0x0055:
        r0 = com.alipay.sdk.data.a.b();	 Catch:{ all -> 0x0007 }
        r1 = r4.c;	 Catch:{ all -> 0x0007 }
        r0.a(r1);	 Catch:{ all -> 0x0007 }
        r4.c();	 Catch:{ all -> 0x0007 }
        r0 = r4.c;	 Catch:{ all -> 0x0007 }
    L_0x0063:
        com.alipay.sdk.app.statistic.a.a(r0, r5);	 Catch:{ all -> 0x0007 }
        goto L_0x0089;	 Catch:{ all -> 0x0007 }
    L_0x0067:
        r6 = move-exception;	 Catch:{ all -> 0x0007 }
        r0 = com.alipay.sdk.data.a.b();	 Catch:{ all -> 0x0007 }
        r1 = r4.c;	 Catch:{ all -> 0x0007 }
        r0.a(r1);	 Catch:{ all -> 0x0007 }
        r4.c();	 Catch:{ all -> 0x0007 }
        r0 = r4.c;	 Catch:{ all -> 0x0007 }
        com.alipay.sdk.app.statistic.a.a(r0, r5);	 Catch:{ all -> 0x0007 }
        throw r6;	 Catch:{ all -> 0x0007 }
    L_0x007a:
        r0 = com.alipay.sdk.data.a.b();	 Catch:{ all -> 0x0007 }
        r1 = r4.c;	 Catch:{ all -> 0x0007 }
        r0.a(r1);	 Catch:{ all -> 0x0007 }
        r4.c();	 Catch:{ all -> 0x0007 }
        r0 = r4.c;	 Catch:{ all -> 0x0007 }
        goto L_0x0063;
    L_0x0089:
        monitor-exit(r4);
        return r6;
    L_0x008b:
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.auth(java.lang.String, boolean):java.lang.String");
    }

    private String a(Activity activity, String str) {
        str = new com.alipay.sdk.sys.a(this.c).a(str);
        if (!a((Context) activity)) {
            return b(activity, str);
        }
        Object a = new e(activity, new a(this)).a(str);
        if (TextUtils.equals(a, e.b)) {
            return b(activity, str);
        }
        return TextUtils.isEmpty(a) != null ? h.a() : a;
    }

    private String b(Activity activity, String str) {
        b();
        try {
            activity = com.alipay.sdk.protocol.b.a(new com.alipay.sdk.packet.impl.a().a((Context) activity, str).a().optJSONObject(com.alipay.sdk.cons.c.c).optJSONObject(com.alipay.sdk.cons.c.d));
            c();
            for (str = null; str < activity.size(); str++) {
                if (((com.alipay.sdk.protocol.b) activity.get(str)).a == com.alipay.sdk.protocol.a.WapPay) {
                    activity = a((com.alipay.sdk.protocol.b) activity.get(str));
                    c();
                    return activity;
                }
            }
        } catch (Throwable e) {
            str = i.a(i.NETWORK_ERROR.h);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.a, e);
            c();
            activity = str;
        } catch (Throwable th) {
            c();
        }
        c();
        activity = null;
        if (activity == null) {
            activity = i.a(i.FAILED.h);
        }
        return h.a(activity.h, activity.i, "");
    }

    private java.lang.String a(com.alipay.sdk.protocol.b r4) {
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
        r3 = this;
        r4 = r4.b;
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = 0;
        r4 = r4[r1];
        r1 = "url";
        r0.putString(r1, r4);
        r4 = new android.content.Intent;
        r1 = r3.c;
        r2 = com.alipay.sdk.app.H5AuthActivity.class;
        r4.<init>(r1, r2);
        r4.putExtras(r0);
        r0 = r3.c;
        r0.startActivity(r4);
        r4 = a;
        monitor-enter(r4);
        r0 = a;	 Catch:{ InterruptedException -> 0x0038 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0038 }
        monitor-exit(r4);
        r4 = com.alipay.sdk.app.h.a;
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0035;
    L_0x0031:
        r4 = com.alipay.sdk.app.h.a();
    L_0x0035:
        return r4;
    L_0x0036:
        r0 = move-exception;
        goto L_0x003e;
    L_0x0038:
        r0 = com.alipay.sdk.app.h.a();	 Catch:{ all -> 0x0036 }
        monitor-exit(r4);	 Catch:{ all -> 0x0036 }
        return r0;
    L_0x003e:
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.a(com.alipay.sdk.protocol.b):java.lang.String");
    }

    private static boolean a(android.content.Context r3) {
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
        r0 = 0;
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0019 }
        r1 = "com.eg.android.AlipayGphone";	 Catch:{ NameNotFoundException -> 0x0019 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0019 }
        r3 = r3.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r3 != 0) goto L_0x0010;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x000f:
        return r0;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0010:
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x0019 }
        r1 = 73;
        if (r3 >= r1) goto L_0x0017;
    L_0x0016:
        return r0;
    L_0x0017:
        r3 = 1;
        return r3;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.a(android.content.Context):boolean");
    }
}
