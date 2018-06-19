package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: WebsiteDetailFragment */
final class ad extends c {
    final /* synthetic */ View a;
    final /* synthetic */ WebsiteDetailFragment b;

    ad(WebsiteDetailFragment websiteDetailFragment, View view) {
        this.b = websiteDetailFragment;
        this.a = view;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        this.b.Z;
        if (l.c()) {
            this.b.a("follow_button", this.a);
        }
    }
}
