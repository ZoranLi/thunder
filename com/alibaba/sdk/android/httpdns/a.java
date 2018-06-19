package com.alibaba.sdk.android.httpdns;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

class a {
    private static a a = new a();
    private static ConcurrentMap f0a;
    private static ConcurrentSkipListSet f1a;

    private a() {
        f0a = new ConcurrentHashMap();
        f1a = new ConcurrentSkipListSet();
    }

    static a a() {
        return a;
    }

    int m5a() {
        return f0a.size();
    }

    b a(String str) {
        return (b) f0a.get(str);
    }

    ArrayList m6a() {
        return new ArrayList(f0a.keySet());
    }

    void m7a(String str) {
        f1a.add(str);
    }

    void a(String str, b bVar) {
        f0a.put(str, bVar);
    }

    boolean m8a(String str) {
        return f1a.contains(str);
    }

    void b(String str) {
        f1a.remove(str);
    }

    void clear() {
        f0a.clear();
        f1a.clear();
    }
}
