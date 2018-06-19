package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.xllib.android.b;

/* compiled from: ShortMovieDetailFragment */
final class aw implements OnClickListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    aw(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onClick(View view) {
        this.a.B.dismiss();
        if (b.a(this.a.mActivity) == null) {
            XLToast.showToast(this.a.mActivity, "无网络连接");
            return;
        }
        view = this.a.B.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        this.a.c.a(view.getId());
        bv.a(view.getId(), view.isHot(), "delete");
    }
}
