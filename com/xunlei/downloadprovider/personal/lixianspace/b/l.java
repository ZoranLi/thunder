package com.xunlei.downloadprovider.personal.lixianspace.b;

import com.xunlei.downloadprovider.member.payment.c.c;
import com.xunlei.downloadprovider.personal.lixianspace.d.h;
import com.xunlei.downloadprovider.personal.lixianspace.d.h.a;
import com.xunlei.downloadprovider.personal.lixianspace.d.o;
import java.util.concurrent.ExecutorService;

/* compiled from: LXSpaceRequestMgr */
public final class l {
    private static ExecutorService a;

    public static void a(Object obj, a... aVarArr) {
        new h(obj).a(new m(), aVarArr);
    }

    public static void a(Object obj) {
        new o(obj).a(new r());
    }

    public static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder("magnet:?xt=urn:btih:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    static /* synthetic */ void a(Runnable runnable) {
        if (a == null) {
            a = c.a("lx-request");
        }
        a.execute(runnable);
    }
}
