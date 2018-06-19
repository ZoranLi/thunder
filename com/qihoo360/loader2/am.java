package com.qihoo360.loader2;

import android.content.Context;
import android.content.Intent;
import com.qihoo360.replugin.a.b;

/* compiled from: PmBase */
final class am implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ aj b;

    am(aj ajVar, Context context) {
        this.b = ajVar;
        this.a = context;
    }

    public final void run() {
        b.a(new Intent("com.qihoo360.replugin.load_large_plugin.dismiss_dlg"));
    }
}
