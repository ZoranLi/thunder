package anet.channel.strategy;

import anet.channel.util.HttpConstant;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class c {
    private ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
    private boolean b = true;

    /* compiled from: Taobao */
    private static class a {
        public static c a = new c();

        private a() {
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public String a(String str) {
        if (!this.b) {
            return null;
        }
        String str2 = (String) this.a.get(str);
        if (str2 == null) {
            str2 = (String) this.a.putIfAbsent(str, "https");
        }
        return str2;
    }

    public void b(String str) {
        this.a.put(str, HttpConstant.HTTP);
    }
}
