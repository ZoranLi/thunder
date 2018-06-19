package com.igexin.push.a.a;

import com.igexin.push.f.b.d;

public class c implements d {
    private static c c;
    private long a = 0;
    private long b = 0;
    private boolean d = false;

    private c() {
    }

    public static c c() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    public void a() {
        d();
    }

    public void a(long j) {
        this.a = j;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.a > this.b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
        r12 = this;
        r0 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r12.b = r0;
        r0 = java.lang.System.currentTimeMillis();
        r2 = com.igexin.push.config.m.b;
        r3 = 1;
        r4 = 0;
        if (r2 == 0) goto L_0x009d;
    L_0x000f:
        r2 = java.util.Calendar.getInstance();
        r5 = com.igexin.push.util.a.a(r0);
        r6 = 5;
        r7 = 13;
        r8 = 12;
        r9 = 11;
        if (r5 == 0) goto L_0x0063;
    L_0x0020:
        r5 = r12.d;
        if (r5 != 0) goto L_0x003b;
    L_0x0024:
        r12.d = r3;
        r5 = new com.igexin.push.e.a;
        r5.<init>();
        r10 = com.igexin.push.core.c.g;
        r5.a(r10);
        r10 = com.igexin.push.core.f.a();
        r10 = r10.h();
        r10.a(r5);
    L_0x003b:
        r5 = com.igexin.push.config.m.a;
        r10 = com.igexin.push.config.m.b;
        r5 = r5 + r10;
        r10 = 24;
        if (r5 <= r10) goto L_0x004e;
    L_0x0044:
        r5 = com.igexin.push.config.m.a;
        r11 = com.igexin.push.config.m.b;
        r5 = r5 + r11;
        r5 = r5 - r10;
    L_0x004a:
        r2.set(r9, r5);
        goto L_0x0054;
    L_0x004e:
        r5 = com.igexin.push.config.m.a;
        r10 = com.igexin.push.config.m.b;
        r5 = r5 + r10;
        goto L_0x004a;
    L_0x0054:
        r2.set(r8, r4);
        r2.set(r7, r4);
        r4 = r2.getTimeInMillis();
        r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r7 >= 0) goto L_0x0094;
    L_0x0062:
        goto L_0x0091;
    L_0x0063:
        r5 = r12.d;
        if (r5 == 0) goto L_0x007e;
    L_0x0067:
        r12.d = r4;
        r5 = new com.igexin.push.e.a;
        r5.<init>();
        r10 = com.igexin.push.core.c.a;
        r5.a(r10);
        r10 = com.igexin.push.core.f.a();
        r10 = r10.h();
        r10.a(r5);
    L_0x007e:
        r5 = com.igexin.push.config.m.a;
        r2.set(r9, r5);
        r2.set(r8, r4);
        r2.set(r7, r4);
        r4 = r2.getTimeInMillis();
        r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r7 >= 0) goto L_0x0094;
    L_0x0091:
        r2.add(r6, r3);
    L_0x0094:
        r4 = r2.getTimeInMillis();
        r6 = r4 - r0;
        r12.b = r6;
        goto L_0x00b8;
    L_0x009d:
        r2 = r12.d;
        if (r2 == 0) goto L_0x00b8;
    L_0x00a1:
        r12.d = r4;
        r2 = new com.igexin.push.e.a;
        r2.<init>();
        r4 = com.igexin.push.core.c.a;
        r2.a(r4);
        r4 = com.igexin.push.core.f.a();
        r4 = r4.h();
        r4.a(r2);
    L_0x00b8:
        r4 = com.igexin.push.config.m.c;
        r6 = r12.b;
        r8 = r0 + r6;
        r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x00e3;
    L_0x00c2:
        r4 = com.igexin.push.config.m.c;
        r6 = r4 - r0;
        r12.b = r6;
        r0 = r12.d;
        if (r0 != 0) goto L_0x00e3;
    L_0x00cc:
        r12.d = r3;
        r0 = new com.igexin.push.e.a;
        r0.<init>();
        r1 = com.igexin.push.core.c.g;
        r0.a(r1);
        r1 = com.igexin.push.core.f.a();
        r1 = r1.h();
        r1.a(r0);
    L_0x00e3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.a.a.c.d():void");
    }
}
