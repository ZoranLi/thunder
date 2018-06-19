package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.a.a;

/* compiled from: WebsiteDetailFragment */
final class n implements OnClickListener {
    final /* synthetic */ WebsiteDetailFragment a;

    n(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onClick(View view) {
        this.a.t.dismiss();
        view = this.a.t.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.i.a);
        a.a(stringBuilder.toString(), this.a.al.getUid(), view.getId(), "cancel");
    }
}
