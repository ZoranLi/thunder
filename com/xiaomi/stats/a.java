package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap.b;
import com.xiaomi.push.service.ap.c;

class a implements com.xiaomi.push.service.ap.b.a {
    private XMPushService a;
    private b b;
    private com.xiaomi.smack.a c;
    private c d;
    private int e;
    private boolean f = false;

    a(XMPushService xMPushService, b bVar) {
        this.a = xMPushService;
        this.d = c.binding;
        this.b = bVar;
    }

    private void b() {
        this.b.b((com.xiaomi.push.service.ap.b.a) this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.b();
        r0 = r3.f;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r0 = r3.e;
        r1 = 11;
        if (r0 != r1) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = com.xiaomi.stats.f.a();
        r0 = r0.f();
        r1 = com.xiaomi.stats.c.a;
        r2 = r3.d;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x002e;
            case 2: goto L_0x005b;
            case 3: goto L_0x0025;
            default: goto L_0x0024;
        };
    L_0x0024:
        goto L_0x005b;
    L_0x0025:
        r1 = com.xiaomi.push.thrift.a.BIND_SUCCESS;
    L_0x0027:
        r1 = r1.a();
        r0.b = r1;
        goto L_0x005b;
    L_0x002e:
        r1 = r3.e;
        r2 = 17;
        if (r1 != r2) goto L_0x0037;
    L_0x0034:
        r1 = com.xiaomi.push.thrift.a.BIND_TCP_READ_TIMEOUT;
        goto L_0x0027;
    L_0x0037:
        r1 = r3.e;
        r2 = 21;
        if (r1 != r2) goto L_0x0040;
    L_0x003d:
        r1 = com.xiaomi.push.thrift.a.BIND_TIMEOUT;
        goto L_0x0027;
    L_0x0040:
        r1 = com.xiaomi.stats.f.b();	 Catch:{ NullPointerException -> 0x005a }
        r1 = r1.a();	 Catch:{ NullPointerException -> 0x005a }
        r1 = com.xiaomi.stats.d.c(r1);	 Catch:{ NullPointerException -> 0x005a }
        r2 = r1.a;	 Catch:{ NullPointerException -> 0x005a }
        r2 = r2.a();	 Catch:{ NullPointerException -> 0x005a }
        r0.b = r2;	 Catch:{ NullPointerException -> 0x005a }
        r1 = r1.b;	 Catch:{ NullPointerException -> 0x005a }
        r0.c(r1);	 Catch:{ NullPointerException -> 0x005a }
        goto L_0x005b;
    L_0x005a:
        r0 = 0;
    L_0x005b:
        if (r0 == 0) goto L_0x0083;
    L_0x005d:
        r1 = r3.c;
        r1 = r1.e();
        r0.b(r1);
        r1 = r3.b;
        r1 = r1.b;
        r0.d(r1);
        r1 = 1;
        r0.c = r1;
        r1 = r3.b;	 Catch:{ NumberFormatException -> 0x007c }
        r1 = r1.h;	 Catch:{ NumberFormatException -> 0x007c }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x007c }
        r1 = (byte) r1;	 Catch:{ NumberFormatException -> 0x007c }
        r0.a(r1);	 Catch:{ NumberFormatException -> 0x007c }
    L_0x007c:
        r1 = com.xiaomi.stats.f.a();
        r1.a(r0);
    L_0x0083:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.a.c():void");
    }

    void a() {
        this.b.a((com.xiaomi.push.service.ap.b.a) this);
        this.c = this.a.h();
    }

    public void a(c cVar, c cVar2, int i) {
        if (!this.f && cVar == c.binding) {
            this.d = cVar2;
            this.e = i;
            this.f = true;
        }
        this.a.a(new b(this, 4));
    }
}
