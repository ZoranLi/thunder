package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.ad.common.browser.WebViewADActivity;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;

/* compiled from: SchemeDISPWebView */
final class o extends d {
    o() {
    }

    protected final boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        intent = intent.getData();
        if (!a.c(intent) || "/webview".equals(intent.getPath()) == null) {
            return false;
        }
        return true;
    }

    protected final void a(Context context, Intent intent) {
        intent = intent.getData();
        if (intent != null) {
            Object queryParameter = intent.getQueryParameter("url");
            String queryParameter2 = intent.getQueryParameter("title");
            String a = a.a(intent);
            if (!TextUtils.isEmpty(queryParameter)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_back", "back_push_web_view");
                WebViewADActivity.startWebViewADActivity(context, a, queryParameter, queryParameter2, bundle);
                c.a(a, a.b(intent));
                c.a(DispatchConstants.OTHER, true);
            }
        }
    }
}
