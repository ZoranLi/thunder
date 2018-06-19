package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTaskMoreOperationDialog */
final class aj implements OnClickListener {
    final /* synthetic */ af a;

    aj(af afVar) {
        this.a = afVar;
    }

    public final void onClick(View view) {
        long j;
        long j2;
        a.b("delete", a.a(this.a.g), this.a.j);
        if (this.a.g.mIsFileMissing == null) {
            if (this.a.g.mDownloadedSize != 0) {
                j = this.a.g.mDownloadedSize;
                j2 = j;
                if (this.a.g.getTaskStatus() != 8) {
                    this.a.i = new z(this.a.getContext(), 1, 0, j2);
                } else {
                    this.a.i = new z(this.a.getContext(), 0, 1, j2);
                }
                if (!(this.a.g == null || this.a.g.getTaskStatus() == 8)) {
                    this.a.i.setCheckStr(null);
                }
                this.a.i.setBtnLeftClickListener(new ak(this));
                this.a.i.setBtnRightClickListener(new al(this));
                this.a.i.show();
                this.a.dismiss();
            }
        }
        j = 1;
        j2 = j;
        if (this.a.g.getTaskStatus() != 8) {
            this.a.i = new z(this.a.getContext(), 0, 1, j2);
        } else {
            this.a.i = new z(this.a.getContext(), 1, 0, j2);
        }
        this.a.i.setCheckStr(null);
        this.a.i.setBtnLeftClickListener(new ak(this));
        this.a.i.setBtnRightClickListener(new al(this));
        this.a.i.show();
        this.a.dismiss();
    }
}
