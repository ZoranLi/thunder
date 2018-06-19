package com.xunlei.downloadprovider.ad.common.adget;

import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.common.report.e;
import java.util.List;

/* compiled from: PreCacheTask */
final class q implements a {
    final /* synthetic */ byte a;
    final /* synthetic */ b$a b;
    final /* synthetic */ p c;

    q(p pVar, byte b, b$a com_xunlei_downloadprovider_ad_common_c_b_a) {
        this.c = pVar;
        this.a = b;
        this.b = com_xunlei_downloadprovider_ad_common_c_b_a;
    }

    public final void a(List<l> list) {
        this.c.b = (byte) (this.c.b | this.a);
        l lVar = (list == null || list.size() == 0) ? null : (l) list.get(0);
        if (lVar != null) {
            this.c.e.put(Byte.valueOf(this.a), list.get(0));
        } else {
            this.c.f.put(Byte.valueOf(this.a), Integer.valueOf(-13));
        }
        String a = ADConst.a(this.a);
        if (lVar != null) {
            this.b.a();
            k.a("adv_request_success", k.a(a, this.c.a, this.c.d), this.b);
        } else {
            this.b.a();
            k.a("adv_request_fail", k.a(this.c.a, this.c.d, a, e.a(-13, "")), this.b);
        }
        this.c.c();
    }

    public final void a(int i, String str) {
        this.c.b = (byte) (this.c.b | this.a);
        this.c.f.put(Byte.valueOf(this.a), Integer.valueOf(i));
        String a = ADConst.a(this.a);
        this.b.a();
        k.a("adv_request_fail", k.a(this.c.a, this.c.d, a, e.a(i, str)), this.b);
        this.c.c();
    }
}
