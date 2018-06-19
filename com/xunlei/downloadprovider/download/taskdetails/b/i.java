package com.xunlei.downloadprovider.download.taskdetails.b;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskCommentController */
final class i implements OnClickListener {
    final /* synthetic */ b a;

    i(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        this.a.u.dismiss();
        if (this.a.u.a == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
    }
}
