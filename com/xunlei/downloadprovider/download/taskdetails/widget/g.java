package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskDetailActionSheetDialog */
final class g implements OnClickListener {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.d != null) {
            this.a.d.onClick(view);
        }
        this.a.dismiss();
    }
}
