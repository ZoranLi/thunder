package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.util.a;

/* compiled from: TaskDetailActionSheetDialog */
final class e implements OnClickListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.l != null) {
            a.a(this.a.l, this.a.getContext());
            com.xunlei.downloadprovider.download.report.a.a("dl_more_copy", this.a.l);
            this.a.dismiss();
        }
    }
}
