package com.igexin.push.core.b;

import com.igexin.push.b.d;
import com.igexin.push.core.g;
import com.igexin.push.util.EncryptUtils;

class z extends d {
    final /* synthetic */ g a;

    z(g gVar) {
        this.a = gVar;
    }

    public void a() {
        g.a().a(this.c, 19, EncryptUtils.getBytesEncrypted(g.w.getBytes()));
    }
}
