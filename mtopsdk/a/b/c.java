package mtopsdk.a.b;

import java.util.HashMap;
import java.util.Map;

public final class c {
    String a;
    public String b = "GET";
    public Map c = new HashMap();
    public d d;
    public String e;
    public int f = 15000;
    public int g = 15000;
    public int h;
    public int i;

    public final b a() {
        if (this.a != null) {
            return new b();
        }
        throw new IllegalStateException("url == null");
    }

    public final c a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("url == null");
        }
        this.a = str;
        return this;
    }
}
