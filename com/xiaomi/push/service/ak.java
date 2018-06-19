package com.xiaomi.push.service;

import com.xiaomi.stats.h;
import java.util.Iterator;
import java.util.List;

final class ak implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;

    ak(List list, boolean z) {
        this.a = list;
        this.b = z;
    }

    public final void run() {
        int i;
        boolean a = aj.b("www.baidu.com:80");
        Iterator it = this.a.iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (!a) {
                if (!aj.b(str)) {
                    a = false;
                    if (!a) {
                        if (this.b) {
                            break;
                        }
                    }
                }
            }
            a = true;
            if (!a) {
                if (this.b) {
                    break;
                }
            }
        }
        if (!a) {
            i = 2;
        }
        h.a(i);
    }
}
