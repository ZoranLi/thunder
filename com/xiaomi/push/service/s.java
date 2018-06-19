package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ap.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import com.xunlei.downloadprovider.search.ui.search.ab;
import java.util.Locale;

public class s {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    public s(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = i;
    }

    public static boolean a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "miui.os.Build";	 Catch:{ Exception -> 0x0012 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0012 }
        r1 = "IS_ALPHA_BUILD";	 Catch:{ Exception -> 0x0012 }
        r0 = r0.getField(r1);	 Catch:{ Exception -> 0x0012 }
        r1 = 0;	 Catch:{ Exception -> 0x0012 }
        r0 = r0.getBoolean(r1);	 Catch:{ Exception -> 0x0012 }
        return r0;
    L_0x0012:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.s.a():boolean");
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public b a(XMPushService xMPushService) {
        b bVar = new b(xMPushService);
        a(bVar, xMPushService, xMPushService.e(), c.a);
        return bVar;
    }

    public b a(b bVar, Context context, e eVar, String str) {
        bVar.a = context.getPackageName();
        bVar.b = this.a;
        bVar.i = this.c;
        bVar.c = this.b;
        bVar.h = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.e = false;
        String str2 = "";
        if (b(context)) {
            str2 = a.a(context);
        }
        bVar.f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s", new Object[]{"sdk_ver", Integer.valueOf(31), "cpvn", "3_5_1", "cpvc", Integer.valueOf(30501), "aapn", str2});
        str2 = b(context) ? "1000271" : this.d;
        bVar.g = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", new Object[]{"appid", str2, "locale", Locale.getDefault().toString(), Constants.EXTRA_KEY_MIID, p.a(context).c()});
        if (a(context)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.g);
            stringBuilder.append(String.format(",%1$s:%2$s", new Object[]{ab.a, str}));
            bVar.g = stringBuilder.toString();
        }
        bVar.k = eVar;
        return bVar;
    }
}
