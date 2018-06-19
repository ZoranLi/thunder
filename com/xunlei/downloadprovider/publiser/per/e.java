package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;

/* compiled from: DynamicCommentVideoViewHolder */
final class e implements OnClickListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        int status = this.a.h.getRelatedVideoInfo().getStatus();
        if (status == 0) {
            XLToast.showToast(view.getContext(), "该视频已下线");
            return;
        }
        if (status != 2) {
            if (status != -2) {
                if (!(this.a.i == null || this.a.h == null)) {
                    this.a.i.a(0, this.a.h);
                }
                return;
            }
        }
        XLToast.showToast(view.getContext(), "该视频已删除");
    }
}
