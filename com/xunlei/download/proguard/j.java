package com.xunlei.download.proguard;

import android.content.Context;
import com.xunlei.download.proguard.h.a;
import com.xunlei.download.proguard.h.b;

/* compiled from: ExtendEntryhelper */
public class j {
    static a a;
    static b b;

    j() {
    }

    static {
        try {
            a = (a) Class.forName("com.android.providers.downloads.ExtendEntryTask").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            b = (b) Class.forName("com.xunlei.download.proguard.i").newInstance();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static z a(Context context, r rVar, d dVar, q qVar, e eVar) {
        return a != null ? a.a(context, rVar, dVar, qVar, eVar) : null;
    }

    public static z.b a(Context context, d dVar, z.a aVar) {
        return b != null ? b.newVipChannelTask(context, dVar, aVar) : null;
    }

    public static void a(Context context) {
        if (a != null) {
            a.a(context);
        }
        if (b != null) {
            b.onInitVipChannel(context);
        }
    }

    public static void b(Context context) {
        if (b != null) {
            b.onUninitVipChannel(context);
        }
        if (a != null) {
            a.b(context);
        }
    }
}
