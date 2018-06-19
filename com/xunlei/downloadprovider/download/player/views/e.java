package com.xunlei.downloadprovider.download.player.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovidershare.a.f;

/* compiled from: ThunderCommandDialog */
final class e implements OnClickListener {
    final /* synthetic */ f a;
    final /* synthetic */ c b;

    e(c cVar, f fVar) {
        this.b = cVar;
        this.a = fVar;
    }

    public final void onClick(View view) {
        m.a().a(this.a.f);
        ClipboardUtil.copyToClipboardWithToast(this.b.getContext(), this.a.f);
        a.d(this.b.a, this.b.b.a, "copy");
        this.b.dismiss();
    }
}
