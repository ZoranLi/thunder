package com.xunlei.downloadprovider.download.center;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadCenterActivityFragment */
final class j implements OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ z b;
    final /* synthetic */ String c;
    final /* synthetic */ h d;

    j(h hVar, List list, z zVar, String str) {
        this.d = hVar;
        this.a = list;
        this.b = zVar;
        this.c = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface<e> b = this.d.a.n.b();
        List arrayList = new ArrayList();
        for (e b2 : b) {
            DownloadTaskInfo b3 = b2.b();
            if (b3 != null) {
                arrayList.add(b3);
            }
        }
        if (this.a.size() > null) {
            a.a("sure", this.b.getChecked(), this.c);
        } else {
            a.d("sure", this.c);
        }
        dialogInterface = this.d.a.d;
        com.xunlei.downloadprovider.download.control.a.a(arrayList, this.b.getChecked() ^ 1);
        this.d.a.a();
        this.b.dismiss();
    }
}
