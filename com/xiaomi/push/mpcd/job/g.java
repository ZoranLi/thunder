package com.xiaomi.push.mpcd.job;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.d;
import java.net.NetworkInterface;
import java.util.Collections;

public class g extends f {
    private boolean a;
    private boolean b;
    private boolean e;
    private boolean f;

    public g(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, i);
        this.a = z;
        this.b = z2;
        this.e = z3;
        this.f = z4;
    }

    private java.lang.String a(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r4 = "off";
        return r4;
    L_0x0007:
        r0 = "";
        r4 = com.xiaomi.channel.commonutils.android.d.h(r4);	 Catch:{ Throwable -> 0x0055 }
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x0055 }
    L_0x0011:
        r1 = r4.hasNext();	 Catch:{ Throwable -> 0x0055 }
        if (r1 == 0) goto L_0x0054;	 Catch:{ Throwable -> 0x0055 }
    L_0x0017:
        r1 = r4.next();	 Catch:{ Throwable -> 0x0055 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0055 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0055 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ Throwable -> 0x0055 }
    L_0x0023:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0055 }
        r2.<init>();	 Catch:{ Throwable -> 0x0055 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0055 }
        r0 = ";";	 Catch:{ Throwable -> 0x0055 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0055 }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x0055 }
    L_0x0034:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0055 }
        r2.<init>();	 Catch:{ Throwable -> 0x0055 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0055 }
        r0 = com.xiaomi.channel.commonutils.string.d.a(r1);	 Catch:{ Throwable -> 0x0055 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0055 }
        r0 = ",";	 Catch:{ Throwable -> 0x0055 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0055 }
        r0 = com.xiaomi.channel.commonutils.string.d.b(r1);	 Catch:{ Throwable -> 0x0055 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0055 }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x0055 }
        goto L_0x0011;
    L_0x0054:
        return r0;
    L_0x0055:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.g.a(android.content.Context):java.lang.String");
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
        r0 = r3.g();	 Catch:{ Throwable -> 0x0031 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0031 }
        if (r1 == 0) goto L_0x0014;	 Catch:{ Throwable -> 0x0031 }
    L_0x0011:
        r0 = "";	 Catch:{ Throwable -> 0x0031 }
        return r0;	 Catch:{ Throwable -> 0x0031 }
    L_0x0014:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0031 }
        r1.<init>();	 Catch:{ Throwable -> 0x0031 }
        r2 = com.xiaomi.channel.commonutils.string.d.a(r0);	 Catch:{ Throwable -> 0x0031 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0031 }
        r2 = ",";	 Catch:{ Throwable -> 0x0031 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0031 }
        r0 = com.xiaomi.channel.commonutils.string.d.b(r0);	 Catch:{ Throwable -> 0x0031 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0031 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x0031 }
        return r0;
    L_0x0031:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.g.f():java.lang.String");
    }

    @TargetApi(9)
    private String g() {
        Object obj = "";
        if (VERSION.SDK_INT < 23) {
            obj = ((WifiManager) this.d.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        if (VERSION.SDK_INT < 9) {
            return "";
        }
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if ("wlan0".equalsIgnoreCase(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    return stringBuilder.toString().toLowerCase();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private java.lang.String h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.b;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "off";
        return r0;
    L_0x0007:
        r0 = r3.d;	 Catch:{ Throwable -> 0x003b }
        r1 = "phone";	 Catch:{ Throwable -> 0x003b }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x003b }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Throwable -> 0x003b }
        r0 = r0.getSubscriberId();	 Catch:{ Throwable -> 0x003b }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x003b }
        if (r1 == 0) goto L_0x001e;	 Catch:{ Throwable -> 0x003b }
    L_0x001b:
        r0 = "";	 Catch:{ Throwable -> 0x003b }
        return r0;	 Catch:{ Throwable -> 0x003b }
    L_0x001e:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003b }
        r1.<init>();	 Catch:{ Throwable -> 0x003b }
        r2 = com.xiaomi.channel.commonutils.string.d.a(r0);	 Catch:{ Throwable -> 0x003b }
        r1.append(r2);	 Catch:{ Throwable -> 0x003b }
        r2 = ",";	 Catch:{ Throwable -> 0x003b }
        r1.append(r2);	 Catch:{ Throwable -> 0x003b }
        r0 = com.xiaomi.channel.commonutils.string.d.b(r0);	 Catch:{ Throwable -> 0x003b }
        r1.append(r0);	 Catch:{ Throwable -> 0x003b }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x003b }
        return r0;
    L_0x003b:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.g.h():java.lang.String");
    }

    private java.lang.String i() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.e;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "off";
        return r0;
    L_0x0007:
        r0 = r3.d;	 Catch:{ Throwable -> 0x003b }
        r1 = "phone";	 Catch:{ Throwable -> 0x003b }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x003b }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Throwable -> 0x003b }
        r0 = r0.getSimSerialNumber();	 Catch:{ Throwable -> 0x003b }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x003b }
        if (r1 == 0) goto L_0x001e;	 Catch:{ Throwable -> 0x003b }
    L_0x001b:
        r0 = "";	 Catch:{ Throwable -> 0x003b }
        return r0;	 Catch:{ Throwable -> 0x003b }
    L_0x001e:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003b }
        r1.<init>();	 Catch:{ Throwable -> 0x003b }
        r2 = com.xiaomi.channel.commonutils.string.d.a(r0);	 Catch:{ Throwable -> 0x003b }
        r1.append(r2);	 Catch:{ Throwable -> 0x003b }
        r2 = ",";	 Catch:{ Throwable -> 0x003b }
        r1.append(r2);	 Catch:{ Throwable -> 0x003b }
        r0 = com.xiaomi.channel.commonutils.string.d.b(r0);	 Catch:{ Throwable -> 0x003b }
        r1.append(r0);	 Catch:{ Throwable -> 0x003b }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x003b }
        return r0;
    L_0x003b:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.g.i():java.lang.String");
    }

    public int a() {
        return 13;
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f());
        stringBuilder.append("|");
        stringBuilder.append(h());
        stringBuilder.append("|");
        stringBuilder.append(i());
        stringBuilder.append("|");
        stringBuilder.append(a(this.d));
        return stringBuilder.toString();
    }

    public d d() {
        return d.DeviceBaseInfo;
    }
}
