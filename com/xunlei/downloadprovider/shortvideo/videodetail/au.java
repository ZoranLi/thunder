package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: ShortMovieDetailFragment */
final class au implements OnClickListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    au(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onClick(View view) {
        this.a.B.dismiss();
        view = this.a.B.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ClipboardUtil.copyToClipboard(BrothersApplication.getApplicationInstance(), view.getContent(), "text");
        XLToast.showToast(this.a.mActivity, "复制成功");
        bv.a(view.getId(), view.isHot(), "copy");
    }
}
