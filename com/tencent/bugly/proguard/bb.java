package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class bb extends m {
    static ArrayList<ba> A = new ArrayList();
    static Map<String, String> B = new HashMap();
    static Map<String, String> C = new HashMap();
    static Map<String, String> v = new HashMap();
    static az w = new az();
    static ay x = new ay();
    static ArrayList<ay> y = new ArrayList();
    static ArrayList<ay> z = new ArrayList();
    public String a = "";
    public long b = 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public Map<String, String> h = null;
    public String i = "";
    public az j = null;
    public int k = 0;
    public String l = "";
    public String m = "";
    public ay n = null;
    public ArrayList<ay> o = null;
    public ArrayList<ay> p = null;
    public ArrayList<ba> q = null;
    public Map<String, String> r = null;
    public Map<String, String> s = null;
    public String t = "";
    public boolean u = true;

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
        if (this.h != null) {
            lVar.a(this.h, 7);
        }
        if (this.i != null) {
            lVar.a(this.i, 8);
        }
        if (this.j != null) {
            lVar.a(this.j, 9);
        }
        lVar.a(this.k, 10);
        if (this.l != null) {
            lVar.a(this.l, 11);
        }
        if (this.m != null) {
            lVar.a(this.m, 12);
        }
        if (this.n != null) {
            lVar.a(this.n, 13);
        }
        if (this.o != null) {
            lVar.a(this.o, 14);
        }
        if (this.p != null) {
            lVar.a(this.p, 15);
        }
        if (this.q != null) {
            lVar.a(this.q, 16);
        }
        if (this.r != null) {
            lVar.a(this.r, 17);
        }
        if (this.s != null) {
            lVar.a(this.s, 18);
        }
        if (this.t != null) {
            lVar.a(this.t, 19);
        }
        lVar.a(this.u, 20);
    }

    static {
        v.put("", "");
        y.add(new ay());
        z.add(new ay());
        A.add(new ba());
        B.put("", "");
        C.put("", "");
    }

    public final void a(k kVar) {
        this.a = kVar.a(0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.a(2, true);
        this.d = kVar.a(3, false);
        this.e = kVar.a(4, false);
        this.f = kVar.a(5, false);
        this.g = kVar.a(6, false);
        this.h = (Map) kVar.a(v, 7, false);
        this.i = kVar.a(8, false);
        this.j = (az) kVar.a(w, 9, false);
        this.k = kVar.a(this.k, 10, false);
        this.l = kVar.a(11, false);
        this.m = kVar.a(12, false);
        this.n = (ay) kVar.a(x, 13, false);
        this.o = (ArrayList) kVar.a(y, 14, false);
        this.p = (ArrayList) kVar.a(z, 15, false);
        this.q = (ArrayList) kVar.a(A, 16, false);
        this.r = (Map) kVar.a(B, 17, false);
        this.s = (Map) kVar.a(C, 18, false);
        this.t = kVar.a(19, false);
        this.u = kVar.a(this.u, 20, false);
    }
}
