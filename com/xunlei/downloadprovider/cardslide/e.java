package com.xunlei.downloadprovider.cardslide;

import com.xunlei.downloadprovider.cardslide.c.a;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.c;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: CardSlideActivity */
final class e implements c {
    final /* synthetic */ int a;
    final /* synthetic */ CardSlideActivity b;

    e(CardSlideActivity cardSlideActivity, int i) {
        this.b = cardSlideActivity;
        this.a = i;
    }

    public final boolean onClick() {
        a aVar = (a) this.b.a.get(this.a);
        if (aVar != null) {
            ShortMovieDetailActivity.a aVar2 = new ShortMovieDetailActivity.a();
            aVar2.p = this.b.x.b;
            aVar2.a = aVar.b.getVideoId();
            aVar2.u = From.CARD_SLIDE_PAGE;
            aVar2.v = aVar.b;
            aVar2.w = aVar.a;
            ShortMovieDetailActivity.a(this.b, aVar2);
            u.a(aVar.c);
            CardSlideActivity.a();
        }
        return false;
    }
}
