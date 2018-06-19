package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailFragment.a;
import com.xunlei.xllib.android.b;

/* compiled from: WebsiteDetailFragment */
final class ai implements OnClickListener {
    final /* synthetic */ WebsiteDetailFragment a;

    ai(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            WebsiteDetailFragment.l(this.a);
            this.a.c();
            this.a.l.setVisibility(8);
            ((a) this.a.mActivity).a(false);
        }
    }
}
