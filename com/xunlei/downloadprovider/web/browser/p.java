package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import com.xunlei.downloadprovider.contentpublish.website.a.l;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: BrowserActivity */
final class p implements c<l> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ BrowserActivity c;

    p(BrowserActivity browserActivity, String str, String str2) {
        this.c = browserActivity;
        this.a = str;
        this.b = str2;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        l lVar = (l) obj;
        String str = "";
        if (lVar != null && lVar.a() && !TextUtils.isEmpty(this.a) && this.a.equals(this.c.D)) {
            str = lVar.c;
            this.c.z = lVar.b;
            this.c.E = lVar.c;
            this.c.v = lVar.b;
        }
        obj = this.c.z;
        if (TextUtils.isEmpty(obj)) {
            obj = this.a;
        }
        if (TextUtils.isEmpty(obj)) {
            obj = this.b;
        }
        b.a().a(obj, this.b, str);
    }

    public final void onFail(String str) {
        b.a().a(this.c.z, this.b, "");
    }
}
