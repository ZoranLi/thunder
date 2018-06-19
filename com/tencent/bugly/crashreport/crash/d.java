package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.umeng.message.proguard.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
public class d {
    private static d a;
    private a b;
    private com.tencent.bugly.crashreport.common.info.a c;
    private b d;
    private Context e;

    /* compiled from: BUGLY */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Thread a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ Map f;

        AnonymousClass2(Thread thread, int i, String str, String str2, String str3, Map map) {
            this.a = thread;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = map;
        }

        public final void run() {
            try {
                if (d.a == null) {
                    an.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                } else {
                    d.a.c(this.a, this.b, this.c, this.d, this.e, this.f);
                }
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
                an.e("[ExtraCrashManager] Crash error %s %s %s", this.c, this.d, this.e);
            }
        }
    }

    private d(Context context) {
        c a = c.a();
        if (a != null) {
            this.b = a.a();
            this.c = com.tencent.bugly.crashreport.common.info.a.a(context);
            this.d = a.o;
            this.e = context;
            am.a().a(new Runnable(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.b();
                }
            });
        }
    }

    public static d a(Context context) {
        if (a == null) {
            a = new d(context);
        }
        return a;
    }

    public static void a(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        am.a().a(new AnonymousClass2(thread, i, str, str2, str3, map));
    }

    private void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = "[ExtraCrashManager] Trying to notify Bugly agents.";
        r1 = 0;
        r2 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.an.c(r0, r2);
        r0 = "com.tencent.bugly.proguard.o";	 Catch:{ Throwable -> 0x0041 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0041 }
        r2 = "com.tencent.bugly";	 Catch:{ Throwable -> 0x0041 }
        r3 = r5.c;	 Catch:{ Throwable -> 0x0041 }
        r3.getClass();	 Catch:{ Throwable -> 0x0041 }
        r3 = "";	 Catch:{ Throwable -> 0x0041 }
        r4 = "";	 Catch:{ Throwable -> 0x0041 }
        r4 = r4.equals(r3);	 Catch:{ Throwable -> 0x0041 }
        if (r4 != 0) goto L_0x0033;	 Catch:{ Throwable -> 0x0041 }
    L_0x001f:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0041 }
        r4.<init>();	 Catch:{ Throwable -> 0x0041 }
        r4.append(r2);	 Catch:{ Throwable -> 0x0041 }
        r2 = ".";	 Catch:{ Throwable -> 0x0041 }
        r4.append(r2);	 Catch:{ Throwable -> 0x0041 }
        r4.append(r3);	 Catch:{ Throwable -> 0x0041 }
        r2 = r4.toString();	 Catch:{ Throwable -> 0x0041 }
    L_0x0033:
        r3 = "sdkPackageName";	 Catch:{ Throwable -> 0x0041 }
        r4 = 0;	 Catch:{ Throwable -> 0x0041 }
        com.tencent.bugly.proguard.ap.a(r0, r3, r2, r4);	 Catch:{ Throwable -> 0x0041 }
        r0 = "[ExtraCrashManager] Bugly game agent has been notified.";	 Catch:{ Throwable -> 0x0041 }
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0041 }
        com.tencent.bugly.proguard.an.c(r0, r2);	 Catch:{ Throwable -> 0x0041 }
        return;
    L_0x0041:
        r0 = "[ExtraCrashManager] no game agent";
        r1 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.an.a(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.d.b():void");
    }

    private CrashDetailBean b(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.B = b.i();
        crashDetailBean.C = b.g();
        crashDetailBean.D = b.k();
        crashDetailBean.E = this.c.p();
        crashDetailBean.F = this.c.o();
        crashDetailBean.G = this.c.q();
        crashDetailBean.w = ap.a(this.e, c.e, c.h);
        crashDetailBean.b = i;
        crashDetailBean.e = this.c.h();
        crashDetailBean.f = this.c.o;
        crashDetailBean.g = this.c.w();
        crashDetailBean.m = this.c.g();
        crashDetailBean.n = str;
        crashDetailBean.o = str2;
        i = "";
        if (str3 != null) {
            str2 = str3.split("\n");
            if (str2.length > 0) {
                i = str2[0];
            }
        } else {
            str3 = "";
        }
        crashDetailBean.p = i;
        crashDetailBean.q = str3;
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = ap.b(crashDetailBean.q.getBytes());
        crashDetailBean.y = ap.a(c.f, false);
        crashDetailBean.z = this.c.e;
        i = new StringBuilder();
        i.append(thread.getName());
        i.append(k.s);
        i.append(thread.getId());
        i.append(k.t);
        crashDetailBean.A = i.toString();
        crashDetailBean.H = this.c.y();
        crashDetailBean.h = this.c.v();
        crashDetailBean.M = this.c.a;
        crashDetailBean.N = this.c.a();
        crashDetailBean.P = this.c.H();
        crashDetailBean.Q = this.c.I();
        crashDetailBean.R = this.c.B();
        crashDetailBean.S = this.c.G();
        this.d.c(crashDetailBean);
        crashDetailBean.x = ao.a();
        if (crashDetailBean.O == null) {
            crashDetailBean.O = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.O.putAll(map);
        }
        return crashDetailBean;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(java.lang.Thread r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.util.Map<java.lang.String, java.lang.String> r25) {
        /*
        r19 = this;
        r8 = r19;
        r1 = r21;
        r9 = r22;
        r10 = r23;
        r11 = r24;
        r2 = 1;
        r12 = 0;
        switch(r1) {
            case 4: goto L_0x0023;
            case 5: goto L_0x0020;
            case 6: goto L_0x0020;
            case 7: goto L_0x000f;
            case 8: goto L_0x001d;
            default: goto L_0x000f;
        };
    L_0x000f:
        r3 = "[ExtraCrashManager] Unknown extra crash type: %d";
        r2 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r21);
        r2[r12] = r1;
        com.tencent.bugly.proguard.an.d(r3, r2);
        return;
    L_0x001d:
        r3 = "H5";
        goto L_0x0025;
    L_0x0020:
        r3 = "Cocos";
        goto L_0x0025;
    L_0x0023:
        r3 = "Unity";
    L_0x0025:
        r13 = r3;
        r3 = "[ExtraCrashManager] %s Crash Happen";
        r4 = new java.lang.Object[r2];
        r4[r12] = r13;
        com.tencent.bugly.proguard.an.e(r3, r4);
        r3 = r8.b;	 Catch:{ Throwable -> 0x0143 }
        r3 = r3.b();	 Catch:{ Throwable -> 0x0143 }
        if (r3 != 0) goto L_0x0052;
    L_0x0037:
        r3 = "waiting for remote sync";
        r4 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0143 }
        com.tencent.bugly.proguard.an.e(r3, r4);	 Catch:{ Throwable -> 0x0143 }
        r3 = r12;
    L_0x003f:
        r4 = r8.b;	 Catch:{ Throwable -> 0x0143 }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0143 }
        if (r4 != 0) goto L_0x0052;
    L_0x0047:
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        com.tencent.bugly.proguard.ap.b(r4);	 Catch:{ Throwable -> 0x0143 }
        r3 = r3 + 500;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        if (r3 < r4) goto L_0x003f;
    L_0x0052:
        r3 = r8.b;	 Catch:{ Throwable -> 0x0143 }
        r3 = r3.b();	 Catch:{ Throwable -> 0x0143 }
        if (r3 != 0) goto L_0x0061;
    L_0x005a:
        r3 = "[ExtraCrashManager] There is no remote strategy, but still store it.";
        r4 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0143 }
        com.tencent.bugly.proguard.an.d(r3, r4);	 Catch:{ Throwable -> 0x0143 }
    L_0x0061:
        r3 = r8.b;	 Catch:{ Throwable -> 0x0143 }
        r3 = r3.c();	 Catch:{ Throwable -> 0x0143 }
        r4 = r3.g;	 Catch:{ Throwable -> 0x0143 }
        if (r4 != 0) goto L_0x00ad;
    L_0x006b:
        r4 = r8.b;	 Catch:{ Throwable -> 0x0143 }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0143 }
        if (r4 == 0) goto L_0x00ad;
    L_0x0073:
        r1 = "[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!";
        r2 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0143 }
        com.tencent.bugly.proguard.an.e(r1, r2);	 Catch:{ Throwable -> 0x0143 }
        r14 = com.tencent.bugly.proguard.ap.a();	 Catch:{ Throwable -> 0x0143 }
        r1 = r8.c;	 Catch:{ Throwable -> 0x0143 }
        r15 = r1.e;	 Catch:{ Throwable -> 0x0143 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0143 }
        r1.<init>();	 Catch:{ Throwable -> 0x0143 }
        r1.append(r9);	 Catch:{ Throwable -> 0x0143 }
        r2 = "\n";
        r1.append(r2);	 Catch:{ Throwable -> 0x0143 }
        r1.append(r10);	 Catch:{ Throwable -> 0x0143 }
        r2 = "\n";
        r1.append(r2);	 Catch:{ Throwable -> 0x0143 }
        r1.append(r11);	 Catch:{ Throwable -> 0x0143 }
        r17 = r1.toString();	 Catch:{ Throwable -> 0x0143 }
        r18 = 0;
        r16 = r20;
        com.tencent.bugly.crashreport.crash.b.a(r13, r14, r15, r16, r17, r18);	 Catch:{ Throwable -> 0x0143 }
        r1 = "[ExtraCrashManager] Successfully handled.";
        r2 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.an.e(r1, r2);
        return;
    L_0x00ad:
        switch(r1) {
            case 4: goto L_0x00db;
            case 5: goto L_0x00c6;
            case 6: goto L_0x00c6;
            case 7: goto L_0x00b0;
            case 8: goto L_0x00b1;
            default: goto L_0x00b0;
        };
    L_0x00b0:
        goto L_0x00db;
    L_0x00b1:
        r3 = r3.m;	 Catch:{ Throwable -> 0x0143 }
        if (r3 != 0) goto L_0x00db;
    L_0x00b5:
        r1 = "[ExtraCrashManager] %s report is disabled.";
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0143 }
        r2[r12] = r13;	 Catch:{ Throwable -> 0x0143 }
        com.tencent.bugly.proguard.an.e(r1, r2);	 Catch:{ Throwable -> 0x0143 }
        r1 = "[ExtraCrashManager] Successfully handled.";
        r2 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.an.e(r1, r2);
        return;
    L_0x00c6:
        r3 = r3.l;	 Catch:{ Throwable -> 0x0143 }
        if (r3 != 0) goto L_0x00db;
    L_0x00ca:
        r1 = "[ExtraCrashManager] %s report is disabled.";
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0143 }
        r2[r12] = r13;	 Catch:{ Throwable -> 0x0143 }
        com.tencent.bugly.proguard.an.e(r1, r2);	 Catch:{ Throwable -> 0x0143 }
        r1 = "[ExtraCrashManager] Successfully handled.";
        r2 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.an.e(r1, r2);
        return;
    L_0x00db:
        r2 = 8;
        if (r1 != r2) goto L_0x00e0;
    L_0x00df:
        r1 = 5;
    L_0x00e0:
        r3 = r1;
        r1 = r8;
        r2 = r20;
        r4 = r9;
        r5 = r10;
        r6 = r11;
        r7 = r25;
        r1 = r1.b(r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0143 }
        if (r1 != 0) goto L_0x00fe;
    L_0x00ef:
        r1 = "[ExtraCrashManager] Failed to package crash data.";
        r2 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0143 }
        com.tencent.bugly.proguard.an.e(r1, r2);	 Catch:{ Throwable -> 0x0143 }
        r1 = "[ExtraCrashManager] Successfully handled.";
        r2 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.an.e(r1, r2);
        return;
    L_0x00fe:
        r14 = com.tencent.bugly.proguard.ap.a();	 Catch:{ Throwable -> 0x0143 }
        r2 = r8.c;	 Catch:{ Throwable -> 0x0143 }
        r15 = r2.e;	 Catch:{ Throwable -> 0x0143 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0143 }
        r2.<init>();	 Catch:{ Throwable -> 0x0143 }
        r2.append(r9);	 Catch:{ Throwable -> 0x0143 }
        r3 = "\n";
        r2.append(r3);	 Catch:{ Throwable -> 0x0143 }
        r2.append(r10);	 Catch:{ Throwable -> 0x0143 }
        r3 = "\n";
        r2.append(r3);	 Catch:{ Throwable -> 0x0143 }
        r2.append(r11);	 Catch:{ Throwable -> 0x0143 }
        r17 = r2.toString();	 Catch:{ Throwable -> 0x0143 }
        r16 = r20;
        r18 = r1;
        com.tencent.bugly.crashreport.crash.b.a(r13, r14, r15, r16, r17, r18);	 Catch:{ Throwable -> 0x0143 }
        r2 = r8.d;	 Catch:{ Throwable -> 0x0143 }
        r2 = r2.a(r1);	 Catch:{ Throwable -> 0x0143 }
        if (r2 != 0) goto L_0x0138;
    L_0x0131:
        r2 = r8.d;	 Catch:{ Throwable -> 0x0143 }
        r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r2.a(r1, r3, r12);	 Catch:{ Throwable -> 0x0143 }
    L_0x0138:
        r1 = "[ExtraCrashManager] Successfully handled.";
        r2 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.an.e(r1, r2);
        return;
    L_0x0140:
        r0 = move-exception;
        r1 = r0;
        goto L_0x014f;
    L_0x0143:
        r0 = move-exception;
        r1 = r0;
        r2 = com.tencent.bugly.proguard.an.a(r1);	 Catch:{ all -> 0x0140 }
        if (r2 != 0) goto L_0x0138;
    L_0x014b:
        r1.printStackTrace();	 Catch:{ all -> 0x0140 }
        goto L_0x0138;
    L_0x014f:
        r2 = "[ExtraCrashManager] Successfully handled.";
        r3 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.an.e(r2, r3);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.d.c(java.lang.Thread, int, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }
}
