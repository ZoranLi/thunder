package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public class ac {
    public static final long a = System.currentTimeMillis();
    private static ac b;
    private Context c;
    private String d = a.b().e;
    private Map<Integer, Map<String, ab>> e = new HashMap();
    private SharedPreferences f;

    public ac(Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized ac a(Context context) {
        synchronized (ac.class) {
            if (b == null) {
                b = new ac(context);
            }
            context = b;
        }
        return context;
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            acVar = b;
        }
        return acVar;
    }

    private synchronized boolean b(int r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        monitor-enter(r14);
        r0 = 0;
        r1 = r14.c(r15);	 Catch:{ Exception -> 0x0084 }
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r14);
        return r0;
    L_0x000a:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0084 }
        r4 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0084 }
        r4.<init>();	 Catch:{ Exception -> 0x0084 }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0084 }
        r5.<init>();	 Catch:{ Exception -> 0x0084 }
        r6 = r1.iterator();	 Catch:{ Exception -> 0x0084 }
    L_0x001c:
        r7 = r6.hasNext();	 Catch:{ Exception -> 0x0084 }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Exception -> 0x0084 }
        if (r7 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x0084 }
    L_0x0025:
        r7 = r6.next();	 Catch:{ Exception -> 0x0084 }
        r7 = (com.tencent.bugly.proguard.ab) r7;	 Catch:{ Exception -> 0x0084 }
        r10 = r7.b;	 Catch:{ Exception -> 0x0084 }
        if (r10 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0084 }
    L_0x002f:
        r10 = r7.b;	 Catch:{ Exception -> 0x0084 }
        r11 = r14.d;	 Catch:{ Exception -> 0x0084 }
        r10 = r10.equalsIgnoreCase(r11);	 Catch:{ Exception -> 0x0084 }
        if (r10 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0084 }
    L_0x0039:
        r10 = r7.d;	 Catch:{ Exception -> 0x0084 }
        if (r10 <= 0) goto L_0x0040;	 Catch:{ Exception -> 0x0084 }
    L_0x003d:
        r4.add(r7);	 Catch:{ Exception -> 0x0084 }
    L_0x0040:
        r10 = r7.c;	 Catch:{ Exception -> 0x0084 }
        r12 = r10 + r8;	 Catch:{ Exception -> 0x0084 }
        r8 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0084 }
        if (r8 >= 0) goto L_0x001c;	 Catch:{ Exception -> 0x0084 }
    L_0x0048:
        r5.add(r7);	 Catch:{ Exception -> 0x0084 }
        goto L_0x001c;	 Catch:{ Exception -> 0x0084 }
    L_0x004c:
        java.util.Collections.sort(r4);	 Catch:{ Exception -> 0x0084 }
        r6 = r4.size();	 Catch:{ Exception -> 0x0084 }
        r7 = 2;	 Catch:{ Exception -> 0x0084 }
        if (r6 < r7) goto L_0x007a;	 Catch:{ Exception -> 0x0084 }
    L_0x0056:
        r5 = r4.size();	 Catch:{ Exception -> 0x0084 }
        r6 = 1;	 Catch:{ Exception -> 0x0084 }
        if (r5 <= 0) goto L_0x0078;	 Catch:{ Exception -> 0x0084 }
    L_0x005d:
        r5 = r4.size();	 Catch:{ Exception -> 0x0084 }
        r5 = r5 - r6;	 Catch:{ Exception -> 0x0084 }
        r4 = r4.get(r5);	 Catch:{ Exception -> 0x0084 }
        r4 = (com.tencent.bugly.proguard.ab) r4;	 Catch:{ Exception -> 0x0084 }
        r4 = r4.c;	 Catch:{ Exception -> 0x0084 }
        r10 = r4 + r8;	 Catch:{ Exception -> 0x0084 }
        r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0084 }
        if (r4 >= 0) goto L_0x0078;	 Catch:{ Exception -> 0x0084 }
    L_0x0070:
        r1.clear();	 Catch:{ Exception -> 0x0084 }
        r14.a(r15, r1);	 Catch:{ Exception -> 0x0084 }
        monitor-exit(r14);
        return r0;
    L_0x0078:
        monitor-exit(r14);
        return r6;
    L_0x007a:
        r1.removeAll(r5);	 Catch:{ Exception -> 0x0084 }
        r14.a(r15, r1);	 Catch:{ Exception -> 0x0084 }
        monitor-exit(r14);
        return r0;
    L_0x0082:
        r15 = move-exception;
        goto L_0x008d;
    L_0x0084:
        r15 = "isFrequentCrash failed";	 Catch:{ all -> 0x0082 }
        r1 = new java.lang.Object[r0];	 Catch:{ all -> 0x0082 }
        com.tencent.bugly.proguard.an.e(r15, r1);	 Catch:{ all -> 0x0082 }
        monitor-exit(r14);
        return r0;
    L_0x008d:
        monitor-exit(r14);
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ac.b(int):boolean");
    }

    public synchronized void a(final int i, final int i2) {
        am.a().a(new Runnable(this) {
            final /* synthetic */ ac c;

            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r12 = this;
                r0 = 0;
                r1 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r1 = r1.d;	 Catch:{ Exception -> 0x0137 }
                r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0137 }
                if (r1 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0137 }
            L_0x000d:
                return;	 Catch:{ Exception -> 0x0137 }
            L_0x000e:
                r1 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r2 = r3;	 Catch:{ Exception -> 0x0137 }
                r1 = r1.c(r2);	 Catch:{ Exception -> 0x0137 }
                if (r1 != 0) goto L_0x001d;	 Catch:{ Exception -> 0x0137 }
            L_0x0018:
                r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0137 }
                r1.<init>();	 Catch:{ Exception -> 0x0137 }
            L_0x001d:
                r2 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r2 = r2.e;	 Catch:{ Exception -> 0x0137 }
                r3 = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0137 }
                r2 = r2.get(r3);	 Catch:{ Exception -> 0x0137 }
                if (r2 != 0) goto L_0x0043;	 Catch:{ Exception -> 0x0137 }
            L_0x002f:
                r2 = new java.util.HashMap;	 Catch:{ Exception -> 0x0137 }
                r2.<init>();	 Catch:{ Exception -> 0x0137 }
                r3 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r3 = r3.e;	 Catch:{ Exception -> 0x0137 }
                r4 = r3;	 Catch:{ Exception -> 0x0137 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0137 }
                r3.put(r4, r2);	 Catch:{ Exception -> 0x0137 }
            L_0x0043:
                r2 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r2 = r2.e;	 Catch:{ Exception -> 0x0137 }
                r3 = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0137 }
                r2 = r2.get(r3);	 Catch:{ Exception -> 0x0137 }
                r2 = (java.util.Map) r2;	 Catch:{ Exception -> 0x0137 }
                r3 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r3 = r3.d;	 Catch:{ Exception -> 0x0137 }
                r2 = r2.get(r3);	 Catch:{ Exception -> 0x0137 }
                if (r2 != 0) goto L_0x00b0;	 Catch:{ Exception -> 0x0137 }
            L_0x0061:
                r2 = new com.tencent.bugly.proguard.ab;	 Catch:{ Exception -> 0x0137 }
                r2.<init>();	 Catch:{ Exception -> 0x0137 }
                r3 = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = (long) r3;	 Catch:{ Exception -> 0x0137 }
                r2.a = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = com.tencent.bugly.proguard.ac.a;	 Catch:{ Exception -> 0x0137 }
                r2.g = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r3 = r3.d;	 Catch:{ Exception -> 0x0137 }
                r2.b = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ Exception -> 0x0137 }
                r3 = r3.o;	 Catch:{ Exception -> 0x0137 }
                r2.f = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ Exception -> 0x0137 }
                r3.getClass();	 Catch:{ Exception -> 0x0137 }
                r3 = "2.6.5";	 Catch:{ Exception -> 0x0137 }
                r2.e = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0137 }
                r2.c = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = r4;	 Catch:{ Exception -> 0x0137 }
                r2.d = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r3 = r3.e;	 Catch:{ Exception -> 0x0137 }
                r4 = r3;	 Catch:{ Exception -> 0x0137 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0137 }
                r3 = r3.get(r4);	 Catch:{ Exception -> 0x0137 }
                r3 = (java.util.Map) r3;	 Catch:{ Exception -> 0x0137 }
                r4 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r4 = r4.d;	 Catch:{ Exception -> 0x0137 }
                r3.put(r4, r2);	 Catch:{ Exception -> 0x0137 }
                goto L_0x00d2;	 Catch:{ Exception -> 0x0137 }
            L_0x00b0:
                r2 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r2 = r2.e;	 Catch:{ Exception -> 0x0137 }
                r3 = r3;	 Catch:{ Exception -> 0x0137 }
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0137 }
                r2 = r2.get(r3);	 Catch:{ Exception -> 0x0137 }
                r2 = (java.util.Map) r2;	 Catch:{ Exception -> 0x0137 }
                r3 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r3 = r3.d;	 Catch:{ Exception -> 0x0137 }
                r2 = r2.get(r3);	 Catch:{ Exception -> 0x0137 }
                r2 = (com.tencent.bugly.proguard.ab) r2;	 Catch:{ Exception -> 0x0137 }
                r3 = r4;	 Catch:{ Exception -> 0x0137 }
                r2.d = r3;	 Catch:{ Exception -> 0x0137 }
            L_0x00d2:
                r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0137 }
                r3.<init>();	 Catch:{ Exception -> 0x0137 }
                r4 = r1.iterator();	 Catch:{ Exception -> 0x0137 }
                r5 = r0;	 Catch:{ Exception -> 0x0137 }
            L_0x00dc:
                r6 = r4.hasNext();	 Catch:{ Exception -> 0x0137 }
                if (r6 == 0) goto L_0x0127;	 Catch:{ Exception -> 0x0137 }
            L_0x00e2:
                r6 = r4.next();	 Catch:{ Exception -> 0x0137 }
                r6 = (com.tencent.bugly.proguard.ab) r6;	 Catch:{ Exception -> 0x0137 }
                r7 = r6.g;	 Catch:{ Exception -> 0x0137 }
                r9 = r2.g;	 Catch:{ Exception -> 0x0137 }
                r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ Exception -> 0x0137 }
                if (r11 != 0) goto L_0x0103;	 Catch:{ Exception -> 0x0137 }
            L_0x00f0:
                r7 = r6.b;	 Catch:{ Exception -> 0x0137 }
                if (r7 == 0) goto L_0x0103;	 Catch:{ Exception -> 0x0137 }
            L_0x00f4:
                r7 = r6.b;	 Catch:{ Exception -> 0x0137 }
                r8 = r2.b;	 Catch:{ Exception -> 0x0137 }
                r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x0137 }
                if (r7 == 0) goto L_0x0103;	 Catch:{ Exception -> 0x0137 }
            L_0x00fe:
                r5 = 1;	 Catch:{ Exception -> 0x0137 }
                r7 = r2.d;	 Catch:{ Exception -> 0x0137 }
                r6.d = r7;	 Catch:{ Exception -> 0x0137 }
            L_0x0103:
                r7 = r6.e;	 Catch:{ Exception -> 0x0137 }
                if (r7 == 0) goto L_0x0111;	 Catch:{ Exception -> 0x0137 }
            L_0x0107:
                r7 = r6.e;	 Catch:{ Exception -> 0x0137 }
                r8 = r2.e;	 Catch:{ Exception -> 0x0137 }
                r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x0137 }
                if (r7 == 0) goto L_0x0123;	 Catch:{ Exception -> 0x0137 }
            L_0x0111:
                r7 = r6.f;	 Catch:{ Exception -> 0x0137 }
                if (r7 == 0) goto L_0x011f;	 Catch:{ Exception -> 0x0137 }
            L_0x0115:
                r7 = r6.f;	 Catch:{ Exception -> 0x0137 }
                r8 = r2.f;	 Catch:{ Exception -> 0x0137 }
                r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x0137 }
                if (r7 == 0) goto L_0x0123;	 Catch:{ Exception -> 0x0137 }
            L_0x011f:
                r7 = r6.d;	 Catch:{ Exception -> 0x0137 }
                if (r7 > 0) goto L_0x00dc;	 Catch:{ Exception -> 0x0137 }
            L_0x0123:
                r3.add(r6);	 Catch:{ Exception -> 0x0137 }
                goto L_0x00dc;	 Catch:{ Exception -> 0x0137 }
            L_0x0127:
                r1.removeAll(r3);	 Catch:{ Exception -> 0x0137 }
                if (r5 != 0) goto L_0x012f;	 Catch:{ Exception -> 0x0137 }
            L_0x012c:
                r1.add(r2);	 Catch:{ Exception -> 0x0137 }
            L_0x012f:
                r2 = r12.c;	 Catch:{ Exception -> 0x0137 }
                r3 = r3;	 Catch:{ Exception -> 0x0137 }
                r2.a(r3, r1);	 Catch:{ Exception -> 0x0137 }
                return;
            L_0x0137:
                r1 = "saveCrashRecord failed";
                r0 = new java.lang.Object[r0];
                com.tencent.bugly.proguard.an.e(r1, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ac.1.run():void");
            }
        });
    }

    private synchronized <T extends java.util.List<?>> T c(int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = 0;
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0056 }
        r3 = r5.c;	 Catch:{ Exception -> 0x0056 }
        r4 = "crashrecord";	 Catch:{ Exception -> 0x0056 }
        r3 = r3.getDir(r4, r1);	 Catch:{ Exception -> 0x0056 }
        r6 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x0056 }
        r2.<init>(r3, r6);	 Catch:{ Exception -> 0x0056 }
        r6 = r2.exists();	 Catch:{ Exception -> 0x0056 }
        if (r6 != 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r5);
        return r0;
    L_0x001c:
        r6 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x0042, ClassNotFoundException -> 0x0034, all -> 0x0031 }
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0042, ClassNotFoundException -> 0x0034, all -> 0x0031 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0042, ClassNotFoundException -> 0x0034, all -> 0x0031 }
        r6.<init>(r3);	 Catch:{ IOException -> 0x0042, ClassNotFoundException -> 0x0034, all -> 0x0031 }
        r2 = r6.readObject();	 Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0035 }
        r2 = (java.util.List) r2;	 Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0035 }
        r6.close();	 Catch:{ Exception -> 0x0056 }
        monitor-exit(r5);
        return r2;
    L_0x0031:
        r2 = move-exception;
        r6 = r0;
        goto L_0x004e;
    L_0x0034:
        r6 = r0;
    L_0x0035:
        r2 = "get object error";	 Catch:{ all -> 0x004d }
        r3 = new java.lang.Object[r1];	 Catch:{ all -> 0x004d }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ all -> 0x004d }
        if (r6 == 0) goto L_0x005d;
    L_0x003e:
        r6.close();	 Catch:{ Exception -> 0x0056 }
        goto L_0x005d;
    L_0x0042:
        r6 = r0;
    L_0x0043:
        r2 = "open record file error";	 Catch:{ all -> 0x004d }
        r3 = new java.lang.Object[r1];	 Catch:{ all -> 0x004d }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ all -> 0x004d }
        if (r6 == 0) goto L_0x005d;
    L_0x004c:
        goto L_0x003e;
    L_0x004d:
        r2 = move-exception;
    L_0x004e:
        if (r6 == 0) goto L_0x0053;
    L_0x0050:
        r6.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0053:
        throw r2;	 Catch:{ Exception -> 0x0056 }
    L_0x0054:
        r6 = move-exception;
        goto L_0x005f;
    L_0x0056:
        r6 = "readCrashRecord error";	 Catch:{ all -> 0x0054 }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0054 }
        com.tencent.bugly.proguard.an.e(r6, r1);	 Catch:{ all -> 0x0054 }
    L_0x005d:
        monitor-exit(r5);
        return r0;
    L_0x005f:
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ac.c(int):T");
    }

    private synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        monitor-enter(r4);
        if (r6 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0050 }
        r2 = r4.c;	 Catch:{ Exception -> 0x0050 }
        r3 = "crashrecord";	 Catch:{ Exception -> 0x0050 }
        r2 = r2.getDir(r3, r0);	 Catch:{ Exception -> 0x0050 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0050 }
        r1.<init>(r2, r5);	 Catch:{ Exception -> 0x0050 }
        r5 = 0;
        r2 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x0034 }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0034 }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0034 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0034 }
        r2.writeObject(r6);	 Catch:{ IOException -> 0x002e, all -> 0x002a }
        r2.close();	 Catch:{ Exception -> 0x0050 }
        monitor-exit(r4);
        return;
    L_0x002a:
        r5 = move-exception;
        r6 = r5;
        r5 = r2;
        goto L_0x0048;
    L_0x002e:
        r5 = move-exception;
        r6 = r5;
        r5 = r2;
        goto L_0x0035;
    L_0x0032:
        r6 = move-exception;
        goto L_0x0048;
    L_0x0034:
        r6 = move-exception;
    L_0x0035:
        r6.printStackTrace();	 Catch:{ all -> 0x0032 }
        r6 = "open record file error";	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.Object[r0];	 Catch:{ all -> 0x0032 }
        com.tencent.bugly.proguard.an.a(r6, r1);	 Catch:{ all -> 0x0032 }
        if (r5 == 0) goto L_0x0046;
    L_0x0041:
        r5.close();	 Catch:{ Exception -> 0x0050 }
        monitor-exit(r4);
        return;
    L_0x0046:
        monitor-exit(r4);
        return;
    L_0x0048:
        if (r5 == 0) goto L_0x004d;
    L_0x004a:
        r5.close();	 Catch:{ Exception -> 0x0050 }
    L_0x004d:
        throw r6;	 Catch:{ Exception -> 0x0050 }
    L_0x004e:
        r5 = move-exception;
        goto L_0x0059;
    L_0x0050:
        r5 = "writeCrashRecord error";	 Catch:{ all -> 0x004e }
        r6 = new java.lang.Object[r0];	 Catch:{ all -> 0x004e }
        com.tencent.bugly.proguard.an.e(r5, r6);	 Catch:{ all -> 0x004e }
        monitor-exit(r4);
        return;
    L_0x0059:
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ac.a(int, java.util.List):void");
    }

    public synchronized boolean a(final int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 1;
        r1 = r4.f;	 Catch:{ Exception -> 0x0030 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0030 }
        r2.<init>();	 Catch:{ Exception -> 0x0030 }
        r2.append(r5);	 Catch:{ Exception -> 0x0030 }
        r3 = "_";	 Catch:{ Exception -> 0x0030 }
        r2.append(r3);	 Catch:{ Exception -> 0x0030 }
        r3 = r4.d;	 Catch:{ Exception -> 0x0030 }
        r2.append(r3);	 Catch:{ Exception -> 0x0030 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0030 }
        r1 = r1.getBoolean(r2, r0);	 Catch:{ Exception -> 0x0030 }
        r0 = com.tencent.bugly.proguard.am.a();	 Catch:{ Exception -> 0x002c }
        r2 = new com.tencent.bugly.proguard.ac$2;	 Catch:{ Exception -> 0x002c }
        r2.<init>(r4, r5);	 Catch:{ Exception -> 0x002c }
        r0.a(r2);	 Catch:{ Exception -> 0x002c }
        monitor-exit(r4);
        return r1;
    L_0x002c:
        r0 = r1;
        goto L_0x0030;
    L_0x002e:
        r5 = move-exception;
        goto L_0x003a;
    L_0x0030:
        r5 = "canInit error";	 Catch:{ all -> 0x002e }
        r1 = 0;	 Catch:{ all -> 0x002e }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x002e }
        com.tencent.bugly.proguard.an.e(r5, r1);	 Catch:{ all -> 0x002e }
        monitor-exit(r4);
        return r0;
    L_0x003a:
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ac.a(int):boolean");
    }
}
