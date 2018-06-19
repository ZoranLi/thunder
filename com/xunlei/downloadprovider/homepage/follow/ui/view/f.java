package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;

/* compiled from: FollowingLiveViewHolder */
final class f implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ e b;

    f(e eVar, a aVar) {
        this.b = eVar;
        this.a = aVar;
    }

    public final void onClick(View view) {
        Context context = view.getContext();
        if (this.a.j != null) {
            com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(context, this.a.n, g.a[this.b.h.ordinal()] != 1 ? XLLiveRoomPlayFrom.FOLLOW_TAB_LIST_FOLLOW_ITEM : XLLiveRoomPlayFrom.FOLLOW_TAB);
        } else {
            if (g.a[this.b.h.ordinal()] != 1) {
                view = From.FOLLOW_TAB_LIST;
            } else {
                view = From.FOLLOW_TAB;
            }
            m.a(context, this.a.b, "rad", this.a.e, this.a.f, view);
        }
        ad.a(this.b.h.toString(), this.a.b, this.a.c, this.a.j);
    }
}
