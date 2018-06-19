package com.xunlei.downloadprovider.download.create;

import android.text.TextUtils;
import com.alipay.sdk.util.e;
import com.xunlei.downloadprovidershare.q$a;

/* compiled from: CreateUrlTaskActivity */
final class y implements q$a {
    final /* synthetic */ CreateUrlTaskActivity a;

    y(CreateUrlTaskActivity createUrlTaskActivity) {
        this.a = createUrlTaskActivity;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(e.b)) {
                this.a.runOnUiThread(new z(this, str));
            }
        }
    }
}
