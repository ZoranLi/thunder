package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;

/* compiled from: WebsiteDetailFragment */
final class i implements a {
    final /* synthetic */ WebsiteDetailFragment a;

    i(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void a(p pVar) {
        this.a.s.e = pVar;
        String str = pVar.a;
        this.a.Z;
        com.xunlei.downloadprovider.contentpublish.website.a.a.a(str, l.c(), this.a.h(), "discuss_alert");
        if (!r.a().a(this.a.mActivity, LoginFrom.VIDEO_DETAIL_USER_DISCUSS_DEFAULT, this.a.ah)) {
            this.a.a(pVar.b, this.a.s.b);
        }
    }
}
