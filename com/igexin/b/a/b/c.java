package com.igexin.b.a.b;

import com.igexin.b.a.d.a.a;
import com.igexin.b.a.d.e;
import com.igexin.b.a.d.f;
import java.util.concurrent.TimeUnit;

public class c extends f {
    static c a;
    public volatile long b;
    public volatile long c;
    public volatile long d;
    public volatile long e;
    a<String, Integer, b, e> f;
    private byte[] v;
    private byte[] w;

    public static c b() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public static void d() {
        a.b = 0;
        a.d = 0;
        a.c = 0;
        a.e = 0;
    }

    public e a(String str, int i, b bVar, Object obj, boolean z) {
        return a(str, i, bVar, obj, z, -1, -1, (byte) 0, null, null);
    }

    public e a(String str, int i, b bVar, Object obj, boolean z, int i2, long j, byte b, Object obj2, com.igexin.b.a.d.a.c cVar) {
        return a(str, i, bVar, obj, z, i2, j, b, obj2, cVar, 0, null);
    }

    public e a(String str, int i, b bVar, Object obj, boolean z, int i2, long j, byte b, Object obj2, com.igexin.b.a.d.a.c cVar, int i3, com.igexin.b.a.d.a.f fVar) {
        com.igexin.b.a.d.a.f fVar2 = fVar;
        if (this.f == null) {
            return null;
        }
        e eVar = (e) r10.f.a(str, Integer.valueOf(i), bVar);
        if (eVar == null || eVar.r()) {
            return null;
        }
        if (fVar2 != null) {
            eVar.a(i3, fVar2);
        }
        a(eVar, obj, z, i2, j, b, obj2, cVar);
        return eVar;
    }

    public e a(String str, int i, b bVar, Object obj, boolean z, int i2, com.igexin.b.a.d.a.f fVar) {
        return a(str, i, bVar, obj, z, -1, -1, (byte) 0, null, null, i2, fVar);
    }

    public void a(a<String, Integer, b, e> aVar) {
        this.f = aVar;
    }

    public void a(byte[] bArr) {
        this.v = bArr;
        this.w = com.igexin.b.b.a.a(bArr);
    }

    boolean a(e eVar, Object obj, boolean z, int i, long j, byte b, Object obj2, com.igexin.b.a.d.a.c cVar) {
        eVar.c = obj;
        eVar.a(j, TimeUnit.MILLISECONDS);
        eVar.x = i;
        eVar.a((int) b);
        eVar.C = obj2;
        eVar.a(cVar);
        return a((e) eVar, z);
    }

    public byte[] a() {
        return this.w;
    }

    public final void c() {
        f();
    }
}
