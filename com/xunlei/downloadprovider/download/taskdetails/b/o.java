package com.xunlei.downloadprovider.download.taskdetails.b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskCommentController */
final class o implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ b b;

    o(b bVar, Dialog dialog) {
        this.b = bVar;
        this.a = dialog;
    }

    public final void onClick(View view) {
        this.a.dismiss();
    }
}
