package com.xunlei.tdlive.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: SimpleEvent */
public class i extends BroadcastReceiver {
    private static i a;
    private CopyOnWriteArraySet<a> b;
    private Context c;

    /* compiled from: SimpleEvent */
    public interface a {
        boolean a(String str, Bundle bundle);
    }

    public static synchronized i a(Context context) {
        synchronized (i.class) {
            if (a == null) {
                a = new i(context);
            }
            context = a;
        }
        return context;
    }

    private i(Context context) {
        this.c = context.getApplicationContext();
    }

    public i a(String str, Bundle bundle) {
        if (str == null) {
            return this;
        }
        Intent intent = new Intent("com.xunlei.tdlive.util.RxEventSimple.ACTION_EVENT");
        intent.putExtra(NotificationCompat.CATEGORY_EVENT, str);
        intent.putExtra("data", bundle);
        LocalBroadcastManager.getInstance(this.c).sendBroadcast(intent);
        return this;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.xunlei.tdlive.util.RxEventSimple.ACTION_EVENT".equals(intent.getAction()) != null && this.b != null) {
            context = this.b.iterator();
            while (context.hasNext()) {
                if (((a) context.next()).a(intent.getStringExtra(NotificationCompat.CATEGORY_EVENT), intent.getBundleExtra("data"))) {
                    return;
                }
            }
        }
    }
}
