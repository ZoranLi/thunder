package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.c;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.homepage.follow.b.e;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: NewFollowTabViewDataList */
final class af {
    int a = 2;
    e b = new e();
    c c;
    final List<ap> d = new ArrayList();
    ap e = new ap(1, this.b);
    ap f = new ap(11);
    final List<ap> g = new LinkedList();
    ap h = new ap(6);
    final List<ap> i = new ArrayList();

    public af() {
        LoginHelper.a();
        if (!l.c()) {
            this.a = 1;
        }
    }

    public final boolean a() {
        return this.d.isEmpty();
    }

    final boolean b() {
        if (this.c != null) {
            if (!this.c.a.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    final List<ap> c() {
        List<ap> arrayList = new ArrayList();
        if (this.c != null) {
            if (!this.c.a.isEmpty()) {
                List<a> list = this.c.a;
                if (list.size() <= 2) {
                    for (a aVar : list) {
                        if (aVar.j) {
                            arrayList.add(new ap(3, aVar));
                        }
                    }
                    arrayList.add(new ap(4, this.c));
                } else if (this.c.b) {
                    for (a aVar2 : list) {
                        if (aVar2.j) {
                            arrayList.add(new ap(3, aVar2));
                        }
                    }
                    arrayList.add(new ap(4, this.c));
                } else {
                    for (int i = 0; i < 2; i++) {
                        if (((a) list.get(i)).j) {
                            arrayList.add(new ap(3, list.get(i)));
                        }
                    }
                    arrayList.add(new ap(4, this.c));
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public final void a(List<d> list) {
        for (d apVar : list) {
            this.g.add(new ap(5, apVar));
        }
    }

    public final void a(List<d> list, boolean z) {
        if (z) {
            this.g.clear();
        }
        if (list != null) {
            if (!list.isEmpty()) {
                z = new ArrayList();
                for (d apVar : list) {
                    z.add(new ap(5, apVar));
                }
                this.g.addAll(0, z);
            }
        }
    }

    public final boolean d() {
        return this.g.isEmpty();
    }

    public final void e() {
        this.g.clear();
    }

    public final void b(List<g> list) {
        if (list != null) {
            if (list.size() != 0) {
                this.i.clear();
                this.i.add(new ap(7));
                for (g apVar : list) {
                    this.i.add(new ap(9, apVar));
                }
            }
        }
    }
}
