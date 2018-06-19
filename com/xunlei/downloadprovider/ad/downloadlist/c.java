package com.xunlei.downloadprovider.ad.downloadlist;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.xllib.b.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ListItemADClient */
public final class c {
    public static c a;
    public static int c;
    public boolean b;
    public boolean d;
    private Map<Integer, Set<b>> e = new HashMap();
    private Map<Integer, Boolean> f = new HashMap();

    /* compiled from: ListItemADClient */
    public interface a {
        void a();

        void a(l lVar);

        int b();

        int c();

        void d();
    }

    private c() {
    }

    public static c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public final void a(int i, b bVar) {
        Set set = (Set) this.e.get(Integer.valueOf(i));
        if (set == null) {
            set = new HashSet();
            this.e.put(Integer.valueOf(i), set);
        }
        set.add(bVar);
    }

    public final void a(int i) {
        c = i;
        Set<b> set = (Set) this.e.get(Integer.valueOf(i));
        if (!d.a(set)) {
            for (b bVar : set) {
                if (bVar != null) {
                    bVar.a();
                }
            }
            set.clear();
        }
    }
}
