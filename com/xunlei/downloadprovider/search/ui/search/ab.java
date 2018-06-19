package com.xunlei.downloadprovider.search.ui.search;

import com.tencent.bugly.crashreport.CrashReport;
import com.xunlei.downloadprovider.d.b.p.a;
import com.xunlei.downloadprovider.d.m;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: MultiSearchCtr */
public class ab {
    public static final String a = "ab";
    public static String f = "";
    public boolean b;
    public String c;
    public o d;
    public b e;
    public final List<a> g = new ArrayList();
    public final List<a> h = new ArrayList();
    public final List<a> i = new ArrayList();
    public final List<a> j = new ArrayList();
    public final List<a> k = new ArrayList();
    private boolean l;
    private boolean m;

    public ab(o oVar, String str, b bVar) {
        this.d = oVar;
        this.c = str;
        this.e = bVar;
    }

    private void a() {
        StringBuilder stringBuilder = new StringBuilder("triggerUpdate invalid: ");
        stringBuilder.append(this.b);
        stringBuilder.append(" keyword: ");
        stringBuilder.append(this.c);
        stringBuilder.append(" mMultiloaded:");
        stringBuilder.append(this.l);
        stringBuilder.append(" mMedialoaded:");
        stringBuilder.append(this.m);
        if (!this.b && this.m) {
            if (this.l) {
                if (this.e.c) {
                    this.e.b.hide();
                    if (this.d != null) {
                        b();
                        return;
                    }
                }
                stringBuilder = new StringBuilder("postLoadingGoneCallBack invalid: ");
                stringBuilder.append(this.b);
                stringBuilder.append(" keyword: ");
                stringBuilder.append(this.c);
                this.e.a = new ae(this);
            }
        }
    }

    private void a(a aVar) {
        int i = 0;
        if (!d.a(this.g)) {
            this.k.add(new n(aVar.c, 0));
        }
        while (i < aVar.d && i < this.g.size()) {
            a aVar2 = (a) this.g.get(i);
            if (aVar2 != null) {
                this.k.add(aVar2);
            }
            i++;
        }
    }

    private void b(a aVar) {
        if (!d.a(this.h)) {
            this.k.add(new n(aVar.c, 4));
        }
        int i = 0;
        while (i < aVar.d && i < this.h.size()) {
            a aVar2 = (a) this.h.get(i);
            if (aVar2 != null) {
                this.k.add(aVar2);
            }
            i++;
        }
    }

    private void c(a aVar) {
        if (!d.a(this.i)) {
            this.k.add(new n(aVar.c, 5));
        }
        int i = 0;
        while (i < aVar.d && i < this.i.size()) {
            a aVar2 = (a) this.i.get(i);
            if (aVar2 != null) {
                this.k.add(aVar2);
            }
            i++;
        }
    }

    private void d(a aVar) {
        if (!d.a(this.j)) {
            this.k.add(new n(aVar.c, 6));
        }
        int i = 0;
        while (i < aVar.d && i < this.j.size()) {
            a aVar2 = (a) this.j.get(i);
            if (aVar2 != null) {
                this.k.add(aVar2);
            }
            i++;
        }
    }

    private void b() {
        StringBuilder stringBuilder = new StringBuilder("doRefresh invalid: ");
        stringBuilder.append(this.b);
        stringBuilder.append(" keyword: ");
        stringBuilder.append(this.c);
        if (!this.b) {
            this.k.clear();
            List list = com.xunlei.downloadprovider.d.d.a().m.a;
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                a aVar = (a) list.get(i);
                if (aVar != null) {
                    int i2 = aVar.a;
                    if (i2 != 0) {
                        switch (i2) {
                            case 4:
                                b(aVar);
                                break;
                            case 5:
                                c(aVar);
                                break;
                            case 6:
                                d(aVar);
                                break;
                            default:
                                break;
                        }
                    }
                    a(aVar);
                }
            }
            this.d.a(this.k, this.c);
            this.d.notifyDataSetChanged();
            if (d.a(this.j) && d.a(this.i) && d.a(this.h)) {
                z = true;
            }
            com.xunlei.downloadprovider.search.c.a.a(z, d.a(this.g), d.a(this.j), d.a(this.i), d.a(this.i), f, this.c);
        }
    }

    private static List<com.xunlei.downloadprovider.search.a.a> b(String str, List<com.xunlei.downloadprovider.search.a.a> list) {
        if (d.a(list)) {
            list = new com.xunlei.downloadprovider.search.a.a();
            list.b = str;
            str = new ArrayList();
            str.add(list);
        } else {
            str = list;
        }
        list = new ArrayList();
        ArrayList b = m.a().b();
        if (b.isEmpty()) {
            return r5;
        }
        try {
            int size = b.size();
            Random random = new Random();
            for (com.xunlei.downloadprovider.search.a.a aVar : r5) {
                if (aVar != null) {
                    if (!k.a.d(aVar.b)) {
                        aVar.m = (String) b.get(random.nextInt(size));
                    }
                    list.add(aVar);
                }
            }
        } catch (String str2) {
            CrashReport.postCatchedException(str2);
            str2.printStackTrace();
        }
        return list;
    }

    static /* synthetic */ void a(ab abVar, List list) {
        if (!d.a(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    abVar.g.add(new ah((com.xunlei.downloadprovider.search.a.a) list.get(i)));
                }
            }
            abVar.m = true;
            abVar.a();
        }
    }
}
