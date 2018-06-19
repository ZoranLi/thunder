package com.xunlei.downloadprovider.web.website.e;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.website.g.a;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: CollectionUpdateViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        view = a.a().a;
        if (view != null && !TextUtils.isEmpty(view.b)) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a(this.a.p, view.b, false, BrowserFrom.COLLECT_WEBSITE_UPDATE);
            b.a();
            b.f();
            if (this.a.z != null) {
                this.a.z.g = false;
                this.a.z.notifyDataSetChanged();
            }
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_url_action", "collect_website_update_click"));
        }
    }
}
