package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Cache */
public interface a {

    /* compiled from: Cache */
    public static class a {
        public byte[] a;
        public String b;
        public long c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();
        public List<g> h;

        public final boolean a() {
            return this.e < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
