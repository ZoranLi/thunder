package com.xunlei.downloadprovider.homepage;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;

/* compiled from: HomeFragment */
final class h implements OnClickListener {
    final /* synthetic */ HomeFragment a;

    h(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final void onClick(View view) {
        if (this.a.p.isUnreadShow() != null) {
            n.a();
            n.l();
        }
        a.a(this.a.getContext(), DLCenterEntry.home.toString());
    }
}
