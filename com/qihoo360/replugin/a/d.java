package com.qihoo360.replugin.a;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import java.util.concurrent.Callable;

/* compiled from: LocalBroadcastHelper */
final class d implements Callable<Void> {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;

    d(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public final /* synthetic */ Object call() throws Exception {
        LocalBroadcastManager.getInstance(this.a).sendBroadcastSync(this.b);
        return null;
    }
}
