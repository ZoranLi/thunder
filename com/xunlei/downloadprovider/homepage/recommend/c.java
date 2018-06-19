package com.xunlei.downloadprovider.homepage.recommend;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: SummaryMoviesFeedView */
final class c implements OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.e.setVisibility(8);
            this.a.a();
        }
    }
}
