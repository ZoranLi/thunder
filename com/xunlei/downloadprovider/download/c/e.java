package com.xunlei.downloadprovider.download.c;

import com.xunlei.downloadprovider.member.a.a.a;
import com.xunlei.downloadprovider.member.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: HighSpeedConfigManager */
public final class e implements a {
    private static e b = new e();
    public b a = new b(this);
    private List<Object> c = new ArrayList();

    public static e a() {
        return b;
    }

    public final void b() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
