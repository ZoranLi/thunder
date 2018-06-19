package com.xunlei.downloadprovider.publiser.visitors.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.recommend.a;

/* compiled from: VisitViewHolder */
final class l implements OnClickListener {
    final /* synthetic */ i a;

    l(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        XLToast.showToast(view.getContext(), "该视频已下线");
        a.c("offline", this.a.a);
    }
}
