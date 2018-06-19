package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.au;

class af extends ContentObserver {
    final /* synthetic */ ac a;

    af(ac acVar, Handler handler) {
        this.a = acVar;
        super(handler);
    }

    public void onChange(boolean z) {
        this.a.v = Integer.valueOf(au.a(this.a.j).b());
        if (this.a.v.intValue() != 0) {
            this.a.j.getContentResolver().unregisterContentObserver(this);
            if (d.c(this.a.j)) {
                this.a.e();
            }
        }
    }
}
