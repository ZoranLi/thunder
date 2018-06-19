package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;

/* compiled from: HistoryCommentWebsiteViewHolder */
final class n implements OnClickListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final void onClick(View view) {
        if (this.a.i == null) {
            XLToast.showToast(view.getContext(), "该链接已删除");
            return;
        }
        if (this.a.j != null) {
            this.a.j.a(11, this.a.g);
        }
    }
}
