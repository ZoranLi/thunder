package com.igexin.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class m extends g {
    public m(j jVar, e eVar, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(eVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.a = jVar.c(allocate, (eVar.d + ((long) (i * eVar.g))) + 28);
    }
}
