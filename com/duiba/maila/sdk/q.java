package com.duiba.maila.sdk;

import com.duiba.maila.sdk.ViewCore.a;

final class q implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    q(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void run() {
        this.b.a.a(this.a);
    }
}
