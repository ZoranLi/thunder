package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskDetailActionSheetDialog */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.onClick(view);
        }
        this.a.dismiss();
    }
}
