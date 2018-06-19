package com.xunlei.downloadprovider.publiser.visitors;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: VisitActivity */
final class b implements OnClickListener {
    final /* synthetic */ VisitActivity a;

    b(VisitActivity visitActivity) {
        this.a = visitActivity;
    }

    public final void onClick(View view) {
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.h.setVisibility(8);
            this.a.a();
        }
    }
}
