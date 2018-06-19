package com.xunlei.downloadprovider.publiser.visitors;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.b;

/* compiled from: VisitActivity */
final class e implements b {
    final /* synthetic */ VisitActivity a;

    public final void a() {
    }

    e(VisitActivity visitActivity) {
        this.a = visitActivity;
    }

    public final void b() {
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            this.a.a();
            return;
        }
        XLToast.showNoNetworkToast(this.a);
        this.a.e.a();
    }
}
