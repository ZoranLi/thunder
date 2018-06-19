package com.igexin.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class i extends e {
    private final j j;

    public i(boolean z, j jVar) {
        this.a = z;
        this.j = jVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = jVar.d(allocate, 16);
        this.c = jVar.b(allocate, 32);
        this.d = jVar.b(allocate, 40);
        this.e = jVar.d(allocate, 54);
        this.f = jVar.d(allocate, 56);
        this.g = jVar.d(allocate, 58);
        this.h = jVar.d(allocate, 60);
        this.i = jVar.d(allocate, 62);
    }

    public d a(long j, int i) {
        return new b(this.j, this, j, i);
    }

    public f a(long j) {
        return new l(this.j, this, j);
    }

    public g a(int i) {
        return new n(this.j, this, i);
    }
}
