package com.xunlei.downloadprovider.download.tasklist.list.download.a;

import android.view.View;
import com.xunlei.downloadprovider.R;

/* compiled from: SnapshotTagViewHolder */
public final class b implements f {
    View a;
    View b;
    View c;
    int[] d = new int[2];
    int[] e = new int[2];
    Runnable f = new c(this);

    public b(View view, View view2) {
        this.a = view;
        this.b = view2;
        this.c = this.a.findViewById(R.id.task_card_snapshot_tip_popup);
        if (this.b != null) {
            this.b.setOnClickListener(new d(this));
        }
        if (this.c != null) {
            this.c.setVisibility(8);
            this.c.setOnClickListener(new e(this));
        }
    }

    public final void a(int i) {
        if (this.b != null) {
            this.b.setVisibility(i);
        }
        if (i != 0) {
            a();
        }
    }

    public final void a() {
        if (this.c != null) {
            this.c.removeCallbacks(this.f);
            this.c.setVisibility(8);
        }
    }
}
