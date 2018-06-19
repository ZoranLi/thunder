package com.igexin.push.core.a;

import com.igexin.b.a.c.a;
import com.igexin.b.a.d.e;
import com.igexin.push.config.l;
import com.igexin.push.core.i;
import com.igexin.push.d.b;
import com.igexin.push.d.c.h;

public class k extends a {
    private static final String a = l.a;

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (obj instanceof h) {
            b.a().e();
            a.b("heartbeatRsp");
            i.a().a(com.igexin.push.core.k.HEARTBEAT_OK);
        }
        return true;
    }
}
