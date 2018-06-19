package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class be extends m {
    static byte[] i;
    static Map<String, String> j = new HashMap();
    public byte a = (byte) 0;
    public int b = 0;
    public byte[] c = null;
    public String d = "";
    public long e = 0;
    public String f = "";
    public String g = "";
    public Map<String, String> h = null;

    public final void a(l lVar) {
        lVar.b(this.a, 0);
        lVar.a(this.b, 1);
        if (this.c != null) {
            lVar.a(this.c, 2);
        }
        if (this.d != null) {
            lVar.a(this.d, 3);
        }
        lVar.a(this.e, 4);
        if (this.f != null) {
            lVar.a(this.f, 5);
        }
        if (this.g != null) {
            lVar.a(this.g, 6);
        }
        if (this.h != null) {
            lVar.a(this.h, 7);
        }
    }

    static {
        byte[] bArr = new byte[1];
        i = bArr;
        bArr[0] = (byte) 0;
        j.put("", "");
    }

    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.a(i, 2, false);
        this.d = kVar.a(3, false);
        this.e = kVar.a(this.e, 4, false);
        this.f = kVar.a(5, false);
        this.g = kVar.a(6, false);
        this.h = (Map) kVar.a(j, 7, false);
    }
}
