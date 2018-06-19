package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.control.p;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadCenterActivityFragment */
final class k implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    k(DownloadCenterActivityFragment downloadCenterActivityFragment) {
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
        p.a().a(arrayList);
        this.a.a();
    }
}
