package com.xiaomi.channel.commonutils.misc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class h {
    private static volatile h a;
    private ScheduledThreadPoolExecutor b = new ScheduledThreadPoolExecutor(1);
    private SparseArray<ScheduledFuture> c = new SparseArray();
    private Object d = new Object();
    private SharedPreferences e;

    public static abstract class a implements Runnable {
        public abstract int a();
    }

    private h(Context context) {
        this.e = context.getSharedPreferences("mipush_extra", 0);
    }

    public static h a(Context context) {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h(context);
                }
            }
        }
        return a;
    }

    private static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder("last_job_time");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.d) {
            scheduledFuture = (ScheduledFuture) this.c.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.b.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        if (aVar != null) {
            if (a(aVar) == null) {
                String a = a(aVar.a());
                Runnable iVar = new i(this, aVar, a);
                long abs = Math.abs(System.currentTimeMillis() - this.e.getLong(a, 0)) / 1000;
                if (abs < ((long) (i - i2))) {
                    i2 = (int) (((long) i) - abs);
                }
                ScheduledFuture scheduleAtFixedRate = this.b.scheduleAtFixedRate(iVar, (long) i2, (long) i, TimeUnit.SECONDS);
                synchronized (this.d) {
                    this.c.put(aVar.a(), scheduleAtFixedRate);
                }
                return true;
            }
        }
        return false;
    }
}
