package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.smtt.utils.TbsLog;
import com.xiaomi.push.service.av;

/* compiled from: BUGLY */
public class NativeCrashHandler implements a {
    private static NativeCrashHandler a = null;
    private static boolean l = false;
    private static boolean m = false;
    private final Context b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final am d;
    private NativeExceptionHandler e;
    private String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private b n;

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i, String str);

    protected native void testCrash();

    protected native String unregist();

    private static void a(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "[Native] Check extra jni for Bugly NDK v%s";
        r1 = 1;
        r2 = new java.lang.Object[r1];
        r3 = 0;
        r2[r3] = r6;
        com.tencent.bugly.proguard.an.c(r0, r2);
        r0 = "2.1.1";
        r2 = ".";
        r4 = "";
        r0 = r0.replace(r2, r4);
        r2 = "2.3.0";
        r4 = ".";
        r5 = "";
        r2 = r2.replace(r4, r5);
        r4 = ".";
        r5 = "";
        r6 = r6.replace(r4, r5);
        r4 = r6.length();
        r5 = 2;
        if (r4 != r5) goto L_0x0040;
    L_0x002e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r6);
        r6 = "0";
        r4.append(r6);
        r6 = r4.toString();
        goto L_0x0057;
    L_0x0040:
        r4 = r6.length();
        if (r4 != r1) goto L_0x0057;
    L_0x0046:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r6);
        r6 = "00";
        r4.append(r6);
        r6 = r4.toString();
    L_0x0057:
        r4 = java.lang.Integer.parseInt(r6);	 Catch:{ Throwable -> 0x006f }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x006f }
        if (r4 < r0) goto L_0x0063;	 Catch:{ Throwable -> 0x006f }
    L_0x0061:
        l = r1;	 Catch:{ Throwable -> 0x006f }
    L_0x0063:
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Throwable -> 0x006f }
        r0 = java.lang.Integer.parseInt(r2);	 Catch:{ Throwable -> 0x006f }
        if (r6 < r0) goto L_0x006f;	 Catch:{ Throwable -> 0x006f }
    L_0x006d:
        m = r1;	 Catch:{ Throwable -> 0x006f }
    L_0x006f:
        r6 = m;
        if (r6 == 0) goto L_0x007b;
    L_0x0073:
        r6 = "[Native] Info setting jni can be accessed.";
        r0 = new java.lang.Object[r3];
        com.tencent.bugly.proguard.an.a(r6, r0);
        goto L_0x0082;
    L_0x007b:
        r6 = "[Native] Info setting jni can not be accessed.";
        r0 = new java.lang.Object[r3];
        com.tencent.bugly.proguard.an.d(r6, r0);
    L_0x0082:
        r6 = l;
        if (r6 == 0) goto L_0x008e;
    L_0x0086:
        r6 = "[Native] Extra jni can be accessed.";
        r0 = new java.lang.Object[r3];
        com.tencent.bugly.proguard.an.a(r6, r0);
        return;
    L_0x008e:
        r6 = "[Native] Extra jni can not be accessed.";
        r0 = new java.lang.Object[r3];
        com.tencent.bugly.proguard.an.d(r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(java.lang.String):void");
    }

    @android.annotation.SuppressLint({"SdCardPath"})
    protected NativeCrashHandler(android.content.Context r2, com.tencent.bugly.crashreport.common.info.a r3, com.tencent.bugly.crashreport.crash.b r4, com.tencent.bugly.crashreport.common.strategy.a r5, com.tencent.bugly.proguard.am r6, boolean r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.<init>();
        r5 = 0;
        r1.h = r5;
        r1.i = r5;
        r1.j = r5;
        r1.k = r5;
        r0 = com.tencent.bugly.proguard.ap.a(r2);
        r1.b = r0;
        r0 = com.tencent.bugly.proguard.ap.a(r8);	 Catch:{ Throwable -> 0x0024 }
        if (r0 != 0) goto L_0x0019;	 Catch:{ Throwable -> 0x0024 }
    L_0x0018:
        goto L_0x003d;	 Catch:{ Throwable -> 0x0024 }
    L_0x0019:
        r8 = "bugly";	 Catch:{ Throwable -> 0x0024 }
        r5 = r2.getDir(r8, r5);	 Catch:{ Throwable -> 0x0024 }
        r8 = r5.getAbsolutePath();	 Catch:{ Throwable -> 0x0024 }
        goto L_0x003d;
    L_0x0024:
        r5 = com.tencent.bugly.crashreport.common.info.a.a(r2);
        r5 = r5.d;
        r8 = new java.lang.StringBuilder;
        r0 = "/data/data/";
        r8.<init>(r0);
        r8.append(r5);
        r5 = "/app_bugly";
        r8.append(r5);
        r8 = r8.toString();
    L_0x003d:
        r1.n = r4;
        r1.f = r8;
        r1.c = r3;
        r1.d = r6;
        r1.g = r7;
        r5 = new com.tencent.bugly.crashreport.crash.jni.a;
        r6 = com.tencent.bugly.crashreport.common.strategy.a.a();
        r5.<init>(r2, r3, r4, r6);
        r1.e = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.<init>(android.content.Context, com.tencent.bugly.crashreport.common.info.a, com.tencent.bugly.crashreport.crash.b, com.tencent.bugly.crashreport.common.strategy.a, com.tencent.bugly.proguard.am, boolean, java.lang.String):void");
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, am amVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (a == null) {
                }
                nativeCrashHandler = a;
            } finally {
                Object obj = r0;
            }
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f = str;
    }

    protected synchronized void a(boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r10.j;	 Catch:{ all -> 0x0108 }
        r1 = 0;	 Catch:{ all -> 0x0108 }
        if (r0 == 0) goto L_0x000f;	 Catch:{ all -> 0x0108 }
    L_0x0006:
        r11 = "[Native] Native crash report has already registered.";	 Catch:{ all -> 0x0108 }
        r0 = new java.lang.Object[r1];	 Catch:{ all -> 0x0108 }
        com.tencent.bugly.proguard.an.d(r11, r0);	 Catch:{ all -> 0x0108 }
        monitor-exit(r10);
        return;
    L_0x000f:
        r0 = r10.i;	 Catch:{ all -> 0x0108 }
        r2 = 1;
        if (r0 == 0) goto L_0x0037;
    L_0x0014:
        r0 = r10.f;	 Catch:{ Throwable -> 0x002e }
        r11 = r10.regist(r0, r11, r2);	 Catch:{ Throwable -> 0x002e }
        if (r11 == 0) goto L_0x0102;	 Catch:{ Throwable -> 0x002e }
    L_0x001c:
        r0 = "[Native] Native Crash Report enable.";	 Catch:{ Throwable -> 0x002e }
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x002e }
        com.tencent.bugly.proguard.an.a(r0, r3);	 Catch:{ Throwable -> 0x002e }
        a(r11);	 Catch:{ Throwable -> 0x002e }
        r0 = r10.c;	 Catch:{ Throwable -> 0x002e }
        r0.s = r11;	 Catch:{ Throwable -> 0x002e }
        r10.j = r2;	 Catch:{ Throwable -> 0x002e }
        monitor-exit(r10);
        return;
    L_0x002e:
        r11 = "[Native] Failed to load Bugly SO file.";	 Catch:{ all -> 0x0108 }
        r0 = new java.lang.Object[r1];	 Catch:{ all -> 0x0108 }
        com.tencent.bugly.proguard.an.c(r11, r0);	 Catch:{ all -> 0x0108 }
        goto L_0x0102;	 Catch:{ all -> 0x0108 }
    L_0x0037:
        r0 = r10.h;	 Catch:{ all -> 0x0108 }
        if (r0 == 0) goto L_0x0102;
    L_0x003b:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ Throwable -> 0x0102 }
        r3 = "registNativeExceptionHandler2";	 Catch:{ Throwable -> 0x0102 }
        r4 = 4;	 Catch:{ Throwable -> 0x0102 }
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0102 }
        r6 = java.lang.String.class;	 Catch:{ Throwable -> 0x0102 }
        r5[r1] = r6;	 Catch:{ Throwable -> 0x0102 }
        r6 = java.lang.String.class;	 Catch:{ Throwable -> 0x0102 }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x0102 }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0102 }
        r7 = 2;	 Catch:{ Throwable -> 0x0102 }
        r5[r7] = r6;	 Catch:{ Throwable -> 0x0102 }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0102 }
        r8 = 3;	 Catch:{ Throwable -> 0x0102 }
        r5[r8] = r6;	 Catch:{ Throwable -> 0x0102 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0102 }
        r6 = r10.f;	 Catch:{ Throwable -> 0x0102 }
        r4[r1] = r6;	 Catch:{ Throwable -> 0x0102 }
        r6 = com.tencent.bugly.crashreport.common.info.b.a(r1);	 Catch:{ Throwable -> 0x0102 }
        r4[r2] = r6;	 Catch:{ Throwable -> 0x0102 }
        r6 = 5;	 Catch:{ Throwable -> 0x0102 }
        if (r11 == 0) goto L_0x0065;	 Catch:{ Throwable -> 0x0102 }
    L_0x0063:
        r9 = r2;	 Catch:{ Throwable -> 0x0102 }
        goto L_0x0066;	 Catch:{ Throwable -> 0x0102 }
    L_0x0065:
        r9 = r6;	 Catch:{ Throwable -> 0x0102 }
    L_0x0066:
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0102 }
        r4[r7] = r9;	 Catch:{ Throwable -> 0x0102 }
        r9 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x0102 }
        r4[r8] = r9;	 Catch:{ Throwable -> 0x0102 }
        r9 = 0;	 Catch:{ Throwable -> 0x0102 }
        r0 = com.tencent.bugly.proguard.ap.a(r0, r3, r9, r5, r4);	 Catch:{ Throwable -> 0x0102 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0102 }
        if (r0 != 0) goto L_0x00ad;	 Catch:{ Throwable -> 0x0102 }
    L_0x007b:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ Throwable -> 0x0102 }
        r3 = "registNativeExceptionHandler";	 Catch:{ Throwable -> 0x0102 }
        r4 = new java.lang.Class[r8];	 Catch:{ Throwable -> 0x0102 }
        r5 = java.lang.String.class;	 Catch:{ Throwable -> 0x0102 }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x0102 }
        r5 = java.lang.String.class;	 Catch:{ Throwable -> 0x0102 }
        r4[r2] = r5;	 Catch:{ Throwable -> 0x0102 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0102 }
        r4[r7] = r5;	 Catch:{ Throwable -> 0x0102 }
        r5 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0102 }
        r8 = r10.f;	 Catch:{ Throwable -> 0x0102 }
        r5[r1] = r8;	 Catch:{ Throwable -> 0x0102 }
        r8 = com.tencent.bugly.crashreport.common.info.b.a(r1);	 Catch:{ Throwable -> 0x0102 }
        r5[r2] = r8;	 Catch:{ Throwable -> 0x0102 }
        r8 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ Throwable -> 0x0102 }
        r8 = r8.L();	 Catch:{ Throwable -> 0x0102 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x0102 }
        r5[r7] = r8;	 Catch:{ Throwable -> 0x0102 }
        r0 = com.tencent.bugly.proguard.ap.a(r0, r3, r9, r4, r5);	 Catch:{ Throwable -> 0x0102 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0102 }
    L_0x00ad:
        if (r0 == 0) goto L_0x0102;	 Catch:{ Throwable -> 0x0102 }
    L_0x00af:
        r10.j = r2;	 Catch:{ Throwable -> 0x0102 }
        r3 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ Throwable -> 0x0102 }
        r3.s = r0;	 Catch:{ Throwable -> 0x0102 }
        r3 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ Throwable -> 0x0102 }
        r4 = "checkExtraJni";	 Catch:{ Throwable -> 0x0102 }
        r5 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0102 }
        r7 = java.lang.String.class;	 Catch:{ Throwable -> 0x0102 }
        r5[r1] = r7;	 Catch:{ Throwable -> 0x0102 }
        r7 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0102 }
        r7[r1] = r0;	 Catch:{ Throwable -> 0x0102 }
        r0 = com.tencent.bugly.proguard.ap.a(r3, r4, r9, r5, r7);	 Catch:{ Throwable -> 0x0102 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Throwable -> 0x0102 }
        if (r0 == 0) goto L_0x00d3;	 Catch:{ Throwable -> 0x0102 }
    L_0x00cd:
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x0102 }
        l = r0;	 Catch:{ Throwable -> 0x0102 }
    L_0x00d3:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ Throwable -> 0x0102 }
        r3 = "enableHandler";	 Catch:{ Throwable -> 0x0102 }
        r4 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0102 }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x0102 }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x0102 }
        r5 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0102 }
        r7 = java.lang.Boolean.valueOf(r2);	 Catch:{ Throwable -> 0x0102 }
        r5[r1] = r7;	 Catch:{ Throwable -> 0x0102 }
        com.tencent.bugly.proguard.ap.a(r0, r3, r9, r4, r5);	 Catch:{ Throwable -> 0x0102 }
        if (r11 == 0) goto L_0x00eb;	 Catch:{ Throwable -> 0x0102 }
    L_0x00ea:
        r6 = r2;	 Catch:{ Throwable -> 0x0102 }
    L_0x00eb:
        r11 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ Throwable -> 0x0102 }
        r0 = "setLogMode";	 Catch:{ Throwable -> 0x0102 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0102 }
        r4 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0102 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0102 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0102 }
        r4 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0102 }
        r2[r1] = r4;	 Catch:{ Throwable -> 0x0102 }
        com.tencent.bugly.proguard.ap.a(r11, r0, r9, r3, r2);	 Catch:{ Throwable -> 0x0102 }
        monitor-exit(r10);
        return;
    L_0x0102:
        r10.i = r1;	 Catch:{ all -> 0x0108 }
        r10.h = r1;	 Catch:{ all -> 0x0108 }
        monitor-exit(r10);
        return;
    L_0x0108:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    public synchronized void startNativeMonitor() {
        if (!this.i) {
            if (!this.h) {
                String str = "Bugly";
                String str2 = "NativeRQD";
                boolean a = ap.a(this.c.r) ^ 1;
                if (c.b) {
                    if (a) {
                        str = this.c.r;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("-rqd");
                        str = stringBuilder.toString();
                    }
                    this.i = a(str, a);
                    if (!(this.i || a)) {
                        this.h = a(str2, false);
                    }
                } else {
                    str2 = this.c.r;
                    if (a) {
                        str = str2;
                    } else {
                        this.c.getClass();
                    }
                    this.i = a(str, a);
                }
                if (this.i || this.h) {
                    a(this.g);
                    this.d.a(new Runnable(this) {
                        final /* synthetic */ NativeCrashHandler a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            if (ap.a(this.a.b, "native_record_lock", 10000)) {
                                try {
                                    this.a.setNativeAppVersion(this.a.c.o);
                                    this.a.setNativeAppChannel(this.a.c.q);
                                    this.a.setNativeAppPackage(this.a.c.d);
                                    this.a.setNativeUserId(this.a.c.g());
                                    this.a.setNativeIsAppForeground(this.a.c.a());
                                    this.a.setNativeLaunchTime(this.a.c.a);
                                } catch (Throwable th) {
                                    if (!an.a(th)) {
                                        th.printStackTrace();
                                    }
                                }
                                CrashDetailBean a = b.a(this.a.b, this.a.f, this.a.e);
                                if (a != null) {
                                    an.a("[Native] Get crash from native record.", new Object[0]);
                                    if (!this.a.n.a(a)) {
                                        this.a.n.a(a, 3000, false);
                                    }
                                    b.a(false, this.a.f);
                                }
                                this.a.b();
                                ap.b(this.a.b, "native_record_lock");
                                return;
                            }
                            an.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                        }
                    });
                    return;
                }
                return;
            }
        }
        a(this.g);
    }

    private boolean a(String str, boolean z) {
        boolean z2;
        try {
            an.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                an.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                z = th;
                z2 = true;
                an.d(z.getMessage(), new Object[0]);
                an.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            z = th2;
            z2 = false;
            an.d(z.getMessage(), new Object[0]);
            an.d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    protected synchronized void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.j;	 Catch:{ all -> 0x0056 }
        r1 = 0;	 Catch:{ all -> 0x0056 }
        if (r0 != 0) goto L_0x000f;	 Catch:{ all -> 0x0056 }
    L_0x0006:
        r0 = "[Native] Native crash report has already unregistered.";	 Catch:{ all -> 0x0056 }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0056 }
        com.tencent.bugly.proguard.an.d(r0, r1);	 Catch:{ all -> 0x0056 }
        monitor-exit(r7);
        return;
    L_0x000f:
        r0 = r7.unregist();	 Catch:{ Throwable -> 0x0020 }
        if (r0 == 0) goto L_0x0027;	 Catch:{ Throwable -> 0x0020 }
    L_0x0015:
        r0 = "[Native] Successfully closed native crash report.";	 Catch:{ Throwable -> 0x0020 }
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0020 }
        com.tencent.bugly.proguard.an.a(r0, r2);	 Catch:{ Throwable -> 0x0020 }
        r7.j = r1;	 Catch:{ Throwable -> 0x0020 }
        monitor-exit(r7);
        return;
    L_0x0020:
        r0 = "[Native] Failed to close native crash report.";	 Catch:{ all -> 0x0056 }
        r2 = new java.lang.Object[r1];	 Catch:{ all -> 0x0056 }
        com.tencent.bugly.proguard.an.c(r0, r2);	 Catch:{ all -> 0x0056 }
    L_0x0027:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ Throwable -> 0x0049 }
        r2 = "enableHandler";	 Catch:{ Throwable -> 0x0049 }
        r3 = 0;	 Catch:{ Throwable -> 0x0049 }
        r4 = 1;	 Catch:{ Throwable -> 0x0049 }
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0049 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x0049 }
        r5[r1] = r6;	 Catch:{ Throwable -> 0x0049 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0049 }
        r6 = java.lang.Boolean.valueOf(r1);	 Catch:{ Throwable -> 0x0049 }
        r4[r1] = r6;	 Catch:{ Throwable -> 0x0049 }
        com.tencent.bugly.proguard.ap.a(r0, r2, r3, r5, r4);	 Catch:{ Throwable -> 0x0049 }
        r7.j = r1;	 Catch:{ Throwable -> 0x0049 }
        r0 = "[Native] Successfully closed native crash report.";	 Catch:{ Throwable -> 0x0049 }
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0049 }
        com.tencent.bugly.proguard.an.a(r0, r2);	 Catch:{ Throwable -> 0x0049 }
        monitor-exit(r7);
        return;
    L_0x0049:
        r0 = "[Native] Failed to close native crash report.";	 Catch:{ all -> 0x0056 }
        r2 = new java.lang.Object[r1];	 Catch:{ all -> 0x0056 }
        com.tencent.bugly.proguard.an.c(r0, r2);	 Catch:{ all -> 0x0056 }
        r7.i = r1;	 Catch:{ all -> 0x0056 }
        r7.h = r1;	 Catch:{ all -> 0x0056 }
        monitor-exit(r7);
        return;
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a():void");
    }

    public void testNativeCrash() {
        if (this.i) {
            testCrash();
        } else {
            an.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.e;
    }

    protected void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r15 = this;
        r0 = com.tencent.bugly.proguard.ap.b();
        r2 = com.tencent.bugly.crashreport.crash.c.g;
        r4 = r0 - r2;
        r0 = new java.io.File;
        r1 = r15.f;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x0076;
    L_0x0015:
        r1 = r0.isDirectory();
        if (r1 == 0) goto L_0x0076;
    L_0x001b:
        r0 = r0.listFiles();
        if (r0 == 0) goto L_0x0075;
    L_0x0021:
        r1 = r0.length;
        if (r1 != 0) goto L_0x0025;
    L_0x0024:
        goto L_0x0075;
    L_0x0025:
        r1 = "tomb_";
        r2 = ".txt";
        r3 = r1.length();
        r6 = 0;
        r7 = r0.length;
        r8 = r6;
        r9 = r8;
    L_0x0031:
        r10 = 1;
        if (r8 >= r7) goto L_0x0067;
    L_0x0034:
        r11 = r0[r8];
        r12 = r11.getName();
        r13 = r12.startsWith(r1);
        if (r13 == 0) goto L_0x0064;
    L_0x0040:
        r13 = r12.indexOf(r2);	 Catch:{ Throwable -> 0x0053 }
        if (r13 <= 0) goto L_0x005c;	 Catch:{ Throwable -> 0x0053 }
    L_0x0046:
        r13 = r12.substring(r3, r13);	 Catch:{ Throwable -> 0x0053 }
        r13 = java.lang.Long.parseLong(r13);	 Catch:{ Throwable -> 0x0053 }
        r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x005c;
    L_0x0052:
        goto L_0x0064;
    L_0x0053:
        r13 = "[Native] Tomb file format error, delete %s";
        r10 = new java.lang.Object[r10];
        r10[r6] = r12;
        com.tencent.bugly.proguard.an.e(r13, r10);
    L_0x005c:
        r10 = r11.delete();
        if (r10 == 0) goto L_0x0064;
    L_0x0062:
        r9 = r9 + 1;
    L_0x0064:
        r8 = r8 + 1;
        goto L_0x0031;
    L_0x0067:
        r0 = "[Native] Clean tombs %d";
        r1 = new java.lang.Object[r10];
        r2 = java.lang.Integer.valueOf(r9);
        r1[r6] = r2;
        com.tencent.bugly.proguard.an.c(r0, r1);
        goto L_0x0076;
    L_0x0075:
        return;
    L_0x0076:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.b():void");
    }

    protected synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            a();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.k;
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            an.a("user change native %b", Boolean.valueOf(z));
            this.k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        z = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a != null) {
            z = z && a.c().g;
        }
        if (z != this.j) {
            an.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.g != this.j) {
                an.d("server native changed to %b", Boolean.valueOf(strategyBean.g));
            }
        }
        boolean z = (com.tencent.bugly.crashreport.common.strategy.a.a().c().g == null || this.k == null) ? null : 1;
        if (z != this.j) {
            an.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean appendLogToNative(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.h;
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0005:
        r0 = r9.i;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = l;
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        if (r10 == 0) goto L_0x0059;
    L_0x0011:
        if (r11 == 0) goto L_0x0059;
    L_0x0013:
        if (r12 != 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0059;
    L_0x0016:
        r0 = r9.i;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        if (r0 == 0) goto L_0x001f;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
    L_0x001a:
        r10 = r9.appendNativeLog(r10, r11, r12);	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        return r10;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
    L_0x001f:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r2 = "appendNativeLog";	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r3 = 0;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r4 = 3;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r5 = new java.lang.Class[r4];	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r6 = java.lang.String.class;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r5[r1] = r6;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r6 = java.lang.String.class;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r7 = 1;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r5[r7] = r6;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r6 = java.lang.String.class;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r8 = 2;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r5[r8] = r6;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r4[r1] = r10;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r4[r7] = r11;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r4[r8] = r12;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r10 = com.tencent.bugly.proguard.ap.a(r0, r2, r3, r5, r4);	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        r10 = (java.lang.Boolean) r10;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        if (r10 == 0) goto L_0x004a;	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
    L_0x0045:
        r10 = r10.booleanValue();	 Catch:{ UnsatisfiedLinkError -> 0x0056, Throwable -> 0x004b }
        return r10;
    L_0x004a:
        return r1;
    L_0x004b:
        r10 = move-exception;
        r11 = com.tencent.bugly.proguard.an.a(r10);
        if (r11 != 0) goto L_0x0055;
    L_0x0052:
        r10.printStackTrace();
    L_0x0055:
        return r1;
    L_0x0056:
        l = r1;
        return r1;
    L_0x0059:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.appendLogToNative(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public boolean putKeyValueToNative(java.lang.String r9, java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.h;
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0005:
        r0 = r8.i;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = l;
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        if (r9 == 0) goto L_0x0050;
    L_0x0011:
        if (r10 != 0) goto L_0x0014;
    L_0x0013:
        goto L_0x0050;
    L_0x0014:
        r0 = r8.i;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        if (r0 == 0) goto L_0x001d;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
    L_0x0018:
        r9 = r8.putNativeKeyValue(r9, r10);	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        return r9;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
    L_0x001d:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r2 = "putNativeKeyValue";	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r3 = 0;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r4 = 2;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r5 = new java.lang.Class[r4];	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r6 = java.lang.String.class;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r5[r1] = r6;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r6 = java.lang.String.class;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r7 = 1;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r5[r7] = r6;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r4 = new java.lang.Object[r4];	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r4[r1] = r9;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r4[r7] = r10;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r9 = com.tencent.bugly.proguard.ap.a(r0, r2, r3, r5, r4);	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        r9 = (java.lang.Boolean) r9;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        if (r9 == 0) goto L_0x0041;	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
    L_0x003c:
        r9 = r9.booleanValue();	 Catch:{ UnsatisfiedLinkError -> 0x004d, Throwable -> 0x0042 }
        return r9;
    L_0x0041:
        return r1;
    L_0x0042:
        r9 = move-exception;
        r10 = com.tencent.bugly.proguard.an.a(r9);
        if (r10 != 0) goto L_0x004c;
    L_0x0049:
        r9.printStackTrace();
    L_0x004c:
        return r1;
    L_0x004d:
        l = r1;
        return r1;
    L_0x0050:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.putKeyValueToNative(java.lang.String, java.lang.String):boolean");
    }

    private boolean a(int r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.i;
        r1 = 0;
        if (r0 == 0) goto L_0x001d;
    L_0x0005:
        r0 = m;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x001d;
    L_0x000a:
        r2.setNativeInfo(r3, r4);	 Catch:{ UnsatisfiedLinkError -> 0x001a, Throwable -> 0x000f }
        r3 = 1;
        return r3;
    L_0x000f:
        r3 = move-exception;
        r4 = com.tencent.bugly.proguard.an.a(r3);
        if (r4 != 0) goto L_0x0019;
    L_0x0016:
        r3.printStackTrace();
    L_0x0019:
        return r1;
    L_0x001a:
        m = r1;
        return r1;
    L_0x001d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(int, java.lang.String):boolean");
    }

    public boolean filterSigabrtSysLog() {
        return a((int) TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "true");
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : av.b);
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (long j2) {
            if (!an.a(j2)) {
                j2.printStackTrace();
            }
            return 0;
        }
    }
}
