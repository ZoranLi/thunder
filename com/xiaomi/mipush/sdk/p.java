package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.d;
import com.xiaomi.xmpush.thrift.ai;
import java.util.HashMap;
import org.apache.thrift.a;

final class p implements Runnable {
    p() {
    }

    public final void run() {
        if (d.c(MiPushClient.sContext) != null) {
            a aiVar = new ai();
            aiVar.b(c.a(MiPushClient.sContext).c());
            aiVar.c("client_info_update");
            aiVar.a(MiPushClient.generatePacketID());
            aiVar.a(new HashMap());
            Object a = com.xiaomi.channel.commonutils.string.d.a(d.c(MiPushClient.sContext));
            Object e = d.e(MiPushClient.sContext);
            if (!TextUtils.isEmpty(e)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(e);
                a = stringBuilder.toString();
            }
            aiVar.i().put(Constants.EXTRA_KEY_IMEI_MD5, a);
            int b = d.b();
            if (b >= 0) {
                aiVar.i().put("space_id", Integer.toString(b));
            }
            ac.a(MiPushClient.sContext).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, null);
        }
    }
}
