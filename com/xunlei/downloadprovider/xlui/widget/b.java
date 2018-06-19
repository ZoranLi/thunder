package com.xunlei.downloadprovider.xlui.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PagerSlidingTabStrip */
final class b implements OnClickListener {
    final /* synthetic */ PagerSlidingTabStrip a;

    b(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.a = pagerSlidingTabStrip;
    }

    public final void onClick(View view) {
        int indexOfChild = this.a.d.indexOfChild(view);
        if (this.a.g != indexOfChild) {
            this.a.C = indexOfChild;
            this.a.g = indexOfChild;
            this.a.b(indexOfChild);
            this.a.e.setCurrentItem(indexOfChild);
        } else {
            OnClickListener onClickListener = (OnClickListener) this.a.b.get(view.getTag());
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
        if (this.a.p != null) {
            this.a.p;
        }
    }
}
