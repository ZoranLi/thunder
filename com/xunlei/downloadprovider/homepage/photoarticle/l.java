package com.xunlei.downloadprovider.homepage.photoarticle;

import com.xunlei.downloadprovider.homepage.photoarticle.a.a.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: PhotoArticleDetailActivity */
final class l implements c<a> {
    final /* synthetic */ PhotoArticleDetailActivity a;

    l(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        a aVar = (a) obj;
        if (aVar != null) {
            if (aVar.a()) {
                this.a.g = aVar.c;
                this.a.h = aVar.b;
                this.a.b();
                return;
            }
        }
        PhotoArticleDetailActivity.b(this.a);
    }

    public final void onFail(String str) {
        PhotoArticleDetailActivity.b(this.a);
    }
}
