package com.xunlei.downloadprovider.download.taskdetails;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.control.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadCenterDetailFragment */
final class i implements OnClickListener {
    final /* synthetic */ z a;
    final /* synthetic */ g b;

    i(g gVar, z zVar) {
        this.b = gVar;
        this.a = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        List arrayList = new ArrayList();
        arrayList.add(this.b.a.h);
        this.b.a.v;
        a.a(arrayList, this.a.getChecked() ^ 1);
        if (this.b.a.h != null && this.b.a.h.getTaskStatus() != 8) {
            com.xunlei.downloadprovider.download.report.a.d("sure", this.b.a.h.mCreateOrigin);
        } else if (this.b.a.h != null) {
            com.xunlei.downloadprovider.download.report.a.a("sure", this.a.getChecked(), this.b.a.h.mCreateOrigin);
        }
        this.b.a.a(true);
        this.a.dismiss();
    }
}
