package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: HistoryCommentCinecismViewHolder */
final class k implements OnClickListener {
    final /* synthetic */ h a;

    k(h hVar) {
        this.a = hVar;
    }

    public final void onClick(View view) {
        CinecismInfo cinecismInfo = this.a.f.a;
        if (cinecismInfo.l == 0) {
            XLToast.showToast(view.getContext(), "该影评已下线");
            return;
        }
        CinecismDetailActivity.a(view.getContext(), "personal_space", cinecismInfo, null, false);
        a.a(cinecismInfo.a, 0, "cinecism", o.a(this.a.h), "active", "discuss");
    }
}
