package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.text.TextUtils;
import com.xunlei.downloadprovider.personal.redenvelope.g.a;

/* compiled from: RedEnvelopesDetailActivity */
final class f implements a {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    f(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void a(String str) {
        this.a.v = false;
        if (!(this.a.s == null || TextUtils.isEmpty(this.a.s.l))) {
            this.a.s.e = 2;
            this.a.runOnUiThread(new g(this));
        }
        RedEnvelopesDetailActivity.a(this.a, str);
    }

    public final void a() {
        this.a.v = false;
        RedEnvelopesDetailActivity.k(this.a);
    }
}
