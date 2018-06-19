package com.xunlei.downloadprovider.homepage.recommend.fans;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.recommend.fans.a.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: FansAndFollowItemView */
final class n implements a {
    final /* synthetic */ long a;
    final /* synthetic */ l b;

    n(l lVar, long j) {
        this.b = lVar;
        this.a = j;
    }

    public final void a() {
        this.b.f.setBackgroundResource(R.drawable.btn_unfollow_selector2);
        this.b.f.setText("已关注");
        long j;
        String a;
        switch (this.b.h) {
            case 1:
                j = this.b.g.b;
                a = l.b(this.b.g.c);
                this.b.j;
                com.xunlei.downloadprovider.homepage.recommend.a.a(j, a, l.c(), "success", null);
                return;
            case 2:
                j = this.b.g.b;
                a = l.b(this.b.g.c);
                this.b.j;
                h.a(j, a, l.c(), "success", null);
                return;
            case 3:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                String stringBuilder2 = stringBuilder.toString();
                String a2 = l.b(this.b.g.c);
                this.b.j;
                h.a(stringBuilder2, a2, l.c(), "success", null);
                break;
            default:
                break;
        }
    }

    public final void a(String str) {
        long j;
        String a;
        switch (this.b.h) {
            case 1:
                j = this.b.g.b;
                a = l.b(this.b.g.c);
                this.b.j;
                com.xunlei.downloadprovider.homepage.recommend.a.a(j, a, l.c(), "fail", str);
                return;
            case 2:
                j = this.b.g.b;
                a = l.b(this.b.g.c);
                this.b.j;
                h.a(j, a, l.c(), "fail", str);
                return;
            case 3:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                String stringBuilder2 = stringBuilder.toString();
                String a2 = l.b(this.b.g.c);
                this.b.j;
                h.a(stringBuilder2, a2, l.c(), "fail", str);
                break;
            default:
                break;
        }
    }
}
