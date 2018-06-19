package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: ChoicenessRecommendUserView */
final class af implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ VideoUserInfo b;
    final /* synthetic */ int c;
    final /* synthetic */ a d;
    final /* synthetic */ b e;

    af(b bVar, String str, VideoUserInfo videoUserInfo, int i, a aVar) {
        this.e = bVar;
        this.a = str;
        this.b = videoUserInfo;
        this.c = i;
        this.d = aVar;
    }

    public final void onClick(View view) {
        m.a(this.e.itemView.getContext(), Long.parseLong(this.a), this.b.getKind(), this.b.getNickname(), this.b.getPortraitUrl(), From.HOME_REC_FOLLOW);
        ChoicenessReporter.a(this.e.g.c, this.c + 1, this.d);
    }
}
