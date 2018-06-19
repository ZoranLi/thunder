package com.xunlei.downloadprovider.ad.downloadlist.c;

import com.xunlei.downloadprovider.ad.recommend.c.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HomeDownloadADReportHelper */
public final class g extends a {
    public static g c;
    public ArrayList<i> b;
    public boolean d;
    private HashMap<Integer, Set<Integer>> e;

    private g() {
        this.d = false;
        this.b = new ArrayList();
        this.a = new HashSet();
        this.e = new HashMap();
        this.e.put(Integer.valueOf(0), new HashSet());
        this.e.put(Integer.valueOf(1), new HashSet());
        this.e.put(Integer.valueOf(2), new HashSet());
    }

    public static g a() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    public final void a(i iVar) {
        if (iVar instanceof b) {
            b bVar = (b) iVar;
            Set set = (Set) this.e.get(Integer.valueOf(bVar.a));
            if (set == null) {
                StringBuilder stringBuilder = new StringBuilder("you should set config for this pageIndex,pageIndex: ");
                stringBuilder.append(bVar.a);
                throw new NullPointerException(stringBuilder.toString());
            } else if (!set.contains(Integer.valueOf(bVar.b))) {
                set.add(Integer.valueOf(bVar.b));
            } else {
                return;
            }
        }
        this.b.add(iVar);
        if (this.d) {
            iVar.c();
            if (this.b != null) {
                this.b.remove(iVar);
            }
        }
    }

    public final void a(int i) {
        ((Set) this.e.get(Integer.valueOf(i))).clear();
    }
}
