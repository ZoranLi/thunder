package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.XMPushService.h;

class bn extends h {
    final /* synthetic */ XMPushService b;

    bn(XMPushService xMPushService, int i) {
        this.b = xMPushService;
        super(i);
    }

    public void a() {
        af.a(this.b);
        if (d.c(this.b)) {
            this.b.a(true);
        }
    }

    public String b() {
        return "prepare the mi push account.";
    }
}
