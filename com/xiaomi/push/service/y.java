package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.h;
import com.xiaomi.xmpush.thrift.af;

final class y extends h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ af c;

    y(int i, XMPushService xMPushService, af afVar) {
        this.b = xMPushService;
        this.c = afVar;
        super(i);
    }

    public final void a() {
        try {
            af.a(this.b, af.a(this.c.j(), this.c.h()));
        } catch (Exception e) {
            b.a(e);
            this.b.a(10, e);
        }
    }

    public final String b() {
        return "send app absent message.";
    }
}
