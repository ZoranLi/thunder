package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.a.a;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: WebsiteDetailFragment */
final class h implements OnClickListener {
    final /* synthetic */ WebsiteDetailFragment a;

    h(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onClick(View view) {
        view = this.a.s.b;
        long id = view == null ? -1 : view.getId();
        String str = this.a.i.a;
        this.a.Z;
        a.a(str, id, l.c(), this.a.h(), this.a.ae);
        if (r.a().a(this.a.getContext(), LoginFrom.LINK_DETAIL_DISCUSS, this.a.ag) == null) {
            WebsiteDetailFragment.w(this.a);
        }
    }
}
