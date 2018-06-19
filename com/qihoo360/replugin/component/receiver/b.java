package com.qihoo360.replugin.component.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.qihoo360.replugin.b.c;

/* compiled from: PluginReceiverHelper */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ BroadcastReceiver b;
    final /* synthetic */ Context c;
    final /* synthetic */ Intent d;

    b(String str, BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        this.a = str;
        this.b = broadcastReceiver;
        this.c = context;
        this.d = intent;
    }

    public final void run() {
        if (c.a) {
            c.a("ms-receiver", String.format("调用 %s.onReceive()", new Object[]{this.a}));
        }
        this.b.onReceive(this.c, this.d);
    }
}
