package com.xunlei.downloadprovider.ad.common.c;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: ADReportUtil */
public final class a {
    public static String a = "guanggao";

    public static String a(@NonNull l lVar) {
        return String.format("%s/%s/%s", new Object[]{a, lVar.A(), lVar.a()});
    }

    public static boolean a(String str) {
        return (str == null || str.startsWith(a) == null) ? null : true;
    }
}
