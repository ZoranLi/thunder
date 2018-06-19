package com.xiaomi.channel.commonutils.file;

import android.os.Environment;
import com.xiaomi.channel.commonutils.logger.b;

public class c {
    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Throwable e) {
            b.a(e);
            return true;
        }
    }

    public static boolean b() {
        try {
            return !Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable e) {
            b.a(e);
            return true;
        }
    }

    public static boolean c() {
        return e() <= 102400;
    }

    public static boolean d() {
        return (b() || c() || a()) ? false : true;
    }

    public static long e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b();
        r1 = 0;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = android.os.Environment.getExternalStorageDirectory();
        if (r0 == 0) goto L_0x0033;
    L_0x000f:
        r3 = r0.getPath();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x001a;
    L_0x0019:
        return r1;
    L_0x001a:
        r3 = new android.os.StatFs;	 Catch:{ Throwable -> 0x0033 }
        r0 = r0.getPath();	 Catch:{ Throwable -> 0x0033 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x0033 }
        r0 = r3.getBlockSize();	 Catch:{ Throwable -> 0x0033 }
        r4 = (long) r0;	 Catch:{ Throwable -> 0x0033 }
        r0 = r3.getAvailableBlocks();	 Catch:{ Throwable -> 0x0033 }
        r0 = (long) r0;
        r2 = 4;
        r6 = r0 - r2;
        r4 = r4 * r6;
        return r4;
    L_0x0033:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.c.e():long");
    }
}
