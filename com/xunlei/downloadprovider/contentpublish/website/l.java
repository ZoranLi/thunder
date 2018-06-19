package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.contentpublish.website.a.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;

/* compiled from: WebsiteDetailFragment */
final class l implements OnClickListener {
    final /* synthetic */ WebsiteDetailFragment a;

    l(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onClick(View view) {
        view = this.a.t.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ReportActivity.a(this.a.mActivity, 5, view.getId(), this.a.i.a, this.a.i.a, DispatchConstants.OTHER);
        this.a.t.dismiss();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.i.a);
        a.a(stringBuilder.toString(), this.a.al.getUid(), view.getId(), "jubao");
    }
}
