package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.statistic.c;

public class e {
    public static final String b = "failed";
    public Activity a;
    private IAlixPay c;
    private final Object d = IAlixPay.class;
    private boolean e;
    private a f;
    private ServiceConnection g = new f(this);
    private IRemoteServiceCallback h = new g(this);

    public interface a {
        void a();
    }

    public e(Activity activity, a aVar) {
        this.a = activity;
        this.f = aVar;
    }

    public final String a(String str) {
        try {
            com.alipay.sdk.util.k.a a = k.a(this.a, k.b);
            if (a.a()) {
                return b;
            }
            if (a != null) {
                if (a.b > 78) {
                    Intent intent = new Intent();
                    intent.setClassName(k.b, "com.alipay.android.app.TransProcessPayActivity");
                    this.a.startActivity(intent);
                    Thread.sleep(200);
                }
            }
            return b(str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", c.B, th);
        }
    }

    private void a(com.alipay.sdk.util.k.a aVar) throws InterruptedException {
        if (aVar != null) {
            if (aVar.b > 78) {
                aVar = new Intent();
                aVar.setClassName(k.b, "com.alipay.android.app.TransProcessPayActivity");
                this.a.startActivity(aVar);
                Thread.sleep(200);
            }
        }
    }

    private java.lang.String b(java.lang.String r8) {
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
        r7 = this;
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "com.eg.android.AlipayGphone";
        r0.setPackage(r1);
        r1 = "com.eg.android.AlipayGphone.IAlixPay";
        r0.setAction(r1);
        r1 = r7.a;
        r1 = com.alipay.sdk.util.k.g(r1);
        r2 = r7.a;	 Catch:{ Throwable -> 0x012d }
        r2 = r2.getApplicationContext();	 Catch:{ Throwable -> 0x012d }
        r3 = r7.g;	 Catch:{ Throwable -> 0x012d }
        r4 = 1;	 Catch:{ Throwable -> 0x012d }
        r2.bindService(r0, r3, r4);	 Catch:{ Throwable -> 0x012d }
        r0 = r7.d;
        monitor-enter(r0);
        r2 = r7.c;	 Catch:{ all -> 0x012a }
        if (r2 != 0) goto L_0x003f;
    L_0x0028:
        r2 = r7.d;	 Catch:{ InterruptedException -> 0x0037 }
        r3 = com.alipay.sdk.data.a.b();	 Catch:{ InterruptedException -> 0x0037 }
        r3 = r3.a();	 Catch:{ InterruptedException -> 0x0037 }
        r5 = (long) r3;	 Catch:{ InterruptedException -> 0x0037 }
        r2.wait(r5);	 Catch:{ InterruptedException -> 0x0037 }
        goto L_0x003f;
    L_0x0037:
        r2 = move-exception;
        r3 = "biz";	 Catch:{ all -> 0x012a }
        r5 = "BindWaitTimeoutEx";	 Catch:{ all -> 0x012a }
        com.alipay.sdk.app.statistic.a.a(r3, r5, r2);	 Catch:{ all -> 0x012a }
    L_0x003f:
        monitor-exit(r0);	 Catch:{ all -> 0x012a }
        r0 = 0;
        r2 = 0;
        r3 = r7.c;	 Catch:{ Throwable -> 0x00de }
        if (r3 != 0) goto L_0x0097;	 Catch:{ Throwable -> 0x00de }
    L_0x0046:
        r8 = r7.a;	 Catch:{ Throwable -> 0x00de }
        r8 = com.alipay.sdk.util.k.g(r8);	 Catch:{ Throwable -> 0x00de }
        r3 = r7.a;	 Catch:{ Throwable -> 0x00de }
        r3 = com.alipay.sdk.util.k.h(r3);	 Catch:{ Throwable -> 0x00de }
        r4 = "biz";	 Catch:{ Throwable -> 0x00de }
        r5 = "ClientBindFailed";	 Catch:{ Throwable -> 0x00de }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r6.<init>();	 Catch:{ Throwable -> 0x00de }
        r6.append(r1);	 Catch:{ Throwable -> 0x00de }
        r1 = "|";	 Catch:{ Throwable -> 0x00de }
        r6.append(r1);	 Catch:{ Throwable -> 0x00de }
        r6.append(r8);	 Catch:{ Throwable -> 0x00de }
        r8 = "|";	 Catch:{ Throwable -> 0x00de }
        r6.append(r8);	 Catch:{ Throwable -> 0x00de }
        r6.append(r3);	 Catch:{ Throwable -> 0x00de }
        r8 = r6.toString();	 Catch:{ Throwable -> 0x00de }
        com.alipay.sdk.app.statistic.a.a(r4, r5, r8);	 Catch:{ Throwable -> 0x00de }
        r8 = "failed";	 Catch:{ Throwable -> 0x00de }
        r1 = r7.c;	 Catch:{ Throwable -> 0x007e }
        r3 = r7.h;	 Catch:{ Throwable -> 0x007e }
        r1.unregisterCallback(r3);	 Catch:{ Throwable -> 0x007e }
    L_0x007e:
        r1 = r7.a;	 Catch:{ Throwable -> 0x0085 }
        r3 = r7.g;	 Catch:{ Throwable -> 0x0085 }
        r1.unbindService(r3);	 Catch:{ Throwable -> 0x0085 }
    L_0x0085:
        r7.h = r2;
        r7.g = r2;
        r7.c = r2;
        r1 = r7.e;
        if (r1 == 0) goto L_0x0096;
    L_0x008f:
        r1 = r7.a;
        r1.setRequestedOrientation(r0);
        r7.e = r0;
    L_0x0096:
        return r8;
    L_0x0097:
        r1 = r7.f;	 Catch:{ Throwable -> 0x00de }
        if (r1 == 0) goto L_0x00a0;	 Catch:{ Throwable -> 0x00de }
    L_0x009b:
        r1 = r7.f;	 Catch:{ Throwable -> 0x00de }
        r1.a();	 Catch:{ Throwable -> 0x00de }
    L_0x00a0:
        r1 = r7.a;	 Catch:{ Throwable -> 0x00de }
        r1 = r1.getRequestedOrientation();	 Catch:{ Throwable -> 0x00de }
        if (r1 != 0) goto L_0x00af;	 Catch:{ Throwable -> 0x00de }
    L_0x00a8:
        r1 = r7.a;	 Catch:{ Throwable -> 0x00de }
        r1.setRequestedOrientation(r4);	 Catch:{ Throwable -> 0x00de }
        r7.e = r4;	 Catch:{ Throwable -> 0x00de }
    L_0x00af:
        r1 = r7.c;	 Catch:{ Throwable -> 0x00de }
        r3 = r7.h;	 Catch:{ Throwable -> 0x00de }
        r1.registerCallback(r3);	 Catch:{ Throwable -> 0x00de }
        r1 = r7.c;	 Catch:{ Throwable -> 0x00de }
        r8 = r1.Pay(r8);	 Catch:{ Throwable -> 0x00de }
        r1 = r7.c;	 Catch:{ Throwable -> 0x00c3 }
        r3 = r7.h;	 Catch:{ Throwable -> 0x00c3 }
        r1.unregisterCallback(r3);	 Catch:{ Throwable -> 0x00c3 }
    L_0x00c3:
        r1 = r7.a;	 Catch:{ Throwable -> 0x00ca }
        r3 = r7.g;	 Catch:{ Throwable -> 0x00ca }
        r1.unbindService(r3);	 Catch:{ Throwable -> 0x00ca }
    L_0x00ca:
        r7.h = r2;
        r7.g = r2;
        r7.c = r2;
        r1 = r7.e;
        if (r1 == 0) goto L_0x00db;
    L_0x00d4:
        r1 = r7.a;
        r1.setRequestedOrientation(r0);
        r7.e = r0;
    L_0x00db:
        return r8;
    L_0x00dc:
        r8 = move-exception;
        goto L_0x010a;
    L_0x00de:
        r8 = move-exception;
        r1 = "biz";	 Catch:{ all -> 0x00dc }
        r3 = "ClientBindException";	 Catch:{ all -> 0x00dc }
        com.alipay.sdk.app.statistic.a.a(r1, r3, r8);	 Catch:{ all -> 0x00dc }
        r8 = com.alipay.sdk.app.h.a();	 Catch:{ all -> 0x00dc }
        r1 = r7.c;	 Catch:{ Throwable -> 0x00f1 }
        r3 = r7.h;	 Catch:{ Throwable -> 0x00f1 }
        r1.unregisterCallback(r3);	 Catch:{ Throwable -> 0x00f1 }
    L_0x00f1:
        r1 = r7.a;	 Catch:{ Throwable -> 0x00f8 }
        r3 = r7.g;	 Catch:{ Throwable -> 0x00f8 }
        r1.unbindService(r3);	 Catch:{ Throwable -> 0x00f8 }
    L_0x00f8:
        r7.h = r2;
        r7.g = r2;
        r7.c = r2;
        r1 = r7.e;
        if (r1 == 0) goto L_0x0109;
    L_0x0102:
        r1 = r7.a;
        r1.setRequestedOrientation(r0);
        r7.e = r0;
    L_0x0109:
        return r8;
    L_0x010a:
        r1 = r7.c;	 Catch:{ Throwable -> 0x0111 }
        r3 = r7.h;	 Catch:{ Throwable -> 0x0111 }
        r1.unregisterCallback(r3);	 Catch:{ Throwable -> 0x0111 }
    L_0x0111:
        r1 = r7.a;	 Catch:{ Throwable -> 0x0118 }
        r3 = r7.g;	 Catch:{ Throwable -> 0x0118 }
        r1.unbindService(r3);	 Catch:{ Throwable -> 0x0118 }
    L_0x0118:
        r7.h = r2;
        r7.g = r2;
        r7.c = r2;
        r1 = r7.e;
        if (r1 == 0) goto L_0x0129;
    L_0x0122:
        r1 = r7.a;
        r1.setRequestedOrientation(r0);
        r7.e = r0;
    L_0x0129:
        throw r8;
    L_0x012a:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
    L_0x012d:
        r8 = move-exception;
        r0 = "biz";
        r1 = "ClientBindServiceFailed";
        com.alipay.sdk.app.statistic.a.a(r0, r1, r8);
        r8 = "failed";
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.e.b(java.lang.String):java.lang.String");
    }

    private void a() {
        this.a = null;
    }
}
