package com.xunlei.downloadprovider.publiser.websitetopic;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: WebsiteTopicActivity */
final class c implements OnClickListener {
    final /* synthetic */ WebsiteTopicActivity a;

    c(WebsiteTopicActivity websiteTopicActivity) {
        this.a = websiteTopicActivity;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) == null) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "无网络连接");
            WebsiteTopicActivity.a(this.a, 2);
            return;
        }
        this.a.d.setVisibility(8);
        this.a.a();
        this.a.h.a(false);
    }
}
