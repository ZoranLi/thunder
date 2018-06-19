package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BaseEffectADViewHolder */
final class b implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ a b;

    b(a aVar, View view) {
        this.b = aVar;
        this.a = view;
    }

    public final void onClick(View view) {
        if (this.b.f != null) {
            this.b.f.a(this.a, 24, this.b.e);
        }
    }
}
