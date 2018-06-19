package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.homepage.choiceness.ui.b.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: ChoicenessUgcPlayerView */
final class am implements a {
    final /* synthetic */ ak a;

    am(ak akVar) {
        this.a = akVar;
    }

    public final void a() {
        this.a.a(true, true);
    }

    public final void b() {
        this.a.a(this.a.getShortVideo(), this.a.getUserInfo(), true, From.HOME_COLLECT_DISCUSS, false);
    }

    public final void c() {
        this.a.q();
    }
}
