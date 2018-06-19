package com.igexin.push.core.b;

import com.igexin.push.b.d;
import com.igexin.push.core.g;
import com.igexin.push.util.EncryptUtils;
import com.igexin.push.util.e;

class aa extends d {
    final /* synthetic */ g a;

    aa(g gVar) {
        this.a = gVar;
    }

    public void a() {
        g.a().a(this.c, 1, EncryptUtils.getBytesEncrypted(String.valueOf(g.q).getBytes()));
        g.a().a(this.c, 20, this.a.g(g.r));
        e.a();
    }
}
