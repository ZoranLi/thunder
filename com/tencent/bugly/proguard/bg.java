package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class bg extends m implements Cloneable {
    static bf m = new bf();
    static Map<String, String> n = new HashMap();
    static final /* synthetic */ boolean o = true;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    public String d = "";
    public String e = "";
    public bf f = null;
    public Map<String, String> g = null;
    public long h = 0;
    public String i = "";
    public String j = "";
    public int k = 0;
    public int l = 0;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bg bgVar = (bg) obj;
        if (n.a(this.a, bgVar.a) && n.a(this.b, bgVar.b) && n.a(this.c, bgVar.c) && n.a(this.d, bgVar.d) && n.a(this.e, bgVar.e) && n.a(this.f, bgVar.f) && n.a(this.g, bgVar.g) && n.a(this.h, bgVar.h) && n.a(this.i, bgVar.i) && n.a(this.j, bgVar.j) && n.a(this.k, bgVar.k) && n.a(this.l, bgVar.l) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final java.lang.Object clone() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0005 }
        goto L_0x0010;
    L_0x0005:
        r0 = o;
        if (r0 != 0) goto L_0x000f;
    L_0x0009:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x000f:
        r0 = 0;
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bg.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
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
        if (this.i != null) {
            lVar.a(this.i, 8);
        }
        if (this.j != null) {
            lVar.a(this.j, 9);
        }
        lVar.a(this.k, 10);
        lVar.a(this.l, 11);
    }

    static {
        n.put("", "");
    }

    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.a(this.c, 2, true);
        this.d = kVar.a(3, false);
        this.e = kVar.a(4, false);
        this.f = (bf) kVar.a(m, 5, false);
        this.g = (Map) kVar.a(n, 6, false);
        this.h = kVar.a(this.h, 7, false);
        this.i = kVar.a(8, false);
        this.j = kVar.a(9, false);
        this.k = kVar.a(this.k, 10, false);
        this.l = kVar.a(this.l, 11, false);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, "enable");
        iVar.a(this.b, "enableUserInfo");
        iVar.a(this.c, "enableQuery");
        iVar.a(this.d, "url");
        iVar.a(this.e, "expUrl");
        iVar.a(this.f, "security");
        iVar.a(this.g, "valueMap");
        iVar.a(this.h, "strategylastUpdateTime");
        iVar.a(this.i, "httpsUrl");
        iVar.a(this.j, "httpsExpUrl");
        iVar.a(this.k, "eventRecordCount");
        iVar.a(this.l, "eventTimeInterval");
    }
}
