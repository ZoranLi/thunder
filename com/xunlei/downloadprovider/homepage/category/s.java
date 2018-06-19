package com.xunlei.downloadprovider.homepage.category;

import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.xllib.b.k;

/* compiled from: ShortVideoCategoryDataHelper */
final class s implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ r c;

    s(r rVar, String str, c cVar) {
        this.c = rVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        if (TextUtils.isEmpty(this.a)) {
            this.b.onFail(null);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/cataract/api/v2/tag_card?page=0&size=8&tag=");
        stringBuilder.append(k.a(this.a, "UTF-8"));
        Request arVar = new ar(0, stringBuilder.toString(), new t(this), new u(this));
        arVar.setShouldCache(false);
        arVar.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        this.c.a(arVar);
    }
}
