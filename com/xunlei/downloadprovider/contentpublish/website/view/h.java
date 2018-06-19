package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: WebsiteCardView */
final class h implements OnClickListener {
    final /* synthetic */ VideoUserInfo a;
    final /* synthetic */ a b;

    h(a aVar, VideoUserInfo videoUserInfo) {
        this.b = aVar;
        this.a = videoUserInfo;
    }

    public final void onClick(View view) {
        m.a(this.b.getContext(), this.a, this.b.r.m());
        this.b.r.c();
    }
}
