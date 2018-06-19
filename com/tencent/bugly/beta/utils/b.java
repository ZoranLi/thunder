package com.tencent.bugly.beta.utils;

import java.io.IOException;
import java.util.HashMap;

/* compiled from: BUGLY */
public class b {
    private String a = null;
    private a b = null;
    private long c = 0;
    private long d = 0;
    private String e = null;
    private final HashMap<Long, String> f = new HashMap();

    public b(String str, long j, long j2) {
        this.f.put(Long.valueOf(1), "armeabi-v4");
        this.f.put(Long.valueOf(2), "armeabi-v4t");
        this.f.put(Long.valueOf(3), "armeabi-v5t");
        this.f.put(Long.valueOf(4), "armeabi-v5te");
        this.f.put(Long.valueOf(5), "armeabi-v5tej");
        this.f.put(Long.valueOf(6), "armeabi-v6");
        this.f.put(Long.valueOf(7), "armeabi-v6kz");
        this.f.put(Long.valueOf(8), "armeabi-v6t2");
        this.f.put(Long.valueOf(9), "armeabi-v6k");
        this.f.put(Long.valueOf(10), "armeabi-v7a");
        this.f.put(Long.valueOf(11), "armeabi-v6-m");
        this.f.put(Long.valueOf(12), "armeabi-v6s-m");
        this.f.put(Long.valueOf(13), "armeabi-v7e-m");
        this.f.put(Long.valueOf(14), "armeabi-v8a");
        this.a = str;
        this.c = j;
        this.d = j2;
    }

    private boolean a() {
        return 0 != this.d;
    }

    private synchronized void b() {
        if (this.b != null) {
            if (this.b.a()) {
                this.b = null;
            }
        }
    }

    private synchronized boolean c() {
        if (!a()) {
            return false;
        }
        if (this.b != null) {
            b();
        }
        try {
            this.b = new a(this.a, this.c);
            if (this.b.b(this.d)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    private synchronized String d() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        while (true) {
            try {
                char b = (char) this.b.b();
                if (b != '\u0000') {
                    stringBuilder.append(b);
                }
            } catch (IOException e) {
                e.getMessage();
                return null;
            }
        }
        return stringBuilder.toString();
    }

    private String e() {
        return d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(long r5) {
        /*
        r4 = this;
        monitor-enter(r4);
    L_0x0001:
        r0 = 0;
        r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        r0 = 0;
        if (r2 <= 0) goto L_0x0065;
    L_0x0008:
        r1 = r4.b;	 Catch:{ IOException -> 0x005d }
        r1 = a(r1);	 Catch:{ IOException -> 0x005d }
        r1 = (int) r1;
        r2 = 34;
        if (r1 == r2) goto L_0x0055;
    L_0x0013:
        r2 = 36;
        if (r1 == r2) goto L_0x0055;
    L_0x0017:
        r2 = 38;
        if (r1 == r2) goto L_0x0055;
    L_0x001b:
        r2 = 42;
        if (r1 == r2) goto L_0x0055;
    L_0x001f:
        r2 = 44;
        if (r1 == r2) goto L_0x0055;
    L_0x0023:
        r2 = 70;
        if (r1 == r2) goto L_0x0055;
    L_0x0027:
        switch(r1) {
            case 4: goto L_0x0046;
            case 5: goto L_0x0046;
            case 6: goto L_0x002f;
            case 7: goto L_0x0055;
            case 8: goto L_0x0055;
            case 9: goto L_0x0055;
            case 10: goto L_0x0055;
            case 11: goto L_0x0055;
            case 12: goto L_0x0055;
            case 13: goto L_0x0055;
            case 14: goto L_0x0055;
            case 15: goto L_0x0055;
            case 16: goto L_0x0055;
            case 17: goto L_0x0055;
            case 18: goto L_0x0055;
            case 19: goto L_0x0055;
            case 20: goto L_0x0055;
            case 21: goto L_0x0055;
            case 22: goto L_0x0055;
            case 23: goto L_0x0055;
            case 24: goto L_0x0055;
            case 25: goto L_0x0055;
            case 26: goto L_0x0055;
            case 27: goto L_0x0055;
            case 28: goto L_0x0055;
            case 29: goto L_0x0055;
            case 30: goto L_0x0055;
            case 31: goto L_0x0055;
            case 32: goto L_0x0046;
            default: goto L_0x002a;
        };
    L_0x002a:
        switch(r1) {
            case 64: goto L_0x0055;
            case 65: goto L_0x0046;
            case 66: goto L_0x0055;
            case 67: goto L_0x0046;
            case 68: goto L_0x0055;
            default: goto L_0x002d;
        };
    L_0x002d:
        monitor-exit(r4);
        return r0;
    L_0x002f:
        r5 = r4.b;	 Catch:{ IOException -> 0x005d }
        r5 = a(r5);	 Catch:{ IOException -> 0x005d }
        r1 = r4.f;	 Catch:{ IOException -> 0x005d }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ IOException -> 0x005d }
        r5 = r1.get(r5);	 Catch:{ IOException -> 0x005d }
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x005d }
        r4.e = r5;	 Catch:{ IOException -> 0x005d }
        r5 = 1;
        monitor-exit(r4);
        return r5;
    L_0x0046:
        r1 = r4.d();	 Catch:{ IOException -> 0x005d }
        if (r1 == 0) goto L_0x0001;
    L_0x004c:
        r1 = r1.length();	 Catch:{ IOException -> 0x005d }
        r0 = (long) r1;	 Catch:{ IOException -> 0x005d }
        r2 = r5 - r0;
        r5 = r2;
        goto L_0x0001;
    L_0x0055:
        r1 = r4.b;	 Catch:{ IOException -> 0x005d }
        a(r1);	 Catch:{ IOException -> 0x005d }
        goto L_0x0001;
    L_0x005b:
        r5 = move-exception;
        goto L_0x0063;
    L_0x005d:
        r5 = move-exception;
        r5.getMessage();	 Catch:{ all -> 0x005b }
        monitor-exit(r4);
        return r0;
    L_0x0063:
        monitor-exit(r4);
        throw r5;
    L_0x0065:
        monitor-exit(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.b.a(long):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean f() {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = 0;
        r1 = r11.b;	 Catch:{ IOException -> 0x005b }
        r1 = r1.f();	 Catch:{ IOException -> 0x005b }
        r3 = 65;
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 == 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r11);
        return r0;
    L_0x0010:
        r1 = r11.b;	 Catch:{ IOException -> 0x005b }
        r1 = r1.h();	 Catch:{ IOException -> 0x005b }
        r3 = r11.e();	 Catch:{ IOException -> 0x005b }
        if (r3 == 0) goto L_0x0057;
    L_0x001c:
        r4 = "aeabi";
        r4 = r3.equals(r4);	 Catch:{ IOException -> 0x005b }
        if (r4 != 0) goto L_0x0025;
    L_0x0024:
        goto L_0x0057;
    L_0x0025:
        r3 = r3.length();	 Catch:{ IOException -> 0x005b }
        r3 = (long) r3;	 Catch:{ IOException -> 0x005b }
        r5 = r1 - r3;
    L_0x002c:
        r1 = 0;
        r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x0054;
    L_0x0032:
        r1 = r11.b;	 Catch:{ IOException -> 0x005b }
        r1 = r1.f();	 Catch:{ IOException -> 0x005b }
        r3 = r11.b;	 Catch:{ IOException -> 0x005b }
        r3 = r3.h();	 Catch:{ IOException -> 0x005b }
        r7 = 5;
        r9 = r3 - r7;
        r3 = 1;
        r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r7 != 0) goto L_0x004e;
    L_0x0048:
        r1 = r11.a(r9);	 Catch:{ IOException -> 0x005b }
        monitor-exit(r11);
        return r1;
    L_0x004e:
        r1 = r11.b;	 Catch:{ IOException -> 0x005b }
        r1.b(r9);	 Catch:{ IOException -> 0x005b }
        goto L_0x002c;
    L_0x0054:
        r0 = 1;
        monitor-exit(r11);
        return r0;
    L_0x0057:
        monitor-exit(r11);
        return r0;
    L_0x0059:
        r0 = move-exception;
        goto L_0x0061;
    L_0x005b:
        r1 = move-exception;
        r1.getMessage();	 Catch:{ all -> 0x0059 }
        monitor-exit(r11);
        return r0;
    L_0x0061:
        monitor-exit(r11);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.b.f():boolean");
    }

    private boolean g() {
        if (c()) {
            f();
            b();
            return true;
        }
        b();
        return false;
    }

    public static String a(String str, long j, long j2) {
        b bVar = new b(str, j, j2);
        if (bVar.g() == null) {
            return null;
        }
        return bVar.e;
    }

    public static synchronized long a(a aVar) throws IOException {
        long j;
        synchronized (b.class) {
            long j2 = 0;
            long j3 = 0;
            while (true) {
                byte b = aVar.b();
                j = j2 | ((((long) b) & 127) << ((int) j3));
                long j4 = j3 + 7;
                if ((b & 128) == 0) {
                } else {
                    j3 = j4;
                    j2 = j;
                }
            }
        }
        return j;
    }
}
