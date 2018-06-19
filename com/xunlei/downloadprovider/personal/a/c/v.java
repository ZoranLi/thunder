package com.xunlei.downloadprovider.personal.a.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.publiser.visitors.VisitActivity;

/* compiled from: UserInfoViewHolder */
final class v implements OnClickListener {
    final /* synthetic */ s a;

    v(s sVar) {
        this.a = sVar;
    }

    public final void onClick(View view) {
        VisitActivity.a(this.a.X, this.a.W.g.c(), "", s.N, "per_cl_visit");
    }
}
