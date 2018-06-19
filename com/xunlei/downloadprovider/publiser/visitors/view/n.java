package com.xunlei.downloadprovider.publiser.visitors.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a;

/* compiled from: VisitViewHolder */
final class n implements OnClickListener {
    final /* synthetic */ i a;

    n(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        a aVar = new a();
        aVar.a = this.a.o.e;
        aVar.b = this.a.o.a;
        aVar.s = true;
        aVar.u = From.HOME_USER_CENTER_VISIT_COMMENT;
        ShortMovieDetailActivity.a(this.a.b, aVar);
    }
}
