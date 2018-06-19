package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailFragment.a;

/* compiled from: WebsiteDetailFragment */
final class ab implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ WebsiteDetailFragment b;

    ab(WebsiteDetailFragment websiteDetailFragment, boolean z) {
        this.b = websiteDetailFragment;
        this.a = z;
    }

    public final void run() {
        if (this.b.mActivity != null) {
            if (!this.b.mActivity.isFinishing()) {
                this.b.j.b = this.a;
                ((a) this.b.mActivity).a(this.b.j);
            }
        }
    }
}
