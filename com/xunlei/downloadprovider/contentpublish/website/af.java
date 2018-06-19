package com.xunlei.downloadprovider.contentpublish.website;

import android.text.TextUtils;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailFragment.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsiteDetailFragment */
final class af implements c<WebsiteDetailInfo> {
    final /* synthetic */ WebsiteDetailFragment a;

    af(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        WebsiteDetailInfo websiteDetailInfo = (WebsiteDetailInfo) obj;
        if (!WebsiteDetailFragment.d(this.a)) {
            this.a.a(ITagManager.SUCCESS, websiteDetailInfo.b, websiteDetailInfo.a);
        }
    }

    public final void onFail(String str) {
        if (!WebsiteDetailFragment.d(this.a)) {
            this.a.v.hide();
            if (TextUtils.equals("not exist", str) != null) {
                this.a.i = null;
                this.a.l.setErrorType(1);
                this.a.l.setVisibility(0);
                this.a.l.a(null, null);
                this.a.l.a((int) R.drawable.commonui_bg_page_gone, (int) R.string.commonui_page_file_gone);
                this.a.l.setOnTouchListener(new ag(this));
                this.a.aj.setVisibility(8);
                ((a) this.a.mActivity).a(true);
                if (!(this.a.s == null || this.a.s.isShowing() == null)) {
                    this.a.s.dismiss();
                }
            }
        }
    }
}
