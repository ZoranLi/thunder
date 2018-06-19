package com.xunlei.downloadprovider.publiser.visitors.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.publiser.visitors.model.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a;

/* compiled from: VisitViewHolder */
final class k implements OnClickListener {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        a aVar = new a();
        aVar.a = this.a.o.e;
        aVar.b = this.a.o.a;
        aVar.u = From.HOME_USER_CENTER_VISIT_VIDEO;
        b b = this.a.o;
        aVar.d = b.i == null ? "" : b.i.a;
        ShortMovieDetailActivity.a(this.a.b, aVar);
    }
}
