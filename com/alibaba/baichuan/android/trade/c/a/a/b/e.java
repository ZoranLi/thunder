package com.alibaba.baichuan.android.trade.c.a.a.b;

public final class e {
    public d a = new d();

    public static e a(String str) {
        e eVar = new e();
        eVar.a.a = str;
        return eVar;
    }

    public final e a(b bVar) {
        this.a.j = bVar;
        this.a.i = bVar.getClass().getName();
        return this;
    }

    public final e a(String str, String str2, String[] strArr, String[] strArr2) {
        f fVar = new f();
        fVar.c = str;
        fVar.d = str2;
        fVar.e = strArr;
        fVar.f = strArr2;
        this.a.m.put(str, fVar);
        return this;
    }

    public final e a(int[] iArr) {
        this.a.g = iArr;
        return this;
    }

    public final e a(String[] strArr) {
        this.a.h = strArr;
        return this;
    }
}
