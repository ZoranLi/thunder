package com.xunlei.downloadprovider.ad.taskdetail.a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TaskDetailAdReportManager */
public final class a {
    private static a b;
    public Map<Integer, Boolean> a;

    private a() {
        this.a = null;
        this.a = new HashMap();
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public static void b() {
        b = null;
    }

    public final void a(int i) {
        this.a.put(Integer.valueOf(i), Boolean.valueOf(true));
    }

    public final boolean b(int i) {
        Boolean bool = (Boolean) this.a.get(Integer.valueOf(i));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
