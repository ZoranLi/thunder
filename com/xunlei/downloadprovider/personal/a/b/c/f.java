package com.xunlei.downloadprovider.personal.a.b.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.personal.a.j;

/* compiled from: UserOneGridScoreViewHolder */
final class f implements OnClickListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void onClick(View view) {
        view = this.a.t.e;
        boolean z = false;
        if (e.n > null) {
            String str = this.a.t.c;
            if (e.n > 0) {
                z = true;
            }
            j.a(str, z, this.a.getLayoutPosition(), this.a.t.d);
        } else {
            view = this.a.t.k;
            String str2 = this.a.t.c;
            String str3 = this.a.t.l;
            String str4 = this.a.t.m;
            if (1 == view && a.a().a(str2, str3, str4) != null) {
                z = true;
            }
            j.a(this.a.t.c, z, this.a.getLayoutPosition(), this.a.t.d);
        }
        e.b(this.a);
    }
}
