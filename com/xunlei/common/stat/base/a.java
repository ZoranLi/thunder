package com.xunlei.common.stat.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import com.xunlei.common.base.XLAlarmBaseTimer;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* compiled from: XLAlarmTimer */
public final class a {
    private static String b = "com.xunlei.xlkdemo.timer.CATEGORY";
    private static String c = "com.xunlei.xlkdemo.timer.action_";
    private static String d = "alarm_timer_id";
    private static a e;
    private Map<String, a> a = new HashMap();
    private Context f = null;
    private BroadcastReceiver g = new BroadcastReceiver(this) {
        private /* synthetic */ a a;

        {
            this.a = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            context = new StringBuilder();
            context.append(intent.getAction());
            context.append(intent.getIntExtra(XLAlarmBaseTimer.MY_ALARM_TIMER_ID, 0));
            a aVar = (a) this.a.a.get(context.toString());
            if (aVar != null) {
                aVar.d();
                if (aVar.e() == null) {
                    a.e.a(aVar.a());
                    return;
                }
                if (VERSION.SDK_INT >= 19) {
                    aVar.b();
                }
            }
        }
    };

    /* compiled from: XLAlarmTimer */
    public static class a {
        private int a;
        private boolean b;
        private b c;
        private int d;
        private PendingIntent e;

        public a(int i, int i2, boolean z, b bVar) {
            this.a = 0;
            this.b = false;
            this.c = null;
            this.d = 0;
            this.e = null;
            this.a = i;
            this.d = i2;
            this.b = z;
            this.c = bVar;
        }

        public static String a(int i) {
            StringBuilder stringBuilder = new StringBuilder(XLAlarmBaseTimer.MY_ALARM_TIMER_ACTION_BASE);
            stringBuilder.append(String.valueOf(i));
            return stringBuilder.toString();
        }

        public final int a() {
            return this.a;
        }

        public final void b() {
            Intent intent = new Intent(XLAlarmBaseTimer.MY_ALARM_TIMER_ACTION_BASE);
            intent.addCategory(XLAlarmBaseTimer.MY_ALARM_TIMER_INTENT_CATEGORY);
            intent.putExtra(XLAlarmBaseTimer.MY_ALARM_TIMER_ID, this.a);
            this.e = PendingIntent.getBroadcast(a.e.f, this.a, intent, 134217728);
            AlarmManager alarmManager = (AlarmManager) a.e.f.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (VERSION.SDK_INT < 19) {
                alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) this.d), (long) this.d, this.e);
                return;
            }
            alarmManager.setExact(0, System.currentTimeMillis() + ((long) this.d), this.e);
        }

        public final void c() {
            ((AlarmManager) a.e.f.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.e);
        }

        public final void d() {
            if (this.c != null) {
                this.c.onTimerTick(this.a);
            }
        }

        public final boolean e() {
            return this.b;
        }

        private int f() {
            return this.d;
        }

        public static String a(String str) {
            str = a(str.getBytes());
            char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            if (str == null) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder(32);
            for (byte b : str) {
                stringBuilder.append(cArr[(b >> 4) & 15]);
                stringBuilder.append(cArr[b & 15]);
            }
            return stringBuilder.toString();
        }

        public static byte[] a(byte[] bArr) {
            try {
                return MessageDigest.getInstance("SHA-1").digest(bArr);
            } catch (byte[] bArr2) {
                bArr2.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: XLAlarmTimer */
    public interface b {
        void onTimerTick(int i);
    }

    private a() {
    }

    public static void a(Context context) {
        a aVar = new a();
        e = aVar;
        aVar.f = context;
        context = new IntentFilter();
        context.addCategory(XLAlarmBaseTimer.MY_ALARM_TIMER_INTENT_CATEGORY);
        context.addAction(XLAlarmBaseTimer.MY_ALARM_TIMER_ACTION_BASE);
        context.setPriority(Integer.MAX_VALUE);
        e.f.registerReceiver(e.g, context);
    }

    public static void a() {
        e.f.unregisterReceiver(e.g);
    }

    public static a b() {
        return e;
    }

    public final void a(int i, int i2, boolean z, b bVar) {
        i2 = new a(i, true, true, bVar);
        this.a.put(a.a(i), i2);
        i2.b();
    }

    public final void a(int i) {
        a aVar = (a) this.a.get(a.a(i));
        if (aVar != null) {
            aVar.c();
            this.a.remove(a.a(i));
        }
    }

    private void d() {
        for (String str : this.a.keySet()) {
            ((a) this.a.get(str)).c();
        }
        this.a.clear();
    }
}
