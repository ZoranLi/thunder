package com.xunlei.downloadprovider.launch.guide.b;

import android.app.Activity;
import android.view.ViewStub;
import com.xunlei.downloadprovider.launch.guide.p.a;

/* compiled from: GuideBottomView */
public abstract class d {
    protected final Activity a;
    protected final ViewStub b;
    protected final a c;

    protected abstract int a();

    public d(Activity activity, ViewStub viewStub, a aVar) {
        this.a = activity;
        this.b = viewStub;
        this.c = aVar;
        this.b.setLayoutResource(a());
        this.b.inflate();
    }
}
