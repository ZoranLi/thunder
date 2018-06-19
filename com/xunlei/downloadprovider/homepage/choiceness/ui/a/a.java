package com.xunlei.downloadprovider.homepage.choiceness.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: BaseExposureAdapter */
public abstract class a<T> extends com.xunlei.downloadprovider.search.ui.a.a<T> {
    public int a = null;
    protected long b;
    private boolean c;

    public void a(int i, boolean z) {
    }

    public void b() {
    }

    public a(Context context) {
        super(context);
    }

    public final boolean a() {
        return this.a == 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (a() == null && this.c != null) {
            view = null;
            if (System.currentTimeMillis() - this.b <= 1000) {
                view = true;
            }
            a(i, view);
        }
        return 0;
    }

    public void notifyDataSetChanged() {
        this.b = System.currentTimeMillis();
        super.notifyDataSetChanged();
    }

    public void a(boolean z) {
        this.c = true;
    }

    public void c() {
        this.c = false;
    }
}
