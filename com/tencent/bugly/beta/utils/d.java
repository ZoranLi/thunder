package com.tencent.bugly.beta.utils;

/* compiled from: BUGLY */
public class d {
    a a = null;
    private String b = null;
    private long c = 0;
    private long d = 0;

    public d(String str, long j, long j2) {
        this.b = str;
        this.c = j;
        this.d = j2;
    }

    private boolean b() {
        if (this.c != 0) {
            if (this.d != 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized void a() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
    }

    private synchronized boolean c() {
        if (!b()) {
            return false;
        }
        if (this.a == null) {
            try {
                this.a = new a(this.b);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private synchronized String b(long j) {
        if (this.a == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.a.b(this.c);
            this.a.b(j);
            while (true) {
                j = this.a.b();
                if (j == null) {
                    break;
                }
                stringBuffer.append((char) j);
            }
            this.a.a();
            this.a = new a(this.b);
        } catch (long j2) {
            this.a = null;
            j2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String a(long r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        r0 = 0;
        if (r2 < 0) goto L_0x0024;
    L_0x0008:
        r1 = r4.d;	 Catch:{ all -> 0x0021 }
        r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r3 < 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0024;
    L_0x000f:
        r1 = r4.a;	 Catch:{ all -> 0x0021 }
        if (r1 != 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.c();	 Catch:{ all -> 0x0021 }
        if (r1 != 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r4);
        return r0;
    L_0x001b:
        r5 = r4.b(r5);	 Catch:{ all -> 0x0021 }
        monitor-exit(r4);
        return r5;
    L_0x0021:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x0024:
        monitor-exit(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.d.a(long):java.lang.String");
    }
}
