package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.c;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CleanTask */
final class x implements Runnable {
    private static boolean a = false;
    private static long b = 300000;
    private static x c;

    private x() {
    }

    static void a() {
        if (!a) {
            i.a("CleanTask", "init TimeoutEventManager");
            c = new x();
            r.a().a(5, c, b);
            a = true;
        }
    }

    static void b() {
        r.a().a(5);
        a = false;
        c = null;
    }

    public final void run() {
        Object[] objArr = new Object[1];
        int i = 0;
        objArr[0] = "clean TimeoutEvent";
        i.a("CleanTask", objArr);
        e a = e.a();
        List arrayList = new ArrayList(a.a.keySet());
        int size = arrayList.size();
        while (i < size) {
            String str = (String) arrayList.get(i);
            c cVar = (c) a.a.get(str);
            if (cVar != null && cVar.a()) {
                a.a.remove(str);
            }
            i++;
        }
        r.a().a(5, c, b);
    }
}
