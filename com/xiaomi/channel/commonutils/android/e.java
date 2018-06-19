package com.xiaomi.channel.commonutils.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;

public class e {
    public static Account a(Context context) {
        try {
            if (!b(context)) {
                return null;
            }
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.xiaomi");
            return (accountsByType == null || accountsByType.length <= 0) ? null : accountsByType[0];
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
    }

    public static boolean b(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r3.getPackageManager();	 Catch:{ Throwable -> 0x001d }
        r3 = r3.getPackageName();	 Catch:{ Throwable -> 0x001d }
        r2 = "android.permission.GET_ACCOUNTS";	 Catch:{ Throwable -> 0x001d }
        r2 = r1.checkPermission(r2, r3);	 Catch:{ Throwable -> 0x001d }
        if (r2 == 0) goto L_0x001b;	 Catch:{ Throwable -> 0x001d }
    L_0x0011:
        r2 = "android.permission.GET_ACCOUNTS_PRIVILEGED";	 Catch:{ Throwable -> 0x001d }
        r3 = r1.checkPermission(r2, r3);	 Catch:{ Throwable -> 0x001d }
        if (r3 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        return r0;
    L_0x001b:
        r3 = 1;
        return r3;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.e.b(android.content.Context):boolean");
    }
}
