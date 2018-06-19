package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.android.b;

/* compiled from: RedEnvelopesActivity */
final class j implements OnClickListener {
    final /* synthetic */ RedEnvelopesActivity a;

    j(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void onClick(View view) {
        if (b.a(this.a.getApplicationContext()) == null) {
            XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
            return;
        }
        this.a.g;
        if (l.c() == null) {
            this.a.b();
            return;
        }
        this.a.d.setVisibility(8);
        this.a.a();
    }
}
