package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: BUGLY */
public class ao {
    public static boolean a = true;
    private static SimpleDateFormat b = null;
    private static int c = 5120;
    private static StringBuilder d;
    private static StringBuilder e;
    private static boolean f;
    private static a g;
    private static String h;
    private static String i;
    private static Context j;
    private static String k;
    private static boolean l;
    private static int m;
    private static final Object n = new Object();

    /* compiled from: BUGLY */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;

        AnonymousClass1(String str) {
            this.a = str;
        }

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r0 = com.tencent.bugly.proguard.ao.n;
            monitor-enter(r0);
            r1 = com.tencent.bugly.proguard.ao.g;	 Catch:{ Throwable -> 0x0084 }
            if (r1 != 0) goto L_0x0018;	 Catch:{ Throwable -> 0x0084 }
        L_0x000b:
            r1 = new com.tencent.bugly.proguard.ao$a;	 Catch:{ Throwable -> 0x0084 }
            r2 = com.tencent.bugly.proguard.ao.k;	 Catch:{ Throwable -> 0x0084 }
            r1.<init>(r2);	 Catch:{ Throwable -> 0x0084 }
            com.tencent.bugly.proguard.ao.g = r1;	 Catch:{ Throwable -> 0x0084 }
            goto L_0x004c;	 Catch:{ Throwable -> 0x0084 }
        L_0x0018:
            r1 = com.tencent.bugly.proguard.ao.g;	 Catch:{ Throwable -> 0x0084 }
            r1 = r1.b;	 Catch:{ Throwable -> 0x0084 }
            if (r1 == 0) goto L_0x0045;	 Catch:{ Throwable -> 0x0084 }
        L_0x0022:
            r1 = com.tencent.bugly.proguard.ao.g;	 Catch:{ Throwable -> 0x0084 }
            r1 = r1.b;	 Catch:{ Throwable -> 0x0084 }
            r1 = r1.length();	 Catch:{ Throwable -> 0x0084 }
            r3 = com.tencent.bugly.proguard.ao.e;	 Catch:{ Throwable -> 0x0084 }
            r3 = r3.length();	 Catch:{ Throwable -> 0x0084 }
            r3 = (long) r3;	 Catch:{ Throwable -> 0x0084 }
            r5 = r1 + r3;	 Catch:{ Throwable -> 0x0084 }
            r1 = com.tencent.bugly.proguard.ao.g;	 Catch:{ Throwable -> 0x0084 }
            r1 = r1.e;	 Catch:{ Throwable -> 0x0084 }
            r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));	 Catch:{ Throwable -> 0x0084 }
            if (r3 <= 0) goto L_0x004c;	 Catch:{ Throwable -> 0x0084 }
        L_0x0045:
            r1 = com.tencent.bugly.proguard.ao.g;	 Catch:{ Throwable -> 0x0084 }
            r1.a();	 Catch:{ Throwable -> 0x0084 }
        L_0x004c:
            r1 = com.tencent.bugly.proguard.ao.g;	 Catch:{ Throwable -> 0x0084 }
            r1 = r1.a;	 Catch:{ Throwable -> 0x0084 }
            r2 = 0;	 Catch:{ Throwable -> 0x0084 }
            if (r1 == 0) goto L_0x006e;	 Catch:{ Throwable -> 0x0084 }
        L_0x0057:
            r1 = com.tencent.bugly.proguard.ao.g;	 Catch:{ Throwable -> 0x0084 }
            r3 = com.tencent.bugly.proguard.ao.e;	 Catch:{ Throwable -> 0x0084 }
            r3 = r3.toString();	 Catch:{ Throwable -> 0x0084 }
            r1.a(r3);	 Catch:{ Throwable -> 0x0084 }
            r1 = com.tencent.bugly.proguard.ao.e;	 Catch:{ Throwable -> 0x0084 }
            r1.setLength(r2);	 Catch:{ Throwable -> 0x0084 }
            goto L_0x007e;	 Catch:{ Throwable -> 0x0084 }
        L_0x006e:
            r1 = com.tencent.bugly.proguard.ao.e;	 Catch:{ Throwable -> 0x0084 }
            r1.setLength(r2);	 Catch:{ Throwable -> 0x0084 }
            r1 = com.tencent.bugly.proguard.ao.e;	 Catch:{ Throwable -> 0x0084 }
            r3 = r7.a;	 Catch:{ Throwable -> 0x0084 }
            r1.append(r3);	 Catch:{ Throwable -> 0x0084 }
        L_0x007e:
            com.tencent.bugly.proguard.ao.f = r2;	 Catch:{ Throwable -> 0x0084 }
            goto L_0x0084;
        L_0x0082:
            r1 = move-exception;
            goto L_0x0086;
        L_0x0084:
            monitor-exit(r0);	 Catch:{ all -> 0x0082 }
            return;	 Catch:{ all -> 0x0082 }
        L_0x0086:
            monitor-exit(r0);	 Catch:{ all -> 0x0082 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.1.run():void");
        }
    }

    /* compiled from: BUGLY */
    public static class a {
        private boolean a;
        private File b;
        private String c;
        private long d;
        private long e = 30720;

        public a(String str) {
            if (str != null) {
                if (!str.equals("")) {
                    this.c = str;
                    this.a = a();
                }
            }
        }

        private boolean a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = 0;
            r1 = new java.io.File;	 Catch:{ Throwable -> 0x0028 }
            r2 = r3.c;	 Catch:{ Throwable -> 0x0028 }
            r1.<init>(r2);	 Catch:{ Throwable -> 0x0028 }
            r3.b = r1;	 Catch:{ Throwable -> 0x0028 }
            r1 = r3.b;	 Catch:{ Throwable -> 0x0028 }
            r1 = r1.exists();	 Catch:{ Throwable -> 0x0028 }
            if (r1 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x0028 }
        L_0x0012:
            r1 = r3.b;	 Catch:{ Throwable -> 0x0028 }
            r1 = r1.delete();	 Catch:{ Throwable -> 0x0028 }
            if (r1 != 0) goto L_0x001d;	 Catch:{ Throwable -> 0x0028 }
        L_0x001a:
            r3.a = r0;	 Catch:{ Throwable -> 0x0028 }
            return r0;	 Catch:{ Throwable -> 0x0028 }
        L_0x001d:
            r1 = r3.b;	 Catch:{ Throwable -> 0x0028 }
            r1 = r1.createNewFile();	 Catch:{ Throwable -> 0x0028 }
            if (r1 != 0) goto L_0x002a;	 Catch:{ Throwable -> 0x0028 }
        L_0x0025:
            r3.a = r0;	 Catch:{ Throwable -> 0x0028 }
            return r0;
        L_0x0028:
            r3.a = r0;
        L_0x002a:
            r0 = 1;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a.a():boolean");
        }

        public boolean a(java.lang.String r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r11 = this;
            r0 = r11.a;
            r1 = 0;
            if (r0 != 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = 0;
            r2 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0031 }
            r3 = r11.b;	 Catch:{ Throwable -> 0x0031 }
            r4 = 1;	 Catch:{ Throwable -> 0x0031 }
            r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x0031 }
            r0 = "UTF-8";	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r12 = r12.getBytes(r0);	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.write(r12);	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.flush();	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.close();	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r5 = r11.d;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r12 = r12.length;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r7 = (long) r12;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r9 = r5 + r7;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r11.d = r9;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.close();	 Catch:{ IOException -> 0x0029 }
        L_0x0029:
            return r4;
        L_0x002a:
            r12 = move-exception;
            goto L_0x0039;
        L_0x002c:
            r0 = r2;
            goto L_0x0031;
        L_0x002e:
            r12 = move-exception;
            r2 = r0;
            goto L_0x0039;
        L_0x0031:
            r11.a = r1;	 Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0038;
        L_0x0035:
            r0.close();	 Catch:{ IOException -> 0x0038 }
        L_0x0038:
            return r1;
        L_0x0039:
            if (r2 == 0) goto L_0x003e;
        L_0x003b:
            r2.close();	 Catch:{ IOException -> 0x003e }
        L_0x003e:
            throw r12;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a.a(java.lang.String):boolean");
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.Object;
        r0.<init>();
        n = r0;
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x0011 }
        r1 = "MM-dd HH:mm:ss";	 Catch:{ Throwable -> 0x0011 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0011 }
        b = r0;	 Catch:{ Throwable -> 0x0011 }
        return;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.<clinit>():void");
    }

    private static boolean b(String str, String str2, String str3) {
        try {
            com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
            if (!(b == null || b.J == null)) {
                return b.J.appendLogToNative(str, str2, str3);
            }
        } catch (String str4) {
            if (an.a(str4) == null) {
                str4.printStackTrace();
            }
        }
        return null;
    }

    public static synchronized void a(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.bugly.proguard.ao.class;
        monitor-enter(r0);
        r1 = l;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x006a;	 Catch:{ all -> 0x006c }
    L_0x0007:
        if (r3 == 0) goto L_0x006a;	 Catch:{ all -> 0x006c }
    L_0x0009:
        r1 = a;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x006a;
    L_0x000e:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065 }
        r2 = 0;	 Catch:{ Throwable -> 0x0065 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0065 }
        e = r1;	 Catch:{ Throwable -> 0x0065 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0065 }
        d = r1;	 Catch:{ Throwable -> 0x0065 }
        j = r3;	 Catch:{ Throwable -> 0x0065 }
        r3 = com.tencent.bugly.crashreport.common.info.a.a(r3);	 Catch:{ Throwable -> 0x0065 }
        r1 = r3.e;	 Catch:{ Throwable -> 0x0065 }
        h = r1;	 Catch:{ Throwable -> 0x0065 }
        r3.getClass();	 Catch:{ Throwable -> 0x0065 }
        r3 = "";	 Catch:{ Throwable -> 0x0065 }
        i = r3;	 Catch:{ Throwable -> 0x0065 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065 }
        r3.<init>();	 Catch:{ Throwable -> 0x0065 }
        r1 = j;	 Catch:{ Throwable -> 0x0065 }
        r1 = r1.getFilesDir();	 Catch:{ Throwable -> 0x0065 }
        r1 = r1.getPath();	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = "/buglylog_";	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = h;	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = "_";	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = i;	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = ".txt";	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0065 }
        k = r3;	 Catch:{ Throwable -> 0x0065 }
        r3 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0065 }
        m = r3;	 Catch:{ Throwable -> 0x0065 }
    L_0x0065:
        r3 = 1;
        l = r3;	 Catch:{ all -> 0x006c }
        monitor-exit(r0);
        return;
    L_0x006a:
        monitor-exit(r0);
        return;
    L_0x006c:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a(android.content.Context):void");
    }

    public static void a(int i) {
        synchronized (n) {
            c = i;
            if (i < 0) {
                c = 0;
            } else if (i > 10240) {
                c = 10240;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(message);
            stringBuilder.append('\n');
            stringBuilder.append(ap.b(th));
            a(str, str2, stringBuilder.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
        r0 = com.tencent.bugly.proguard.ao.class;
        monitor-enter(r0);
        r1 = l;	 Catch:{ all -> 0x004b }
        if (r1 == 0) goto L_0x0049;
    L_0x0007:
        r1 = a;	 Catch:{ all -> 0x004b }
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        goto L_0x0049;
    L_0x000c:
        b(r3, r4, r5);	 Catch:{ all -> 0x004b }
        r1 = android.os.Process.myTid();	 Catch:{ all -> 0x004b }
        r1 = (long) r1;	 Catch:{ all -> 0x004b }
        r3 = a(r3, r4, r5, r1);	 Catch:{ all -> 0x004b }
        r4 = n;	 Catch:{ all -> 0x004b }
        monitor-enter(r4);	 Catch:{ all -> 0x004b }
        r5 = e;	 Catch:{ all -> 0x0046 }
        r5.append(r3);	 Catch:{ all -> 0x0046 }
        r5 = e;	 Catch:{ all -> 0x0046 }
        r5 = r5.length();	 Catch:{ all -> 0x0046 }
        r1 = c;	 Catch:{ all -> 0x0046 }
        if (r5 > r1) goto L_0x002d;
    L_0x002a:
        monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        monitor-exit(r0);
        return;
    L_0x002d:
        r5 = f;	 Catch:{ all -> 0x0046 }
        if (r5 == 0) goto L_0x0034;
    L_0x0031:
        monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        monitor-exit(r0);
        return;
    L_0x0034:
        r5 = 1;
        f = r5;	 Catch:{ all -> 0x0046 }
        r5 = com.tencent.bugly.proguard.am.a();	 Catch:{ all -> 0x0046 }
        r1 = new com.tencent.bugly.proguard.ao$1;	 Catch:{ all -> 0x0046 }
        r1.<init>(r3);	 Catch:{ all -> 0x0046 }
        r5.a(r1);	 Catch:{ all -> 0x0046 }
        monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        monitor-exit(r0);
        return;
    L_0x0046:
        r3 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        throw r3;	 Catch:{ all -> 0x004b }
    L_0x0049:
        monitor-exit(r0);
        return;
    L_0x004b:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static String a(String str, String str2, String str3, long j) {
        String format;
        d.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        if (b != null) {
            format = b.format(date);
        } else {
            format = date.toString();
        }
        StringBuilder stringBuilder = d;
        stringBuilder.append(format);
        stringBuilder.append(" ");
        stringBuilder.append(m);
        stringBuilder.append(" ");
        stringBuilder.append(j);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(str3);
        stringBuilder.append("\u0001\r\n");
        return d.toString();
    }

    public static byte[] a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = n;
        monitor-enter(r0);
        r2 = g;	 Catch:{ Throwable -> 0x0039 }
        if (r2 == 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0039 }
    L_0x000d:
        r2 = g;	 Catch:{ Throwable -> 0x0039 }
        r2 = r2.a;	 Catch:{ Throwable -> 0x0039 }
        if (r2 == 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0039 }
    L_0x0015:
        r2 = g;	 Catch:{ Throwable -> 0x0039 }
        r2 = r2.b;	 Catch:{ Throwable -> 0x0039 }
        goto L_0x001d;	 Catch:{ Throwable -> 0x0039 }
    L_0x001c:
        r2 = r1;	 Catch:{ Throwable -> 0x0039 }
    L_0x001d:
        r3 = e;	 Catch:{ Throwable -> 0x0039 }
        r3 = r3.length();	 Catch:{ Throwable -> 0x0039 }
        if (r3 != 0) goto L_0x0029;
    L_0x0025:
        if (r2 != 0) goto L_0x0029;
    L_0x0027:
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        return r1;
    L_0x0029:
        r3 = e;	 Catch:{ Throwable -> 0x0039 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0039 }
        r4 = "BuglyLog.txt";	 Catch:{ Throwable -> 0x0039 }
        r2 = com.tencent.bugly.proguard.ap.a(r2, r3, r4);	 Catch:{ Throwable -> 0x0039 }
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        return r2;	 Catch:{ all -> 0x0037 }
    L_0x0037:
        r1 = move-exception;	 Catch:{ all -> 0x0037 }
        goto L_0x003b;	 Catch:{ all -> 0x0037 }
    L_0x0039:
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        return r1;	 Catch:{ all -> 0x0037 }
    L_0x003b:
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a():byte[]");
    }
}
