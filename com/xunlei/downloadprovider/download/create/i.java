package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: BaseBtFileExplorerActivity */
final class i implements OnClickListener {
    final /* synthetic */ BaseBtFileExplorerActivity a;

    i(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        this.a = baseBtFileExplorerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (BaseBtFileExplorerActivity.j(this.a) != null) {
            BaseBtFileExplorerActivity.j(this.a).dismiss();
            BaseBtFileExplorerActivity.k(this.a);
        }
    }
}
