package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.h;
import com.xiaomi.xmpush.thrift.af;

final class ab extends h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ af c;

    ab(int i, XMPushService xMPushService, af afVar) {
        this.b = xMPushService;
        this.c = afVar;
        super(i);
    }

    public final void a() {
        try {
            af a = x.a(this.b, this.c);
            a.m().a("miui_message_unrecognized", "1");
            af.a(this.b, a);
        } catch (Exception e) {
            b.a(e);
            this.b.a(10, e);
        }
    }

    public final String b() {
        return "send ack message for unrecognized new miui message.";
    }
}
