package com.xunlei.downloadprovider.homepage.follow.ui;

import android.support.v7.widget.RecyclerView.Adapter;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder;

/* compiled from: ExposureRecyclerViewAdapter */
public abstract class a extends Adapter<ViewHolder> {
    private int a = 0;
    private boolean b;

    protected abstract void a();

    protected abstract void a(int i, boolean z);

    private boolean c() {
        return this.a == 2;
    }

    public final void a(int i) {
        if (c() && this.a != i) {
            a();
        }
        this.a = i;
    }

    public int getItemViewType(int i) {
        if (!c() && this.b) {
            a(i, true);
        }
        return -1;
    }

    public void a(boolean z) {
        this.b = true;
    }

    public void b() {
        this.b = false;
    }
}
