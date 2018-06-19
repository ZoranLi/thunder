package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.misc.h.a;
import com.xiaomi.push.service.p;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.r;
import java.util.HashMap;
import java.util.Map;

public class ao extends a {
    private Context a;

    public ao(Context context) {
        this.a = context;
    }

    public int a() {
        return 10;
    }

    public void run() {
        org.apache.thrift.a aiVar = new ai(MiPushClient.generatePacketID(), false);
        c a = c.a(this.a);
        aiVar.c(r.A.W);
        aiVar.b(a.c());
        aiVar.d(this.a.getPackageName());
        Map hashMap = new HashMap();
        g.a(hashMap, Constants.EXTRA_KEY_MIID, p.a(this.a).c());
        aiVar.h = hashMap;
        ac.a(this.a).a(aiVar, com.xiaomi.xmpush.thrift.a.i, true, null);
    }
}
