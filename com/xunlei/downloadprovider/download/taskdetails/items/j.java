package com.xunlei.downloadprovider.download.taskdetails.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.vod.floatwindow.a;

/* compiled from: DetailOpenBarViewHolder */
final class j implements OnClickListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        if ((this.a.h != null ? this.a.h.E() : null) == null) {
            if (a.a != null) {
                if (this.a.itemView.getContext() != null) {
                    XLToast.showToast(this.a.itemView.getContext(), "悬浮窗口正在播放视频");
                }
                return;
            }
            if (!(this.a.f == null || this.a.n == null)) {
                view = this.a.f.b();
                if (view != null) {
                    view.a(this.a.n);
                }
            }
        }
    }
}
