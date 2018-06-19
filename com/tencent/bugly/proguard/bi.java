package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class bi extends m implements Cloneable {
    static ArrayList<bh> f;
    static Map<String, String> g;
    public byte a = (byte) 0;
    public String b = "";
    public String c = "";
    public ArrayList<bh> d = null;
    public Map<String, String> e = null;

    public final void a(StringBuilder stringBuilder, int i) {
    }

    public final void a(l lVar) {
        lVar.b(this.a, 0);
        if (this.b != null) {
            lVar.a(this.b, 1);
        }
        if (this.c != null) {
            lVar.a(this.c, 2);
        }
        if (this.d != null) {
            lVar.a(this.d, 3);
        }
        if (this.e != null) {
            lVar.a(this.e, 4);
        }
    }

    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.a(1, false);
        this.c = kVar.a(2, false);
        if (f == null) {
            f = new ArrayList();
            f.add(new bh());
        }
        this.d = (ArrayList) kVar.a(f, 3, false);
        if (g == null) {
            g = new HashMap();
            g.put("", "");
        }
        this.e = (Map) kVar.a(g, 4, false);
    }
}
