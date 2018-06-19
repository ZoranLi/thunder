package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailFragment.a;
import com.xunlei.xllib.android.b;

/* compiled from: ShortMovieDetailFragment */
final class bq implements OnClickListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    bq(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.e(false);
            this.a.i();
            this.a.r.setVisibility(8);
            ((a) this.a.mActivity).b(false);
        }
    }
}
