package anetwork.channel.statist;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class a {
    private static a f;
    public boolean a = false;
    public long b = 0;
    public Set<String> c;
    public Set<String> d;
    public long e = 0;

    private a() {
        if (this.c == null) {
            this.c = new HashSet();
        } else {
            this.c.clear();
        }
        if (this.d == null) {
            this.d = new HashSet();
        }
    }

    public static a a() {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a();
                }
            }
        }
        return f;
    }
}
