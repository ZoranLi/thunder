package com.xunlei.downloadprovider.web.browser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;

/* compiled from: BrowserActivity */
final class h implements OnClickListener {
    final /* synthetic */ CooperationItem a;
    final /* synthetic */ BrowserActivity b;

    h(BrowserActivity browserActivity, CooperationItem cooperationItem) {
        this.b = browserActivity;
        this.a = cooperationItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BrowserActivity.u(this.b);
        if (this.a != null) {
            a.a(l.c(this.a.getDisplayLocation()), this.a.getAppPackageName(), "1");
            this.b.b(this.a);
        }
    }
}
