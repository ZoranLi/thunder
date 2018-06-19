package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.b.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a;

/* compiled from: MultiSearchAdapter */
final class w implements OnClickListener {
    final /* synthetic */ aj a;
    final /* synthetic */ o b;

    w(o oVar, aj ajVar) {
        this.b = oVar;
        this.a = ajVar;
    }

    public final void onClick(View view) {
        i.a().a(this.b.c, 1);
        a aVar = new a();
        aVar.a = this.a.c;
        aVar.u = From.SEARCH_NOW_SHORTVIDEO;
        ShortMovieDetailActivity.a(this.b.b, aVar);
        com.xunlei.downloadprovider.search.c.a.a("shortvideo");
    }
}
