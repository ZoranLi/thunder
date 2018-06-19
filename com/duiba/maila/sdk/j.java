package com.duiba.maila.sdk;

import com.duiba.maila.sdk.util.d;

final class j implements Runnable {
    final /* synthetic */ Integer a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ MailaActivityInSdk d;

    j(MailaActivityInSdk mailaActivityInSdk, Integer num, String str, String str2) {
        this.d = mailaActivityInSdk;
        this.a = num;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        ((d) this.d.j.get(this.a)).c.put(this.b, this.c);
    }
}
