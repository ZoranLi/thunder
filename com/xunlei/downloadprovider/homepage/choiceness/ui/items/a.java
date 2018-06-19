package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.d;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: ChoicenessCinecismView */
public final class a extends com.xunlei.downloadprovider.homepage.cinecism.ui.a implements b<d> {

    /* compiled from: ChoicenessCinecismView */
    private static class a extends com.xunlei.downloadprovider.homepage.cinecism.a {
        public final String f() {
            return "home_choiceness";
        }

        public final String g() {
            return "home_cinecism_card";
        }

        private a() {
        }

        public final void a(ShareOperationType shareOperationType, String str, String str2) {
            if (shareOperationType == ShareOperationType.REPORT) {
                ReportActivity.a(BrothersApplication.getApplicationInstance(), 8, str, this.a.a.a, DispatchConstants.OTHER);
                ChoicenessReporter.a(str, "jubao", "home_collect");
                return;
            }
            ChoicenessReporter.b(this.a, str2, "cinecism");
        }

        public final From h() {
            return From.HOME_CINECISM_CARD;
        }

        public final void a() {
            ChoicenessReporter.a(this.a);
        }

        public final void b() {
            ChoicenessReporter.a(this.a, "", "cinecism");
        }

        public final void c() {
            e eVar = this.a;
            LoginHelper.a();
            ChoicenessReporter.a(eVar, eVar.b, "cinecism", l.c(), false);
        }

        public final void a(String str, String str2) {
            e eVar = this.a;
            LoginHelper.a();
            ChoicenessReporter.a(eVar, eVar.b, "cinecism", l.c(), str, str2, 0);
        }

        public final void d() {
            ChoicenessReporter.a(this.a, "cinecism");
        }

        public final void e() {
            ChoicenessReporter.a(this.a, false, "cinecism");
        }

        public final void a(int i, ShareOperationType shareOperationType) {
            ChoicenessReporter.a(this.a, shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i, false, "cinecism");
        }
    }

    public final /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
        d dVar = (d) eVar;
        getReportStrategy().a = dVar;
        a(dVar, i2);
    }

    public a(@NonNull Context context) {
        super(context, new a());
    }
}
