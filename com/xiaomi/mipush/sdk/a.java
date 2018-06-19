package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.service.am;
import com.xiaomi.xmpush.thrift.g;

public class a {
    public static StackTraceElement[] a;

    public static void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Thread.getAllStackTraces();	 Catch:{ Throwable -> 0x0010 }
        r1 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0010 }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x0010 }
        r0 = (java.lang.StackTraceElement[]) r0;	 Catch:{ Throwable -> 0x0010 }
        a = r0;	 Catch:{ Throwable -> 0x0010 }
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.a.a():void");
    }

    public static void a(Context context) {
        h.a(context).a(new b(context), 20);
    }

    private static java.lang.String b(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a;
        if (r0 == 0) goto L_0x0030;
    L_0x0004:
        r0 = a;
        r1 = 4;
        r0 = r0.length;
        if (r0 > r1) goto L_0x000b;
    L_0x000a:
        goto L_0x0030;
    L_0x000b:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r2 = r1;
    L_0x0011:
        r3 = a;	 Catch:{ Exception -> 0x002d }
        r3 = r3.length;	 Catch:{ Exception -> 0x002d }
        if (r2 >= r3) goto L_0x0028;	 Catch:{ Exception -> 0x002d }
    L_0x0016:
        r3 = r4 + 4;	 Catch:{ Exception -> 0x002d }
        if (r2 >= r3) goto L_0x0028;	 Catch:{ Exception -> 0x002d }
    L_0x001a:
        r3 = a;	 Catch:{ Exception -> 0x002d }
        r3 = r3[r2];	 Catch:{ Exception -> 0x002d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x002d }
        r0.add(r3);	 Catch:{ Exception -> 0x002d }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x002d }
        goto L_0x0011;	 Catch:{ Exception -> 0x002d }
    L_0x0028:
        r4 = r0.toString();	 Catch:{ Exception -> 0x002d }
        return r4;
    L_0x002d:
        r4 = "";
        return r4;
    L_0x0030:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.a.b(int):java.lang.String");
    }

    private static boolean d(Context context) {
        am a = am.a(context);
        if (!a.a(g.AggregationSdkMonitorSwitch.a(), false)) {
            return false;
        }
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_upload_call_stack_timestamp", 0)) >= ((long) Math.max(60, a.a(g.AggregationSdkMonitorFrequency.a(), 86400)));
    }

    private static void e(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_upload_call_stack_timestamp", System.currentTimeMillis());
        edit.commit();
    }
}
