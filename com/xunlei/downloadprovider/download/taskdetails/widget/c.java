package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskDetailActionSheetDialog */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.c != null) {
            this.a.c.onClick(view);
        }
    }
}
