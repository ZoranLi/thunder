package com.xunlei.downloadprovider.publiser.visitors;

import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: VisitActivity */
final class c implements aa {
    final /* synthetic */ VisitActivity a;

    c(VisitActivity visitActivity) {
        this.a = visitActivity;
    }

    public final void a(boolean z, List<String> list) {
        this.a.f.notifyDataSetChanged();
    }
}
