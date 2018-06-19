package com.xiaomi.push.mpcd.job;

import android.content.Context;
import com.xiaomi.xmpush.thrift.d;

public class a extends f {
    public a(Context context, int i) {
        super(context, i);
    }

    public int a() {
        return 7;
    }

    public java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r5.d;	 Catch:{ Throwable -> 0x0034 }
        r1 = android.accounts.AccountManager.get(r1);	 Catch:{ Throwable -> 0x0034 }
        r1 = r1.getAccounts();	 Catch:{ Throwable -> 0x0034 }
        r2 = 0;	 Catch:{ Throwable -> 0x0034 }
    L_0x0010:
        r3 = r1.length;	 Catch:{ Throwable -> 0x0034 }
        r4 = 10;	 Catch:{ Throwable -> 0x0034 }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ Throwable -> 0x0034 }
        if (r2 >= r3) goto L_0x0034;	 Catch:{ Throwable -> 0x0034 }
    L_0x0019:
        r3 = r1[r2];	 Catch:{ Throwable -> 0x0034 }
        if (r2 <= 0) goto L_0x0022;	 Catch:{ Throwable -> 0x0034 }
    L_0x001d:
        r4 = ";";	 Catch:{ Throwable -> 0x0034 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0034 }
    L_0x0022:
        r4 = r3.name;	 Catch:{ Throwable -> 0x0034 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0034 }
        r4 = ",";	 Catch:{ Throwable -> 0x0034 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0034 }
        r3 = r3.type;	 Catch:{ Throwable -> 0x0034 }
        r0.append(r3);	 Catch:{ Throwable -> 0x0034 }
        r2 = r2 + 1;
        goto L_0x0010;
    L_0x0034:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.a.b():java.lang.String");
    }

    protected boolean c() {
        return this.d.getPackageManager().checkPermission("android.permission.GET_ACCOUNTS", this.d.getPackageName()) == 0;
    }

    public d d() {
        return d.Account;
    }
}
