package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.control.d;
import com.xunlei.downloadprovider.download.control.p;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadCenterActivityFragment */
final class l implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    l(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        View<e> b = this.a.n.b();
        List arrayList = new ArrayList();
        for (e b2 : b) {
            DownloadTaskInfo b3 = b2.b();
            if (b3 != null) {
                arrayList.add(b3);
            }
        }
        view = this.a.d;
        if (!b.a(view.a)) {
            view.a();
        } else if (b.f(view.a)) {
            p.a().a(arrayList, false);
        } else if (!view.a(new d(view, arrayList))) {
            view.a(new com.xunlei.downloadprovider.download.control.e(view, arrayList));
        }
        this.a.a();
    }
}
