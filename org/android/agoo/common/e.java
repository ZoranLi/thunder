package org.android.agoo.common;

import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
final class e implements ThreadFactory {
    e() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AGOO");
    }
}
