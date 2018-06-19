package com.xiaomi.push.mpcd.job;

import android.content.Context;
import com.xiaomi.xmpush.thrift.d;

public class c extends f {
    public c(Context context, int i) {
        super(context, i);
    }

    public int a() {
        return 4;
    }

    public java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r8.d;	 Catch:{ Throwable -> 0x0076 }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0076 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Throwable -> 0x0076 }
        r2 = r1.getInstalledPackages(r2);	 Catch:{ Throwable -> 0x0076 }
        r3 = 0;	 Catch:{ Throwable -> 0x0076 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x0076 }
    L_0x0016:
        r4 = r2.hasNext();	 Catch:{ Throwable -> 0x0076 }
        if (r4 == 0) goto L_0x0076;	 Catch:{ Throwable -> 0x0076 }
    L_0x001c:
        r4 = r2.next();	 Catch:{ Throwable -> 0x0076 }
        r4 = (android.content.pm.PackageInfo) r4;	 Catch:{ Throwable -> 0x0076 }
        r5 = r4.applicationInfo;	 Catch:{ Throwable -> 0x0076 }
        r5 = r5.flags;	 Catch:{ Throwable -> 0x0076 }
        r5 = r5 & 1;	 Catch:{ Throwable -> 0x0076 }
        if (r5 != 0) goto L_0x0016;	 Catch:{ Throwable -> 0x0076 }
    L_0x002a:
        r5 = r0.length();	 Catch:{ Throwable -> 0x0076 }
        if (r5 <= 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0076 }
    L_0x0030:
        r5 = ";";	 Catch:{ Throwable -> 0x0076 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0076 }
    L_0x0035:
        r5 = r4.applicationInfo;	 Catch:{ Throwable -> 0x0076 }
        r5 = r5.loadLabel(r1);	 Catch:{ Throwable -> 0x0076 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0076 }
        r6 = r8.d;	 Catch:{ Throwable -> 0x0076 }
        r7 = r4.packageName;	 Catch:{ Throwable -> 0x0076 }
        r6 = com.xiaomi.channel.commonutils.android.a.f(r6, r7);	 Catch:{ Throwable -> 0x0076 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0076 }
        r5 = ",";	 Catch:{ Throwable -> 0x0076 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0076 }
        r5 = r4.packageName;	 Catch:{ Throwable -> 0x0076 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0076 }
        r5 = ",";	 Catch:{ Throwable -> 0x0076 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0076 }
        r5 = r4.versionName;	 Catch:{ Throwable -> 0x0076 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0076 }
        r5 = ",";	 Catch:{ Throwable -> 0x0076 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0076 }
        r4 = r4.versionCode;	 Catch:{ Throwable -> 0x0076 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0076 }
        r4 = ",";	 Catch:{ Throwable -> 0x0076 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0076 }
        r0.append(r6);	 Catch:{ Throwable -> 0x0076 }
        r3 = r3 + 1;
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 < r4) goto L_0x0016;
    L_0x0076:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.c.b():java.lang.String");
    }

    public d d() {
        return d.AppInstallList;
    }
}
