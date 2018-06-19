package com.xunlei.tdlive.util;

import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.pushmessage.e;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XLog {
    private static String a = "xllive/log";
    private static String b = "xllive.log";
    private static SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static a d = new a();
    private static int e = 0;
    private static boolean f = false;
    private static m g;

    private static class a {
        private String a = "";
        private boolean b = false;
        private String c = "";
        private long d = 0;
        private String e = "";
        private String f = XLog.a;
        private String g = XLog.b;
        private c h = c.LOG_LEVEL_DEBUG;
        private long i = 20971520;
        private File j = null;
        private int k = 0;

        public long a() {
            return this.d;
        }

        public String b() {
            return this.c == null ? "" : this.c;
        }

        public boolean c() {
            return this.b;
        }

        public String d() {
            return this.a == null ? "" : this.a;
        }

        public c e() {
            return this.h;
        }

        public File f() {
            if ("mounted".equalsIgnoreCase(Environment.getExternalStorageState())) {
                StringBuilder stringBuilder;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(Environment.getExternalStorageDirectory().getPath());
                stringBuilder2.append(File.separator);
                stringBuilder2.append(this.f);
                File file = new File(stringBuilder2.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (this.j == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getPath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                    stringBuilder.append(this.g);
                    this.j = new File(stringBuilder.toString());
                }
                while (this.j != null && this.j.length() >= this.i) {
                    this.k++;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getPath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                    stringBuilder.append(".");
                    stringBuilder.append(this.k);
                    stringBuilder.append(".");
                    stringBuilder.append(this.g);
                    this.j = new File(stringBuilder.toString());
                }
            }
            return this.j;
        }

        public boolean a(String str) {
            File file = new File(str);
            if (file.exists() != null) {
                try {
                    return a(new FileInputStream(file), true);
                } catch (String str2) {
                    str2.printStackTrace();
                }
            }
            return null;
        }

        public boolean a(java.io.InputStream r8, boolean r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            if (r8 == 0) goto L_0x0116;
        L_0x0002:
            r9 = "";	 Catch:{ Exception -> 0x0116 }
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0116 }
            r0.<init>();	 Catch:{ Exception -> 0x0116 }
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0116 }
            r1.<init>();	 Catch:{ Exception -> 0x0116 }
        L_0x000e:
            r2 = r8.read();	 Catch:{ Exception -> 0x0116 }
            r3 = -1;	 Catch:{ Exception -> 0x0116 }
            if (r2 == r3) goto L_0x0111;	 Catch:{ Exception -> 0x0116 }
        L_0x0015:
            r4 = r0.length();	 Catch:{ Exception -> 0x0116 }
            r5 = 10;	 Catch:{ Exception -> 0x0116 }
            r6 = 13;	 Catch:{ Exception -> 0x0116 }
            if (r4 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x0116 }
        L_0x001f:
            r4 = 35;	 Catch:{ Exception -> 0x0116 }
            if (r2 != r4) goto L_0x002e;	 Catch:{ Exception -> 0x0116 }
        L_0x0023:
            r2 = r8.read();	 Catch:{ Exception -> 0x0116 }
            if (r2 == r3) goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x0029:
            if (r2 == r6) goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x002b:
            if (r2 != r5) goto L_0x0023;	 Catch:{ Exception -> 0x0116 }
        L_0x002d:
            goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x002e:
            r3 = 32;	 Catch:{ Exception -> 0x0116 }
            if (r2 == r3) goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x0032:
            r3 = 9;	 Catch:{ Exception -> 0x0116 }
            if (r2 == r3) goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x0036:
            r3 = 61;	 Catch:{ Exception -> 0x0116 }
            if (r2 != r3) goto L_0x003f;	 Catch:{ Exception -> 0x0116 }
        L_0x003a:
            r9 = r0.toString();	 Catch:{ Exception -> 0x0116 }
            goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x003f:
            if (r2 == r5) goto L_0x0054;	 Catch:{ Exception -> 0x0116 }
        L_0x0041:
            if (r2 != r6) goto L_0x0044;	 Catch:{ Exception -> 0x0116 }
        L_0x0043:
            goto L_0x0054;	 Catch:{ Exception -> 0x0116 }
        L_0x0044:
            r3 = r9.length();	 Catch:{ Exception -> 0x0116 }
            if (r3 != 0) goto L_0x004f;	 Catch:{ Exception -> 0x0116 }
        L_0x004a:
            r2 = (char) r2;	 Catch:{ Exception -> 0x0116 }
            r0.append(r2);	 Catch:{ Exception -> 0x0116 }
            goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x004f:
            r2 = (char) r2;	 Catch:{ Exception -> 0x0116 }
            r1.append(r2);	 Catch:{ Exception -> 0x0116 }
            goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x0054:
            r2 = r0.length();	 Catch:{ Exception -> 0x0116 }
            if (r2 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x005a:
            r0 = "ANR_DIR";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x006a;	 Catch:{ Exception -> 0x0116 }
        L_0x0062:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r7.c = r9;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x006a:
            r0 = "ANR_INTERVAL";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x007e;	 Catch:{ Exception -> 0x0116 }
        L_0x0072:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r0 = java.lang.Long.parseLong(r9);	 Catch:{ Exception -> 0x0116 }
            r7.d = r0;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x007e:
            r0 = "CRASH_DIR";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x008e;	 Catch:{ Exception -> 0x0116 }
        L_0x0086:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r7.a = r9;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x008e:
            r0 = "CRASH_DUMP";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x00a1;	 Catch:{ Exception -> 0x0116 }
        L_0x0096:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r9 = java.lang.Boolean.parseBoolean(r9);	 Catch:{ Exception -> 0x0116 }
            r7.b = r9;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x00a1:
            r0 = "LOG_FILTER";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x00b0;	 Catch:{ Exception -> 0x0116 }
        L_0x00a9:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r7.e = r9;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x00b0:
            r0 = "LOG_FILE";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x00bf;	 Catch:{ Exception -> 0x0116 }
        L_0x00b8:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r7.g = r9;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x00bf:
            r0 = "LOG_DIR";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x00ce;	 Catch:{ Exception -> 0x0116 }
        L_0x00c7:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r7.f = r9;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x00ce:
            r0 = "LOG_FILE_SIZE";	 Catch:{ Exception -> 0x0116 }
            r0 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r0 == 0) goto L_0x00ee;	 Catch:{ Exception -> 0x0116 }
        L_0x00d6:
            r9 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r0 = java.lang.Long.parseLong(r9);	 Catch:{ Exception -> 0x0116 }
            r7.i = r0;	 Catch:{ Exception -> 0x0116 }
            r0 = r7.i;	 Catch:{ Exception -> 0x0116 }
            r2 = 0;	 Catch:{ Exception -> 0x0116 }
            r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0116 }
            if (r9 != 0) goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x00e8:
            r0 = 20971520; // 0x1400000 float:3.526483E-38 double:1.03613076E-316;	 Catch:{ Exception -> 0x0116 }
            r7.i = r0;	 Catch:{ Exception -> 0x0116 }
            goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x00ee:
            r0 = "LOG_LEVEL";	 Catch:{ Exception -> 0x0116 }
            r9 = r9.equals(r0);	 Catch:{ Exception -> 0x0116 }
            if (r9 == 0) goto L_0x0103;	 Catch:{ Exception -> 0x0116 }
        L_0x00f6:
            r9 = r7.h;	 Catch:{ Exception -> 0x0116 }
            r0 = r1.toString();	 Catch:{ Exception -> 0x0116 }
            r0 = r0.toLowerCase();	 Catch:{ Exception -> 0x0116 }
            r9.a(r0);	 Catch:{ Exception -> 0x0116 }
        L_0x0103:
            r9 = "";	 Catch:{ Exception -> 0x0116 }
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0116 }
            r0.<init>();	 Catch:{ Exception -> 0x0116 }
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0116 }
            r1.<init>();	 Catch:{ Exception -> 0x0116 }
            goto L_0x000e;	 Catch:{ Exception -> 0x0116 }
        L_0x0111:
            r8.close();	 Catch:{ Exception -> 0x0116 }
            r8 = 1;
            return r8;
        L_0x0116:
            r8 = 0;
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.XLog.a.a(java.io.InputStream, boolean):boolean");
        }
    }

    private static class b {
        StackTraceElement[] a;
        c b;
        String c;
        String d;
        Throwable e;
        long f;

        private b() {
        }
    }

    public enum c {
        LOG_LEVEL_DEBUG(1),
        LOG_LEVEL_INFO(2),
        LOG_LEVEL_WARN(3),
        LOG_LEVEL_ERROR(4),
        LOG_LEVEL_OFF(5);
        
        private int f;

        private c(int i) {
            this.f = null;
            this.f = i;
        }

        public final void a(String str) {
            if (!str.equals(e.a)) {
                if (!str.equals("error")) {
                    if (!str.equals(IXAdRequestInfo.WIDTH)) {
                        if (!str.equals("warn")) {
                            if (!str.equals("i")) {
                                if (!str.equals("info")) {
                                    if (str.equals(d.a) || str.equals("debug") != null) {
                                        this.f = LOG_LEVEL_DEBUG.a();
                                    }
                                    return;
                                }
                            }
                            this.f = LOG_LEVEL_INFO.a();
                            return;
                        }
                    }
                    this.f = LOG_LEVEL_WARN.a();
                    return;
                }
            }
            this.f = LOG_LEVEL_ERROR.a();
        }

        public final int a() {
            return this.f;
        }

        public final String toString() {
            return a(true);
        }

        public final String a(boolean z) {
            if (a() == LOG_LEVEL_ERROR.a()) {
                return z ? "E" : "ERROR";
            } else {
                if (a() == LOG_LEVEL_WARN.a()) {
                    return z ? "W" : "WARN";
                } else {
                    if (a() == LOG_LEVEL_DEBUG.a()) {
                        return z ? "D" : "DEBUG";
                    } else {
                        if (a() == LOG_LEVEL_INFO.a()) {
                            return z ? "I" : "INFO";
                        } else {
                            return "";
                        }
                    }
                }
            }
        }
    }

    public static boolean init(String str) {
        return d.a(str);
    }

    public static long getAnrInterval() {
        return d.a();
    }

    public static String getAnrDir() {
        return d.b();
    }

    public static String getCrashDir() {
        return d.d();
    }

    public static boolean needDumpCrash() {
        return d.c();
    }

    public static boolean enableLog() {
        return f;
    }

    public static void enableLog(boolean z) {
        f = z;
    }

    public static void dumpMessageQueue(int i) {
        e = i;
    }

    public static StackTraceElement getCurrentStackTraceElement() {
        return Thread.currentThread().getStackTrace()[3];
    }

    public static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    public static void i(String str, String str2) {
        a(c.LOG_LEVEL_INFO, str, str2, null);
    }

    public static void d(String str, String str2) {
        a(c.LOG_LEVEL_INFO, str, str2, null);
    }

    public static void w(String str, String str2) {
        a(c.LOG_LEVEL_WARN, str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        a(c.LOG_LEVEL_ERROR, str, str2, th);
    }

    public static void printStackTrace(String str, Throwable th) {
        if (enableLog()) {
            a(c.LOG_LEVEL_WARN, str, null, th);
        }
    }

    public static boolean canbeLog(c cVar) {
        return cVar.a() >= d.e().a() ? true : null;
    }

    private static void a(c cVar, String str, String str2, Throwable th) {
        if (enableLog() && cVar.a() >= d.e().a()) {
            b(cVar, str, str2, th);
        }
    }

    private static void b(c cVar, String str, String str2, Throwable th) {
        if (g == null || !g.c()) {
            m mVar = new m("log", new Callback() {
                public final boolean handleMessage(Message message) {
                    if (message.obj instanceof b) {
                        b bVar = (b) message.obj;
                        if (bVar.b == c.LOG_LEVEL_WARN && bVar.d == null && bVar.e != null) {
                            bVar.e.printStackTrace();
                            bVar.d = bVar.c;
                            bVar.b = c.LOG_LEVEL_ERROR;
                        }
                        if (bVar.b == c.LOG_LEVEL_INFO) {
                            a(bVar.c, bVar.d, bVar.a);
                        } else if (bVar.b == c.LOG_LEVEL_DEBUG) {
                            a(bVar.c, bVar.d, bVar.a);
                        } else if (bVar.b == c.LOG_LEVEL_WARN) {
                            a(bVar.c, bVar.d, bVar.a);
                        } else if (bVar.b == c.LOG_LEVEL_ERROR) {
                            a(bVar.c, bVar.d, bVar.a);
                        }
                        a(bVar.f, bVar.b, bVar.c, a(bVar.c, bVar.d, bVar.a));
                        a();
                    }
                    return null;
                }

                private void a() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r4 = this;
                    r0 = com.xunlei.tdlive.util.XLog.e;
                    if (r0 <= 0) goto L_0x0034;
                L_0x0006:
                    r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0034 }
                    r0.<init>();	 Catch:{ Throwable -> 0x0034 }
                    r1 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x0034 }
                    r2 = new android.util.StringBuilderPrinter;	 Catch:{ Throwable -> 0x0034 }
                    r2.<init>(r0);	 Catch:{ Throwable -> 0x0034 }
                    r3 = "";	 Catch:{ Throwable -> 0x0034 }
                    r1.dump(r2, r3);	 Catch:{ Throwable -> 0x0034 }
                    r0 = r0.toString();	 Catch:{ Throwable -> 0x0034 }
                    r1 = com.xunlei.tdlive.util.XLog.e;	 Catch:{ Throwable -> 0x0034 }
                    r2 = 1;	 Catch:{ Throwable -> 0x0034 }
                    if (r1 != r2) goto L_0x0030;	 Catch:{ Throwable -> 0x0034 }
                L_0x0024:
                    r1 = "(Total messages: ";	 Catch:{ Throwable -> 0x0034 }
                    r1 = r0.lastIndexOf(r1);	 Catch:{ Throwable -> 0x0034 }
                    if (r1 <= 0) goto L_0x002f;	 Catch:{ Throwable -> 0x0034 }
                L_0x002c:
                    r0.substring(r1);	 Catch:{ Throwable -> 0x0034 }
                L_0x002f:
                    return;	 Catch:{ Throwable -> 0x0034 }
                L_0x0030:
                    com.xunlei.tdlive.util.XLog.e;	 Catch:{ Throwable -> 0x0034 }
                    return;
                L_0x0034:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.XLog.1.a():void");
                }

                private void a(long r4, com.xunlei.tdlive.util.XLog.c r6, java.lang.String r7, java.lang.String r8) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r3 = this;
                    r0 = new java.lang.StringBuilder;
                    r0.<init>();
                    r1 = com.xunlei.tdlive.util.XLog.c;
                    r2 = new java.util.Date;
                    r2.<init>();
                    r1 = r1.format(r2);
                    r0.append(r1);
                    r1 = ": ";
                    r0.append(r1);
                    r6 = r6.toString();
                    r0.append(r6);
                    r6 = "/";
                    r0.append(r6);
                    r0.append(r7);
                    r6 = "(";
                    r0.append(r6);
                    r0.append(r4);
                    r4 = "): ";
                    r0.append(r4);
                    r0.append(r8);
                    r4 = "\r";
                    r0.append(r4);
                    r4 = r0.toString();
                    r5 = new java.io.FileWriter;	 Catch:{ Throwable -> 0x0062 }
                    r6 = com.xunlei.tdlive.util.XLog.d;	 Catch:{ Throwable -> 0x0062 }
                    r6 = r6.f();	 Catch:{ Throwable -> 0x0062 }
                    r7 = 1;	 Catch:{ Throwable -> 0x0062 }
                    r5.<init>(r6, r7);	 Catch:{ Throwable -> 0x0062 }
                    r6 = new java.io.BufferedWriter;	 Catch:{ Throwable -> 0x0062 }
                    r6.<init>(r5);	 Catch:{ Throwable -> 0x0062 }
                    r6.write(r4);	 Catch:{ Throwable -> 0x0062 }
                    r6.newLine();	 Catch:{ Throwable -> 0x0062 }
                    r6.close();	 Catch:{ Throwable -> 0x0062 }
                    r5.close();	 Catch:{ Throwable -> 0x0062 }
                    return;
                L_0x0062:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.XLog.1.a(long, com.xunlei.tdlive.util.XLog$c, java.lang.String, java.lang.String):void");
                }

                private String a(String str, String str2, StackTraceElement[] stackTraceElementArr) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(" ");
                    stringBuilder.append(a(str, stackTraceElementArr));
                    return stringBuilder.toString();
                }

                private java.lang.String a(java.lang.String r6, java.lang.StackTraceElement[] r7) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r5 = this;
                    if (r7 == 0) goto L_0x0054;
                L_0x0002:
                    r0 = r7.length;	 Catch:{ Throwable -> 0x0052 }
                    r1 = 0;	 Catch:{ Throwable -> 0x0052 }
                L_0x0004:
                    if (r1 >= r0) goto L_0x0054;	 Catch:{ Throwable -> 0x0052 }
                L_0x0006:
                    r2 = r7[r1];	 Catch:{ Throwable -> 0x0052 }
                    r3 = -1;	 Catch:{ Throwable -> 0x0052 }
                    r4 = r2.getClassName();	 Catch:{ Throwable -> 0x0052 }
                    r4 = r4.indexOf(r6);	 Catch:{ Throwable -> 0x0052 }
                    if (r3 == r4) goto L_0x004f;	 Catch:{ Throwable -> 0x0052 }
                L_0x0013:
                    r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0052 }
                    r7 = "[";	 Catch:{ Throwable -> 0x0052 }
                    r6.<init>(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = r2.getFileName();	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = ":";	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = r2.getLineNumber();	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = " - ";	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = r2.getClassName();	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = ".";	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = r2.getMethodName();	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r7 = "]";	 Catch:{ Throwable -> 0x0052 }
                    r6.append(r7);	 Catch:{ Throwable -> 0x0052 }
                    r6 = r6.toString();	 Catch:{ Throwable -> 0x0052 }
                    goto L_0x0054;
                L_0x004f:
                    r1 = r1 + 1;
                    goto L_0x0004;
                L_0x0052:
                    r6 = "[]";
                L_0x0054:
                    return r6;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.XLog.1.a(java.lang.String, java.lang.StackTraceElement[]):java.lang.String");
                }
            });
            g = mVar;
            mVar.a();
        }
        b bVar = new b();
        bVar.a = Thread.currentThread().getStackTrace();
        bVar.c = str;
        bVar.b = cVar;
        bVar.d = str2;
        bVar.e = th;
        bVar.f = Thread.currentThread().getId();
        cVar = new Message();
        cVar.what = 1000;
        cVar.obj = bVar;
        g.a(cVar, null);
    }
}
