package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.xllib.android.b;

/* compiled from: RedEnvelopesDetailActivity */
final class c implements OnClickListener {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    c(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void onClick(View view) {
        if (b.a(this.a.getApplicationContext()) == null) {
            XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
            return;
        }
        this.a.p.setVisibility(8);
        this.a.a();
    }
}
