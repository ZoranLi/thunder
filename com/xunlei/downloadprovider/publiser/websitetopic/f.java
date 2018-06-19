package com.xunlei.downloadprovider.publiser.websitetopic;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.publiser.websitetopic.a.a;
import com.xunlei.downloadprovider.publiser.websitetopic.c.b;

/* compiled from: WebsiteTopicFragment */
final class f implements c<b> {
    final /* synthetic */ boolean a;
    final /* synthetic */ WebsiteTopicFragment b;

    f(WebsiteTopicFragment websiteTopicFragment, boolean z) {
        this.b = websiteTopicFragment;
        this.a = z;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        b bVar = (b) obj;
        boolean z = bVar.a;
        if (!(this.a || this.b.a == null)) {
            this.b.a.a(z, bVar);
        }
        if (z) {
            WebsiteTopicFragment.e(this.b);
            this.b.f = bVar.c;
            this.b.g = bVar.b;
            obj = bVar.f;
            a a = this.b.c;
            if (obj != null && obj.size() > 0) {
                a.b.addAll(obj);
                a.notifyDataSetChanged();
            }
        }
        this.b.h = false;
    }

    public final void onFail(String str) {
        if (this.a == null && this.b.a != null) {
            this.b.a.a(false, null);
        }
        this.b.h = false;
        WebsiteTopicFragment.e(this.b);
    }
}
