package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.h;
import com.xiaomi.xmpush.thrift.af;

final class ae extends h {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ af c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;
    final /* synthetic */ boolean g;

    ae(int i, XMPushService xMPushService, af afVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.b = xMPushService;
        this.c = afVar;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        super(i);
    }

    public final void a() {
        try {
            af a = x.a(this.b, this.c, this.d, this.e, this.f);
            if (this.g) {
                a.m().a("permission_to_location", av.b);
            }
            af.a(this.b, a);
        } catch (Exception e) {
            b.a(e);
            this.b.a(10, e);
        }
    }

    public final String b() {
        return "send wrong message ack for message.";
    }
}
