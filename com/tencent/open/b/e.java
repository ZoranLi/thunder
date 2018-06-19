package com.tencent.open.b;

import com.tencent.open.utils.d;

/* compiled from: ProGuard */
public class e {
    public static int a(String str) {
        str = com.tencent.open.utils.e.a(d.a(), str).a("Common_BusinessReportFrequency");
        return str == null ? 100 : str;
    }

    public static int a() {
        int a = com.tencent.open.utils.e.a(d.a(), null).a("Common_HttpRetryCount");
        return a == 0 ? 2 : a;
    }
}
