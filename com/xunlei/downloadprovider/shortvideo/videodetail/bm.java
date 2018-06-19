package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: ShortMovieDetailFragment */
final class bm extends c {
    final /* synthetic */ View a;
    final /* synthetic */ ShortMovieDetailFragment b;

    bm(ShortMovieDetailFragment shortMovieDetailFragment, View view) {
        this.b = shortMovieDetailFragment;
        this.a = view;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        this.b.aq;
        if (l.c()) {
            this.b.a("follow_button", this.a);
        }
    }
}
