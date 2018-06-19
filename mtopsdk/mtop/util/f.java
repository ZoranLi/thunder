package mtopsdk.mtop.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.i;

final class f implements ThreadFactory {
    private int a = 10;
    private final AtomicInteger b = new AtomicInteger();
    private String c = "";

    public f(int i) {
        this.a = i;
    }

    public f(int i, String str) {
        this.a = i;
        this.c = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("MTOPSDK ");
        if (i.a(this.c)) {
            stringBuilder.append(this.c);
            str = " ";
        } else {
            str = "DefaultPool ";
        }
        stringBuilder.append(str);
        stringBuilder.append("Thread:");
        stringBuilder.append(this.b.getAndIncrement());
        return new g(this, runnable, stringBuilder.toString());
    }
}
