package com.xunlei.downloadprovider.publiser.websitetopic.b;

import android.content.Context;
import com.xunlei.downloadprovider.contentpublish.website.view.n;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.publiser.websitetopic.g;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: WebsiteTopicViewHolder */
public final class c extends a<com.xunlei.downloadprovider.publiser.websitetopic.c.c> {

    /* compiled from: WebsiteTopicViewHolder */
    private static class a extends n<com.xunlei.downloadprovider.publiser.websitetopic.c.c> {
        public final void c() {
        }

        public final void g() {
        }

        public final String h() {
            return "lick_collect";
        }

        public final String i() {
            return "shortvideo_usercenter";
        }

        public final String k() {
            return "link_collect";
        }

        public final String l() {
            return "link_collect_comment";
        }

        private a() {
        }

        public final BrowserFrom j() {
            return BrowserFrom.WEBSITE_TOPIC;
        }

        public final From m() {
            return From.WEBSITE_TOPIC;
        }

        public final void a() {
            g.c((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a);
        }

        public final void b() {
            g.c((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a);
        }

        public final void d() {
            g.d((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a);
        }

        public final void e() {
            g.f((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a);
        }

        public final void a(String str, String str2) {
            g.a((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a, str, str2);
        }

        public final void f() {
            g.e((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a);
        }

        public final void a(int i, ShareOperationType shareOperationType) {
            g.a((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a, shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i);
        }

        public final void a(ShareOperationType shareOperationType, String str, String str2) {
            g.a((com.xunlei.downloadprovider.publiser.websitetopic.c.c) this.a, shareOperationType.getReportShareTo());
        }
    }

    public final /* synthetic */ void a(Object obj) {
        com.xunlei.downloadprovider.publiser.websitetopic.c.c cVar = (com.xunlei.downloadprovider.publiser.websitetopic.c.c) obj;
        com.xunlei.downloadprovider.contentpublish.website.view.a aVar = (com.xunlei.downloadprovider.contentpublish.website.view.a) this.itemView;
        aVar.getReportStrategy().a = cVar;
        aVar.a(cVar.b, cVar.c);
    }

    public c(Context context) {
        super(new com.xunlei.downloadprovider.contentpublish.website.view.a(context, new a()));
    }
}
