package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: SchemeDISPBrowser */
final class i extends d {
    i() {
    }

    protected final boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        intent = intent.getData();
        if (!a.c(intent) || "/browser".equals(intent.getPath()) == null) {
            return false;
        }
        return true;
    }

    protected final void a(Context context, Intent intent) {
        intent = intent.getData();
        Object queryParameter = intent.getQueryParameter("url");
        String a = a.a(intent);
        if (!TextUtils.isEmpty(queryParameter)) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a(context, 16, queryParameter, true, BrowserFrom.fromString(a, BrowserFrom.OTHER));
            c.a(a, a.b(intent));
            c.a(DispatchConstants.OTHER, true);
        }
    }
}
