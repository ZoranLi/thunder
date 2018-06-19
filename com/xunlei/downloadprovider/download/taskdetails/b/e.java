package com.xunlei.downloadprovider.download.taskdetails.b;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskCommentController */
final class e implements OnCheckedChangeListener {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        a.a(this.a.l, "input", "", "if_progress");
    }
}
