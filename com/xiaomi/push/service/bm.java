package com.xiaomi.push.service;

import com.xiaomi.smack.b;
import com.xiaomi.smack.e;
import java.util.Map;

class bm extends b {
    final /* synthetic */ XMPushService a;

    bm(XMPushService xMPushService, Map map, int i, String str, e eVar) {
        this.a = xMPushService;
        super(map, i, str, eVar);
    }

    public byte[] a() {
        try {
            com.xiaomi.push.protobuf.b.b bVar = new com.xiaomi.push.protobuf.b.b();
            bVar.a(az.a().c());
            return bVar.c();
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("getOBBString err: ");
            stringBuilder.append(e.toString());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            return null;
        }
    }
}
