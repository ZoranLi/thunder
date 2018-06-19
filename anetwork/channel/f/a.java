package anetwork.channel.f;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public final class a {
    private static AtomicInteger a = new AtomicInteger(0);

    public static String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(16);
        if (str != null) {
            stringBuilder.append(str);
            stringBuilder.append('.');
        }
        stringBuilder.append(str2);
        stringBuilder.append(a.incrementAndGet() & Integer.MAX_VALUE);
        return stringBuilder.toString();
    }
}
