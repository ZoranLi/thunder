package com.xunlei.downloadprovider.contentpublish.website.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.f.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.b.a;

/* compiled from: WebsiteCardView */
final class i implements OnClickListener {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (a.d(this.a)) {
            if (this.a.s == null) {
                this.a.s = new j(this, view);
            }
            view = c.a(this.a.r.h(), this.a.v, this.a.w);
            com.xunlei.downloadprovidershare.b.c b = a.b();
            if (LoginHelper.a().g.c() > 0 && this.a.w.getUid().equals(String.valueOf(LoginHelper.a().g.c()))) {
                b.a(ShareOperationType.REPORT);
            }
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.b((Activity) this.a.getContext(), view, this.a.s, b);
            this.a.r.g();
        }
    }
}
