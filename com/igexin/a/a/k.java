package com.igexin.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class k extends f {
    public k(j jVar, e eVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(eVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = eVar.c + (j * ((long) eVar.e));
        this.a = jVar.c(allocate, j2);
        this.b = jVar.c(allocate, j2 + 4);
        this.c = jVar.c(allocate, j2 + 8);
        this.d = jVar.c(allocate, j2 + 20);
    }
}
