package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService.f;
import com.xiaomi.push.service.ap.a;

class bo implements a {
    final /* synthetic */ XMPushService a;

    bo(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a() {
        this.a.n();
        if (ap.a().c() <= 0) {
            this.a.a(new f(this.a, 12, null));
        }
    }
}
