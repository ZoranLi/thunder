package com.qihoo360.replugin.component.service.server;

import com.alipay.sdk.util.h;
import com.qihoo360.replugin.utils.a.c;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: ProcessBindRecord */
final class g {
    final i a;
    final c b;
    final h c;
    final c<a> d = new c();

    g(i iVar, c cVar, h hVar) {
        this.a = iVar;
        this.b = cVar;
        this.c = hVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ProcessBindRecord{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" ");
        stringBuilder.append(this.a.k);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(this.c.a);
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }
}
