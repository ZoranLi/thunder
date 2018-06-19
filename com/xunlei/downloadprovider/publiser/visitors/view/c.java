package com.xunlei.downloadprovider.publiser.visitors.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: UnfollowFooterViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        LoginHelper.a();
        if (l.c() != null) {
            b.a(this.a, this.a.d);
        } else {
            b.b(this.a, this.a.d);
        }
    }
}
