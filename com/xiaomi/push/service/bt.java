package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.h;

class bt extends h {
    final /* synthetic */ String b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ XMPushService d;

    bt(XMPushService xMPushService, int i, String str, byte[] bArr) {
        this.d = xMPushService;
        this.b = str;
        this.c = bArr;
        super(i);
    }

    public void a() {
        try {
            af.a(this.d, this.b, this.c);
        } catch (Exception e) {
            b.a(e);
            this.d.a(10, e);
        }
    }

    public String b() {
        return "send mi push message";
    }
}
