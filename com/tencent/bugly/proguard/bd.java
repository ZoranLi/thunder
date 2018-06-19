package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class bd extends m {
    static byte[] y;
    static Map<String, String> z = new HashMap();
    public int a = 0;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public int g = 0;
    public byte[] h = null;
    public String i = "";
    public String j = "";
    public Map<String, String> k = null;
    public String l = "";
    public long m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
        lVar.a(this.d, 3);
        if (this.e != null) {
            lVar.a(this.e, 4);
        }
        lVar.a(this.f, 5);
        lVar.a(this.g, 6);
        lVar.a(this.h, 7);
        if (this.i != null) {
            lVar.a(this.i, 8);
        }
        if (this.j != null) {
            lVar.a(this.j, 9);
        }
        if (this.k != null) {
            lVar.a(this.k, 10);
        }
        if (this.l != null) {
            lVar.a(this.l, 11);
        }
        lVar.a(this.m, 12);
        if (this.n != null) {
            lVar.a(this.n, 13);
        }
        if (this.o != null) {
            lVar.a(this.o, 14);
        }
        if (this.p != null) {
            lVar.a(this.p, 15);
        }
        lVar.a(this.q, 16);
        if (this.r != null) {
            lVar.a(this.r, 17);
        }
        if (this.s != null) {
            lVar.a(this.s, 18);
        }
        if (this.t != null) {
            lVar.a(this.t, 19);
        }
        if (this.u != null) {
            lVar.a(this.u, 20);
        }
        if (this.v != null) {
            lVar.a(this.v, 21);
        }
        if (this.w != null) {
            lVar.a(this.w, 22);
        }
        if (this.x != null) {
            lVar.a(this.x, 23);
        }
    }

    static {
        byte[] bArr = new byte[1];
        y = bArr;
        bArr[0] = (byte) 0;
        z.put("", "");
    }

    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.a(1, true);
        this.c = kVar.a(2, true);
        this.d = kVar.a(3, true);
        this.e = kVar.a(4, false);
        this.f = kVar.a(5, true);
        this.g = kVar.a(this.g, 6, true);
        this.h = kVar.a(y, 7, true);
        this.i = kVar.a(8, false);
        this.j = kVar.a(9, false);
        this.k = (Map) kVar.a(z, 10, false);
        this.l = kVar.a(11, false);
        this.m = kVar.a(this.m, 12, false);
        this.n = kVar.a(13, false);
        this.o = kVar.a(14, false);
        this.p = kVar.a(15, false);
        this.q = kVar.a(this.q, 16, false);
        this.r = kVar.a(17, false);
        this.s = kVar.a(18, false);
        this.t = kVar.a(19, false);
        this.u = kVar.a(20, false);
        this.v = kVar.a(21, false);
        this.w = kVar.a(22, false);
        this.x = kVar.a(23, false);
    }
}
