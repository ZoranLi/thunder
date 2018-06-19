package com.xunlei.downloadprovider.homepage.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadTabFragment */
final class i implements OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ z b;
    final /* synthetic */ DownloadTabFragment c;

    i(DownloadTabFragment downloadTabFragment, List list, z zVar) {
        this.c = downloadTabFragment;
        this.a = list;
        this.b = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface<e> a = this.c.d.a();
        List arrayList = new ArrayList();
        for (e b : a) {
            DownloadTaskInfo b2 = b.b();
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        dialogInterface = a.a(a);
        if (this.a.size() > 0) {
            a.a("sure", this.b.getChecked(), dialogInterface);
        } else {
            a.d("sure", dialogInterface);
        }
        dialogInterface = this.c.b;
        com.xunlei.downloadprovider.download.control.a.a(arrayList, this.b.getChecked() ^ 1);
        this.c.a((boolean) 0);
        this.b.dismiss();
    }
}
