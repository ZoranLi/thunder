package com.xunlei.downloadprovider.download.taskdetails.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: TaskCommentController */
final class p implements OnDismissListener {
    final /* synthetic */ b a;

    p(b bVar) {
        this.a = bVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.t.show();
    }
}
