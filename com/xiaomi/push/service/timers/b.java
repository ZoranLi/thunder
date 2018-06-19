package com.xiaomi.push.service.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.channel.commonutils.reflect.a;
import com.xiaomi.push.service.as;
import com.xiaomi.smack.g;

class b implements a {
    private PendingIntent a = null;
    private Context b = null;
    private volatile long c = 0;

    public b(Context context) {
        this.b = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(alarmManager, new Object[]{Integer.valueOf(0), Long.valueOf(j), pendingIntent});
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a() {
        if (this.a != null) {
            ((AlarmManager) this.b.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.a);
            this.a = null;
            com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
        }
        this.c = 0;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.b.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.a = PendingIntent.getBroadcast(this.b, 0, intent, 0);
        if (VERSION.SDK_INT >= 23) {
            a.a(alarmManager, "setExactAndAllowWhileIdle", new Object[]{Integer.valueOf(0), Long.valueOf(j), this.a});
        } else if (VERSION.SDK_INT >= 19) {
            a(alarmManager, j, this.a);
        } else {
            alarmManager.set(0, j, this.a);
        }
        StringBuilder stringBuilder = new StringBuilder("register timer ");
        stringBuilder.append(j);
        com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
    }

    public void a(boolean z) {
        long c = (long) g.c();
        if (z || this.c != 0) {
            Intent intent;
            if (z) {
                a();
            }
            if (!z) {
                if (this.c != 0) {
                    this.c += c;
                    if (this.c < System.currentTimeMillis()) {
                        this.c = System.currentTimeMillis() + c;
                    }
                    intent = new Intent(as.o);
                    intent.setPackage(this.b.getPackageName());
                    a(intent, this.c);
                }
            }
            this.c = System.currentTimeMillis() + (c - (SystemClock.elapsedRealtime() % c));
            intent = new Intent(as.o);
            intent.setPackage(this.b.getPackageName());
            a(intent, this.c);
        }
    }

    public boolean b() {
        return this.c != 0;
    }
}
