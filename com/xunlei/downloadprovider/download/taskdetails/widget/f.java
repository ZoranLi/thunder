package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskDetailActionSheetDialog */
final class f implements OnClickListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.onClick(view);
        }
        this.a.dismiss();
    }
}
