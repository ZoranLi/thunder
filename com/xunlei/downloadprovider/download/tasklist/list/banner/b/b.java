package com.xunlei.downloadprovider.download.tasklist.list.banner.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadExceptionBanner */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        a.c("dl_fail");
        this.a.c();
    }
}
