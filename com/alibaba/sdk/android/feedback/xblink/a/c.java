package com.alibaba.sdk.android.feedback.xblink.a;

import android.util.LruCache;

class c extends LruCache {
    final /* synthetic */ b a;

    c(b bVar, int i) {
        this.a = bVar;
        super(i);
    }

    protected int a(String str, d dVar) {
        return ((int) dVar.b) / 1024;
    }

    protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
        return a((String) obj, (d) obj2);
    }
}
