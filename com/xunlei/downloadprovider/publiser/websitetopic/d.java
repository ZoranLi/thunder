package com.xunlei.downloadprovider.publiser.websitetopic;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.publiser.websitetopic.c.b;

/* compiled from: WebsiteTopicActivity */
final class d implements a {
    final /* synthetic */ WebsiteTopicActivity a;

    d(WebsiteTopicActivity websiteTopicActivity) {
        this.a = websiteTopicActivity;
    }

    public final void a(boolean z, b bVar) {
        this.a.a.hide();
        if (z && bVar.f.size() <= false) {
            this.a.i = bVar;
            this.a.d.setVisibility(8);
            WebsiteTopicActivity.b(this.a, bVar);
            g.a(this.a.l, bVar.d);
        } else if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            WebsiteTopicActivity.a(this.a, (int) null);
        } else {
            WebsiteTopicActivity.a(this.a, 2);
        }
    }
}
