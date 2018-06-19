package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService.h;

class bi extends h {
    final /* synthetic */ XMPushService b;

    bi(XMPushService xMPushService, int i) {
        this.b = xMPushService;
        super(i);
    }

    public void a() {
        if (this.b.k != null) {
            this.b.k.b(15, null);
            this.b.k = null;
        }
    }

    public String b() {
        return "disconnect for service destroy.";
    }
}
