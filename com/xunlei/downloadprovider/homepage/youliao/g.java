package com.xunlei.downloadprovider.homepage.youliao;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.cardslide.CardSlideActivity;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.web.a;

/* compiled from: YouliaoVideoFragment */
final class g implements OnClickListener {
    final /* synthetic */ YouliaoVideoFragment a;

    g(YouliaoVideoFragment youliaoVideoFragment) {
        this.a = youliaoVideoFragment;
    }

    public final void onClick(View view) {
        if (d.a().r.a() == 1) {
            view = d.a().r.b();
            a.a();
            a.a(this.a.getContext(), k.a.e(view), "", "");
            a.a(com.xunlei.xllib.b.k.a(view, "UTF-8"));
            return;
        }
        CardSlideActivity.a(this.a.mActivity, "shortvideo_youliao_banner");
        a.a("CardSlideActivity");
    }
}
