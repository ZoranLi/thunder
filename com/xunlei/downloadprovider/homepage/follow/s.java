package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.f;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FollowManager */
final class s implements e$d<a, List<a>> {
    final /* synthetic */ boolean a;
    final /* synthetic */ e$d b;
    final /* synthetic */ long c;
    final /* synthetic */ b d;

    s(b bVar, boolean z, e$d com_xunlei_downloadprovider_member_payment_a_e_d, long j) {
        this.d = bVar;
        this.a = z;
        this.b = com_xunlei_downloadprovider_member_payment_a_e_d;
        this.c = j;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        a aVar = (a) obj;
        List list = (List) obj2;
        if (this.a) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "关注成功");
        }
        if (this.d.b(aVar.b)) {
            this.b.a(aVar, list);
            return;
        }
        f fVar = new f(aVar.b, aVar.i, aVar.i);
        this.d.j.put(Long.valueOf(aVar.b), fVar);
        aVar.i = 0;
        b.a(this.d, aVar);
        b.a(new t(this, fVar));
        this.d.b.sendBroadcast(new XLIntent("new_follow"));
        List arrayList = new ArrayList(1);
        arrayList.add(String.valueOf(this.c));
        ab.a().a(false, arrayList);
        this.b.a(aVar, list);
    }

    public final void a(String str) {
        if (this.a) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), a.a(str));
        }
        this.b.a(str);
    }
}
