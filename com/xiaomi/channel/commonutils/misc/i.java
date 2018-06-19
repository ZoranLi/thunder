package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.h.a;

class i extends h$b {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    i(h hVar, a aVar, String str) {
        this.b = hVar;
        this.a = str;
        super(aVar);
    }

    void a() {
        super.a();
    }

    void b() {
        h.a(this.b).edit().putLong(this.a, System.currentTimeMillis()).commit();
    }
}
