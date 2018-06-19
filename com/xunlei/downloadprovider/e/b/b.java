package com.xunlei.downloadprovider.e.b;

import com.xunlei.downloadprovider.e.a.f;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ShareCountPresenterImpl */
public final class b {
    private static b a;
    private static HashSet<a> b = new HashSet();

    public static b a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static boolean a(a aVar) {
        return b.add(aVar);
    }

    public static boolean b(a aVar) {
        return b.remove(aVar);
    }

    public static void a(String str) {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }
}
