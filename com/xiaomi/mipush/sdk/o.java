package com.xiaomi.mipush.sdk;

import com.xiaomi.push.mpcd.d;

final class o implements Runnable {
    o() {
    }

    public final void run() {
        d.a(MiPushClient.sContext);
    }
}
