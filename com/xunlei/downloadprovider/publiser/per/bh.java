package com.xunlei.downloadprovider.publiser.per;

import android.content.Context;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.contentpublish.website.view.n;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.publiser.per.model.h;
import com.xunlei.downloadprovider.shortvideo.videodetail.i;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: HistoryPublishWebsiteViewHolder */
public final class bh extends bq<h> {
    private g a;
    private i b;
    private bo c;
    private bp<h> d;
    private WebsiteInfo e;
    private String f;

    /* compiled from: HistoryPublishWebsiteViewHolder */
    private static class a extends n<h> {
        public final void a(String str, String str2) {
        }

        public final void c() {
        }

        public final void e() {
        }

        public final void g() {
        }

        public final String h() {
            return "personal_space_video_share";
        }

        public final String i() {
            return "shortvideo_usercenter";
        }

        public final String k() {
            return "shortvideo_channel_publiccard";
        }

        public final String l() {
            return "shortvideo_channel_publicdiscuss";
        }

        private a() {
        }

        public final void a(ShareOperationType shareOperationType, String str, String str2) {
            if (shareOperationType != ShareOperationType.DELETE) {
                com.xunlei.downloadprovider.homepage.recommend.a.b(str, "web_url", str2, "foot", o.a(((h) this.a).getUserInfo().getKind()), "publish");
            }
        }

        public final BrowserFrom j() {
            return BrowserFrom.SHORTVIDEO_USERCENTER_URL;
        }

        public final From m() {
            return From.PUBLISHER_HISTORY_TAB;
        }

        public final void a() {
            com.xunlei.downloadprovider.homepage.recommend.a.a(((h) this.a).a, "detail");
        }

        public final void b() {
            com.xunlei.downloadprovider.homepage.recommend.a.a(((h) this.a).a, "websize");
        }

        public final void d() {
            h hVar = (h) this.a;
            com.xunlei.downloadprovider.homepage.recommend.a.a(hVar.a.a, "web_url", hVar.getUserInfo().getKind(), "publish", "bottom");
        }

        public final void f() {
            com.xunlei.downloadprovider.homepage.recommend.a.a(((h) this.a).a.a, o.a(((h) this.a).getUserInfo().getKind()), "web_url");
        }

        public final void a(int i, ShareOperationType shareOperationType) {
            com.xunlei.downloadprovider.homepage.recommend.a.a(((h) this.a).a.a, "web_url", shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i, "foot", o.a(((h) this.a).getUserInfo().getKind()), "publish");
        }
    }

    public bh(Context context, g gVar, bo boVar) {
        super(new com.xunlei.downloadprovider.contentpublish.website.view.a(context, new a()));
        com.xunlei.downloadprovider.contentpublish.website.view.a aVar = (com.xunlei.downloadprovider.contentpublish.website.view.a) this.itemView;
        aVar.setFollowBtnVisibility(8);
        aVar.setPublishTimeVisibility(0);
        aVar.a.setVisibility(8);
        this.a = gVar;
        this.c = boVar;
        aVar.setOnLongClickListener(new bi(this));
    }

    public final void a(bp<h> bpVar) {
        this.d = bpVar;
        this.e = ((h) bpVar.b).a;
        this.f = ((h) bpVar.b).getUserInfo().getKind();
        h hVar = (h) bpVar.b;
        com.xunlei.downloadprovider.contentpublish.website.view.a aVar = (com.xunlei.downloadprovider.contentpublish.website.view.a) this.itemView;
        aVar.getReportStrategy().a = hVar;
        aVar.a(hVar.a, hVar.getUserInfo());
        aVar.setPublishTimeVisibility(8);
        aVar.setRightPublishTimeVisibility(0);
        aVar.setPublisherLayoutOnClickListener(null);
        aVar.setOnDeleteClickListener(new bj(this, hVar));
    }

    static /* synthetic */ void a(bh bhVar) {
        if (bhVar.e.b <= 0 || bhVar.e.b == LoginHelper.a().g.c()) {
            Context context = bhVar.itemView.getContext();
            bhVar.b = new i(context);
            bhVar.b.a();
            bhVar.b.b();
            bhVar.b.c();
            bhVar.b.c(new bk(bhVar, context));
            bhVar.b.d(new bm(bhVar));
            bhVar.b.show();
        }
    }
}
