package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.shortvideo.videodetail.bv;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: RecommendWebsiteViewHolder */
final class al implements OnClickListener {
    final /* synthetic */ ak a;

    al(ak akVar) {
        this.a = akVar;
    }

    public final void onClick(View view) {
        a.a();
        a.a(this.a.itemView.getContext(), this.a.h.f, true, BrowserFrom.VIDEO_DETAIL_RECOMMEND_WEBSITE);
        bv.b(this.a.f, this.a.h.a, this.a.g.getUid(), this.a.g.getKind());
    }
}
