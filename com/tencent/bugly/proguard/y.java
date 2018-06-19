package com.tencent.bugly.proguard;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class y extends m implements Cloneable {
    static v q = null;
    static u r = null;
    static u s = null;
    static Map<String, String> t = null;
    static final /* synthetic */ boolean u = true;
    public String a = "";
    public String b = "";
    public long c = 0;
    public int d = 0;
    public v e = null;
    public u f = null;
    public byte g = (byte) 0;
    public int h = 0;
    public long i = 0;
    public u j = null;
    public String k = "";
    public Map<String, String> l = null;
    public String m = "";
    public int n = 0;
    public long o = 0;
    public int p = 0;

    public final long a() {
        return this.c;
    }

    public final u b() {
        return this.f;
    }

    public y(String str, String str2, long j, int i, v vVar, u uVar, byte b, int i2, long j2, u uVar2, String str3, Map<String, String> map, String str4, int i3, long j3, int i4) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = i;
        this.e = vVar;
        this.f = uVar;
        this.g = b;
        this.h = i2;
        this.i = j2;
        this.j = uVar2;
        this.k = str3;
        this.l = map;
        this.m = str4;
        this.n = i3;
        this.o = j3;
        this.p = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        y yVar = (y) obj;
        if (n.a(this.a, yVar.a) && n.a(this.b, yVar.b) && n.a(this.c, yVar.c) && n.a(this.d, yVar.d) && n.a(this.e, yVar.e) && n.a(this.f, yVar.f) && n.a(this.g, yVar.g) && n.a(this.h, yVar.h) && n.a(this.i, yVar.i) && n.a(this.j, yVar.j) && n.a(this.k, yVar.k) && n.a(this.l, yVar.l) && n.a(this.m, yVar.m) && n.a(this.n, yVar.n) && n.a(this.o, yVar.o) && n.a(this.p, yVar.p) != null) {
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
        r0 = u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.y.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
        lVar.a(this.d, 3);
        lVar.a(this.e, 4);
        lVar.a(this.f, 5);
        lVar.b(this.g, 6);
        lVar.a(this.h, 7);
        lVar.a(this.i, 8);
        if (this.j != null) {
            lVar.a(this.j, 9);
        }
        if (this.k != null) {
            lVar.a(this.k, 10);
        }
        if (this.l != null) {
            lVar.a(this.l, 11);
        }
        if (this.m != null) {
            lVar.a(this.m, 12);
        }
        lVar.a(this.n, 13);
        lVar.a(this.o, 14);
        lVar.a(this.p, 15);
    }

    public final void a(k kVar) {
        this.a = kVar.a(0, true);
        this.b = kVar.a(1, true);
        this.c = kVar.a(this.c, 2, true);
        this.d = kVar.a(this.d, 3, true);
        if (q == null) {
            q = new v();
        }
        this.e = (v) kVar.a(q, 4, true);
        if (r == null) {
            r = new u();
        }
        this.f = (u) kVar.a(r, 5, true);
        this.g = kVar.a(this.g, 6, true);
        this.h = kVar.a(this.h, 7, false);
        this.i = kVar.a(this.i, 8, false);
        if (s == null) {
            s = new u();
        }
        this.j = (u) kVar.a(s, 9, false);
        this.k = kVar.a(10, false);
        if (t == null) {
            t = new HashMap();
            t.put("", "");
        }
        this.l = (Map) kVar.a(t, 11, false);
        this.m = kVar.a(12, false);
        this.n = kVar.a(this.n, 13, false);
        this.o = kVar.a(this.o, 14, false);
        this.p = kVar.a(this.p, 15, false);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, "title");
        iVar.a(this.b, "newFeature");
        iVar.a(this.c, "publishTime");
        iVar.a(this.d, "publishType");
        iVar.a(this.e, "appBasicInfo");
        iVar.a(this.f, "apkBaseInfo");
        iVar.a(this.g, "updateStrategy");
        iVar.a(this.h, "popTimes");
        iVar.a(this.i, "popInterval");
        iVar.a(this.j, "diffApkInfo");
        iVar.a(this.k, DispatchConstants.NET_TYPE);
        iVar.a(this.l, "reserved");
        iVar.a(this.m, "strategyId");
        iVar.a(this.n, "status");
        iVar.a(this.o, "updateTime");
        iVar.a(this.p, "updateType");
    }
}
