package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;

/* compiled from: ShortMovieDetailFragment */
final class az implements e {
    final /* synthetic */ ShortMovieDetailFragment a;

    az(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void a(String str, int i) {
        if (!(this.a.d == null || TextUtils.equals(str, this.a.d.a().getVideoId()) == null)) {
            this.a.d.a().setLikeCount(i + 1);
            this.a.d.a().setHasLike(true);
            this.a.H.b(this.a.I);
            this.a.am.setSelected(true);
        }
    }
}
