package com.tencent.bugly.beta.ui;

import com.tencent.bugly.beta.global.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
public class g {
    public static final Map<Integer, b> a = new ConcurrentHashMap();
    public static final Map<Integer, d> b = new ConcurrentHashMap();
    public static final Map<Integer, d> c = new ConcurrentHashMap();
    private static d d;

    public static synchronized void a(com.tencent.bugly.beta.ui.b r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.bugly.beta.ui.g.class;
        monitor-enter(r0);
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0053 }
        r2 = 14;	 Catch:{ all -> 0x0053 }
        r3 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ all -> 0x0053 }
        r5 = 0;	 Catch:{ all -> 0x0053 }
        if (r1 < r2) goto L_0x0011;	 Catch:{ all -> 0x0053 }
    L_0x000c:
        a(r7, r8, r5, r3);	 Catch:{ all -> 0x0053 }
        monitor-exit(r0);
        return;
    L_0x0011:
        r1 = 1;
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ SecurityException -> 0x0028 }
        r2 = r2.s;	 Catch:{ SecurityException -> 0x0028 }
        r6 = "activity";	 Catch:{ SecurityException -> 0x0028 }
        r2 = r2.getSystemService(r6);	 Catch:{ SecurityException -> 0x0028 }
        r2 = (android.app.ActivityManager) r2;	 Catch:{ SecurityException -> 0x0028 }
        if (r2 == 0) goto L_0x0026;	 Catch:{ SecurityException -> 0x0028 }
    L_0x0020:
        r2.getRunningTasks(r1);	 Catch:{ SecurityException -> 0x0028 }
        a(r7, r8, r5, r3);	 Catch:{ SecurityException -> 0x0028 }
    L_0x0026:
        monitor-exit(r0);
        return;
    L_0x0028:
        if (r8 == 0) goto L_0x0031;
    L_0x002a:
        r2 = 0;
        a(r7, r8, r1, r2);	 Catch:{ all -> 0x0053 }
        monitor-exit(r0);
        return;
    L_0x0031:
        r8 = "无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n";	 Catch:{ all -> 0x0053 }
        r1 = new java.lang.Object[r5];	 Catch:{ all -> 0x0053 }
        com.tencent.bugly.proguard.an.e(r8, r1);	 Catch:{ all -> 0x0053 }
        r8 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ all -> 0x0053 }
        r8 = r8.b;	 Catch:{ all -> 0x0053 }
        if (r8 == 0) goto L_0x0051;	 Catch:{ all -> 0x0053 }
    L_0x003e:
        r8 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ all -> 0x0053 }
        r8 = r8.b;	 Catch:{ all -> 0x0053 }
        r8 = r8.a;	 Catch:{ all -> 0x0053 }
        if (r8 == 0) goto L_0x0051;	 Catch:{ all -> 0x0053 }
    L_0x0046:
        r8 = com.tencent.bugly.beta.ui.c.a;	 Catch:{ all -> 0x0053 }
        r1 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ all -> 0x0053 }
        r1 = r1.b;	 Catch:{ all -> 0x0053 }
        r1 = r1.a;	 Catch:{ all -> 0x0053 }
        r8.a(r1, r7);	 Catch:{ all -> 0x0053 }
    L_0x0051:
        monitor-exit(r0);
        return;
    L_0x0053:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.g.a(com.tencent.bugly.beta.ui.b, boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(com.tencent.bugly.beta.ui.b r16, boolean r17, boolean r18, long r19) {
        /*
        r1 = r16;
        r2 = r19;
        r4 = com.tencent.bugly.beta.ui.g.class;
        monitor-enter(r4);
        if (r1 == 0) goto L_0x0130;
    L_0x0009:
        r5 = r16.b();	 Catch:{ all -> 0x012c }
        if (r5 == 0) goto L_0x0011;
    L_0x000f:
        goto L_0x0130;
    L_0x0011:
        r5 = r16.hashCode();	 Catch:{ all -> 0x012c }
        r6 = r1 instanceof com.tencent.bugly.beta.ui.h;	 Catch:{ all -> 0x012c }
        r7 = 11;
        r8 = 4;
        r9 = 3;
        r10 = 1;
        r11 = 0;
        r12 = 2;
        if (r6 == 0) goto L_0x00a3;
    L_0x0020:
        r6 = d;	 Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.e.b(r6);	 Catch:{ all -> 0x012c }
        r6 = r1;
        r6 = (com.tencent.bugly.beta.ui.h) r6;	 Catch:{ all -> 0x012c }
        r6 = r6.p;	 Catch:{ all -> 0x012c }
        r6 = r6.g;	 Catch:{ all -> 0x012c }
        if (r6 != r12) goto L_0x0052;
    L_0x002e:
        r6 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x012c }
        r13 = 15;
        r14 = new java.lang.Object[r8];	 Catch:{ all -> 0x012c }
        r14[r11] = r1;	 Catch:{ all -> 0x012c }
        r15 = java.lang.Boolean.valueOf(r17);	 Catch:{ all -> 0x012c }
        r14[r10] = r15;	 Catch:{ all -> 0x012c }
        r15 = java.lang.Boolean.valueOf(r18);	 Catch:{ all -> 0x012c }
        r14[r12] = r15;	 Catch:{ all -> 0x012c }
        r15 = java.lang.Long.valueOf(r19);	 Catch:{ all -> 0x012c }
        r14[r9] = r15;	 Catch:{ all -> 0x012c }
        r6.<init>(r13, r14);	 Catch:{ all -> 0x012c }
        d = r6;	 Catch:{ all -> 0x012c }
        r13 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        com.tencent.bugly.beta.utils.e.a(r6, r13);	 Catch:{ all -> 0x012c }
    L_0x0052:
        if (r17 != 0) goto L_0x0094;
    L_0x0054:
        r13 = b();	 Catch:{ all -> 0x012c }
        if (r13 != 0) goto L_0x0094;
    L_0x005a:
        r13 = b;	 Catch:{ all -> 0x012c }
        r14 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x012c }
        r13 = r13.get(r14);	 Catch:{ all -> 0x012c }
        r13 = (com.tencent.bugly.beta.global.d) r13;	 Catch:{ all -> 0x012c }
        if (r13 != 0) goto L_0x008c;
    L_0x0068:
        r13 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x012c }
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x012c }
        r8[r11] = r1;	 Catch:{ all -> 0x012c }
        r1 = java.lang.Boolean.valueOf(r17);	 Catch:{ all -> 0x012c }
        r8[r10] = r1;	 Catch:{ all -> 0x012c }
        r1 = java.lang.Boolean.valueOf(r18);	 Catch:{ all -> 0x012c }
        r8[r12] = r1;	 Catch:{ all -> 0x012c }
        r1 = java.lang.Long.valueOf(r19);	 Catch:{ all -> 0x012c }
        r8[r9] = r1;	 Catch:{ all -> 0x012c }
        r13.<init>(r7, r8);	 Catch:{ all -> 0x012c }
        r1 = b;	 Catch:{ all -> 0x012c }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x012c }
        r1.put(r5, r13);	 Catch:{ all -> 0x012c }
    L_0x008c:
        com.tencent.bugly.beta.utils.e.b(r13);	 Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.e.a(r13, r2);	 Catch:{ all -> 0x012c }
        monitor-exit(r4);
        return;
    L_0x0094:
        r13 = b;	 Catch:{ all -> 0x012c }
        r14 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x012c }
        r13 = r13.remove(r14);	 Catch:{ all -> 0x012c }
        r13 = (java.lang.Runnable) r13;	 Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.e.b(r13);	 Catch:{ all -> 0x012c }
    L_0x00a3:
        if (r18 != 0) goto L_0x00e9;
    L_0x00a5:
        r14 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x012c }
        r14 = r14.s;	 Catch:{ all -> 0x012c }
        r14 = com.tencent.bugly.proguard.ap.b(r14);	 Catch:{ all -> 0x012c }
        if (r14 != 0) goto L_0x00e9;
    L_0x00af:
        r14 = c;	 Catch:{ all -> 0x012c }
        r15 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x012c }
        r14 = r14.get(r15);	 Catch:{ all -> 0x012c }
        r14 = (com.tencent.bugly.beta.global.d) r14;	 Catch:{ all -> 0x012c }
        if (r14 != 0) goto L_0x00e1;
    L_0x00bd:
        r14 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x012c }
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x012c }
        r8[r11] = r1;	 Catch:{ all -> 0x012c }
        r1 = java.lang.Boolean.valueOf(r17);	 Catch:{ all -> 0x012c }
        r8[r10] = r1;	 Catch:{ all -> 0x012c }
        r1 = java.lang.Boolean.valueOf(r18);	 Catch:{ all -> 0x012c }
        r8[r12] = r1;	 Catch:{ all -> 0x012c }
        r1 = java.lang.Long.valueOf(r19);	 Catch:{ all -> 0x012c }
        r8[r9] = r1;	 Catch:{ all -> 0x012c }
        r14.<init>(r7, r8);	 Catch:{ all -> 0x012c }
        r1 = c;	 Catch:{ all -> 0x012c }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x012c }
        r1.put(r5, r14);	 Catch:{ all -> 0x012c }
    L_0x00e1:
        com.tencent.bugly.beta.utils.e.b(r14);	 Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.e.a(r14, r2);	 Catch:{ all -> 0x012c }
        monitor-exit(r4);
        return;
    L_0x00e9:
        r2 = c;	 Catch:{ all -> 0x012c }
        r3 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x012c }
        r2 = r2.remove(r3);	 Catch:{ all -> 0x012c }
        r2 = (java.lang.Runnable) r2;	 Catch:{ all -> 0x012c }
        com.tencent.bugly.beta.utils.e.b(r2);	 Catch:{ all -> 0x012c }
        r2 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x012c }
        r3 = 17;
        r6 = new java.lang.Object[r9];	 Catch:{ all -> 0x012c }
        r7 = a;	 Catch:{ all -> 0x012c }
        r6[r11] = r7;	 Catch:{ all -> 0x012c }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x012c }
        r6[r10] = r5;	 Catch:{ all -> 0x012c }
        r6[r12] = r1;	 Catch:{ all -> 0x012c }
        r2.<init>(r3, r6);	 Catch:{ all -> 0x012c }
        r1 = r16.getActivity();	 Catch:{ all -> 0x012c }
        if (r1 == 0) goto L_0x0127;
    L_0x0113:
        r3 = r1 instanceof com.tencent.bugly.beta.ui.BetaActivity;	 Catch:{ all -> 0x012c }
        if (r3 == 0) goto L_0x011d;
    L_0x0117:
        r3 = r1;
        r3 = (com.tencent.bugly.beta.ui.BetaActivity) r3;	 Catch:{ all -> 0x012c }
        r3.onDestroyRunnable = r2;	 Catch:{ all -> 0x012c }
        goto L_0x0122;
    L_0x011d:
        r5 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        com.tencent.bugly.beta.utils.e.a(r2, r5);	 Catch:{ all -> 0x012c }
    L_0x0122:
        r1.finish();	 Catch:{ all -> 0x012c }
        monitor-exit(r4);
        return;
    L_0x0127:
        r2.run();	 Catch:{ all -> 0x012c }
        monitor-exit(r4);
        return;
    L_0x012c:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r4);
        throw r1;
    L_0x0130:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.g.a(com.tencent.bugly.beta.ui.b, boolean, boolean, long):void");
    }

    public static java.lang.String a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r2 = 14;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        if (r1 < r2) goto L_0x000e;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
    L_0x0007:
        r1 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = r1.u;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        return r1;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
    L_0x000e:
        r1 = com.tencent.bugly.beta.global.e.E;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = r1.s;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r2 = "activity";	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = r1.getSystemService(r2);	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        if (r1 == 0) goto L_0x0048;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
    L_0x001c:
        r2 = 1;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = r1.getRunningTasks(r2);	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        if (r1 == 0) goto L_0x0048;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
    L_0x0023:
        r2 = r1.isEmpty();	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        if (r2 != 0) goto L_0x0048;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
    L_0x0029:
        r1 = r1.get(r0);	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = (android.app.ActivityManager.RunningTaskInfo) r1;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = r1.topActivity;	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        r1 = r1.getClassName();	 Catch:{ SecurityException -> 0x0041, Exception -> 0x0036 }
        return r1;
    L_0x0036:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.an.b(r0);
        if (r1 != 0) goto L_0x0048;
    L_0x003d:
        r0.printStackTrace();
        goto L_0x0048;
    L_0x0041:
        r1 = "无法获取Activity信息，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n";
        r0 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.an.e(r1, r0);
    L_0x0048:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.g.a():java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean b() {
        /*
        r0 = com.tencent.bugly.beta.ui.g.class;
        monitor-enter(r0);
        r1 = a();	 Catch:{ all -> 0x0094 }
        r2 = 0;
        if (r1 == 0) goto L_0x0092;
    L_0x000a:
        r3 = "background";
        r3 = r1.equals(r3);	 Catch:{ all -> 0x0094 }
        if (r3 != 0) goto L_0x0092;
    L_0x0012:
        r3 = "unknown";
        r3 = r1.equals(r3);	 Catch:{ all -> 0x0094 }
        if (r3 == 0) goto L_0x001c;
    L_0x001a:
        goto L_0x0092;
    L_0x001c:
        r3 = 0;
        r4 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0023 }
        r3 = r4;
        goto L_0x0027;
    L_0x0023:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ all -> 0x0094 }
    L_0x0027:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0094 }
        r4 = r4.m;	 Catch:{ all -> 0x0094 }
        r4 = r4.isEmpty();	 Catch:{ all -> 0x0094 }
        r5 = 1;
        if (r4 != 0) goto L_0x005c;
    L_0x0032:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0094 }
        r4 = r4.m;	 Catch:{ all -> 0x0094 }
        r4 = r4.iterator();	 Catch:{ all -> 0x0094 }
    L_0x003a:
        r6 = r4.hasNext();	 Catch:{ all -> 0x0094 }
        if (r6 == 0) goto L_0x005a;
    L_0x0040:
        r6 = r4.next();	 Catch:{ all -> 0x0094 }
        r6 = (java.lang.Class) r6;	 Catch:{ all -> 0x0094 }
        r7 = r6.getName();	 Catch:{ all -> 0x0094 }
        r7 = android.text.TextUtils.equals(r7, r1);	 Catch:{ all -> 0x0094 }
        if (r7 != 0) goto L_0x0058;
    L_0x0050:
        if (r3 == 0) goto L_0x003a;
    L_0x0052:
        r6 = r6.isAssignableFrom(r3);	 Catch:{ all -> 0x0094 }
        if (r6 == 0) goto L_0x003a;
    L_0x0058:
        monitor-exit(r0);
        return r5;
    L_0x005a:
        monitor-exit(r0);
        return r2;
    L_0x005c:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0094 }
        r4 = r4.n;	 Catch:{ all -> 0x0094 }
        r4 = r4.isEmpty();	 Catch:{ all -> 0x0094 }
        if (r4 != 0) goto L_0x0090;
    L_0x0066:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0094 }
        r4 = r4.n;	 Catch:{ all -> 0x0094 }
        r4 = r4.iterator();	 Catch:{ all -> 0x0094 }
    L_0x006e:
        r6 = r4.hasNext();	 Catch:{ all -> 0x0094 }
        if (r6 == 0) goto L_0x008e;
    L_0x0074:
        r6 = r4.next();	 Catch:{ all -> 0x0094 }
        r6 = (java.lang.Class) r6;	 Catch:{ all -> 0x0094 }
        r7 = r6.getName();	 Catch:{ all -> 0x0094 }
        r7 = android.text.TextUtils.equals(r7, r1);	 Catch:{ all -> 0x0094 }
        if (r7 != 0) goto L_0x008c;
    L_0x0084:
        if (r3 == 0) goto L_0x006e;
    L_0x0086:
        r6 = r6.isAssignableFrom(r3);	 Catch:{ all -> 0x0094 }
        if (r6 == 0) goto L_0x006e;
    L_0x008c:
        monitor-exit(r0);
        return r2;
    L_0x008e:
        monitor-exit(r0);
        return r5;
    L_0x0090:
        monitor-exit(r0);
        return r5;
    L_0x0092:
        monitor-exit(r0);
        return r2;
    L_0x0094:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.g.b():boolean");
    }
}
