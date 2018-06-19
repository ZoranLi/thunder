package com.xunlei.downloadprovider.publiser.visitors;

import android.widget.TextView;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper.a;

/* compiled from: VisitActivity */
final class d implements a {
    final /* synthetic */ VisitActivity a;

    d(VisitActivity visitActivity) {
        this.a = visitActivity;
    }

    public final void a(int i) {
        this.a.j = i;
        if (this.a.m != null) {
            TextView c = this.a.m;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j.a((long) i));
            stringBuilder.append("次访问");
            c.setText(stringBuilder.toString());
        }
    }
}
