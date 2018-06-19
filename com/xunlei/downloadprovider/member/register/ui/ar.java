package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.downloadprovider.member.login.b.i;
import java.util.HashMap;

/* compiled from: RegisterSuccessActivity */
final class ar implements OnClickListener {
    final /* synthetic */ RegisterSuccessActivity a;

    ar(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void onClick(View view) {
        if (this.a.c == 1) {
            view = new HashMap();
            view.put(USERINFOKEY.NickName, this.a.r);
            view.put(USERINFOKEY.Sex, RegisterSuccessActivity.j(this.a));
            i.a(this.a.e.q, view, null);
            this.a.v = new as(this);
            this.a.e.a(this.a.v);
            return;
        }
        this.a.finish();
    }
}
