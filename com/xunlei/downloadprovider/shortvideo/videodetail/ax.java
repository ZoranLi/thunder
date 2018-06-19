package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ShortMovieDetailFragment */
final class ax implements OnClickListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    ax(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onClick(View view) {
        this.a.B.dismiss();
        view = this.a.B.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        bv.a(view.getId(), view.isHot(), "cancel");
    }
}
