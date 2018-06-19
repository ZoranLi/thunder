package com.xunlei.downloadprovider.download.tasklist.list.download.a;

import android.view.View;

/* compiled from: SampleSnapshotTagViewHolder */
public final class a implements f {
    private View a;

    /* compiled from: SampleSnapshotTagViewHolder */
    public interface a {
        void a();
    }

    public a(View view) {
        this.a = view;
    }

    public final void a(int i) {
        if (this.a != null) {
            this.a.setVisibility(i);
        }
    }

    public final int a() {
        return this.a != null ? this.a.getVisibility() : 8;
    }
}
