package com.xunlei.downloadprovider.personal.a.b.c;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: UserOneGridViewHolder */
final class o implements g {
    final /* synthetic */ k a;

    o(k kVar) {
        this.a = kVar;
    }

    public final void onLogout() {
        if (TextUtils.equals("my_gift", this.a.g.c)) {
            this.a.d.setVisibility(8);
            this.a.c.setText("");
            this.a.g.e = "";
            return;
        }
        this.a.a(this.a.g);
    }
}
