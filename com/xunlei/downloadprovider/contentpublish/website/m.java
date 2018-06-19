package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.contentpublish.website.a.a;
import com.xunlei.xllib.android.b;

/* compiled from: WebsiteDetailFragment */
final class m implements OnClickListener {
    final /* synthetic */ WebsiteDetailFragment a;

    m(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onClick(View view) {
        this.a.t.dismiss();
        if (b.a(this.a.mActivity) == null) {
            XLToast.showToast(this.a.mActivity, "无网络连接");
            return;
        }
        view = this.a.t.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        this.a.c.a(view.getId());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.i.a);
        a.a(stringBuilder.toString(), this.a.al.getUid(), view.getId(), "delete");
    }
}
