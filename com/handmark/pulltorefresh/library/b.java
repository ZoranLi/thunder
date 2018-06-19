package com.handmark.pulltorefresh.library;

import com.handmark.pulltorefresh.library.a.f;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: LoadingLayoutProxy */
public final class b implements a {
    private final HashSet<f> a = new HashSet();

    b() {
    }

    public final void a(f fVar) {
        if (fVar != null) {
            this.a.add(fVar);
        }
    }

    public final void setBgColorForRefreshingView(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((f) it.next()).setBgColorForRefreshingView(i);
        }
    }
}
