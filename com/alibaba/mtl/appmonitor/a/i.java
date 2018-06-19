package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UTEvent */
public class i implements b {
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public Map<String, String> f;

    public final void d() {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        if (this.f != null) {
            this.f.clear();
        }
    }

    public final void a(Object... objArr) {
        if (this.f == null) {
            this.f = new HashMap();
        }
    }
}
