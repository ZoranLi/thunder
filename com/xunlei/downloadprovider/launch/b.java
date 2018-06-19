package com.xunlei.downloadprovider.launch;

import com.xunlei.downloadprovider.app.a.d.c;

/* compiled from: LaunchActivity */
final class b extends c {
    final /* synthetic */ long a;
    final /* synthetic */ LaunchActivity b;

    b(LaunchActivity launchActivity, long j) {
        this.b = launchActivity;
        this.a = j;
    }

    public final void a() {
        LaunchActivity.a = true;
        this.b.b();
        long currentTimeMillis = System.currentTimeMillis() - this.a;
        StringBuilder stringBuilder = new StringBuilder("End init----------- costTime = ");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("ms");
    }
}
