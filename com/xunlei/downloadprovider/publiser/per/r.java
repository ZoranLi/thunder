package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailActivity;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;

/* compiled from: HistoryCommentWebsiteViewHolder */
final class r implements OnClickListener {
    final /* synthetic */ WebsiteInfo a;

    r(WebsiteInfo websiteInfo) {
        this.a = websiteInfo;
    }

    public final void onClick(View view) {
        WebsiteDetailActivity.a(view.getContext(), null, this.a, "shortvideo_channel_noticecard");
    }
}
