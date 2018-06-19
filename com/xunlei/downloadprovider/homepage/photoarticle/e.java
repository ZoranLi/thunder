package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;

/* compiled from: PhotoArticleDetailActivity */
final class e implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    e(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        this.a.n.dismiss();
        view = this.a.n.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ClipboardUtil.copyToClipboard(this.a, view.getContent(), "text");
        XLToast.showToast(this.a, "复制成功");
        y.a(this.a.f, this.a.h(), "copy", view.getId());
    }
}
