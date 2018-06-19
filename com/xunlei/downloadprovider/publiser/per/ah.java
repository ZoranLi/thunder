package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailActivity;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;

/* compiled from: HistoryLikeWebsiteViewHolder */
final class ah implements OnClickListener {
    final /* synthetic */ WebsiteInfo a;
    final /* synthetic */ af b;

    ah(af afVar, WebsiteInfo websiteInfo) {
        this.b = afVar;
        this.a = websiteInfo;
    }

    public final void onClick(View view) {
        if (this.a == null) {
            XLToast.showToast(view.getContext(), "该链接已删除");
        } else {
            WebsiteDetailActivity.a(view.getContext(), null, this.a, "shortvideo_channel_noticecard");
        }
    }
}
