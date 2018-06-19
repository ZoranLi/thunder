package com.qihoo360.loader2;

import android.content.Intent;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.g;

/* compiled from: PmHostSvc */
final class ao implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ an b;

    ao(an anVar, Intent intent) {
        this.b = anVar;
        this.a = intent;
    }

    public final void run() {
        g.a();
        b.a(this.a);
    }
}
