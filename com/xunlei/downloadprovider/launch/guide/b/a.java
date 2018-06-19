package com.xunlei.downloadprovider.launch.guide.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: GuideBaseView */
public abstract class a extends FrameLayout {
    protected final Context a;
    protected final com.xunlei.downloadprovider.launch.guide.p.a b;
    protected int c;

    public abstract void a(int i);

    public View getView() {
        return this;
    }

    public a(Context context, com.xunlei.downloadprovider.launch.guide.p.a aVar) {
        super(context);
        this.a = context;
        this.b = aVar;
    }

    public int getItemTag() {
        return this.c;
    }

    public void setItemTag(int i) {
        this.c = i;
    }
}
