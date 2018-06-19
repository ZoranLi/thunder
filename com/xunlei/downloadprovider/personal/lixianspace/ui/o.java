package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: LXSpaceCreateTaskByMagnetUrlActivity */
final class o implements OnClickListener {
    final /* synthetic */ LXSpaceCreateTaskByMagnetUrlActivity a;

    o(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity) {
        this.a = lXSpaceCreateTaskByMagnetUrlActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.d != null) {
            this.a.d.dismiss();
            this.a.d = null;
        }
    }
}
