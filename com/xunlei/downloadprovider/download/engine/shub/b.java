package com.xunlei.downloadprovider.download.engine.shub;

import android.util.LruCache;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: GcidManager */
public final class b {
    private static b c = new b();
    public LruCache<String, GcidInfo> a = new LruCache(1000);
    public ConcurrentHashMap<String, b> b = new ConcurrentHashMap();

    /* compiled from: GcidManager */
    public interface a {
        void a(GcidInfo gcidInfo);
    }

    /* compiled from: GcidManager */
    private static class b {
        public String a;
        GcidInfo b;
        c c;
        public String d;

        public b(String str) {
            this.d = str;
        }

        static /* synthetic */ void a(b bVar) {
            if (bVar.b != null) {
                bVar.c.a(bVar, bVar.b);
            }
        }
    }

    /* compiled from: GcidManager */
    private interface c {
        void a(b bVar, GcidInfo gcidInfo);
    }

    public static b a() {
        return c;
    }

    private b() {
    }
}
