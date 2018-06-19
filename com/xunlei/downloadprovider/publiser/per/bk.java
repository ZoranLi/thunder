package com.xunlei.downloadprovider.publiser.per;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.xllib.android.b;

/* compiled from: HistoryPublishWebsiteViewHolder */
final class bk implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ bh b;

    bk(bh bhVar, Context context) {
        this.b = bhVar;
        this.a = context;
    }

    public final void onClick(View view) {
        this.b.b.dismiss();
        a.e(this.b.e.a, o.a(this.b.f), "web_url");
        if (b.a(this.a) == null) {
            XLToast.showToast(this.a, "无网络连接");
        } else {
            new com.xunlei.downloadprovider.contentpublish.website.a.b().a(this.b.e.a, new bl(this));
        }
    }
}
