package com.xunlei.downloadprovider.homepage.photoarticle.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.e.a.d;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.homepage.photoarticle.y;

/* compiled from: PhotoArticleLikeViewHolder */
final class e implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ d b;

    e(d dVar, View view) {
        this.b = dVar;
        this.a = view;
    }

    public final void onClick(View view) {
        if (this.b.g != null) {
            if (this.b.g.g == null) {
                view = this.b.g;
                this.b.b.a();
                d dVar = new d(view.a, view.a, view.h);
                dVar.a = 9;
                dVar.e = null;
                f.a().a(this.a.getContext(), dVar, null);
                y.a(this.b.g.a, String.valueOf(this.b.g.f), "picture_below");
            }
        }
    }
}
