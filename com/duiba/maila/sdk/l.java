package com.duiba.maila.sdk;

import android.text.TextUtils;
import com.duiba.maila.sdk.MailaActivityInSdk.a;

final class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    l(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void run() {
        MailaActivityInSdk mailaActivityInSdk = this.b.a;
        String str = this.a;
        StringBuilder stringBuilder = new StringBuilder("javascript:callbackGPS('");
        stringBuilder.append(str);
        stringBuilder.append("')");
        Object stringBuilder2 = stringBuilder.toString();
        if (!TextUtils.isEmpty(stringBuilder2)) {
            mailaActivityInSdk.a.loadUrl(stringBuilder2);
        }
    }
}
