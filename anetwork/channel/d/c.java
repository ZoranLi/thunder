package anetwork.channel.d;

import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public final class c {
    private static final CopyOnWriteArrayList<b> a = new CopyOnWriteArrayList();

    public static b a(int i) {
        return (b) a.get(i);
    }

    public static int a() {
        return a.size();
    }
}
