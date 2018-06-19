package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.module.PushChannelRegion;

class ad implements Runnable {
    final /* synthetic */ ac a;

    ad(ac acVar) {
        this.a = acVar;
    }

    public void run() {
        if (TextUtils.isEmpty(ac.e)) {
            ac.e = PushChannelRegion.China.name();
        }
        this.a.B();
        synchronized (this.a.f) {
            try {
                this.a.f.wait(5000);
                if (TextUtils.isEmpty(ac.d)) {
                    this.a.h = true;
                    b.a("app request xmsf region timeout");
                    this.a.x();
                }
                b.c("app start own push channel");
                this.a.a(this.a.o());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.a.C();
    }
}
