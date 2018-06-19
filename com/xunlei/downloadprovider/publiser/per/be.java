package com.xunlei.downloadprovider.publiser.per;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.h;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.xllib.android.b;

/* compiled from: HistoryPublishVideoItemViewHolder */
final class be implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ bc b;

    be(bc bcVar, Context context) {
        this.b = bcVar;
        this.a = context;
    }

    public final void onClick(View view) {
        this.b.c.dismiss();
        a.e(this.b.f.getVideoId(), o.a(this.b.g), "shortvideo");
        if (b.a(this.a) == null) {
            XLToast.showToast(this.a, "无网络连接");
        } else {
            new h().a(this.b.f.getVideoId(), this.b.f.getGcid(), new bf(this));
        }
    }
}
