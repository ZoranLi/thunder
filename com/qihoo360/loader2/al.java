package com.qihoo360.loader2;

import android.content.Context;
import android.content.Intent;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;

/* compiled from: PmBase */
final class al implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ aj b;

    al(aj ajVar, Context context) {
        this.b = ajVar;
        this.a = context;
    }

    public final void run() {
        if (c.a) {
            c.a("loadClass", "发广播，让 PluginLoadingActivity2 消失");
        }
        b.a(new Intent("com.qihoo360.replugin.load_large_plugin.dismiss_dlg"));
    }
}
