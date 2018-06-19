package com.xunlei.downloadprovider.download.create;

import android.text.TextUtils;
import com.xunlei.downloadprovider.contentpublish.website.a.l;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: ThunderTaskActivity */
final class ai implements c<l> {
    final /* synthetic */ String a;
    final /* synthetic */ ThunderTaskActivity b;

    ai(ThunderTaskActivity thunderTaskActivity, String str) {
        this.b = thunderTaskActivity;
        this.a = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        l lVar = (l) obj;
        String str = this.a;
        String str2 = "";
        if (lVar != null && lVar.a()) {
            if (!TextUtils.isEmpty(lVar.b)) {
                str = lVar.b;
            }
            if (!TextUtils.isEmpty(lVar.c)) {
                str2 = lVar.c;
            }
        }
        String str3 = str;
        String str4 = str2;
        b.a();
        b.a(this.b, this.a, str3, str4, "bho", null);
    }

    public final void onFail(String str) {
        b.a();
        b.a(this.b, this.a, this.a, "", "bho", null);
    }
}
