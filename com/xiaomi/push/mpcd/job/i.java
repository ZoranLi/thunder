package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.xmpush.thrift.d;

public class i extends f {
    private SharedPreferences a;

    public i(Context context, int i) {
        super(context, i);
        this.a = context.getSharedPreferences("mipush_extra", 0);
    }

    public int a() {
        return 9;
    }

    public java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = 0;
        r1 = r12.d;	 Catch:{ Throwable -> 0x0074 }
        r2 = "activity";	 Catch:{ Throwable -> 0x0074 }
        r1 = r1.getSystemService(r2);	 Catch:{ Throwable -> 0x0074 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Throwable -> 0x0074 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0074 }
        r3 = 21;	 Catch:{ Throwable -> 0x0074 }
        r4 = 0;	 Catch:{ Throwable -> 0x0074 }
        r5 = 1;	 Catch:{ Throwable -> 0x0074 }
        if (r2 >= r3) goto L_0x0024;	 Catch:{ Throwable -> 0x0074 }
    L_0x0013:
        r1 = r1.getRunningTasks(r5);	 Catch:{ Throwable -> 0x0074 }
        r1 = r1.get(r4);	 Catch:{ Throwable -> 0x0074 }
        r1 = (android.app.ActivityManager.RunningTaskInfo) r1;	 Catch:{ Throwable -> 0x0074 }
        r1 = r1.topActivity;	 Catch:{ Throwable -> 0x0074 }
        r1 = r1.getPackageName();	 Catch:{ Throwable -> 0x0074 }
        goto L_0x0075;	 Catch:{ Throwable -> 0x0074 }
    L_0x0024:
        r1 = r12.d;	 Catch:{ Throwable -> 0x0074 }
        r2 = "usagestats";	 Catch:{ Throwable -> 0x0074 }
        r1 = r1.getSystemService(r2);	 Catch:{ Throwable -> 0x0074 }
        r6 = r1;	 Catch:{ Throwable -> 0x0074 }
        r6 = (android.app.usage.UsageStatsManager) r6;	 Catch:{ Throwable -> 0x0074 }
        r1 = java.util.Calendar.getInstance();	 Catch:{ Throwable -> 0x0074 }
        r2 = -1;	 Catch:{ Throwable -> 0x0074 }
        r3 = 5;	 Catch:{ Throwable -> 0x0074 }
        r1.add(r3, r2);	 Catch:{ Throwable -> 0x0074 }
        r8 = r1.getTimeInMillis();	 Catch:{ Throwable -> 0x0074 }
        r1.add(r3, r5);	 Catch:{ Throwable -> 0x0074 }
        r10 = r1.getTimeInMillis();	 Catch:{ Throwable -> 0x0074 }
        r7 = 0;	 Catch:{ Throwable -> 0x0074 }
        r1 = r6.queryUsageStats(r7, r8, r10);	 Catch:{ Throwable -> 0x0074 }
        r2 = com.xiaomi.channel.commonutils.misc.c.a(r1);	 Catch:{ Throwable -> 0x0074 }
        if (r2 == 0) goto L_0x004f;	 Catch:{ Throwable -> 0x0074 }
    L_0x004e:
        return r0;	 Catch:{ Throwable -> 0x0074 }
    L_0x004f:
        r2 = 0;	 Catch:{ Throwable -> 0x0074 }
        r5 = "";	 Catch:{ Throwable -> 0x0074 }
    L_0x0053:
        r6 = r1.size();	 Catch:{ Throwable -> 0x0074 }
        if (r4 >= r6) goto L_0x0072;	 Catch:{ Throwable -> 0x0074 }
    L_0x0059:
        r6 = r1.get(r4);	 Catch:{ Throwable -> 0x0074 }
        r6 = (android.app.usage.UsageStats) r6;	 Catch:{ Throwable -> 0x0074 }
        r7 = r6.getLastTimeStamp();	 Catch:{ Throwable -> 0x0074 }
        r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x0074 }
        if (r9 <= 0) goto L_0x006f;	 Catch:{ Throwable -> 0x0074 }
    L_0x0067:
        r2 = r6.getLastTimeStamp();	 Catch:{ Throwable -> 0x0074 }
        r5 = r6.getPackageName();	 Catch:{ Throwable -> 0x0074 }
    L_0x006f:
        r4 = r4 + 1;
        goto L_0x0053;
    L_0x0072:
        r1 = r5;
        goto L_0x0075;
    L_0x0074:
        r1 = r0;
    L_0x0075:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x007c;
    L_0x007b:
        return r0;
    L_0x007c:
        r2 = r12.a;
        r3 = "ltapn";
        r0 = r2.getString(r3, r0);
        r0 = android.text.TextUtils.equals(r1, r0);
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r0 = "^";
        return r0;
    L_0x008d:
        r0 = r12.a;
        r0 = r0.edit();
        r2 = "ltapn";
        r0 = r0.putString(r2, r1);
        r0.commit();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.i.b():java.lang.String");
    }

    public d d() {
        return d.TopApp;
    }
}
