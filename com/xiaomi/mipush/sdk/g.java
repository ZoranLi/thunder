package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.Location;
import com.qihoo360.replugin.RePlugin;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.channel.commonutils.misc.h.a;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.k;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.o;
import com.xiaomi.xmpush.thrift.p;
import com.xiaomi.xmpush.thrift.r;
import com.xunlei.common.androidutil.DateTimeUtil;
import java.util.Date;
import java.util.HashMap;

public class g extends a {
    private final int a = -1;
    private final int b = DateTimeUtil.HOUR_SECOND;
    private Context c;
    private int d;

    public g(Context context, int i) {
        this.c = context;
        this.d = i;
    }

    private static Location a(Location location, Location location2) {
        return location == null ? location2 : (location2 != null && location.getTime() <= location2.getTime()) ? location2 : location;
    }

    public static void a(Context context, boolean z) {
        p b = b(context);
        byte[] a = au.a(b);
        org.apache.thrift.a aiVar = new ai(RePlugin.PROCESS_UI, false);
        aiVar.c(r.GeoUpdateLoc.W);
        aiVar.a(a);
        aiVar.a(new HashMap());
        aiVar.i().put(Constants.EXTRA_KEY_INITIAL_WIFI_UPLOAD, String.valueOf(z));
        z = k.b(context);
        if (z) {
            aiVar.i().put(Constants.EXTRA_KEY_XMSF_GEO_IS_WORK, String.valueOf(z));
        }
        StringBuilder stringBuilder = new StringBuilder("reportLocInfo locInfo timestamp:");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(String.valueOf(b.c() != null ? b.c() : "null"));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(String.valueOf(b.b != null ? b.b.toString() : null));
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(String.valueOf(b.a != null ? b.a.toString() : null));
        b.c(stringBuilder.toString());
        ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
        g(context);
    }

    private boolean a(long j) {
        return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.c.getSharedPreferences("mipush_extra", 0).getLong("last_upload_lbs_data_timestamp", -1))) > ((float) j) * 0.9f;
    }

    protected static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        return (packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageName) == 0) || (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName) == 0);
    }

    private static p b(Context context) {
        p pVar = new p();
        pVar.a(c(context));
        pVar.b(d(context));
        pVar.a(e(context));
        return pVar;
    }

    private boolean b() {
        if (d.e(this.c)) {
            return true;
        }
        return d.f(this.c) && a((long) Math.max(60, am.a(this.c).a(com.xiaomi.xmpush.thrift.g.UploadNOWIFIGeoLocFrequency.a(), (int) DateTimeUtil.HOUR_SECOND)));
    }

    private static java.util.List<com.xiaomi.xmpush.thrift.y> c(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new com.xiaomi.mipush.sdk.h;
        r0.<init>();
        r1 = 0;
        r2 = "wifi";	 Catch:{ Throwable -> 0x005c }
        r6 = r6.getSystemService(r2);	 Catch:{ Throwable -> 0x005c }
        r6 = (android.net.wifi.WifiManager) r6;	 Catch:{ Throwable -> 0x005c }
        r6 = r6.getScanResults();	 Catch:{ Throwable -> 0x005c }
        r2 = com.xiaomi.channel.commonutils.misc.c.a(r6);	 Catch:{ Throwable -> 0x005c }
        if (r2 != 0) goto L_0x005a;	 Catch:{ Throwable -> 0x005c }
    L_0x0018:
        java.util.Collections.sort(r6, r0);	 Catch:{ Throwable -> 0x005c }
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x005c }
        r0.<init>();	 Catch:{ Throwable -> 0x005c }
        r2 = 0;	 Catch:{ Throwable -> 0x005c }
    L_0x0021:
        r3 = 30;	 Catch:{ Throwable -> 0x005c }
        r4 = r6.size();	 Catch:{ Throwable -> 0x005c }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ Throwable -> 0x005c }
        if (r2 >= r3) goto L_0x005b;	 Catch:{ Throwable -> 0x005c }
    L_0x002d:
        r3 = r6.get(r2);	 Catch:{ Throwable -> 0x005c }
        r3 = (android.net.wifi.ScanResult) r3;	 Catch:{ Throwable -> 0x005c }
        if (r3 == 0) goto L_0x0057;	 Catch:{ Throwable -> 0x005c }
    L_0x0035:
        r4 = new com.xiaomi.xmpush.thrift.y;	 Catch:{ Throwable -> 0x005c }
        r4.<init>();	 Catch:{ Throwable -> 0x005c }
        r5 = r3.BSSID;	 Catch:{ Throwable -> 0x005c }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x005c }
        if (r5 == 0) goto L_0x0045;	 Catch:{ Throwable -> 0x005c }
    L_0x0042:
        r5 = "";	 Catch:{ Throwable -> 0x005c }
        goto L_0x0047;	 Catch:{ Throwable -> 0x005c }
    L_0x0045:
        r5 = r3.BSSID;	 Catch:{ Throwable -> 0x005c }
    L_0x0047:
        r4.a(r5);	 Catch:{ Throwable -> 0x005c }
        r5 = r3.level;	 Catch:{ Throwable -> 0x005c }
        r4.a(r5);	 Catch:{ Throwable -> 0x005c }
        r3 = r3.SSID;	 Catch:{ Throwable -> 0x005c }
        r4.b(r3);	 Catch:{ Throwable -> 0x005c }
        r0.add(r4);	 Catch:{ Throwable -> 0x005c }
    L_0x0057:
        r2 = r2 + 1;
        goto L_0x0021;
    L_0x005a:
        r0 = r1;
    L_0x005b:
        return r0;
    L_0x005c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.c(android.content.Context):java.util.List<com.xiaomi.xmpush.thrift.y>");
    }

    private static java.util.List<com.xiaomi.xmpush.thrift.c> d(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "phone";	 Catch:{ Throwable -> 0x004c }
        r7 = r7.getSystemService(r1);	 Catch:{ Throwable -> 0x004c }
        r7 = (android.telephony.TelephonyManager) r7;	 Catch:{ Throwable -> 0x004c }
        r7 = r7.getNeighboringCellInfo();	 Catch:{ Throwable -> 0x004c }
        r1 = 0;	 Catch:{ Throwable -> 0x004c }
        r2 = r0;	 Catch:{ Throwable -> 0x004c }
    L_0x000f:
        r3 = r7.size();	 Catch:{ Throwable -> 0x004c }
        if (r1 >= r3) goto L_0x004b;	 Catch:{ Throwable -> 0x004c }
    L_0x0015:
        r2 = r7.get(r1);	 Catch:{ Throwable -> 0x004c }
        r2 = (android.telephony.NeighboringCellInfo) r2;	 Catch:{ Throwable -> 0x004c }
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x004c }
        r3.<init>();	 Catch:{ Throwable -> 0x004c }
        r4 = r2.getLac();	 Catch:{ Throwable -> 0x004c }
        if (r4 > 0) goto L_0x002c;	 Catch:{ Throwable -> 0x004c }
    L_0x0026:
        r4 = r2.getCid();	 Catch:{ Throwable -> 0x004c }
        if (r4 <= 0) goto L_0x0047;	 Catch:{ Throwable -> 0x004c }
    L_0x002c:
        r4 = new com.xiaomi.xmpush.thrift.c;	 Catch:{ Throwable -> 0x004c }
        r4.<init>();	 Catch:{ Throwable -> 0x004c }
        r5 = r2.getCid();	 Catch:{ Throwable -> 0x004c }
        r4.a(r5);	 Catch:{ Throwable -> 0x004c }
        r5 = -113; // 0xffffffffffffff8f float:NaN double:NaN;	 Catch:{ Throwable -> 0x004c }
        r6 = 2;	 Catch:{ Throwable -> 0x004c }
        r2 = r2.getRssi();	 Catch:{ Throwable -> 0x004c }
        r6 = r6 * r2;	 Catch:{ Throwable -> 0x004c }
        r5 = r5 + r6;	 Catch:{ Throwable -> 0x004c }
        r4.b(r5);	 Catch:{ Throwable -> 0x004c }
        r3.add(r4);	 Catch:{ Throwable -> 0x004c }
    L_0x0047:
        r1 = r1 + 1;
        r2 = r3;
        goto L_0x000f;
    L_0x004b:
        return r2;
    L_0x004c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.d(android.content.Context):java.util.List<com.xiaomi.xmpush.thrift.c>");
    }

    private static l e(Context context) {
        l lVar = null;
        if (!a(context)) {
            return null;
        }
        Location f = f(context);
        if (f != null) {
            o oVar = new o();
            oVar.b(f.getLatitude());
            oVar.a(f.getLongitude());
            lVar = new l();
            lVar.a((double) f.getAccuracy());
            lVar.a(oVar);
            lVar.a(f.getProvider());
            lVar.a(new Date().getTime() - f.getTime());
        }
        return lVar;
    }

    private static android.location.Location f(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "location";
        r4 = r4.getSystemService(r0);
        r4 = (android.location.LocationManager) r4;
        r0 = 0;
        r1 = "network";	 Catch:{ Exception -> 0x0010 }
        r1 = r4.getLastKnownLocation(r1);	 Catch:{ Exception -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r1 = r0;
    L_0x0011:
        r2 = "gps";	 Catch:{ Exception -> 0x0018 }
        r2 = r4.getLastKnownLocation(r2);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0019;
    L_0x0018:
        r2 = r0;
    L_0x0019:
        r3 = "passive";	 Catch:{ Exception -> 0x0020 }
        r4 = r4.getLastKnownLocation(r3);	 Catch:{ Exception -> 0x0020 }
        goto L_0x0021;
    L_0x0020:
        r4 = r0;
    L_0x0021:
        r0 = a(r1, r2);
        r4 = a(r4, r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.f(android.content.Context):android.location.Location");
    }

    private static void g(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_upload_lbs_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    public int a() {
        return 11;
    }

    public void run() {
        if (k.e(this.c) && am.a(this.c).a(com.xiaomi.xmpush.thrift.g.UploadGeoAppLocSwitch.a(), true) && d.d(this.c) && b() && f.a(this.c, "11", (long) this.d)) {
            a(this.c, false);
        }
    }
}
