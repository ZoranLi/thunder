package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService.h;

class i extends h {
    final /* synthetic */ long b;
    final /* synthetic */ h c;

    i(h hVar, int i, long j) {
        this.c = hVar;
        this.b = j;
        super(i);
    }

    public void a() {
        Thread.yield();
        if (this.c.l() && !this.c.a(this.b)) {
            this.c.s.a(22, null);
            this.c.s.a(true);
        }
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder("check the ping-pong.");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
