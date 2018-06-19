package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: MainThreadExecutorDelivery */
public final class ae {
    private final Executor a = new af(this, new Handler(Looper.getMainLooper()));

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
