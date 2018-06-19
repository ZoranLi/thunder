package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import android.os.Handler;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: MainThreadExecutorDelivery */
final class af implements Executor {
    final /* synthetic */ Handler a;
    final /* synthetic */ ae b;

    af(ae aeVar, Handler handler) {
        this.b = aeVar;
        this.a = handler;
    }

    public final void execute(@NonNull Runnable runnable) {
        this.a.post(runnable);
    }
}
