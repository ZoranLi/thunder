package com.xunlei.downloadprovider.publiser.per;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.d;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.publiser.per.model.f;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: HistoryPublishCinecismViewHolder */
final class ai extends bq<f> {

    /* compiled from: HistoryPublishCinecismViewHolder */
    private static class a extends com.xunlei.downloadprovider.homepage.cinecism.a {
        public final void a(String str, String str2) {
        }

        public final void c() {
        }

        public final void e() {
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return "personal_space";
        }

        public final From h() {
            return null;
        }

        private a() {
        }

        public final void a(ShareOperationType shareOperationType, String str, String str2) {
            if (shareOperationType == ShareOperationType.REPORT) {
                ReportActivity.a(BrothersApplication.getApplicationInstance(), 8, str, this.a.a.a, "shortvideo_usercenter");
                return;
            }
            com.xunlei.downloadprovider.homepage.recommend.a.b(str, "cinecism", str2, "foot", o.a(this.a.b.getKind()), "publish");
        }

        public final void a() {
            com.xunlei.downloadprovider.homepage.recommend.a.a(this.a.a.a, 0, "cinecism", o.a(this.a.b.getKind()), "publish", "publish");
        }

        public final void b() {
            d dVar = this.a;
            com.xunlei.downloadprovider.homepage.recommend.a.a(dVar.a.a, "cinecism", dVar.b.getKind(), "publish", "bottom");
        }

        public final void d() {
            com.xunlei.downloadprovider.homepage.recommend.a.a(this.a.a.a, o.a(this.a.b.getKind()), "cinecism");
        }

        public final void a(int i, ShareOperationType shareOperationType) {
            com.xunlei.downloadprovider.homepage.recommend.a.a(this.a.a.a, "cinecism", shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i, "foot", o.a(this.a.b.getKind()), "publish");
        }
    }

    ai(Context context) {
        super(new com.xunlei.downloadprovider.homepage.cinecism.ui.a(context, new a()));
        com.xunlei.downloadprovider.homepage.cinecism.ui.a aVar = (com.xunlei.downloadprovider.homepage.cinecism.ui.a) this.itemView;
        aVar.setLayoutParams(new LayoutParams(-1, -2));
        aVar.setFollowBtnVisibility(8);
        aVar.setUserInfoTagVisibility(8);
        aVar.setRightPublishTimeVisibility(0);
    }

    public final void a(bp<f> bpVar) {
        f fVar = (f) bpVar.b;
        com.xunlei.downloadprovider.homepage.cinecism.ui.a aVar = (com.xunlei.downloadprovider.homepage.cinecism.ui.a) this.itemView;
        d dVar = new d(fVar.a, fVar.getUserInfo());
        aVar.a(dVar, 47);
        aVar.getReportStrategy().a = dVar;
        aVar.setPublisherLayoutOnClickListener(new aj(this, aVar));
    }
}
