package com.xunlei.downloadprovider.xlui.widget.extendviewpager;

import android.database.DataSetObserver;

/* compiled from: CircleIndicator */
final class b extends DataSetObserver {
    final /* synthetic */ CircleIndicator a;

    b(CircleIndicator circleIndicator) {
        this.a = circleIndicator;
    }

    public final void onChanged() {
        super.onChanged();
        if (this.a.a != null) {
            int d = this.a.getPagerAdapterCount();
            if (d != this.a.getChildCount()) {
                if (this.a.n < d) {
                    this.a.n = this.a.a.getCurrentItem();
                } else {
                    this.a.n = -1;
                }
                this.a.a();
            }
        }
    }
}
