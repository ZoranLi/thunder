package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import android.text.TextUtils;
import com.xunlei.downloadprovider.personal.redenvelope.g.a;

/* compiled from: RedEnvelopesActivity */
final class m implements a {
    final /* synthetic */ RedEnvelopesActivity a;

    m(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void a(String str) {
        this.a.l = false;
        if (!(this.a.n == null || TextUtils.isEmpty(this.a.n.j))) {
            this.a.n.e = 2;
            this.a.h.notifyDataSetChanged();
            RedEnvelopesActivity.a(this.a, this.a.n);
        }
        RedEnvelopesActivity.a(this.a, str);
    }

    public final void a() {
        this.a.l = false;
        RedEnvelopesActivity.s(this.a);
    }
}
