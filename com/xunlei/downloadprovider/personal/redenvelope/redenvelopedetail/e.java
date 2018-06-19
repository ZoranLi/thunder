package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;

/* compiled from: RedEnvelopesDetailActivity */
final class e implements OnClickListener {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    e(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.s != null) {
            com.xunlei.downloadprovider.personal.redenvelope.e.a(this.a.getApplicationContext(), this.a.s.l);
            XLToast.showToast(this.a.getApplicationContext(), "复制成功");
        }
    }
}
