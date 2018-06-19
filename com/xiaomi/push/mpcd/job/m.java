package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.metoknlp.devicediscover.a;
import com.xiaomi.push.service.am;
import com.xiaomi.xmpush.thrift.g;
import com.xunlei.common.androidutil.DateTimeUtil;

public class m extends f {
    private final Object a = new Object();
    private String b;
    private SharedPreferences e;
    private a f = new n(this);

    public m(Context context, int i) {
        super(context, i);
        a(context);
        this.e = context.getSharedPreferences("mipush_extra", 0);
    }

    private void a(Context context) {
        com.xiaomi.metoknlp.a.a(context).f();
        com.xiaomi.metoknlp.a.a().a(this.f, 1);
    }

    private static java.lang.String b(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x001a }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x001a }
        r2 = "devices";	 Catch:{ Throwable -> 0x001a }
        r2 = r0.getJSONArray(r2);	 Catch:{ Throwable -> 0x001a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x001a }
        r0 = r2.length();	 Catch:{ Throwable -> 0x001a }
        r1 = 1;	 Catch:{ Throwable -> 0x001a }
        r0 = r0 - r1;	 Catch:{ Throwable -> 0x001a }
        r2 = r2.substring(r1, r0);	 Catch:{ Throwable -> 0x001a }
        return r2;
    L_0x001a:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.m.b(java.lang.String):java.lang.String");
    }

    public int a() {
        return 14;
    }

    public String b() {
        if (d.e(this.d)) {
            com.xiaomi.metoknlp.a.a().c();
            synchronized (this.a) {
                try {
                    this.a.wait(10000);
                } catch (Throwable e) {
                    b.a(e);
                }
            }
            Editor edit = this.e.edit();
            edit.putLong("last_mac_upload_timestamp", System.currentTimeMillis());
            edit.commit();
        }
        String str = this.b;
        this.b = "";
        return str;
    }

    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.WifiDevicesMac;
    }

    protected boolean e() {
        if (f()) {
            return f.a(this.d, String.valueOf(a()), (long) this.c);
        }
        int max = Math.max(DateTimeUtil.HOUR_SECOND, am.a(this.d).a(g.Y.a(), 7200));
        return ((((float) Math.abs(System.currentTimeMillis() - this.e.getLong("last_mac_upload_timestamp", 0))) > (((float) (max * 1000)) * 0.9f) ? 1 : (((float) Math.abs(System.currentTimeMillis() - this.e.getLong("last_mac_upload_timestamp", 0))) == (((float) (max * 1000)) * 0.9f) ? 0 : -1)) >= 0) && f.a(this.d, String.valueOf(a()), (long) max);
    }

    public boolean f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 1;
        r1 = r6.e;	 Catch:{ Throwable -> 0x0047 }
        r2 = "last_wifi_ssid";	 Catch:{ Throwable -> 0x0047 }
        r3 = "";	 Catch:{ Throwable -> 0x0047 }
        r1 = r1.getString(r2, r3);	 Catch:{ Throwable -> 0x0047 }
        r2 = r6.d;	 Catch:{ Throwable -> 0x0047 }
        r3 = "wifi";	 Catch:{ Throwable -> 0x0047 }
        r2 = r2.getSystemService(r3);	 Catch:{ Throwable -> 0x0047 }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ Throwable -> 0x0047 }
        r3 = r2.isWifiEnabled();	 Catch:{ Throwable -> 0x0047 }
        if (r3 == 0) goto L_0x0047;	 Catch:{ Throwable -> 0x0047 }
    L_0x001b:
        r2 = r2.getConnectionInfo();	 Catch:{ Throwable -> 0x0047 }
        if (r2 == 0) goto L_0x0047;	 Catch:{ Throwable -> 0x0047 }
    L_0x0021:
        r3 = r6.e;	 Catch:{ Throwable -> 0x0047 }
        r3 = r3.edit();	 Catch:{ Throwable -> 0x0047 }
        r4 = "last_wifi_ssid";	 Catch:{ Throwable -> 0x0047 }
        r5 = r2.getSSID();	 Catch:{ Throwable -> 0x0047 }
        r3.putString(r4, r5);	 Catch:{ Throwable -> 0x0047 }
        r3.commit();	 Catch:{ Throwable -> 0x0047 }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0047 }
        r4 = 0;	 Catch:{ Throwable -> 0x0047 }
        if (r3 == 0) goto L_0x003b;	 Catch:{ Throwable -> 0x0047 }
    L_0x003a:
        return r4;	 Catch:{ Throwable -> 0x0047 }
    L_0x003b:
        r2 = r2.getSSID();	 Catch:{ Throwable -> 0x0047 }
        r1 = android.text.TextUtils.equals(r2, r1);	 Catch:{ Throwable -> 0x0047 }
        if (r1 != 0) goto L_0x0046;
    L_0x0045:
        return r0;
    L_0x0046:
        return r4;
    L_0x0047:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.m.f():boolean");
    }
}
