package com.xunlei.downloadprovider.publiser.visitors;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VisitActivity */
final class a implements OnClickListener {
    final /* synthetic */ VisitActivity a;

    a(VisitActivity visitActivity) {
        this.a = visitActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
