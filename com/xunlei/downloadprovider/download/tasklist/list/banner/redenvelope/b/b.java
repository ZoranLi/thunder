package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskDownloadRedEnvelopeBanner */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.d != null) {
            a.m(this.a.d.user_type);
        }
        if (this.a.c != null && this.a.b != null) {
            this.a.b.a(this.a.c);
        }
    }
}
