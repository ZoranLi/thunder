package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.e.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.model.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: UploadTask */
public abstract class c implements Runnable {
    private static boolean a = false;
    static volatile boolean b = false;
    static int d;
    int c = -1;
    float e = 200.0f;
    int f = 0;

    public abstract void a();

    public abstract void b();

    public static boolean c() {
        return b;
    }

    private static int a(List<a> list) {
        int i = 0;
        if (list == null) {
            return 0;
        }
        int i2 = 0;
        while (i < list.size()) {
            String str = ((a) list.get(i)).b;
            if (str != null && "6005".equalsIgnoreCase(str.toString())) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private int d() {
        if (this.c == -1) {
            String a = l.a();
            if ("wifi".equalsIgnoreCase(a)) {
                this.c = 20;
            } else if ("4G".equalsIgnoreCase(a)) {
                this.c = 16;
            } else if ("3G".equalsIgnoreCase(a)) {
                this.c = 12;
            } else {
                this.c = 8;
            }
        }
        return this.c;
    }

    private static com.alibaba.mtl.log.e.a.a a(String str, Map<String, Object> map) {
        if (str != null) {
            map = e.a(2, str, map).b;
            i.a("UploadTask", "url:", str);
            if (map != null) {
                str = null;
                try {
                    str = new String(map, "UTF-8");
                } catch (Map<String, Object> map2) {
                    map2.printStackTrace();
                }
                if (str != null) {
                    i.a("UploadTask", "result:", str);
                    return com.alibaba.mtl.log.e.a.a(str);
                }
            }
        }
        return com.alibaba.mtl.log.e.a.a.c;
    }

    private Map<String, Object> b(List<a> list) {
        if (list != null) {
            if (list.size() != 0) {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < list.size(); i++) {
                    List a = com.alibaba.mtl.log.a.a.a(((a) list.get(i)).b);
                    if (a != null) {
                        for (int i2 = 0; i2 < a.size(); i2++) {
                            StringBuilder stringBuilder = (StringBuilder) hashMap.get(a.get(i2));
                            if (stringBuilder == null) {
                                stringBuilder = new StringBuilder();
                                hashMap.put(a.get(i2), stringBuilder);
                            } else {
                                stringBuilder.append("\n");
                            }
                            stringBuilder.append(((a) list.get(i)).a());
                        }
                    }
                }
                Map hashMap2 = new HashMap();
                this.f = 0;
                for (String str : hashMap.keySet()) {
                    Object a2 = a(((StringBuilder) hashMap.get(str)).toString());
                    hashMap2.put(str, a2);
                    this.f += a2.length;
                }
                this.e = ((float) this.f) / ((float) list.size());
                i.a("UploadTask", "averagePackageSize:", Float.valueOf(this.e));
                return hashMap2;
            }
        }
        return null;
    }

    private static byte[] a(java.lang.String r3) {
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
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 0;
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ IOException -> 0x0023 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0023 }
        r1 = "UTF-8";	 Catch:{ IOException -> 0x001d, all -> 0x001b }
        r3 = r3.getBytes(r1);	 Catch:{ IOException -> 0x001d, all -> 0x001b }
        r2.write(r3);	 Catch:{ IOException -> 0x001d, all -> 0x001b }
        r2.flush();	 Catch:{ IOException -> 0x001d, all -> 0x001b }
        r2.close();	 Catch:{ Exception -> 0x002c }
        goto L_0x002c;
    L_0x001b:
        r3 = move-exception;
        goto L_0x003a;
    L_0x001d:
        r3 = move-exception;
        r1 = r2;
        goto L_0x0024;
    L_0x0020:
        r3 = move-exception;
        r2 = r1;
        goto L_0x003a;
    L_0x0023:
        r3 = move-exception;
    L_0x0024:
        r3.printStackTrace();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x002c;
    L_0x0029:
        r1.close();	 Catch:{ Exception -> 0x002c }
    L_0x002c:
        r3 = r0.toByteArray();
        r1 = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK";
        r3 = com.alibaba.mtl.log.e.n.a(r3, r1);
        r0.close();	 Catch:{ Exception -> 0x0039 }
    L_0x0039:
        return r3;
    L_0x003a:
        if (r2 == 0) goto L_0x003f;
    L_0x003c:
        r2.close();	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.d.c.a(java.lang.String):byte[]");
    }

    public void run() {
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
        r21 = this;
        r1 = r21;
        r2 = com.alibaba.mtl.log.e.l.b();	 Catch:{ Throwable -> 0x0292 }
        if (r2 == 0) goto L_0x028e;	 Catch:{ Throwable -> 0x0292 }
    L_0x0008:
        r2 = a;	 Catch:{ Throwable -> 0x0292 }
        if (r2 != 0) goto L_0x028e;	 Catch:{ Throwable -> 0x0292 }
    L_0x000c:
        r2 = b;	 Catch:{ Throwable -> 0x0292 }
        if (r2 != 0) goto L_0x028e;	 Catch:{ Throwable -> 0x0292 }
    L_0x0010:
        r2 = 1;	 Catch:{ Throwable -> 0x0292 }
        b = r2;	 Catch:{ Throwable -> 0x0292 }
        r3 = com.alibaba.mtl.log.a.d.a();	 Catch:{ Throwable -> 0x0292 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0292 }
        r4 = 0;	 Catch:{ Throwable -> 0x0292 }
        r5 = r4;	 Catch:{ Throwable -> 0x0292 }
        r6 = r5;	 Catch:{ Throwable -> 0x0292 }
    L_0x001c:
        r7 = 3;	 Catch:{ Throwable -> 0x0292 }
        if (r5 >= r7) goto L_0x0288;	 Catch:{ Throwable -> 0x0292 }
    L_0x001f:
        r8 = com.alibaba.mtl.log.a.c();	 Catch:{ Throwable -> 0x0292 }
        r8 = com.alibaba.mtl.log.e.k.a(r8);	 Catch:{ Throwable -> 0x0292 }
        if (r8 != 0) goto L_0x0036;	 Catch:{ Throwable -> 0x0292 }
    L_0x0029:
        r3 = "UploadTask";	 Catch:{ Throwable -> 0x0292 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0292 }
        r5 = "Other Process is Uploading, break";	 Catch:{ Throwable -> 0x0292 }
        r2[r4] = r5;	 Catch:{ Throwable -> 0x0292 }
        com.alibaba.mtl.log.e.i.a(r3, r2);	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0288;	 Catch:{ Throwable -> 0x0292 }
    L_0x0036:
        r8 = com.alibaba.mtl.log.c.c.a();	 Catch:{ Throwable -> 0x0292 }
        r8.b();	 Catch:{ Throwable -> 0x0292 }
        r8 = 0;	 Catch:{ Throwable -> 0x0292 }
        if (r3 == 0) goto L_0x00b8;	 Catch:{ Throwable -> 0x0292 }
    L_0x0040:
        r9 = r3.size();	 Catch:{ Throwable -> 0x0292 }
        if (r9 <= 0) goto L_0x00b8;	 Catch:{ Throwable -> 0x0292 }
    L_0x0046:
        r9 = r8;	 Catch:{ Throwable -> 0x0292 }
    L_0x0047:
        r10 = r3.size();	 Catch:{ Throwable -> 0x0292 }
        if (r6 >= r10) goto L_0x00b5;	 Catch:{ Throwable -> 0x0292 }
    L_0x004d:
        r9 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x0292 }
        r9 = r3.get(r9);	 Catch:{ Throwable -> 0x0292 }
        r9 = (com.alibaba.mtl.log.a.c) r9;	 Catch:{ Throwable -> 0x0292 }
        r10 = r9.b;	 Catch:{ Throwable -> 0x0292 }
        if (r10 == 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0292 }
    L_0x005b:
        r10 = r9.b;	 Catch:{ Throwable -> 0x0292 }
        r10 = r10.size();	 Catch:{ Throwable -> 0x0292 }
        if (r10 <= 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0292 }
    L_0x0063:
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0292 }
        r10.<init>();	 Catch:{ Throwable -> 0x0292 }
        r11 = "eventId in (";	 Catch:{ Throwable -> 0x0292 }
        r10.append(r11);	 Catch:{ Throwable -> 0x0292 }
        r11 = r4;	 Catch:{ Throwable -> 0x0292 }
    L_0x006e:
        r12 = r9.b;	 Catch:{ Throwable -> 0x0292 }
        r12 = r12.size();	 Catch:{ Throwable -> 0x0292 }
        if (r11 >= r12) goto L_0x008b;	 Catch:{ Throwable -> 0x0292 }
    L_0x0076:
        if (r11 == 0) goto L_0x007d;	 Catch:{ Throwable -> 0x0292 }
    L_0x0078:
        r12 = " , ";	 Catch:{ Throwable -> 0x0292 }
        r10.append(r12);	 Catch:{ Throwable -> 0x0292 }
    L_0x007d:
        r12 = r9.b;	 Catch:{ Throwable -> 0x0292 }
        r12 = r12.get(r11);	 Catch:{ Throwable -> 0x0292 }
        r12 = (java.lang.String) r12;	 Catch:{ Throwable -> 0x0292 }
        r10.append(r12);	 Catch:{ Throwable -> 0x0292 }
        r11 = r11 + 1;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x006e;	 Catch:{ Throwable -> 0x0292 }
    L_0x008b:
        r11 = " ) ";	 Catch:{ Throwable -> 0x0292 }
        r10.append(r11);	 Catch:{ Throwable -> 0x0292 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0096;	 Catch:{ Throwable -> 0x0292 }
    L_0x0095:
        r10 = r8;	 Catch:{ Throwable -> 0x0292 }
    L_0x0096:
        r11 = com.alibaba.mtl.log.c.c.a();	 Catch:{ Throwable -> 0x0292 }
        r12 = r21.d();	 Catch:{ Throwable -> 0x0292 }
        r10 = r11.a(r10, r12);	 Catch:{ Throwable -> 0x0292 }
        r11 = r10.size();	 Catch:{ Throwable -> 0x0292 }
        if (r11 <= 0) goto L_0x00b1;	 Catch:{ Throwable -> 0x0292 }
    L_0x00a8:
        r9 = r9.a;	 Catch:{ Throwable -> 0x0292 }
        r20 = r10;	 Catch:{ Throwable -> 0x0292 }
        r10 = r6;	 Catch:{ Throwable -> 0x0292 }
        r6 = r9;	 Catch:{ Throwable -> 0x0292 }
        r9 = r20;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x00bb;	 Catch:{ Throwable -> 0x0292 }
    L_0x00b1:
        r6 = r6 + 1;	 Catch:{ Throwable -> 0x0292 }
        r9 = r10;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0047;	 Catch:{ Throwable -> 0x0292 }
    L_0x00b5:
        r10 = r6;	 Catch:{ Throwable -> 0x0292 }
        r6 = r8;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x00bb;	 Catch:{ Throwable -> 0x0292 }
    L_0x00b8:
        r10 = r6;	 Catch:{ Throwable -> 0x0292 }
        r6 = r8;	 Catch:{ Throwable -> 0x0292 }
        r9 = r6;	 Catch:{ Throwable -> 0x0292 }
    L_0x00bb:
        if (r9 == 0) goto L_0x00c5;	 Catch:{ Throwable -> 0x0292 }
    L_0x00bd:
        if (r9 == 0) goto L_0x00d1;	 Catch:{ Throwable -> 0x0292 }
    L_0x00bf:
        r11 = r9.size();	 Catch:{ Throwable -> 0x0292 }
        if (r11 != 0) goto L_0x00d1;	 Catch:{ Throwable -> 0x0292 }
    L_0x00c5:
        r9 = com.alibaba.mtl.log.c.c.a();	 Catch:{ Throwable -> 0x0292 }
        r11 = r21.d();	 Catch:{ Throwable -> 0x0292 }
        r9 = r9.a(r8, r11);	 Catch:{ Throwable -> 0x0292 }
    L_0x00d1:
        if (r9 == 0) goto L_0x0283;	 Catch:{ Throwable -> 0x0292 }
    L_0x00d3:
        r8 = r9.size();	 Catch:{ Throwable -> 0x0292 }
        if (r8 != 0) goto L_0x00db;	 Catch:{ Throwable -> 0x0292 }
    L_0x00d9:
        goto L_0x0283;	 Catch:{ Throwable -> 0x0292 }
    L_0x00db:
        r8 = a(r9);	 Catch:{ Throwable -> 0x0292 }
        r11 = r1.b(r9);	 Catch:{ Throwable -> 0x0292 }
        if (r11 == 0) goto L_0x027f;	 Catch:{ Throwable -> 0x0292 }
    L_0x00e5:
        r12 = r11.size();	 Catch:{ Throwable -> 0x0292 }
        if (r12 != 0) goto L_0x00ed;
    L_0x00eb:
        goto L_0x027f;
    L_0x00ed:
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r14 = com.alibaba.mtl.log.a.a.b;	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r15 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        if (r15 != 0) goto L_0x010c;	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
    L_0x00f9:
        r14 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r15 = "http://";	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r14.<init>(r15);	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r14.append(r6);	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r6 = "/rest/sur";	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r14.append(r6);	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r14 = r14.toString();	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
    L_0x010c:
        r6 = com.alibaba.mtl.log.e.t.a(r14, r11);	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r6 = a(r6, r11);	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r11 = r6.a;	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r14 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r16 = r8;	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r7 = r14 - r12;	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r12 = java.lang.Boolean.valueOf(r11);	 Catch:{ Throwable -> 0x0274, all -> 0x026e }
        r17 = 0;
        r13 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1));
        if (r13 < 0) goto L_0x0192;
    L_0x0128:
        r13 = r1.f;	 Catch:{ Throwable -> 0x018d, all -> 0x026e }
        r13 = (float) r13;
        r2 = (float) r7;
        r13 = r13 / r2;
        r2 = r12.booleanValue();	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
        if (r2 == 0) goto L_0x014e;	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
    L_0x0133:
        r17 = 45000; // 0xafc8 float:6.3058E-41 double:2.2233E-319;	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
        r2 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1));	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
        if (r2 > 0) goto L_0x0192;	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
    L_0x013a:
        r2 = 1194313728; // 0x472fc800 float:45000.0 double:5.900693834E-315;	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
        r2 = r2 * r13;	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
        r12 = (double) r2;	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
        r2 = r1.e;	 Catch:{ Throwable -> 0x0188, all -> 0x026e }
        r19 = r5;
        r4 = (double) r2;
        r12 = r12 / r4;
        r2 = d;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = (double) r2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12 = r12 - r4;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = (int) r12;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r1.c = r2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = 1;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x015c;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x014e:
        r19 = r5;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r1.c;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = 2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r2 / r4;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r1.c = r2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = d;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = 1;
        r2 = r2 + r4;
        d = r2;	 Catch:{ Throwable -> 0x0185, all -> 0x026e }
    L_0x015c:
        r2 = r1.c;	 Catch:{ Throwable -> 0x0185, all -> 0x026e }
        if (r2 > 0) goto L_0x0166;	 Catch:{ Throwable -> 0x0185, all -> 0x026e }
    L_0x0160:
        r1.c = r4;	 Catch:{ Throwable -> 0x0185, all -> 0x026e }
        r2 = 0;
        d = r2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x016e;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x0166:
        r2 = r1.c;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = 350; // 0x15e float:4.9E-43 double:1.73E-321;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        if (r2 <= r4) goto L_0x016e;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x016c:
        r1.c = r4;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x016e:
        r2 = "UploadTask";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = 2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r5 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = "winsize:";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12 = 0;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r5[r12] = r4;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = r1.c;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12 = 1;
        r5[r12] = r4;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        com.alibaba.mtl.log.e.i.a(r2, r5);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x0194;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x0185:
        r12 = r4;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x0268;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x0188:
        r19 = r5;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x018a:
        r12 = 1;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x0268;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x018d:
        r19 = r5;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x018f:
        r12 = r2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x0268;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x0192:
        r19 = r5;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x0194:
        if (r11 == 0) goto L_0x01c0;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x0196:
        r2 = com.alibaba.mtl.log.c.c.a();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = "LogStoreMgr";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r5 = 1;
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x01bd, all -> 0x026e }
        r5 = 0;
        r6[r5] = r9;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        com.alibaba.mtl.log.e.i.a(r4, r6);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r2.a;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r2.b(r9);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = r9.size();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = r4 - r16;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        if (r2 >= r4) goto L_0x01b6;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x01b3:
        r21.b();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x01b6:
        com.alibaba.mtl.log.b.a.a(r9, r2);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        com.alibaba.mtl.log.b.a.a();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x01f9;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x01bd:
        r12 = r5;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        goto L_0x0268;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x01c0:
        r2 = r9.size();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r2 - r16;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        com.alibaba.mtl.log.b.a.a(r2);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        com.alibaba.mtl.log.b.a.b();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = "E0102";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = r6.b;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r2.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        if (r2 == 0) goto L_0x01db;
    L_0x01d6:
        com.alibaba.mtl.log.e.k.a();	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0286;
    L_0x01db:
        r2 = "E0111";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = r6.b;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r2.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        if (r2 != 0) goto L_0x01f2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
    L_0x01e5:
        r2 = "E0112";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r4 = r6.b;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = r2.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        if (r2 == 0) goto L_0x01f0;
    L_0x01ef:
        goto L_0x01f2;
    L_0x01f0:
        r2 = 0;
        goto L_0x01f3;
    L_0x01f2:
        r2 = 1;
    L_0x01f3:
        if (r2 == 0) goto L_0x01f9;
    L_0x01f5:
        r2 = 1;
        a = r2;	 Catch:{ Throwable -> 0x018f, all -> 0x026e }
        goto L_0x01d6;
    L_0x01f9:
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = "UploadTask";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r6 = 4;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r13 = "logs.size():";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r17 = 0;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12[r17] = r13;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r9 = r9.size();	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r13 = 1;
        r12[r13] = r9;	 Catch:{ Throwable -> 0x026c, all -> 0x026e }
        r9 = " selfMonitorLogCount:";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r13 = 2;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12[r13] = r9;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r9 = r16;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r13 = 3;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12[r13] = r9;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        com.alibaba.mtl.log.e.i.a(r2, r12);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r2 = "UploadTask";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r9 = 6;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r9 = new java.lang.Object[r9];	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12 = "upload isSendSuccess:";	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r13 = 0;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r9[r13] = r12;	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ Throwable -> 0x018a, all -> 0x026e }
        r12 = 1;
        r9[r12] = r11;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r11 = " consume:";	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r13 = 2;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r9[r13] = r11;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r8 = 3;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r9[r8] = r7;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r7 = " delete consume:";	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r9[r6] = r7;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r6 = 5;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r7 = r4 - r14;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r4 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r9[r6] = r4;	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        com.alibaba.mtl.log.e.i.a(r2, r9);	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r2 = new java.util.Random;	 Catch:{ Throwable -> 0x0261, all -> 0x026e }
        r2.<init>();	 Catch:{ Throwable -> 0x0261, all -> 0x026e }
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ Throwable -> 0x0261, all -> 0x026e }
        r2 = r2.nextInt(r4);	 Catch:{ Throwable -> 0x0261, all -> 0x026e }
        r4 = (long) r2;	 Catch:{ Throwable -> 0x0261, all -> 0x026e }
        java.lang.Thread.sleep(r4);	 Catch:{ Throwable -> 0x0261, all -> 0x026e }
        goto L_0x0268;
    L_0x0261:
        r2 = "UploadTask";	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        r4 = "thread sleep interrupted";	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
        com.alibaba.mtl.log.e.i.a(r2, r4);	 Catch:{ Throwable -> 0x0268, all -> 0x026e }
    L_0x0268:
        com.alibaba.mtl.log.e.k.a();	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0278;	 Catch:{ Throwable -> 0x0292 }
    L_0x026c:
        r12 = r13;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0268;	 Catch:{ Throwable -> 0x0292 }
    L_0x026e:
        r0 = move-exception;	 Catch:{ Throwable -> 0x0292 }
        r2 = r0;	 Catch:{ Throwable -> 0x0292 }
        com.alibaba.mtl.log.e.k.a();	 Catch:{ Throwable -> 0x0292 }
        throw r2;	 Catch:{ Throwable -> 0x0292 }
    L_0x0274:
        r12 = r2;	 Catch:{ Throwable -> 0x0292 }
        r19 = r5;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0268;	 Catch:{ Throwable -> 0x0292 }
    L_0x0278:
        r5 = r19 + 1;	 Catch:{ Throwable -> 0x0292 }
        r6 = r10;	 Catch:{ Throwable -> 0x0292 }
        r2 = r12;	 Catch:{ Throwable -> 0x0292 }
        r4 = 0;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x001c;	 Catch:{ Throwable -> 0x0292 }
    L_0x027f:
        r2 = r4;	 Catch:{ Throwable -> 0x0292 }
        b = r2;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0289;	 Catch:{ Throwable -> 0x0292 }
    L_0x0283:
        r2 = r4;	 Catch:{ Throwable -> 0x0292 }
        b = r2;	 Catch:{ Throwable -> 0x0292 }
    L_0x0286:
        r2 = 0;	 Catch:{ Throwable -> 0x0292 }
        goto L_0x0289;	 Catch:{ Throwable -> 0x0292 }
    L_0x0288:
        r2 = r4;	 Catch:{ Throwable -> 0x0292 }
    L_0x0289:
        b = r2;	 Catch:{ Throwable -> 0x0292 }
        com.alibaba.mtl.log.e.k.a();	 Catch:{ Throwable -> 0x0292 }
    L_0x028e:
        r21.a();	 Catch:{ Throwable -> 0x0292 }
        return;
    L_0x0292:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.d.c.run():void");
    }
}
