package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService.h;
import com.xiaomi.slim.b;

class d extends h {
    private XMPushService b = null;
    private b[] c;

    public d(XMPushService xMPushService, b[] bVarArr) {
        super(4);
        this.b = xMPushService;
        this.c = bVarArr;
    }

    public void a() {
        try {
            if (this.c != null) {
                this.b.a(this.c);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    public String b() {
        return "batch send message.";
    }
}
