package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;

/* compiled from: DownloadTaskMoreOperationDialog */
final class an implements OnClickListener {
    final /* synthetic */ af a;

    an(af afVar) {
        this.a = afVar;
    }

    public final void onClick(View view) {
        PrivateSpaceMgr.a();
        if (PrivateSpaceMgr.b() != null) {
            PrivateSpaceMgr.a();
            if (PrivateSpaceMgr.h() == null) {
                af.e(this.a);
                this.a.dismiss();
            }
        }
        PrivateSpaceMgr.a(this.a.mCtx, "bottom_menu", this.a.k);
        this.a.dismiss();
    }
}
