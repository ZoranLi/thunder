package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: ShortMovieDetailFragment */
final class bu extends c {
    final /* synthetic */ bt a;

    bu(bt btVar) {
        this.a = btVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        LoginHelper.a();
        if (l.c()) {
            this.a.a.e("discuss_result");
        }
    }
}
