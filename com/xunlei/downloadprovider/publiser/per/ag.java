package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: HistoryLikeWebsiteViewHolder */
final class ag implements OnClickListener {
    final /* synthetic */ WebsiteInfo a;
    final /* synthetic */ af b;

    ag(af afVar, WebsiteInfo websiteInfo) {
        this.b = afVar;
        this.a = websiteInfo;
    }

    public final void onClick(View view) {
        if (this.a == null) {
            XLToast.showToast(view.getContext(), "该链接已删除");
            return;
        }
        a.a();
        a.a(view.getContext(), this.a.f, true, BrowserFrom.SHORTVIDEO_USERCENTER_URL);
    }
}
