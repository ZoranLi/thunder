package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.lixianspace.a;

/* compiled from: LXSpaceExpansionDlg */
final class f implements OnClickListener {
    final /* synthetic */ c a;

    f(c cVar) {
        this.a = cVar;
    }

    public final void onClick(View view) {
        a.a(this.a.getContext(), "dilatation", this.a.o);
        this.a.dismiss();
        com.xunlei.downloadprovider.personal.lixianspace.c.a.c("pay");
    }
}
