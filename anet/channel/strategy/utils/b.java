package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import com.alipay.sdk.cons.c;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
final class b implements ThreadFactory {
    b() {
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder("AMDC");
        stringBuilder.append(a.a.incrementAndGet());
        Thread thread = new Thread(runnable, stringBuilder.toString());
        ALog.i(b.TAG, "thread created!", null, c.e, thread.getName());
        thread.setPriority(5);
        return thread;
    }
}
