package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadCenterActivityFragment */
final class h implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    h(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        View<e> b = this.a.n.b();
        List arrayList = new ArrayList();
        if (b.size() != 0) {
            String a = a.a(b);
            Object obj = null;
            long j = 0;
            for (e eVar : b) {
                if (eVar.b() != null) {
                    long j2;
                    if (eVar.b().mIsFileMissing || eVar.b().mDownloadedSize == 0) {
                        if (!eVar.b().mIsFileMissing) {
                            if (j != 0) {
                                j2 = j;
                            }
                        }
                        j2 = j + 1;
                    } else {
                        j2 = j + eVar.b().mDownloadedSize;
                    }
                    if (eVar.b().getTaskStatus() == 8) {
                        arrayList.add(eVar);
                        if (obj == null) {
                            obj = 1;
                        }
                    }
                    j = j2;
                }
            }
            View zVar = new z(this.a.getActivity(), arrayList.size(), b.size() - arrayList.size(), j);
            if (obj == null) {
                zVar.setCheckStr(null);
            }
            zVar.setBtnLeftClickListener(new i(this, a, zVar));
            zVar.setBtnRightClickListener(new j(this, arrayList, zVar, a));
            zVar.show();
        }
    }
}
