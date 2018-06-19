package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.a.a;

/* compiled from: WebsiteDetailFragment */
final class k implements OnClickListener {
    final /* synthetic */ WebsiteDetailFragment a;

    k(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onClick(View view) {
        this.a.t.dismiss();
        view = this.a.t.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ClipboardUtil.copyToClipboard(BrothersApplication.getApplicationInstance(), view.getContent(), "text");
        XLToast.showToast(this.a.mActivity, "复制成功");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.i.a);
        a.a(stringBuilder.toString(), this.a.al.getUid(), view.getId(), "copy");
    }
}
