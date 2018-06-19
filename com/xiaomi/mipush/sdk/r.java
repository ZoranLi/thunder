package com.xiaomi.mipush.sdk;

import com.xiaomi.xmpush.thrift.f;

class r implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ MiTinyDataClient$a$a b;

    r(MiTinyDataClient$a$a miTinyDataClient$a$a, f fVar) {
        this.b = miTinyDataClient$a$a;
        this.a = fVar;
    }

    public void run() {
        this.b.a.add(this.a);
        this.b.a();
    }
}
