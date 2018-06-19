package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: ShortMovieDetailFragment */
final class aq implements OnClickListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    aq(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onClick(View view) {
        view = this.a.A.b;
        long id = view == null ? -1 : view.getId();
        String videoId = this.a.d.a().getVideoId();
        this.a.aq;
        bv.a(videoId, id, l.c(), this.a.o(), this.a.aw);
        if (r.a().a(this.a.mActivity, LoginFrom.VIDEO_DETAIL_USER_DISCUSS, this.a.ax) == null) {
            ShortMovieDetailFragment.E(this.a);
        }
    }
}
