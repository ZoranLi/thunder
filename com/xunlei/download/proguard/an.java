package com.xunlei.download.proguard;

import android.os.Environment;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.pushmessage.e;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: XLLog */
public class an {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static a b = new a();

    /* compiled from: XLLog */
    static class a {
        private String a = "";
        private boolean b = false;
        private String c = "";
        private long d = 0;
        private String e = "";
        private String f = "";
        private String g = "";
        private b h = b.LOG_LEVEL_OFF;
        private long i = 20971520;
        private File j = null;
        private int k = 0;
        private int l = 0;

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

        public String e() {
            return this.e == null ? "" : this.e;
        }

        public b f() {
            return this.h;
        }

        public File g() {
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
                while (this.j == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getPath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                    stringBuilder.append(".R");
                    stringBuilder.append(this.l);
                    stringBuilder.append(".0.");
                    stringBuilder.append(this.g);
                    this.j = new File(stringBuilder.toString());
                    if (!this.j.exists()) {
                        break;
                    }
                    this.l++;
                    this.j = null;
                }
                if (h() >= this.i) {
                    this.k++;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getPath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                    stringBuilder.append(".R");
                    stringBuilder.append(this.l);
                    stringBuilder.append(".");
                    stringBuilder.append(this.k);
                    stringBuilder.append(".");
                    stringBuilder.append(this.g);
                    this.j = new File(stringBuilder.toString());
                    this.j.delete();
                }
            }
            return this.j;
        }

        public long h() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.j;
            r1 = -1;
            if (r0 == 0) goto L_0x0015;
        L_0x0006:
            r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0015 }
            r3 = r4.j;	 Catch:{ Exception -> 0x0015 }
            r0.<init>(r3);	 Catch:{ Exception -> 0x0015 }
            r3 = r0.available();	 Catch:{ Exception -> 0x0015 }
            r1 = (long) r3;	 Catch:{ Exception -> 0x0015 }
            r0.close();	 Catch:{ Exception -> 0x0015 }
        L_0x0015:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.an.a.h():long");
        }

        public boolean a(java.lang.String r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r0 = new java.io.File;
            r0.<init>(r9);
            r9 = r0.exists();
            if (r9 == 0) goto L_0x0124;
        L_0x000b:
            r9 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0124 }
            r9.<init>(r0);	 Catch:{ Exception -> 0x0124 }
            r0 = "";	 Catch:{ Exception -> 0x0124 }
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0124 }
            r1.<init>();	 Catch:{ Exception -> 0x0124 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0124 }
            r2.<init>();	 Catch:{ Exception -> 0x0124 }
        L_0x001c:
            r3 = r9.read();	 Catch:{ Exception -> 0x0124 }
            r4 = -1;	 Catch:{ Exception -> 0x0124 }
            if (r3 == r4) goto L_0x011f;	 Catch:{ Exception -> 0x0124 }
        L_0x0023:
            r5 = r1.length();	 Catch:{ Exception -> 0x0124 }
            r6 = 10;	 Catch:{ Exception -> 0x0124 }
            r7 = 13;	 Catch:{ Exception -> 0x0124 }
            if (r5 != 0) goto L_0x003c;	 Catch:{ Exception -> 0x0124 }
        L_0x002d:
            r5 = 35;	 Catch:{ Exception -> 0x0124 }
            if (r3 != r5) goto L_0x003c;	 Catch:{ Exception -> 0x0124 }
        L_0x0031:
            r3 = r9.read();	 Catch:{ Exception -> 0x0124 }
            if (r3 == r4) goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x0037:
            if (r3 == r7) goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x0039:
            if (r3 != r6) goto L_0x0031;	 Catch:{ Exception -> 0x0124 }
        L_0x003b:
            goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x003c:
            r4 = 32;	 Catch:{ Exception -> 0x0124 }
            if (r3 == r4) goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x0040:
            r4 = 9;	 Catch:{ Exception -> 0x0124 }
            if (r3 == r4) goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x0044:
            r4 = 61;	 Catch:{ Exception -> 0x0124 }
            if (r3 != r4) goto L_0x004d;	 Catch:{ Exception -> 0x0124 }
        L_0x0048:
            r0 = r1.toString();	 Catch:{ Exception -> 0x0124 }
            goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x004d:
            if (r3 == r6) goto L_0x0062;	 Catch:{ Exception -> 0x0124 }
        L_0x004f:
            if (r3 != r7) goto L_0x0052;	 Catch:{ Exception -> 0x0124 }
        L_0x0051:
            goto L_0x0062;	 Catch:{ Exception -> 0x0124 }
        L_0x0052:
            r4 = r0.length();	 Catch:{ Exception -> 0x0124 }
            if (r4 != 0) goto L_0x005d;	 Catch:{ Exception -> 0x0124 }
        L_0x0058:
            r3 = (char) r3;	 Catch:{ Exception -> 0x0124 }
            r1.append(r3);	 Catch:{ Exception -> 0x0124 }
            goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x005d:
            r3 = (char) r3;	 Catch:{ Exception -> 0x0124 }
            r2.append(r3);	 Catch:{ Exception -> 0x0124 }
            goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x0062:
            r3 = r1.length();	 Catch:{ Exception -> 0x0124 }
            if (r3 == 0) goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x0068:
            r1 = "ANR_DIR";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x0078;	 Catch:{ Exception -> 0x0124 }
        L_0x0070:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r8.c = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x0078:
            r1 = "ANR_INTERVAL";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x0124 }
        L_0x0080:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r0 = java.lang.Long.parseLong(r0);	 Catch:{ Exception -> 0x0124 }
            r8.d = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x008c:
            r1 = "CRASH_DIR";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0124 }
        L_0x0094:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r8.a = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x009c:
            r1 = "CRASH_DUMP";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x00af;	 Catch:{ Exception -> 0x0124 }
        L_0x00a4:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r0 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Exception -> 0x0124 }
            r8.b = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x00af:
            r1 = "LOG_FILTER";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x00be;	 Catch:{ Exception -> 0x0124 }
        L_0x00b7:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r8.e = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x00be:
            r1 = "LOG_FILE";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x00cd;	 Catch:{ Exception -> 0x0124 }
        L_0x00c6:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r8.g = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x00cd:
            r1 = "LOG_DIR";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x00dc;	 Catch:{ Exception -> 0x0124 }
        L_0x00d5:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r8.f = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x00dc:
            r1 = "LOG_FILE_SIZE";	 Catch:{ Exception -> 0x0124 }
            r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r1 == 0) goto L_0x00fc;	 Catch:{ Exception -> 0x0124 }
        L_0x00e4:
            r0 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r0 = java.lang.Long.parseLong(r0);	 Catch:{ Exception -> 0x0124 }
            r8.i = r0;	 Catch:{ Exception -> 0x0124 }
            r0 = r8.i;	 Catch:{ Exception -> 0x0124 }
            r2 = 0;	 Catch:{ Exception -> 0x0124 }
            r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0124 }
            if (r4 != 0) goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x00f6:
            r0 = 20971520; // 0x1400000 float:3.526483E-38 double:1.03613076E-316;	 Catch:{ Exception -> 0x0124 }
            r8.i = r0;	 Catch:{ Exception -> 0x0124 }
            goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x00fc:
            r1 = "LOG_LEVEL";	 Catch:{ Exception -> 0x0124 }
            r0 = r0.equals(r1);	 Catch:{ Exception -> 0x0124 }
            if (r0 == 0) goto L_0x0111;	 Catch:{ Exception -> 0x0124 }
        L_0x0104:
            r0 = r8.h;	 Catch:{ Exception -> 0x0124 }
            r1 = r2.toString();	 Catch:{ Exception -> 0x0124 }
            r1 = r1.toLowerCase();	 Catch:{ Exception -> 0x0124 }
            r0.a(r1);	 Catch:{ Exception -> 0x0124 }
        L_0x0111:
            r0 = "";	 Catch:{ Exception -> 0x0124 }
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0124 }
            r1.<init>();	 Catch:{ Exception -> 0x0124 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0124 }
            r2.<init>();	 Catch:{ Exception -> 0x0124 }
            goto L_0x001c;	 Catch:{ Exception -> 0x0124 }
        L_0x011f:
            r9.close();	 Catch:{ Exception -> 0x0124 }
            r9 = 1;
            return r9;
        L_0x0124:
            r9 = 0;
            return r9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.an.a.a(java.lang.String):boolean");
        }
    }

    /* compiled from: XLLog */
    public enum b {
        LOG_LEVEL_DEBUG(1),
        LOG_LEVEL_INFO(2),
        LOG_LEVEL_WARN(3),
        LOG_LEVEL_ERROR(4),
        LOG_LEVEL_OFF(5);
        
        private int f;

        private b(int i) {
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

    public static boolean a(String str) {
        return b.a(str);
    }

    public static long a() {
        return b.a();
    }

    public static String b() {
        return b.b();
    }

    public static String c() {
        return b.d();
    }

    public static boolean d() {
        return b.c();
    }

    public static void a(String str, String str2) {
        a(b.LOG_LEVEL_INFO, str, str2);
    }

    public static void b(String str, String str2) {
        a(b.LOG_LEVEL_DEBUG, str, str2);
    }

    public static void c(String str, String str2) {
        a(b.LOG_LEVEL_WARN, str, str2);
    }

    public static void d(String str, String str2) {
        a(b.LOG_LEVEL_ERROR, str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        b bVar = b.LOG_LEVEL_WARN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(th);
        a(bVar, str, stringBuilder.toString());
    }

    public static void e(String str, String str2) {
        b(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        b bVar = b.LOG_LEVEL_WARN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(th);
        a(bVar, str, stringBuilder.toString());
    }

    public static boolean a(b bVar) {
        return bVar.a() >= b.f().a() ? true : null;
    }

    private static void a(b bVar, String str, String str2) {
        if (bVar.a() >= b.f().a()) {
            if (bVar.a() == b.LOG_LEVEL_INFO.a()) {
                f(str, str2);
            } else if (bVar.a() == b.LOG_LEVEL_DEBUG.a()) {
                f(str, str2);
            } else if (bVar.a() == b.LOG_LEVEL_WARN.a()) {
                f(str, str2);
            } else if (bVar.a() == b.LOG_LEVEL_ERROR.a()) {
                f(str, str2);
            }
            synchronized (an.class) {
                b(bVar, str, f(str, str2));
            }
        }
    }

    private static void b(com.xunlei.download.proguard.an.b r3, java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = a;
        r2 = new java.util.Date;
        r2.<init>();
        r1 = r1.format(r2);
        r0.append(r1);
        r1 = ": ";
        r0.append(r1);
        r3 = r3.toString();
        r0.append(r3);
        r3 = "/";
        r0.append(r3);
        r0.append(r4);
        r3 = "(";
        r0.append(r3);
        r3 = java.lang.Thread.currentThread();
        r3 = r3.getId();
        r0.append(r3);
        r3 = "):\t";
        r0.append(r3);
        r0.append(r5);
        r3 = "\r";
        r0.append(r3);
        r3 = r0.toString();
        r4 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0066 }
        r5 = b;	 Catch:{ Exception -> 0x0066 }
        r5 = r5.g();	 Catch:{ Exception -> 0x0066 }
        r0 = 1;	 Catch:{ Exception -> 0x0066 }
        r4.<init>(r5, r0);	 Catch:{ Exception -> 0x0066 }
        r5 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x0066 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x0066 }
        r5.write(r3);	 Catch:{ Exception -> 0x0066 }
        r5.newLine();	 Catch:{ Exception -> 0x0066 }
        r5.close();	 Catch:{ Exception -> 0x0066 }
        r4.close();	 Catch:{ Exception -> 0x0066 }
        return;
    L_0x0066:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.an.b(com.xunlei.download.proguard.an$b, java.lang.String, java.lang.String):void");
    }

    public static synchronized void a(Throwable th) {
        synchronized (an.class) {
            if (b.LOG_LEVEL_ERROR.a() >= b.f().a()) {
                try {
                    Writer fileWriter = new FileWriter(b.g(), true);
                    Writer bufferedWriter = new BufferedWriter(fileWriter);
                    th.printStackTrace(new PrintWriter(bufferedWriter));
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private static String f(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(" ");
        stringBuilder.append(b(str));
        stringBuilder.append(" [");
        stringBuilder.append(b.e());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static java.lang.String b(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Thread.currentThread();	 Catch:{ Exception -> 0x0058 }
        r0 = r0.getStackTrace();	 Catch:{ Exception -> 0x0058 }
        r1 = r0.length;	 Catch:{ Exception -> 0x0058 }
        r2 = 0;	 Catch:{ Exception -> 0x0058 }
    L_0x000a:
        if (r2 >= r1) goto L_0x005a;	 Catch:{ Exception -> 0x0058 }
    L_0x000c:
        r3 = r0[r2];	 Catch:{ Exception -> 0x0058 }
        r4 = -1;	 Catch:{ Exception -> 0x0058 }
        r5 = r3.getClassName();	 Catch:{ Exception -> 0x0058 }
        r5 = r5.indexOf(r6);	 Catch:{ Exception -> 0x0058 }
        if (r4 == r5) goto L_0x0055;	 Catch:{ Exception -> 0x0058 }
    L_0x0019:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
        r0 = "[";	 Catch:{ Exception -> 0x0058 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = r3.getFileName();	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = ":";	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = r3.getLineNumber();	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = " - ";	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = r3.getClassName();	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = ".";	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = r3.getMethodName();	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r0 = "]";	 Catch:{ Exception -> 0x0058 }
        r6.append(r0);	 Catch:{ Exception -> 0x0058 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0058 }
        goto L_0x005a;
    L_0x0055:
        r2 = r2 + 1;
        goto L_0x000a;
    L_0x0058:
        r6 = "[]";
    L_0x005a:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.an.b(java.lang.String):java.lang.String");
    }
}
