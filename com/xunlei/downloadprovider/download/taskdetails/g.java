package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class g implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    g(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        this.a.k.dismiss();
        if (view.getId() == R.id.delete_Button) {
            if (this.a.h != null) {
                long j;
                long j2;
                View zVar;
                if (this.a.h.mIsFileMissing == null) {
                    if (this.a.h.mDownloadedSize != 0) {
                        j = this.a.h.mDownloadedSize;
                        j2 = j;
                        if (this.a.h.getTaskStatus() != 8) {
                            zVar = new z(this.a.getContext(), 1, 0, j2);
                        } else {
                            zVar = new z(this.a.getContext(), 0, 1, j2);
                        }
                        if (!(this.a.h == null || this.a.h.getTaskStatus() == 8)) {
                            view.setCheckStr(null);
                        }
                        view.setBtnLeftClickListener(new h(this, view));
                        view.setBtnRightClickListener(new i(this, view));
                        view.show();
                        a.a("dl_more_delete", this.a.h);
                    }
                }
                j = 1;
                j2 = j;
                if (this.a.h.getTaskStatus() != 8) {
                    zVar = new z(this.a.getContext(), 0, 1, j2);
                } else {
                    zVar = new z(this.a.getContext(), 1, 0, j2);
                }
                view.setCheckStr(null);
                view.setBtnLeftClickListener(new h(this, view));
                view.setBtnRightClickListener(new i(this, view));
                view.show();
                a.a("dl_more_delete", this.a.h);
            }
        }
    }
}
