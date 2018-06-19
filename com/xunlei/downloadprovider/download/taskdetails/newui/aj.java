package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.control.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadDetailsActivityFragment */
final class aj implements OnClickListener {
    final /* synthetic */ z a;
    final /* synthetic */ DownloadDetailsActivityFragment b;

    aj(DownloadDetailsActivityFragment downloadDetailsActivityFragment, z zVar) {
        this.b = downloadDetailsActivityFragment;
        this.a = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        List arrayList = new ArrayList();
        arrayList.add(this.b.f);
        this.b.w;
        a.a(arrayList, this.a.getChecked() ^ 1);
        if (this.b.f != null && this.b.f.getTaskStatus() != 8) {
            com.xunlei.downloadprovider.download.report.a.d("sure", this.b.f.mCreateOrigin);
        } else if (this.b.g != null) {
            com.xunlei.downloadprovider.download.report.a.a("sure", this.a.getChecked(), this.b.f.mCreateOrigin);
        }
        this.a.dismiss();
        this.b.j();
    }
}
