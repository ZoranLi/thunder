package com.igexin.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a extends d {
    public a(j jVar, e eVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(eVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 8));
        this.a = jVar.c(allocate, j2);
        this.b = jVar.c(allocate, j2 + 4);
    }
}
