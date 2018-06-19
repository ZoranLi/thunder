package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: BaseBtFileExplorerActivity */
final class h implements OnClickListener {
    final /* synthetic */ BaseBtFileExplorerActivity a;

    h(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        this.a = baseBtFileExplorerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (BaseBtFileExplorerActivity.j(this.a) != null) {
            BaseBtFileExplorerActivity.j(this.a).dismiss();
            BaseBtFileExplorerActivity.k(this.a);
        }
        this.a.d();
    }
}
