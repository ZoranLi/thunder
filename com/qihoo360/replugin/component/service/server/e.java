package com.qihoo360.replugin.component.service.server;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qihoo360.replugin.b.c;

/* compiled from: PluginServiceServer */
final class e extends Handler {
    final /* synthetic */ d a;

    e(d dVar, Looper looper) {
        this.a = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            Intent intent = (Intent) message.getData().getParcelable("intent");
            i iVar = (i) message.obj;
            if (intent != null && iVar != null) {
                iVar.f.onStartCommand(intent, 0, 0);
            } else if (c.a != null) {
                c.d("ws001", "pss.onStartCommand fail.");
            }
        }
    }
}
