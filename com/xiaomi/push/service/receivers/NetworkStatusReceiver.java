package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.AssemblePushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ac;
import com.xiaomi.mipush.sdk.aj;
import com.xiaomi.mipush.sdk.c;
import com.xiaomi.mipush.sdk.u;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver extends BroadcastReceiver {
    private static int a = 1;
    private static int b = 1;
    private static int c = 2;
    private static BlockingQueue<Runnable> d = new LinkedBlockingQueue();
    private static ThreadPoolExecutor e = new ThreadPoolExecutor(a, b, (long) c, TimeUnit.SECONDS, d);
    private static boolean f = false;
    private boolean g;

    public NetworkStatusReceiver() {
        this.g = false;
        this.g = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.g = false;
        f = true;
    }

    private void a(Context context) {
        if (!(ac.a(context).d() || !c.a(context).i() || c.a(context).m())) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                context.startService(intent);
            } catch (Throwable e) {
                b.a(e);
            }
        }
        if (d.c(context) && ac.a(context).h()) {
            ac.a(context).e();
        }
        if (d.c(context)) {
            if ("syncing".equals(u.a(context).a(aj.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(u.a(context).a(aj.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(u.a(context).a(aj.UPLOAD_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if (AssemblePushHelper.needConnect() && AssemblePushHelper.shouldTryConnect(context)) {
                AssemblePushHelper.setConnectTime(context);
                com.xiaomi.mipush.sdk.d.c(context);
            }
        }
    }

    public static boolean a() {
        return f;
    }

    public void onReceive(Context context, Intent intent) {
        if (!this.g) {
            e.execute(new a(this, context));
        }
    }
}
