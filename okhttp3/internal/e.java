package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

/* compiled from: Util */
final class e implements ThreadFactory {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;

    e(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a);
        thread.setDaemon(this.b);
        return thread;
    }
}
