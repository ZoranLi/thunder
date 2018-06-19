package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.xiaomi.channel.commonutils.android.d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.xiaomi.smack.b;

public class t {
    private static s a;
    private static a b;

    public interface a {
        void a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.s a(android.content.Context r13) {
        /*
        r0 = com.xiaomi.push.service.t.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x00ad }
        if (r1 == 0) goto L_0x000b;
    L_0x0007:
        r13 = a;	 Catch:{ all -> 0x00ad }
        monitor-exit(r0);
        return r13;
    L_0x000b:
        r1 = "mipush_account";
        r2 = 0;
        r1 = r13.getSharedPreferences(r1, r2);	 Catch:{ all -> 0x00ad }
        r2 = "uuid";
        r3 = 0;
        r5 = r1.getString(r2, r3);	 Catch:{ all -> 0x00ad }
        r2 = "token";
        r6 = r1.getString(r2, r3);	 Catch:{ all -> 0x00ad }
        r2 = "security";
        r7 = r1.getString(r2, r3);	 Catch:{ all -> 0x00ad }
        r2 = "app_id";
        r8 = r1.getString(r2, r3);	 Catch:{ all -> 0x00ad }
        r2 = "app_token";
        r9 = r1.getString(r2, r3);	 Catch:{ all -> 0x00ad }
        r2 = "package_name";
        r10 = r1.getString(r2, r3);	 Catch:{ all -> 0x00ad }
        r2 = "device_id";
        r2 = r1.getString(r2, r3);	 Catch:{ all -> 0x00ad }
        r4 = "env_type";
        r11 = 1;
        r11 = r1.getInt(r4, r11);	 Catch:{ all -> 0x00ad }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x00ad }
        if (r4 != 0) goto L_0x0063;
    L_0x004a:
        r4 = "a-";
        r4 = r2.startsWith(r4);	 Catch:{ all -> 0x00ad }
        if (r4 == 0) goto L_0x0063;
    L_0x0052:
        r2 = com.xiaomi.channel.commonutils.android.d.i(r13);	 Catch:{ all -> 0x00ad }
        r1 = r1.edit();	 Catch:{ all -> 0x00ad }
        r4 = "device_id";
        r1 = r1.putString(r4, r2);	 Catch:{ all -> 0x00ad }
        r1.commit();	 Catch:{ all -> 0x00ad }
    L_0x0063:
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x00ad }
        if (r1 != 0) goto L_0x00ab;
    L_0x0069:
        r1 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x00ad }
        if (r1 != 0) goto L_0x00ab;
    L_0x006f:
        r1 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x00ad }
        if (r1 != 0) goto L_0x00ab;
    L_0x0075:
        r1 = com.xiaomi.channel.commonutils.android.d.i(r13);	 Catch:{ all -> 0x00ad }
        r4 = "com.xiaomi.xmsf";
        r12 = r13.getPackageName();	 Catch:{ all -> 0x00ad }
        r4 = r4.equals(r12);	 Catch:{ all -> 0x00ad }
        if (r4 != 0) goto L_0x00a1;
    L_0x0085:
        r4 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00ad }
        if (r4 != 0) goto L_0x00a1;
    L_0x008b:
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x00ad }
        if (r4 != 0) goto L_0x00a1;
    L_0x0091:
        r1 = r2.equals(r1);	 Catch:{ all -> 0x00ad }
        if (r1 != 0) goto L_0x00a1;
    L_0x0097:
        r1 = "erase the old account.";
        com.xiaomi.channel.commonutils.logger.b.d(r1);	 Catch:{ all -> 0x00ad }
        c(r13);	 Catch:{ all -> 0x00ad }
        monitor-exit(r0);
        return r3;
    L_0x00a1:
        r13 = new com.xiaomi.push.service.s;	 Catch:{ all -> 0x00ad }
        r4 = r13;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x00ad }
        a = r13;	 Catch:{ all -> 0x00ad }
        monitor-exit(r0);
        return r13;
    L_0x00ab:
        monitor-exit(r0);
        return r3;
    L_0x00ad:
        r13 = move-exception;
        monitor-exit(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.t.a(android.content.Context):com.xiaomi.push.service.s");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.s a(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
        r0 = com.xiaomi.push.service.t.class;
        monitor-enter(r0);
        r1 = new java.util.TreeMap;	 Catch:{ all -> 0x015a }
        r1.<init>();	 Catch:{ all -> 0x015a }
        r2 = "devid";
        r3 = com.xiaomi.channel.commonutils.android.d.a(r9);	 Catch:{ all -> 0x015a }
        r1.put(r2, r3);	 Catch:{ all -> 0x015a }
        r2 = d(r9);	 Catch:{ all -> 0x015a }
        if (r2 == 0) goto L_0x0019;
    L_0x0017:
        r11 = "1000271";
    L_0x0019:
        r5 = r11;
        r11 = d(r9);	 Catch:{ all -> 0x015a }
        if (r11 == 0) goto L_0x0022;
    L_0x0020:
        r12 = "420100086271";
    L_0x0022:
        r6 = r12;
        r11 = d(r9);	 Catch:{ all -> 0x015a }
        if (r11 == 0) goto L_0x002b;
    L_0x0029:
        r10 = "com.xiaomi.xmsf";
    L_0x002b:
        r7 = r10;
        r10 = "appid";
        r1.put(r10, r5);	 Catch:{ all -> 0x015a }
        r10 = "apptoken";
        r1.put(r10, r6);	 Catch:{ all -> 0x015a }
        r10 = 0;
        r11 = r9.getPackageManager();	 Catch:{ Exception -> 0x0042 }
        r12 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r11 = r11.getPackageInfo(r7, r12);	 Catch:{ Exception -> 0x0042 }
        goto L_0x0047;
    L_0x0042:
        r11 = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(r11);	 Catch:{ all -> 0x015a }
        r11 = r10;
    L_0x0047:
        r12 = "appversion";
        if (r11 == 0) goto L_0x0052;
    L_0x004b:
        r11 = r11.versionCode;	 Catch:{ all -> 0x015a }
        r11 = java.lang.String.valueOf(r11);	 Catch:{ all -> 0x015a }
        goto L_0x0054;
    L_0x0052:
        r11 = "0";
    L_0x0054:
        r1.put(r12, r11);	 Catch:{ all -> 0x015a }
        r11 = "sdkversion";
        r12 = 31;
        r12 = java.lang.Integer.toString(r12);	 Catch:{ all -> 0x015a }
        r1.put(r11, r12);	 Catch:{ all -> 0x015a }
        r11 = "packagename";
        r1.put(r11, r7);	 Catch:{ all -> 0x015a }
        r11 = "model";
        r12 = android.os.Build.MODEL;	 Catch:{ all -> 0x015a }
        r1.put(r11, r12);	 Catch:{ all -> 0x015a }
        r11 = com.xiaomi.channel.commonutils.android.d.c(r9);	 Catch:{ all -> 0x015a }
        r11 = com.xiaomi.channel.commonutils.string.d.a(r11);	 Catch:{ all -> 0x015a }
        r12 = com.xiaomi.channel.commonutils.android.d.e(r9);	 Catch:{ all -> 0x015a }
        r2 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x015a }
        if (r2 != 0) goto L_0x0094;
    L_0x0080:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015a }
        r2.<init>();	 Catch:{ all -> 0x015a }
        r2.append(r11);	 Catch:{ all -> 0x015a }
        r11 = ",";
        r2.append(r11);	 Catch:{ all -> 0x015a }
        r2.append(r12);	 Catch:{ all -> 0x015a }
        r11 = r2.toString();	 Catch:{ all -> 0x015a }
    L_0x0094:
        r12 = "imei_md5";
        r1.put(r12, r11);	 Catch:{ all -> 0x015a }
        r11 = "os";
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015a }
        r12.<init>();	 Catch:{ all -> 0x015a }
        r2 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x015a }
        r12.append(r2);	 Catch:{ all -> 0x015a }
        r2 = "-";
        r12.append(r2);	 Catch:{ all -> 0x015a }
        r2 = android.os.Build.VERSION.INCREMENTAL;	 Catch:{ all -> 0x015a }
        r12.append(r2);	 Catch:{ all -> 0x015a }
        r12 = r12.toString();	 Catch:{ all -> 0x015a }
        r1.put(r11, r12);	 Catch:{ all -> 0x015a }
        r11 = com.xiaomi.channel.commonutils.android.d.b();	 Catch:{ all -> 0x015a }
        if (r11 < 0) goto L_0x00c5;
    L_0x00bc:
        r12 = "space_id";
        r11 = java.lang.Integer.toString(r11);	 Catch:{ all -> 0x015a }
        r1.put(r12, r11);	 Catch:{ all -> 0x015a }
    L_0x00c5:
        r11 = com.xiaomi.channel.commonutils.android.d.k(r9);	 Catch:{ all -> 0x015a }
        r11 = com.xiaomi.channel.commonutils.string.d.a(r11);	 Catch:{ all -> 0x015a }
        r12 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x015a }
        if (r12 != 0) goto L_0x00d8;
    L_0x00d3:
        r12 = "mac_address";
        r1.put(r12, r11);	 Catch:{ all -> 0x015a }
    L_0x00d8:
        r11 = "android_id";
        r12 = com.xiaomi.channel.commonutils.android.d.b(r9);	 Catch:{ all -> 0x015a }
        r1.put(r11, r12);	 Catch:{ all -> 0x015a }
        r11 = b(r9);	 Catch:{ all -> 0x015a }
        r11 = com.xiaomi.channel.commonutils.network.d.a(r9, r11, r1);	 Catch:{ all -> 0x015a }
        r12 = "";
        if (r11 == 0) goto L_0x00f1;
    L_0x00ed:
        r12 = r11.a();	 Catch:{ all -> 0x015a }
    L_0x00f1:
        r11 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x015a }
        if (r11 != 0) goto L_0x0158;
    L_0x00f7:
        r11 = new org.json.JSONObject;	 Catch:{ all -> 0x015a }
        r11.<init>(r12);	 Catch:{ all -> 0x015a }
        r1 = "code";
        r1 = r11.getInt(r1);	 Catch:{ all -> 0x015a }
        if (r1 != 0) goto L_0x0146;
    L_0x0104:
        r10 = "data";
        r10 = r11.getJSONObject(r10);	 Catch:{ all -> 0x015a }
        r11 = "ssecurity";
        r4 = r10.getString(r11);	 Catch:{ all -> 0x015a }
        r11 = "token";
        r3 = r10.getString(r11);	 Catch:{ all -> 0x015a }
        r11 = "userId";
        r10 = r10.getString(r11);	 Catch:{ all -> 0x015a }
        r11 = new com.xiaomi.push.service.s;	 Catch:{ all -> 0x015a }
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015a }
        r12.<init>();	 Catch:{ all -> 0x015a }
        r12.append(r10);	 Catch:{ all -> 0x015a }
        r10 = "@xiaomi.com/an";
        r12.append(r10);	 Catch:{ all -> 0x015a }
        r10 = 6;
        r10 = com.xiaomi.channel.commonutils.string.d.a(r10);	 Catch:{ all -> 0x015a }
        r12.append(r10);	 Catch:{ all -> 0x015a }
        r2 = r12.toString();	 Catch:{ all -> 0x015a }
        r8 = com.xiaomi.channel.commonutils.misc.a.c();	 Catch:{ all -> 0x015a }
        r1 = r11;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x015a }
        a(r9, r11);	 Catch:{ all -> 0x015a }
        a = r11;	 Catch:{ all -> 0x015a }
        monitor-exit(r0);
        return r11;
    L_0x0146:
        r1 = "code";
        r1 = r11.getInt(r1);	 Catch:{ all -> 0x015a }
        r2 = "description";
        r11 = r11.optString(r2);	 Catch:{ all -> 0x015a }
        com.xiaomi.push.service.w.a(r9, r1, r11);	 Catch:{ all -> 0x015a }
        com.xiaomi.channel.commonutils.logger.b.a(r12);	 Catch:{ all -> 0x015a }
    L_0x0158:
        monitor-exit(r0);
        return r10;
    L_0x015a:
        r9 = move-exception;
        monitor-exit(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.t.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.s");
    }

    public static void a() {
        if (b != null) {
            b.a();
        }
    }

    public static void a(Context context, s sVar) {
        Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", sVar.a);
        edit.putString("security", sVar.c);
        edit.putString("token", sVar.b);
        edit.putString(Constants.APP_ID, sVar.d);
        edit.putString(Constants.PACKAGE_NAME, sVar.f);
        edit.putString("app_token", sVar.e);
        edit.putString("device_id", d.i(context));
        edit.putInt("env_type", sVar.g);
        edit.commit();
        a();
    }

    public static String b(Context context) {
        StringBuilder stringBuilder;
        String str;
        if (com.xiaomi.channel.commonutils.misc.a.b()) {
            stringBuilder = new StringBuilder("http://");
            stringBuilder.append(b.c);
            str = ":9085/pass/register";
        } else if (PushChannelRegion.Global.name().equals(a.a(context).a())) {
            return "https://register.xmpush.global.xiaomi.com/pass/register";
        } else {
            stringBuilder = new StringBuilder("https://");
            stringBuilder.append(com.xiaomi.channel.commonutils.misc.a.a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com");
            str = "/pass/register";
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void c(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    private static boolean d(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
