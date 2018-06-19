package com.igexin.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class h extends e {
    private final j j;

    public h(boolean z, j jVar) {
        this.a = z;
        this.j = jVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = jVar.d(allocate, 16);
        this.c = jVar.c(allocate, 28);
        this.d = jVar.c(allocate, 32);
        this.e = jVar.d(allocate, 42);
        this.f = jVar.d(allocate, 44);
        this.g = jVar.d(allocate, 46);
        this.h = jVar.d(allocate, 48);
        this.i = jVar.d(allocate, 50);
    }

    public d a(long j, int i) {
        return new a(this.j, this, j, i);
    }

    public f a(long j) {
        return new k(this.j, this, j);
    }

    public g a(int i) {
        return new m(this.j, this, i);
    }
}
