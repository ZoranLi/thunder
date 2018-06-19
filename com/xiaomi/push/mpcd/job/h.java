package com.xiaomi.push.mpcd.job;

import android.content.Context;
import com.xiaomi.xmpush.thrift.d;

public class h extends f {
    private boolean a;
    private boolean b;
    private boolean e;
    private boolean f;
    private boolean g;

    public h(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context, i);
        this.a = z;
        this.b = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
    }

    private java.lang.String f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "off";
        return r0;
    L_0x0007:
        r0 = new android.util.DisplayMetrics;	 Catch:{ Throwable -> 0x0036 }
        r0.<init>();	 Catch:{ Throwable -> 0x0036 }
        r1 = r3.d;	 Catch:{ Throwable -> 0x0036 }
        r2 = "window";	 Catch:{ Throwable -> 0x0036 }
        r1 = r1.getSystemService(r2);	 Catch:{ Throwable -> 0x0036 }
        r1 = (android.view.WindowManager) r1;	 Catch:{ Throwable -> 0x0036 }
        r1 = r1.getDefaultDisplay();	 Catch:{ Throwable -> 0x0036 }
        r1.getMetrics(r0);	 Catch:{ Throwable -> 0x0036 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0036 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036 }
        r2 = r0.heightPixels;	 Catch:{ Throwable -> 0x0036 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0036 }
        r2 = ",";	 Catch:{ Throwable -> 0x0036 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0036 }
        r0 = r0.widthPixels;	 Catch:{ Throwable -> 0x0036 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0036 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x0036 }
        return r0;
    L_0x0036:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.h.f():java.lang.String");
    }

    private java.lang.String g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.b;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "off";
        return r0;
    L_0x0007:
        r0 = android.os.Build.VERSION.RELEASE;	 Catch:{ Throwable -> 0x000a }
        return r0;
    L_0x000a:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.h.g():java.lang.String");
    }

    private java.lang.String h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.e;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "off";
        return r0;
    L_0x0007:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x000e }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x000e }
        return r0;
    L_0x000e:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.h.h():java.lang.String");
    }

    private java.lang.String i() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "off";
        return r0;
    L_0x0007:
        r0 = r2.d;	 Catch:{ Throwable -> 0x0014 }
        r0 = r0.getContentResolver();	 Catch:{ Throwable -> 0x0014 }
        r1 = "android_id";	 Catch:{ Throwable -> 0x0014 }
        r0 = android.provider.Settings.Secure.getString(r0, r1);	 Catch:{ Throwable -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.h.i():java.lang.String");
    }

    private java.lang.String j() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.g;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "off";
        return r0;
    L_0x0007:
        r0 = r2.d;	 Catch:{ Throwable -> 0x0016 }
        r1 = "phone";	 Catch:{ Throwable -> 0x0016 }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x0016 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Throwable -> 0x0016 }
        r0 = r0.getSimOperator();	 Catch:{ Throwable -> 0x0016 }
        return r0;
    L_0x0016:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.h.j():java.lang.String");
    }

    public int a() {
        return 3;
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f());
        stringBuilder.append("|");
        stringBuilder.append(g());
        stringBuilder.append("|");
        stringBuilder.append(h());
        stringBuilder.append("|");
        stringBuilder.append(i());
        stringBuilder.append("|");
        stringBuilder.append(j());
        return stringBuilder.toString();
    }

    public d d() {
        return d.DeviceInfoV2;
    }
}
