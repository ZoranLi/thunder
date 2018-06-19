package com.igexin.push.core.c;

import com.igexin.push.f.a;
import com.igexin.push.util.e;

class g extends a {
    final /* synthetic */ byte[] a;
    final /* synthetic */ f b;

    g(f fVar, byte[] bArr) {
        this.b = fVar;
        this.a = bArr;
    }

    protected void a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.igexin.push.core.g.f.getFilesDir().getPath());
        stringBuilder.append("/conf_n.pid");
        e.a(this.a, stringBuilder.toString(), false);
    }
}
