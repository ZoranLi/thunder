package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.text.TextUtils;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailFragment.a;
import java.util.List;

/* compiled from: ShortMovieDetailFragment */
final class ba implements aa {
    final /* synthetic */ ShortMovieDetailFragment a;

    ba(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void a(boolean z, List<String> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                CharSequence uid = this.a.d.b().getUid();
                if (!(TextUtils.isEmpty(uid) || list.contains(uid) == null)) {
                    if (z) {
                        this.a.p.c = true;
                        this.a.p.a = true;
                    } else {
                        this.a.p.a = false;
                        this.a.p.c = false;
                    }
                    ((a) this.a.mActivity).a(this.a.p);
                }
            }
        }
    }
}
