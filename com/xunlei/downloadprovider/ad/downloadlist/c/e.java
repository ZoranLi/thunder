package com.xunlei.downloadprovider.ad.downloadlist.c;

import com.xunlei.downloadprovider.ad.recommend.c.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: DownloadADReportHelper */
public final class e extends a {
    public static e c;
    public ArrayList<i> b;
    public int d;
    private HashMap<Integer, Set<Integer>> e;
    private boolean f;

    private e() {
        this.b = new ArrayList();
        this.a = new HashSet();
        this.e = new HashMap();
        this.e.put(Integer.valueOf(0), new HashSet());
        this.e.put(Integer.valueOf(1), new HashSet());
        this.e.put(Integer.valueOf(2), new HashSet());
    }

    public static e a() {
        if (c == null) {
            c = new e();
        }
        return c;
    }

    public final void b() {
        Collection arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar.a() == this.d) {
                Object obj = 1;
                if (iVar.b()) {
                    if (!this.f) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    iVar.c();
                    arrayList.add(iVar);
                }
            }
        }
        if (arrayList.size() != 0) {
            this.b.removeAll(arrayList);
        }
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
        if (iVar.a() == this.d) {
            Object obj = 1;
            if (iVar.b()) {
                if (!this.f) {
                    obj = null;
                }
            }
            if (obj != null) {
                iVar.c();
                if (this.b != null) {
                    this.b.remove(iVar);
                }
            }
        }
    }

    public final void a(int i) {
        ((Set) this.e.get(Integer.valueOf(i))).clear();
    }

    public final void a(boolean z) {
        this.f = z;
        if (z) {
            b();
        }
    }
}
