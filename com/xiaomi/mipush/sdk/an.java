package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.android.d;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.p;
import com.xiaomi.push.service.p.a;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.r;
import java.util.HashMap;
import java.util.Map;

public class an implements a {
    public an(Context context) {
        p.a(context).a((a) this);
    }

    private void b(String str, Context context) {
        org.apache.thrift.a aiVar = new ai();
        aiVar.c(r.ClientMIIDUpdate.W);
        aiVar.b(c.a(context).c());
        aiVar.a(MiPushClient.generatePacketID());
        Map hashMap = new HashMap();
        g.a(hashMap, Constants.EXTRA_KEY_MIID, str);
        aiVar.a(hashMap);
        int b = d.b();
        if (b >= 0) {
            aiVar.i().put("space_id", Integer.toString(b));
        }
        ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
    }

    public void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_miid_time", -1);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int a = am.a(context).a(com.xiaomi.xmpush.thrift.g.SyncMIIDFrequency.a(), 21600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
            return;
        }
        if (Math.abs(currentTimeMillis - j) > ((long) a)) {
            h.a(context).a(new ao(context), a);
            sharedPreferences.edit().putLong("last_sync_miid_time", currentTimeMillis).commit();
        }
    }

    public void a(String str, Context context) {
        b(str, context);
    }
}
