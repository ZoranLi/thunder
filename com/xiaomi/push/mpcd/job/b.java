package com.xiaomi.push.mpcd.job;

import android.content.Context;
import com.xiaomi.xmpush.thrift.d;

public class b extends f {
    public b(Context context, int i) {
        super(context, i);
    }

    public int a() {
        return 5;
    }

    public java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r4.d;	 Catch:{ Throwable -> 0x0040 }
        r2 = "activity";	 Catch:{ Throwable -> 0x0040 }
        r1 = r1.getSystemService(r2);	 Catch:{ Throwable -> 0x0040 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Throwable -> 0x0040 }
        r2 = 10;	 Catch:{ Throwable -> 0x0040 }
        r1 = r1.getRunningTasks(r2);	 Catch:{ Throwable -> 0x0040 }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0040 }
    L_0x0019:
        r2 = r1.hasNext();	 Catch:{ Throwable -> 0x0040 }
        if (r2 == 0) goto L_0x0040;	 Catch:{ Throwable -> 0x0040 }
    L_0x001f:
        r2 = r1.next();	 Catch:{ Throwable -> 0x0040 }
        r2 = (android.app.ActivityManager.RunningTaskInfo) r2;	 Catch:{ Throwable -> 0x0040 }
        if (r2 == 0) goto L_0x0019;	 Catch:{ Throwable -> 0x0040 }
    L_0x0027:
        r3 = r2.topActivity;	 Catch:{ Throwable -> 0x0040 }
        if (r3 == 0) goto L_0x0019;	 Catch:{ Throwable -> 0x0040 }
    L_0x002b:
        r3 = r0.length();	 Catch:{ Throwable -> 0x0040 }
        if (r3 <= 0) goto L_0x0036;	 Catch:{ Throwable -> 0x0040 }
    L_0x0031:
        r3 = ";";	 Catch:{ Throwable -> 0x0040 }
        r0.append(r3);	 Catch:{ Throwable -> 0x0040 }
    L_0x0036:
        r2 = r2.topActivity;	 Catch:{ Throwable -> 0x0040 }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x0040 }
        r0.append(r2);	 Catch:{ Throwable -> 0x0040 }
        goto L_0x0019;
    L_0x0040:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0048;
    L_0x0046:
        r0 = 0;
        return r0;
    L_0x0048:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.b.b():java.lang.String");
    }

    public d d() {
        return d.AppActiveList;
    }
}
