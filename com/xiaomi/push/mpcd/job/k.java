package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.xiaomi.xmpush.thrift.d;
import java.util.Comparator;

public class k extends f {
    private Comparator<ScanResult> a = new l(this);

    public k(Context context, int i) {
        super(context, i);
    }

    public int a() {
        return 8;
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
        r1 = r5.d;	 Catch:{ Throwable -> 0x0079 }
        r2 = "wifi";	 Catch:{ Throwable -> 0x0079 }
        r1 = r1.getSystemService(r2);	 Catch:{ Throwable -> 0x0079 }
        r1 = (android.net.wifi.WifiManager) r1;	 Catch:{ Throwable -> 0x0079 }
        r2 = r1.isWifiEnabled();	 Catch:{ Throwable -> 0x0079 }
        if (r2 == 0) goto L_0x0033;	 Catch:{ Throwable -> 0x0079 }
    L_0x0015:
        r2 = r1.getConnectionInfo();	 Catch:{ Throwable -> 0x0079 }
        if (r2 == 0) goto L_0x0033;	 Catch:{ Throwable -> 0x0079 }
    L_0x001b:
        r3 = r2.getSSID();	 Catch:{ Throwable -> 0x0079 }
        r0.append(r3);	 Catch:{ Throwable -> 0x0079 }
        r3 = ",";	 Catch:{ Throwable -> 0x0079 }
        r0.append(r3);	 Catch:{ Throwable -> 0x0079 }
        r2 = r2.getBSSID();	 Catch:{ Throwable -> 0x0079 }
        r0.append(r2);	 Catch:{ Throwable -> 0x0079 }
        r2 = "|";	 Catch:{ Throwable -> 0x0079 }
        r0.append(r2);	 Catch:{ Throwable -> 0x0079 }
    L_0x0033:
        r1 = r1.getScanResults();	 Catch:{ Throwable -> 0x0079 }
        r2 = com.xiaomi.channel.commonutils.misc.c.a(r1);	 Catch:{ Throwable -> 0x0079 }
        if (r2 != 0) goto L_0x0079;	 Catch:{ Throwable -> 0x0079 }
    L_0x003d:
        r2 = r5.a;	 Catch:{ Throwable -> 0x0079 }
        java.util.Collections.sort(r1, r2);	 Catch:{ Throwable -> 0x0079 }
        r2 = 0;	 Catch:{ Throwable -> 0x0079 }
    L_0x0043:
        r3 = 5;	 Catch:{ Throwable -> 0x0079 }
        r4 = r1.size();	 Catch:{ Throwable -> 0x0079 }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ Throwable -> 0x0079 }
        if (r2 >= r3) goto L_0x0079;	 Catch:{ Throwable -> 0x0079 }
    L_0x004e:
        r3 = r1.get(r2);	 Catch:{ Throwable -> 0x0079 }
        r3 = (android.net.wifi.ScanResult) r3;	 Catch:{ Throwable -> 0x0079 }
        if (r2 <= 0) goto L_0x005b;	 Catch:{ Throwable -> 0x0079 }
    L_0x0056:
        r4 = ";";	 Catch:{ Throwable -> 0x0079 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0079 }
    L_0x005b:
        if (r3 == 0) goto L_0x0076;	 Catch:{ Throwable -> 0x0079 }
    L_0x005d:
        r4 = r3.SSID;	 Catch:{ Throwable -> 0x0079 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0079 }
        r4 = ",";	 Catch:{ Throwable -> 0x0079 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0079 }
        r4 = r3.BSSID;	 Catch:{ Throwable -> 0x0079 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0079 }
        r4 = ",";	 Catch:{ Throwable -> 0x0079 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0079 }
        r3 = r3.level;	 Catch:{ Throwable -> 0x0079 }
        r0.append(r3);	 Catch:{ Throwable -> 0x0079 }
    L_0x0076:
        r2 = r2 + 1;
        goto L_0x0043;
    L_0x0079:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.k.b():java.lang.String");
    }

    public d d() {
        return d.WIFI;
    }
}
