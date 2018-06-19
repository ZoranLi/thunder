package com.xunlei.downloadprovider.vod.manager;

import com.xunlei.downloadprovider.member.payment.a.e$b;
import com.xunlei.downloadprovider.member.payment.a.e$d;

/* compiled from: VideoPublishManager */
public final class k implements e$d<String, String> {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ e$b f;
    final /* synthetic */ j g;

    public k(j jVar, String str, long j, long j2, String str2, String str3, e$b com_xunlei_downloadprovider_member_payment_a_e_b) {
        this.g = jVar;
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = str2;
        this.e = str3;
        this.f = com_xunlei_downloadprovider_member_payment_a_e_b;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        String str = (String) obj;
        j.a(this.a, str, (String) obj2, new l(this, str));
    }

    public final void a(String str) {
        if (this.f != null) {
            this.f.a(j.c);
        }
    }
}
