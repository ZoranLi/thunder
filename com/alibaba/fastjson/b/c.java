package com.alibaba.fastjson.b;

/* compiled from: FieldWriter */
public final class c {
    c a;
    final int b;
    final int c;
    final int d;

    public c(b bVar, String str, String str2) {
        if (bVar.j == null) {
            bVar.j = this;
        } else {
            bVar.k.a = this;
        }
        bVar.k = this;
        this.b = 1;
        this.c = bVar.a(str);
        this.d = bVar.a(str2);
    }
}
