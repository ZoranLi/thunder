package com.xunlei.downloadprovider.search.ui.widget;

import com.xunlei.downloadprovider.search.b.c.a;
import com.xunlei.xllib.b.d;
import java.util.List;

/* compiled from: SearchAssociativeView */
public final class e implements a {
    final /* synthetic */ SearchAssociativeView a;

    public e(SearchAssociativeView searchAssociativeView) {
        this.a = searchAssociativeView;
    }

    public final void a(String str, List<com.xunlei.downloadprovider.search.a.a> list) {
        if (!(this.a.c.equals(str) || d.a(list))) {
            list.clear();
        }
        this.a.a.a(this.a.c, this.a.a(str, (List) list));
    }
}
