package com.xunlei.downloadprovider.download.taskdetails.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.xllib.android.b;

/* compiled from: TaskCommentController */
final class h implements OnClickListener {
    final /* synthetic */ b a;

    h(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        this.a.u.dismiss();
        if (b.a(this.a.i) == null) {
            XLToast.showToast(this.a.i, "无网络连接");
            return;
        }
        view = this.a.u.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        this.a.v.a(view.getBaseCommentInfo().getId());
    }
}
