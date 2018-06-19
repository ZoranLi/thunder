package com.alibaba.mtl.appmonitor.c;

import org.json.JSONArray;

/* compiled from: ReuseJSONArray */
public class d extends JSONArray implements b {
    public final void a(Object... objArr) {
    }

    public final void d() {
        for (int i = 0; i < length(); i++) {
            Object opt = opt(i);
            if (opt != null && (opt instanceof b)) {
                a.a().a((b) opt);
            }
        }
    }
}
