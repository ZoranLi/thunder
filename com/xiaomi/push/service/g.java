package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.h.a;
import java.util.Iterator;

public class g extends a {
    private XMPushService a;

    public g(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public int a() {
        return 15;
    }

    public void run() {
        Iterator it = j.a(this.a).a().iterator();
        while (it.hasNext()) {
            com.xiaomi.push.service.module.a aVar = (com.xiaomi.push.service.module.a) it.next();
            if (aVar.a() < System.currentTimeMillis()) {
                if (j.a(this.a).a(aVar.b()) == 0) {
                    StringBuilder stringBuilder = new StringBuilder("GeofenceDbCleaner delete a geofence message failed message_id:");
                    stringBuilder.append(aVar.b());
                    b.a(stringBuilder.toString());
                }
                x.a(this.a, x.a(aVar.d()), false, false, true);
            }
        }
    }
}
