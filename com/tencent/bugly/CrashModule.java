package com.tencent.bugly;

import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;

/* compiled from: BUGLY */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;
    private static int c = 0;
    private static boolean d = false;
    private static CrashModule e = new CrashModule();
    private long a;
    private a b;

    public static CrashModule getInstance() {
        e.id = 1004;
        return e;
    }

    public static boolean hasInitialized() {
        return d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r12, boolean r13, com.tencent.bugly.BuglyStrategy r14) {
        /*
        r11 = this;
        monitor-enter(r11);
        if (r12 == 0) goto L_0x0088;
    L_0x0003:
        r0 = d;	 Catch:{ all -> 0x0085 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        goto L_0x0088;
    L_0x0009:
        r0 = "Initializing crash module.";
        r1 = 0;
        r2 = new java.lang.Object[r1];	 Catch:{ all -> 0x0085 }
        com.tencent.bugly.proguard.an.a(r0, r2);	 Catch:{ all -> 0x0085 }
        r0 = com.tencent.bugly.proguard.ac.a();	 Catch:{ all -> 0x0085 }
        r2 = c;	 Catch:{ all -> 0x0085 }
        r3 = 1;
        r2 = r2 + r3;
        c = r2;	 Catch:{ all -> 0x0085 }
        r4 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r0.a(r4, r2);	 Catch:{ all -> 0x0085 }
        d = r3;	 Catch:{ all -> 0x0085 }
        com.tencent.bugly.crashreport.CrashReport.setContext(r12);	 Catch:{ all -> 0x0085 }
        r11.a(r12, r14);	 Catch:{ all -> 0x0085 }
        r5 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r8 = r11.b;	 Catch:{ all -> 0x0085 }
        r9 = 0;
        r10 = 0;
        r6 = r12;
        r7 = r13;
        com.tencent.bugly.crashreport.crash.c.a(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0085 }
        r13 = com.tencent.bugly.crashreport.crash.c.a();	 Catch:{ all -> 0x0085 }
        r13.f();	 Catch:{ all -> 0x0085 }
        if (r14 == 0) goto L_0x004e;
    L_0x003c:
        r0 = r14.isEnableNativeCrashMonitor();	 Catch:{ all -> 0x0085 }
        if (r0 == 0) goto L_0x0043;
    L_0x0042:
        goto L_0x004e;
    L_0x0043:
        r0 = "[crash] Closed native crash monitor!";
        r2 = new java.lang.Object[r1];	 Catch:{ all -> 0x0085 }
        com.tencent.bugly.proguard.an.a(r0, r2);	 Catch:{ all -> 0x0085 }
        r13.g();	 Catch:{ all -> 0x0085 }
        goto L_0x0051;
    L_0x004e:
        r13.h();	 Catch:{ all -> 0x0085 }
    L_0x0051:
        if (r14 == 0) goto L_0x0065;
    L_0x0053:
        r14 = r14.isEnableANRCrashMonitor();	 Catch:{ all -> 0x0085 }
        if (r14 == 0) goto L_0x005a;
    L_0x0059:
        goto L_0x0065;
    L_0x005a:
        r14 = "[crash] Closed ANR monitor!";
        r0 = new java.lang.Object[r1];	 Catch:{ all -> 0x0085 }
        com.tencent.bugly.proguard.an.a(r14, r0);	 Catch:{ all -> 0x0085 }
        r13.j();	 Catch:{ all -> 0x0085 }
        goto L_0x0068;
    L_0x0065:
        r13.i();	 Catch:{ all -> 0x0085 }
    L_0x0068:
        com.tencent.bugly.crashreport.crash.d.a(r12);	 Catch:{ all -> 0x0085 }
        r13 = com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.getInstance();	 Catch:{ all -> 0x0085 }
        r14 = "android.net.conn.CONNECTIVITY_CHANGE";
        r13.addFilter(r14);	 Catch:{ all -> 0x0085 }
        r13.register(r12);	 Catch:{ all -> 0x0085 }
        r12 = com.tencent.bugly.proguard.ac.a();	 Catch:{ all -> 0x0085 }
        r13 = c;	 Catch:{ all -> 0x0085 }
        r13 = r13 - r3;
        c = r13;	 Catch:{ all -> 0x0085 }
        r12.a(r4, r13);	 Catch:{ all -> 0x0085 }
        monitor-exit(r11);
        return;
    L_0x0085:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
    L_0x0088:
        monitor-exit(r11);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Context r7, com.tencent.bugly.BuglyStrategy r8) {
        /*
        r6 = this;
        monitor-enter(r6);
        if (r8 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r6);
        return;
    L_0x0005:
        r0 = r8.getLibBuglySOFilePath();	 Catch:{ all -> 0x0054 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0054 }
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x0020;
    L_0x0011:
        r7 = com.tencent.bugly.crashreport.common.info.a.a(r7);	 Catch:{ all -> 0x0054 }
        r7.r = r0;	 Catch:{ all -> 0x0054 }
        r7 = "setted libBugly.so file path :%s";
        r1 = new java.lang.Object[r2];	 Catch:{ all -> 0x0054 }
        r1[r3] = r0;	 Catch:{ all -> 0x0054 }
        com.tencent.bugly.proguard.an.a(r7, r1);	 Catch:{ all -> 0x0054 }
    L_0x0020:
        r7 = r8.getCrashHandleCallback();	 Catch:{ all -> 0x0054 }
        if (r7 == 0) goto L_0x0033;
    L_0x0026:
        r7 = r8.getCrashHandleCallback();	 Catch:{ all -> 0x0054 }
        r6.b = r7;	 Catch:{ all -> 0x0054 }
        r7 = "setted CrashHanldeCallback";
        r0 = new java.lang.Object[r3];	 Catch:{ all -> 0x0054 }
        com.tencent.bugly.proguard.an.a(r7, r0);	 Catch:{ all -> 0x0054 }
    L_0x0033:
        r0 = r8.getAppReportDelay();	 Catch:{ all -> 0x0054 }
        r4 = 0;
        r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r7 <= 0) goto L_0x0052;
    L_0x003d:
        r7 = r8.getAppReportDelay();	 Catch:{ all -> 0x0054 }
        r6.a = r7;	 Catch:{ all -> 0x0054 }
        r7 = "setted delay: %d";
        r8 = new java.lang.Object[r2];	 Catch:{ all -> 0x0054 }
        r0 = r6.a;	 Catch:{ all -> 0x0054 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ all -> 0x0054 }
        r8[r3] = r0;	 Catch:{ all -> 0x0054 }
        com.tencent.bugly.proguard.an.a(r7, r8);	 Catch:{ all -> 0x0054 }
    L_0x0052:
        monitor-exit(r6);
        return;
    L_0x0054:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.a(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            c a = c.a();
            if (a != null) {
                a.a(strategyBean);
            }
        }
    }

    public String[] getTables() {
        return new String[]{"t_cr"};
    }
}
