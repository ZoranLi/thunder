package com.qiniu.android.dns;

import com.qiniu.android.dns.local.e;
import com.qiniu.android.dns.util.LruCache;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DnsManager */
public final class a {
    final c[] a;
    final LruCache<String, f[]> b;
    public final d c;
    volatile NetworkInfo d;
    volatile int e;
    private final e f;

    /* compiled from: DnsManager */
    private static class a implements d {
        private AtomicInteger a;

        public final String[] a(String[] strArr) {
            return strArr;
        }

        private a() {
            this.a = new AtomicInteger();
        }
    }

    public a(NetworkInfo networkInfo, c[] cVarArr) {
        this(networkInfo, cVarArr, (byte) 0);
    }

    private a(NetworkInfo networkInfo, c[] cVarArr, byte b) {
        this.f = new e();
        this.d = (byte) 0;
        this.e = 0;
        if (networkInfo == null) {
            networkInfo = NetworkInfo.b;
        }
        this.d = networkInfo;
        this.a = (c[]) cVarArr.clone();
        this.b = new LruCache();
        this.c = new a();
    }

    private static f[] a(f[] fVarArr) {
        ArrayList arrayList = new ArrayList(fVarArr.length);
        for (f fVar : fVarArr) {
            if (fVar != null && fVar.b == 1) {
                arrayList.add(fVar);
            }
        }
        return (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    private static String[] b(f[] fVarArr) {
        if (fVarArr != null) {
            if (fVarArr.length != 0) {
                ArrayList arrayList = new ArrayList(fVarArr.length);
                for (f fVar : fVarArr) {
                    arrayList.add(fVar.a);
                }
                if (arrayList.size() == null) {
                    return null;
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        return null;
    }

    public static boolean a(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r7 == 0) goto L_0x0075;
    L_0x0003:
        r1 = r7.length();
        r2 = 7;
        if (r1 < r2) goto L_0x0075;
    L_0x000a:
        r1 = r7.length();
        r2 = 15;
        if (r1 <= r2) goto L_0x0013;
    L_0x0012:
        goto L_0x0075;
    L_0x0013:
        r1 = "-";
        r1 = r7.contains(r1);
        if (r1 == 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        r1 = 46;
        r2 = r7.indexOf(r1);	 Catch:{ NumberFormatException -> 0x0074 }
        r3 = -1;	 Catch:{ NumberFormatException -> 0x0074 }
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ NumberFormatException -> 0x0074 }
        if (r2 == r3) goto L_0x0032;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x0027:
        r5 = r7.substring(r0, r2);	 Catch:{ NumberFormatException -> 0x0074 }
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x0074 }
        if (r5 <= r4) goto L_0x0032;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x0031:
        return r0;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x0032:
        r5 = 1;	 Catch:{ NumberFormatException -> 0x0074 }
        r2 = r2 + r5;	 Catch:{ NumberFormatException -> 0x0074 }
        r6 = r7.indexOf(r1, r2);	 Catch:{ NumberFormatException -> 0x0074 }
        if (r6 == r3) goto L_0x0045;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x003a:
        r2 = r7.substring(r2, r6);	 Catch:{ NumberFormatException -> 0x0074 }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0074 }
        if (r2 <= r4) goto L_0x0045;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x0044:
        return r0;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x0045:
        r6 = r6 + r5;	 Catch:{ NumberFormatException -> 0x0074 }
        r2 = r7.indexOf(r1, r6);	 Catch:{ NumberFormatException -> 0x0074 }
        if (r2 == r3) goto L_0x0073;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x004c:
        r3 = r7.substring(r6, r2);	 Catch:{ NumberFormatException -> 0x0074 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0074 }
        if (r3 <= r4) goto L_0x0073;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x0056:
        r2 = r2 + r5;	 Catch:{ NumberFormatException -> 0x0074 }
        r3 = r7.length();	 Catch:{ NumberFormatException -> 0x0074 }
        r3 = r3 - r5;	 Catch:{ NumberFormatException -> 0x0074 }
        r2 = r7.substring(r2, r3);	 Catch:{ NumberFormatException -> 0x0074 }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0074 }
        if (r2 <= r4) goto L_0x0073;	 Catch:{ NumberFormatException -> 0x0074 }
    L_0x0066:
        r2 = r7.length();	 Catch:{ NumberFormatException -> 0x0074 }
        r2 = r2 - r5;	 Catch:{ NumberFormatException -> 0x0074 }
        r7 = r7.charAt(r2);	 Catch:{ NumberFormatException -> 0x0074 }
        if (r7 != r1) goto L_0x0072;
    L_0x0071:
        goto L_0x0073;
    L_0x0072:
        return r0;
    L_0x0073:
        return r5;
    L_0x0074:
        return r0;
    L_0x0075:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.a.a(java.lang.String):boolean");
    }

    public final java.lang.String[] a(com.qiniu.android.dns.b r15) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        r0 = r15.d;
        if (r0 == 0) goto L_0x0012;
    L_0x0004:
        r0 = r14.f;
        r1 = r14.d;
        r0 = r0.a(r15, r1);
        if (r0 == 0) goto L_0x0012;
    L_0x000e:
        r1 = r0.length;
        if (r1 == 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = r14.b;
        monitor-enter(r0);
        r1 = r14.d;	 Catch:{ all -> 0x0125 }
        r2 = com.qiniu.android.dns.NetworkInfo.b;	 Catch:{ all -> 0x0125 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0125 }
        r2 = 0;	 Catch:{ all -> 0x0125 }
        r3 = 0;	 Catch:{ all -> 0x0125 }
        r4 = 1;	 Catch:{ all -> 0x0125 }
        if (r1 == 0) goto L_0x0038;	 Catch:{ all -> 0x0125 }
    L_0x0022:
        r1 = com.qiniu.android.dns.e.b();	 Catch:{ all -> 0x0125 }
        if (r1 == 0) goto L_0x0038;	 Catch:{ all -> 0x0125 }
    L_0x0028:
        r1 = r14.b;	 Catch:{ all -> 0x0125 }
        r1.clear();	 Catch:{ all -> 0x0125 }
        r1 = r14.a;	 Catch:{ all -> 0x0125 }
        monitor-enter(r1);	 Catch:{ all -> 0x0125 }
        r14.e = r3;	 Catch:{ all -> 0x0035 }
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
    L_0x0033:
        r1 = r2;	 Catch:{ all -> 0x0035 }
        goto L_0x0079;	 Catch:{ all -> 0x0035 }
    L_0x0035:
        r15 = move-exception;	 Catch:{ all -> 0x0035 }
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        throw r15;	 Catch:{ all -> 0x0125 }
    L_0x0038:
        r1 = r14.b;	 Catch:{ all -> 0x0125 }
        r5 = r15.a;	 Catch:{ all -> 0x0125 }
        r1 = r1.get(r5);	 Catch:{ all -> 0x0125 }
        r1 = (com.qiniu.android.dns.f[]) r1;	 Catch:{ all -> 0x0125 }
        if (r1 == 0) goto L_0x0079;	 Catch:{ all -> 0x0125 }
    L_0x0044:
        r5 = r1.length;	 Catch:{ all -> 0x0125 }
        if (r5 == 0) goto L_0x0079;	 Catch:{ all -> 0x0125 }
    L_0x0047:
        r5 = r1[r3];	 Catch:{ all -> 0x0125 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0125 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ all -> 0x0125 }
        r6 = r6 / r8;	 Catch:{ all -> 0x0125 }
        r8 = r5.d;	 Catch:{ all -> 0x0125 }
        r5 = r5.c;	 Catch:{ all -> 0x0125 }
        r10 = (long) r5;	 Catch:{ all -> 0x0125 }
        r12 = r8 + r10;	 Catch:{ all -> 0x0125 }
        r5 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));	 Catch:{ all -> 0x0125 }
        if (r5 >= 0) goto L_0x005d;	 Catch:{ all -> 0x0125 }
    L_0x005b:
        r5 = r4;	 Catch:{ all -> 0x0125 }
        goto L_0x005e;	 Catch:{ all -> 0x0125 }
    L_0x005d:
        r5 = r3;	 Catch:{ all -> 0x0125 }
    L_0x005e:
        if (r5 != 0) goto L_0x0033;	 Catch:{ all -> 0x0125 }
    L_0x0060:
        r15 = r1.length;	 Catch:{ all -> 0x0125 }
        if (r15 <= r4) goto L_0x0073;	 Catch:{ all -> 0x0125 }
    L_0x0063:
        if (r1 == 0) goto L_0x0073;	 Catch:{ all -> 0x0125 }
    L_0x0065:
        r15 = r1.length;	 Catch:{ all -> 0x0125 }
        if (r15 <= r4) goto L_0x0073;	 Catch:{ all -> 0x0125 }
    L_0x0068:
        r15 = r1[r3];	 Catch:{ all -> 0x0125 }
        r2 = r1.length;	 Catch:{ all -> 0x0125 }
        r2 = r2 - r4;	 Catch:{ all -> 0x0125 }
        java.lang.System.arraycopy(r1, r4, r1, r3, r2);	 Catch:{ all -> 0x0125 }
        r2 = r1.length;	 Catch:{ all -> 0x0125 }
        r2 = r2 - r4;	 Catch:{ all -> 0x0125 }
        r1[r2] = r15;	 Catch:{ all -> 0x0125 }
    L_0x0073:
        r15 = b(r1);	 Catch:{ all -> 0x0125 }
        monitor-exit(r0);	 Catch:{ all -> 0x0125 }
        return r15;	 Catch:{ all -> 0x0125 }
    L_0x0079:
        monitor-exit(r0);	 Catch:{ all -> 0x0125 }
        r0 = r14.e;
        r5 = r2;
        r2 = r1;
        r1 = r3;
    L_0x007f:
        r6 = r14.a;
        r6 = r6.length;
        if (r1 >= r6) goto L_0x00e0;
    L_0x0084:
        r6 = r0 + r1;
        r7 = r14.a;
        r7 = r7.length;
        r6 = r6 % r7;
        r7 = r14.d;
        r8 = com.qiniu.android.dns.e.a();
        r9 = r14.a;	 Catch:{ DomainNotOwn -> 0x00dd, IOException -> 0x00ac, Exception -> 0x009c }
        r6 = r9[r6];	 Catch:{ DomainNotOwn -> 0x00dd, IOException -> 0x00ac, Exception -> 0x009c }
        r9 = r14.d;	 Catch:{ DomainNotOwn -> 0x00dd, IOException -> 0x00ac, Exception -> 0x009c }
        r6 = r6.a(r15, r9);	 Catch:{ DomainNotOwn -> 0x00dd, IOException -> 0x00ac, Exception -> 0x009c }
        r2 = r6;
        goto L_0x00b0;
    L_0x009c:
        r6 = move-exception;
        r9 = android.os.Build.VERSION.SDK_INT;
        r10 = 9;
        if (r9 < r10) goto L_0x00a8;
    L_0x00a3:
        r5 = new java.io.IOException;
        r5.<init>(r6);
    L_0x00a8:
        r6.printStackTrace();
        goto L_0x00b0;
    L_0x00ac:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00b0:
        r6 = com.qiniu.android.dns.e.a();
        r9 = r14.d;
        if (r9 != r7) goto L_0x00e0;
    L_0x00b8:
        if (r2 == 0) goto L_0x00bd;
    L_0x00ba:
        r7 = r2.length;
        if (r7 != 0) goto L_0x00e0;
    L_0x00bd:
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x00e0;
    L_0x00c3:
        r6 = r14.a;
        monitor-enter(r6);
        r7 = r14.e;	 Catch:{ all -> 0x00da }
        if (r7 != r0) goto L_0x00d8;	 Catch:{ all -> 0x00da }
    L_0x00ca:
        r7 = r14.e;	 Catch:{ all -> 0x00da }
        r7 = r7 + r4;	 Catch:{ all -> 0x00da }
        r14.e = r7;	 Catch:{ all -> 0x00da }
        r7 = r14.e;	 Catch:{ all -> 0x00da }
        r8 = r14.a;	 Catch:{ all -> 0x00da }
        r8 = r8.length;	 Catch:{ all -> 0x00da }
        if (r7 != r8) goto L_0x00d8;	 Catch:{ all -> 0x00da }
    L_0x00d6:
        r14.e = r3;	 Catch:{ all -> 0x00da }
    L_0x00d8:
        monitor-exit(r6);	 Catch:{ all -> 0x00da }
        goto L_0x00dd;	 Catch:{ all -> 0x00da }
    L_0x00da:
        r15 = move-exception;	 Catch:{ all -> 0x00da }
        monitor-exit(r6);	 Catch:{ all -> 0x00da }
        throw r15;
    L_0x00dd:
        r1 = r1 + 1;
        goto L_0x007f;
    L_0x00e0:
        if (r2 == 0) goto L_0x0108;
    L_0x00e2:
        r0 = r2.length;
        if (r0 != 0) goto L_0x00e6;
    L_0x00e5:
        goto L_0x0108;
    L_0x00e6:
        r0 = a(r2);
        r1 = r0.length;
        if (r1 != 0) goto L_0x00f5;
    L_0x00ed:
        r15 = new java.net.UnknownHostException;
        r0 = "no A records";
        r15.<init>(r0);
        throw r15;
    L_0x00f5:
        r1 = r14.b;
        monitor-enter(r1);
        r2 = r14.b;	 Catch:{ all -> 0x0105 }
        r15 = r15.a;	 Catch:{ all -> 0x0105 }
        r2.put(r15, r0);	 Catch:{ all -> 0x0105 }
        monitor-exit(r1);	 Catch:{ all -> 0x0105 }
        r15 = b(r0);
        return r15;
    L_0x0105:
        r15 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0105 }
        throw r15;
    L_0x0108:
        r0 = r15.d;
        if (r0 != 0) goto L_0x011a;
    L_0x010c:
        r0 = r14.f;
        r1 = r14.d;
        r0 = r0.a(r15, r1);
        if (r0 == 0) goto L_0x011a;
    L_0x0116:
        r1 = r0.length;
        if (r1 == 0) goto L_0x011a;
    L_0x0119:
        return r0;
    L_0x011a:
        if (r5 == 0) goto L_0x011d;
    L_0x011c:
        throw r5;
    L_0x011d:
        r0 = new java.net.UnknownHostException;
        r15 = r15.a;
        r0.<init>(r15);
        throw r0;
    L_0x0125:
        r15 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0125 }
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.a.a(com.qiniu.android.dns.b):java.lang.String[]");
    }
}
