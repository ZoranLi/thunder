package com.igexin.push.util;

public class l {
    public static java.lang.String a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0011 }
        r2 = 21;	 Catch:{ Throwable -> 0x0011 }
        if (r1 >= r2) goto L_0x000b;	 Catch:{ Throwable -> 0x0011 }
    L_0x0008:
        r1 = android.os.Build.CPU_ABI;	 Catch:{ Throwable -> 0x0011 }
        return r1;	 Catch:{ Throwable -> 0x0011 }
    L_0x000b:
        r1 = android.os.Build.SUPPORTED_ABIS;	 Catch:{ Throwable -> 0x0011 }
        r2 = 0;	 Catch:{ Throwable -> 0x0011 }
        r1 = r1[r2];	 Catch:{ Throwable -> 0x0011 }
        return r1;
    L_0x0011:
        r1 = r0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.l.a():java.lang.String");
    }

    public static java.lang.String a(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "phone";	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x000d }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x000d }
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x000d }
        return r1;
    L_0x000d:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.l.a(android.content.Context):java.lang.String");
    }

    public static int b(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r2.getPackageManager();	 Catch:{ Exception -> 0x0012 }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x0012 }
        r2 = r1.getPackageInfo(r2, r0);	 Catch:{ Exception -> 0x0012 }
        r2 = r2.applicationInfo;	 Catch:{ Exception -> 0x0012 }
        r2 = r2.targetSdkVersion;	 Catch:{ Exception -> 0x0012 }
        return r2;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.l.b(android.content.Context):int");
    }

    public static java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        r1 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x000f }
        r1 = r1.getContentResolver();	 Catch:{ Throwable -> 0x000f }
        r2 = "android_id";	 Catch:{ Throwable -> 0x000f }
        r1 = android.provider.Settings.Secure.getString(r1, r2);	 Catch:{ Throwable -> 0x000f }
        r0 = r1;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.l.b():java.lang.String");
    }

    public static java.lang.String c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        r1 = android.os.Looper.myLooper();	 Catch:{  }
        r2 = android.os.Looper.getMainLooper();	 Catch:{  }
        if (r1 != r2) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0055 }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0055 }
        r2 = "com.android.vending";	 Catch:{ Throwable -> 0x0055 }
        r3 = 0;	 Catch:{ Throwable -> 0x0055 }
        r1.getPackageInfo(r2, r3);	 Catch:{ Throwable -> 0x0055 }
        r1 = new android.content.Intent;	 Catch:{  }
        r2 = "com.google.android.gms.ads.identifier.service.START";	 Catch:{  }
        r1.<init>(r2);	 Catch:{  }
        r2 = "com.google.android.gms";	 Catch:{  }
        r1.setPackage(r2);	 Catch:{  }
        r2 = new com.igexin.push.util.n;	 Catch:{  }
        r3 = 0;	 Catch:{  }
        r2.<init>(r3);	 Catch:{  }
        r3 = com.igexin.push.core.g.f;	 Catch:{  }
        r4 = 1;	 Catch:{  }
        r1 = r3.bindService(r1, r2, r4);	 Catch:{  }
        if (r1 == 0) goto L_0x0055;
    L_0x0034:
        r1 = new com.igexin.push.util.o;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r3 = r2.a();	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r1 = r1.a();	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r0 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0046 }
        r0.unbindService(r2);	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        r0 = r1;
        return r0;
    L_0x0048:
        r1 = move-exception;
        r3 = com.igexin.push.core.g.f;	 Catch:{  }
        r3.unbindService(r2);	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x004f:
        r1 = com.igexin.push.core.g.f;	 Catch:{  }
        r1.unbindService(r2);	 Catch:{  }
        return r0;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.l.c():java.lang.String");
    }
}
