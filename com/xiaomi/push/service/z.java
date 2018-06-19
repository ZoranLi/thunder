package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.h;
import com.xiaomi.xmpush.thrift.af;

final class z extends h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ af c;

    z(int i, XMPushService xMPushService, af afVar) {
        this.b = xMPushService;
        this.c = afVar;
        super(i);
    }

    public final void a() {
        try {
            af.a(this.b, x.a(this.b, this.c));
        } catch (Exception e) {
            b.a(e);
            this.b.a(10, e);
        }
    }

    public final String b() {
        return "send ack message for message.";
    }
}
