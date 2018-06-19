package com.xunlei.downloadprovider.cardslide.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.cardslide.CardSlideActivity;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

/* compiled from: CardViewHolder */
public final class b implements OnClickListener {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.j != null) {
            view = this.a.j.a;
            if (view != null) {
                m.a(this.a.a, Long.valueOf(view.getUid()).longValue(), view.getKind(), view.getNickname(), view.getPortraitUrl(), From.CARD_SLIDE_PAGE);
                CardSlideActivity.a();
            }
        }
    }
}
