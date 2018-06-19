package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: FollowBtnView */
final class a implements OnClickListener {
    final /* synthetic */ FollowBtnView a;

    a(FollowBtnView followBtnView) {
        this.a = followBtnView;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            LoginHelper.a();
            boolean c = l.c();
            if (c != null) {
                FollowBtnView.a(this.a, this.a.a);
            } else {
                LoginHelper.a().a(this.a.getContext(), new c(this.a, this.a.a.getUid(), this.a.a), this.a.c.b(), null);
            }
            if (this.a.c != null) {
                this.a.c.a(c);
            }
        }
    }
}
