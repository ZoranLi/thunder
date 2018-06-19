package com.duiba.maila.sdk;

import com.duiba.maila.sdk.util.b;
import com.duiba.maila.sdk.util.h;

final class d implements Runnable {
    final /* synthetic */ MailaActivityInSdk a;

    d(MailaActivityInSdk mailaActivityInSdk) {
        this.a = mailaActivityInSdk;
    }

    public final void run() {
        b.a(this.a, h.a, "json", this.a.b().toString());
    }
}
