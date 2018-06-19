package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;

/* compiled from: DynamicLikeVideoViewHolder */
final class g implements OnClickListener {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void onClick(View view) {
        int status = this.a.g.getRelatedVideoInfo().getStatus();
        if (status == 0) {
            XLToast.showToast(view.getContext(), "该视频已下线");
            return;
        }
        if (status != 2) {
            if (status != -2) {
                if (!(this.a.d == null || this.a.g == null)) {
                    this.a.d.a(0, this.a.g);
                }
                return;
            }
        }
        XLToast.showToast(view.getContext(), "该视频已删除");
    }
}
