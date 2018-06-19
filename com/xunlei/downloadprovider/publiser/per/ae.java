package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.per.model.d;

/* compiled from: HistoryLikeCinecismViewHolder */
final class ae implements OnClickListener {
    final /* synthetic */ d a;
    final /* synthetic */ ad b;

    ae(ad adVar, d dVar) {
        this.b = adVar;
        this.a = dVar;
    }

    public final void onClick(View view) {
        CinecismInfo cinecismInfo = this.a.b;
        if (cinecismInfo.l == 0) {
            XLToast.showToast(view.getContext(), "该影评已下线");
            return;
        }
        CinecismDetailActivity.a(view.getContext(), "personal_space", cinecismInfo, null, false);
        a.a(cinecismInfo.a, 0, "cinecism", o.a(this.b.c), "active", "zan");
    }
}
