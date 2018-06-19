package com.igexin.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class l extends f {
    public l(j jVar, e eVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(eVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = eVar.c + (j * ((long) eVar.e));
        this.a = jVar.c(allocate, j2);
        this.b = jVar.b(allocate, j2 + 8);
        this.c = jVar.b(allocate, j2 + 16);
        this.d = jVar.b(allocate, j2 + 40);
    }
}
