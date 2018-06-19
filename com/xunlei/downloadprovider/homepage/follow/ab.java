package com.xunlei.downloadprovider.homepage.follow;

import java.util.ArrayList;
import java.util.List;

/* compiled from: FollowPresenterImpl */
public class ab {
    private static ab a;
    private ArrayList<aa> b = new ArrayList();

    private ab() {
    }

    public static ab a() {
        if (a == null) {
            synchronized (ab.class) {
                if (a == null) {
                    a = new ab();
                }
            }
        }
        return a;
    }

    public final void a(aa aaVar) {
        if (!this.b.contains(aaVar)) {
            this.b.add(aaVar);
        }
    }

    public final void b(aa aaVar) {
        this.b.remove(aaVar);
    }

    public final void a(boolean z, List<String> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < this.b.size(); i++) {
                ((aa) this.b.get(i)).a(z, list);
            }
        }
    }
}
