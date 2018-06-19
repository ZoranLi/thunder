package com.xunlei.downloadprovider.download.giftdispatch.utils;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: GiftDispatchingDataManager */
final class d implements a {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    d(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (volleyError != null) {
            a.b;
            StringBuilder stringBuilder = new StringBuilder("requestGiftDispathingData - ");
            stringBuilder.append(this.a);
            stringBuilder.append(" error: ");
            stringBuilder.append(volleyError.toString());
        }
        this.b.b.c();
    }
}
