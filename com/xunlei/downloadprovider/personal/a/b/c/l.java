package com.xunlei.downloadprovider.personal.a.b.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.personal.a.j;

/* compiled from: UserOneGridViewHolder */
final class l implements OnClickListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void onClick(View view) {
        view = this.a.g.e;
        boolean z = false;
        boolean z2 = (1 != this.a.g.k || a.a().a(this.a.g.c, this.a.g.l, this.a.g.m) == null) ? null : 1;
        if ("my_gift".equals(this.a.g.c)) {
            boolean j = f.a().j();
            String str = this.a.g.c;
            if (z2 != null || j) {
                z = true;
            }
            j.a(str, z, this.a.getLayoutPosition(), this.a.g.d);
        } else {
            j.a(this.a.g.c, z2, this.a.getLayoutPosition(), this.a.g.d);
        }
        k.b(this.a);
    }
}
