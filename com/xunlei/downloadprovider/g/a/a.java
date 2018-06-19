package com.xunlei.downloadprovider.g.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: XLVideoBusinessImpl */
public class a {
    private static a c;
    private final String a = a.class.getSimpleName();
    private List<Object> b = new ArrayList();

    private a() {
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public final void b() {
        ArrayList arrayList = new ArrayList(this.b);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
