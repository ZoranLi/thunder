package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.i;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

/* compiled from: ChoicenessLivestreamItemView */
final class q implements OnClickListener {
    final /* synthetic */ i a;
    final /* synthetic */ ChoicenessLivestreamItemView b;

    q(ChoicenessLivestreamItemView choicenessLivestreamItemView, i iVar) {
        this.b = choicenessLivestreamItemView;
        this.a = iVar;
    }

    public final void onClick(View view) {
        m.a(this.b.getContext(), Long.valueOf(this.a.a).longValue(), "rad", this.a.p, this.a.b, From.HOMEPAGE);
        ChoicenessReporter.a(this.a.E.getKind(), this.b.getReportContentType());
    }
}
