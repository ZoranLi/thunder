package com.xunlei.downloadprovider.download.taskdetails.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskCommentController */
final class f implements OnClickListener {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        this.a.u.dismiss();
        view = this.a.u.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ClipboardUtil.copyToClipboard(this.a.i, view.getBaseCommentInfo().getContent(), "text");
        XLToast.showToast(this.a.i, "复制成功");
        String n = this.a.l;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(view.getBaseCommentInfo().getId());
        a.c(n, stringBuilder.toString(), "copy");
    }
}
