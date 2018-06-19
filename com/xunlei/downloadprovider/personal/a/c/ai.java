package com.xunlei.downloadprovider.personal.a.c;

import com.sina.weibo.sdk.utils.NetworkHelper;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;

/* compiled from: UserInfoViewHolder */
final class ai implements c<PublisherInfo> {
    final /* synthetic */ s a;

    public final void onFail(String str) {
    }

    ai(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        obj = ((PublisherInfo) obj).b();
        String a = j.a((long) obj.c);
        String a2 = j.a((long) obj.b);
        this.a.s.setText(a);
        this.a.t.setText(a2);
        s.L = a;
        s.M = a2;
        a a3 = a.a();
        if (NetworkHelper.isNetworkAvailable(a.b())) {
            a3.a("key_user_follow_count", a);
            a3.a("key_user_fans_count", a2);
        }
    }
}
