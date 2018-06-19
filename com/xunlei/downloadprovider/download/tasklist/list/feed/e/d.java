package com.xunlei.downloadprovider.download.tasklist.list.feed.e;

import android.os.Handler;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a;

/* compiled from: TaskListFeedNetwork */
public final class d implements a<a> {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ long c;
    final /* synthetic */ String d;
    final /* synthetic */ a e;
    final /* synthetic */ c f;

    public d(c cVar, int i, int i2, long j, String str, a aVar) {
        this.f = cVar;
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
        this.e = aVar;
    }

    public final /* synthetic */ void a(Object obj) {
        XLThreadPool.execute(new e(this, (a) obj));
    }

    public final void a(int i, String str) {
        if (this.e != 0) {
            new Handler(BrothersApplication.getApplicationInstance().getMainLooper()).post(new j(this));
        }
    }
}
