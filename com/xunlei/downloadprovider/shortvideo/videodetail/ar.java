package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.a;

/* compiled from: ShortMovieDetailFragment */
final class ar implements a {
    final /* synthetic */ ShortMovieDetailFragment a;

    ar(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void a(p pVar) {
        this.a.A.e = pVar;
        String str = pVar.a;
        this.a.aq;
        bv.a(str, l.c(), this.a.o(), "discuss_alert");
        if (!r.a().a(this.a.mActivity, LoginFrom.VIDEO_DETAIL_USER_DISCUSS_DEFAULT, this.a.ay)) {
            this.a.a(pVar.b, this.a.A.b);
        }
    }
}
