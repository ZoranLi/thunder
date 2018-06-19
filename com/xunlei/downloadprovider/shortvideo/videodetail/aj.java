package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.ad.d.i;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.player.xmp.a.a;
import com.xunlei.downloadprovider.player.xmp.e;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: ShortMovieDetailActivity */
final class aj extends com.xunlei.downloadprovider.player.xmp.aj {
    final /* synthetic */ ShortMovieDetailActivity a;

    aj(ShortMovieDetailActivity shortMovieDetailActivity) {
        this.a = shortMovieDetailActivity;
    }

    public final void a() {
        super.a();
        this.a.X = true;
        this.a.p.setVisibility(From.HOME_PAGE_AD.getText().contentEquals(this.a.e) ? 4 : 0);
        this.a.q.setVisibility(0);
        if (this.a.k()) {
            this.a.m.e(false);
            new i(this.a).a(this.a.i);
            return;
        }
        boolean d = d.a().l.d();
        int i = d.a().l.i();
        if (!d || i <= 0) {
            this.a.m.e(false);
            if (this.a.a != null) {
                this.a.a.f();
            }
            return;
        }
        this.a.m.e(true);
        bv.c("detail_shortvideo_playend");
        this.a.x.postDelayed(this.a.aa, (long) (i * 1000));
    }

    public final void a(int i) {
        super.a(i);
        if (!(this.a.L == null || this.a.L.isFollowed())) {
            if (this.a.a != null) {
                e eVar = this.a.a.i;
                if (eVar != null) {
                    boolean a = a.a(eVar, i, this.a.a.f.c());
                    if (a) {
                        eVar.a();
                        StringBuilder stringBuilder = new StringBuilder("onPlayPositionChange--position=");
                        stringBuilder.append(i);
                        stringBuilder.append("|canShowFollowAnimation=");
                        stringBuilder.append(a);
                        this.a.k.getPublisherInfoView().a.a();
                        this.a.G.a.a();
                    }
                }
            }
        }
    }
}
