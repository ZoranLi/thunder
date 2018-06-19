package com.xunlei.downloadprovider.personal.a.c;

import com.sina.weibo.sdk.utils.NetworkHelper;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper.a;

/* compiled from: UserInfoViewHolder */
final class aj implements a {
    final /* synthetic */ s a;

    aj(s sVar) {
        this.a = sVar;
    }

    public final void a(int i) {
        long j = (long) i;
        CharSequence a = j.a(j);
        this.a.S = j;
        this.a.u.setText(a);
        s.N = i;
        com.xunlei.downloadprovider.personal.a.a a2 = com.xunlei.downloadprovider.personal.a.a.a();
        if (NetworkHelper.isNetworkAvailable(com.xunlei.downloadprovider.personal.a.a.b())) {
            a2.a("key_user_visitor_count", i);
        }
    }
}
