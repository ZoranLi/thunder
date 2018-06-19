package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class bh extends m {
    static Map<String, String> i = new HashMap();
    public long a = 0;
    public byte b = (byte) 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public Map<String, String> f = null;
    public String g = "";
    public boolean h = true;

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.b(this.b, 1);
        if (this.c != null) {
            lVar.a(this.c, 2);
        }
        if (this.d != null) {
            lVar.a(this.d, 3);
        }
        if (this.e != null) {
            lVar.a(this.e, 4);
        }
        if (this.f != null) {
            lVar.a(this.f, 5);
        }
        if (this.g != null) {
            lVar.a(this.g, 6);
        }
        lVar.a(this.h, 7);
    }

    static {
        i.put("", "");
    }

    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.a(2, false);
        this.d = kVar.a(3, false);
        this.e = kVar.a(4, false);
        this.f = (Map) kVar.a(i, 5, false);
        this.g = kVar.a(6, false);
        this.h = kVar.a(this.h, 7, false);
    }
}
