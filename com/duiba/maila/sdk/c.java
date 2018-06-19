package com.duiba.maila.sdk;

import com.duiba.maila.sdk.util.d;

final class c implements Runnable {
    final /* synthetic */ Integer a;
    final /* synthetic */ String b;
    final /* synthetic */ String[] c;
    final /* synthetic */ MailaActivityInSdk d;

    c(MailaActivityInSdk mailaActivityInSdk, Integer num, String str, String[] strArr) {
        this.d = mailaActivityInSdk;
        this.a = num;
        this.b = str;
        this.c = strArr;
    }

    public final void run() {
        ((d) this.d.j.get(this.a)).c.put(this.b, this.c[0]);
    }
}
