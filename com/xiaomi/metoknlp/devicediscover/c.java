package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;

public class c {
    private Context a;
    private String b;
    private long c;
    private long d;
    private long e;
    private long f;

    public c(Context context) {
        this.a = context;
        a();
    }

    public void a() {
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public void a(String str) {
        i();
        a();
        b(str);
    }

    public String b() {
        return this.b;
    }

    public void b(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;
        r1 = "none";
        r0 = com.xiaomi.metoknlp.devicediscover.j.b(r0, r4, r1);
        if (r0 == 0) goto L_0x0050;
    L_0x000a:
        r1 = "none";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0050;
    L_0x0013:
        r1 = "_";	 Catch:{ Exception -> 0x004f }
        r0 = r0.split(r1);	 Catch:{ Exception -> 0x004f }
        r3.b = r4;	 Catch:{ Exception -> 0x004f }
        r4 = 1;	 Catch:{ Exception -> 0x004f }
        r4 = r0[r4];	 Catch:{ Exception -> 0x004f }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x004f }
        r1 = r4.longValue();	 Catch:{ Exception -> 0x004f }
        r3.c = r1;	 Catch:{ Exception -> 0x004f }
        r4 = 2;	 Catch:{ Exception -> 0x004f }
        r4 = r0[r4];	 Catch:{ Exception -> 0x004f }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x004f }
        r1 = r4.longValue();	 Catch:{ Exception -> 0x004f }
        r3.d = r1;	 Catch:{ Exception -> 0x004f }
        r4 = 3;	 Catch:{ Exception -> 0x004f }
        r4 = r0[r4];	 Catch:{ Exception -> 0x004f }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x004f }
        r1 = r4.longValue();	 Catch:{ Exception -> 0x004f }
        r3.e = r1;	 Catch:{ Exception -> 0x004f }
        r4 = 4;	 Catch:{ Exception -> 0x004f }
        r4 = r0[r4];	 Catch:{ Exception -> 0x004f }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x004f }
        r0 = r4.longValue();	 Catch:{ Exception -> 0x004f }
        r3.f = r0;	 Catch:{ Exception -> 0x004f }
    L_0x004f:
        return;
    L_0x0050:
        r3.a();
        r3.b = r4;
        r0 = java.lang.System.currentTimeMillis();
        r3.f = r0;
        r3.e = r0;
        r3.c = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.c.b(java.lang.String):void");
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.f;
    }

    public void f() {
        this.d += System.currentTimeMillis() - this.c;
    }

    public void g() {
        this.f = System.currentTimeMillis();
    }

    public void h() {
        f();
        i();
        a();
    }

    public void i() {
        if (this.b != null) {
            j.a(this.a, this.b, toString());
        }
    }

    public String toString() {
        if (this.b == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append("_");
        stringBuilder.append(this.c);
        stringBuilder.append("_");
        stringBuilder.append(this.d);
        stringBuilder.append("_");
        stringBuilder.append(this.e);
        stringBuilder.append("_");
        stringBuilder.append(this.f);
        return stringBuilder.toString();
    }
}
