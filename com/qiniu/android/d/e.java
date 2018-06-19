package com.qiniu.android.d;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: StringMap */
public final class e {
    public Map<String, Object> a;

    /* compiled from: StringMap */
    public interface a {
        void a(String str, Object obj);
    }

    public e() {
        this(new HashMap());
    }

    private e(Map<String, Object> map) {
        this.a = map;
    }

    public final e a(String str, Object obj) {
        this.a.put(str, obj);
        return this;
    }

    public final void a(a aVar) {
        for (Entry entry : this.a.entrySet()) {
            aVar.a((String) entry.getKey(), entry.getValue());
        }
    }
}
