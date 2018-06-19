package com.xunlei.downloadprovider.search.ui.widget;

import java.util.ArrayList;

/* compiled from: SearchHistoryListView */
final class h implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ g b;

    h(g gVar, ArrayList arrayList) {
        this.b = gVar;
        this.a = arrayList;
    }

    public final void run() {
        if (this.b.b.a != null) {
            b b = this.b.b.a;
            ArrayList arrayList = this.a;
            b.a = arrayList;
            if (arrayList == null || arrayList.size() == 0) {
                b.b.setVisibility(8);
            } else {
                b.b.setVisibility(0);
            }
            b.notifyDataSetChanged();
        }
        if (this.a.size() == 0) {
            this.b.a.a();
            return;
        }
        this.b.b.c.setVisibility(0);
        this.b.b.d.setVisibility(0);
        this.b.a.b();
    }
}
