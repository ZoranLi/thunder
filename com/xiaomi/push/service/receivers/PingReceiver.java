package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.timers.a;

public class PingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        a.a(false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(intent.getPackage());
        stringBuilder.append(" is the package name");
        b.c(stringBuilder.toString());
        if (!as.o.equals(intent.getAction())) {
            b.a("cancel the old ping timer");
            a.a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            b.c("Ping XMChannelService on timer");
            try {
                intent = new Intent(context, XMPushService.class);
                intent.putExtra("time_stamp", System.currentTimeMillis());
                intent.setAction("com.xiaomi.push.timer");
                context.startService(intent);
            } catch (Throwable e) {
                b.a(e);
            }
        }
    }
}
