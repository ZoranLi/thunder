package com.xunlei.downloadprovider.homepage.follow.ui;

import android.text.TextUtils;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.payment.a.e$e;
import java.util.List;

/* compiled from: FollowFragment */
final class d implements e$e<List<a>, String, Boolean> {
    final /* synthetic */ FollowFragment a;

    d(FollowFragment followFragment) {
        this.a = followFragment;
    }

    public final /* synthetic */ void a(Object obj, Object obj2, Object obj3) {
        List list = (List) obj;
        String str = (String) obj2;
        Boolean bool = (Boolean) obj3;
        this.a.j = false;
        this.a.g = str;
        this.a.h = bool.booleanValue();
        this.a.d.setVisibility(8);
        if (list.size() > null) {
            FollowFragment.a(this.a, list);
            if (this.a.b != null) {
                this.a.b.a();
            }
        }
        if (bool.booleanValue() == null) {
            this.a.e.b(new e(this.a));
        }
        this.a.a.a();
    }

    public final void a() {
        this.a.j = false;
        this.a.a.a();
        if (TextUtils.isEmpty(this.a.g)) {
            this.a.d.setVisibility(8);
            this.a.b();
        }
    }
}
