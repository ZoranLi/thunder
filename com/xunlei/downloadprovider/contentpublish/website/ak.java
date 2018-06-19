package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: WebsiteDetailFragment */
final class ak extends c {
    final /* synthetic */ aj a;

    ak(aj ajVar) {
        this.a = ajVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        LoginHelper.a();
        if (l.c()) {
            this.a.a.c("discuss_result");
        }
    }
}
