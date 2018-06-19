package com.xunlei.downloadprovider.download.tasklist.list.feed.a;

import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

/* compiled from: TouTiaoAuthManager */
final class b implements a<a.a> {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    b(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final /* synthetic */ void a(Object obj) {
        a.a aVar = (a.a) obj;
        new StringBuilder("requestToken onSuccess tokenInfo: ").append(aVar.toString());
        a.a(this.b, aVar);
        if (this.a != null) {
            this.a.a(aVar);
        }
    }

    public final void a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("requestToken onFail. errorCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" errorInfo: ");
        stringBuilder.append(str);
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a("token", i, str);
        if (this.a != null) {
            this.a.a(i, str);
        }
    }
}
