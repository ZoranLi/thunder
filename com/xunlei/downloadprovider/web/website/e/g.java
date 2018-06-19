package com.xunlei.downloadprovider.web.website.e;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.web.website.b.e;

/* compiled from: WebsiteCardItemViewHolder */
public final class g implements OnLongClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ e d;

    public g(e eVar, e eVar2, int i, String str) {
        this.d = eVar;
        this.a = eVar2;
        this.b = i;
        this.c = str;
    }

    public final boolean onLongClick(View view) {
        e.a(this.d, this.a, this.c);
        return true;
    }
}
