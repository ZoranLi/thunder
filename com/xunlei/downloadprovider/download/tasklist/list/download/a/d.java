package com.xunlei.downloadprovider.download.tasklist.list.download.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: SnapshotTagViewHolder */
final class d implements OnClickListener {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        view = this.a;
        if (view.c != null) {
            view.c.setVisibility(0);
            View view2 = view.b;
            int[] iArr = view.e;
            if (view2 != null) {
                view.a.getLocationInWindow(view.d);
                view2.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - view.d[0];
                iArr[1] = iArr[1] - view.d[1];
            }
            int width = view.c.getWidth();
            int height = view.c.getHeight();
            if (width <= 0) {
                width = DipPixelUtil.dip2px(117.0f);
            }
            if (height <= 0) {
                height = DipPixelUtil.dip2px(29.0f);
            }
            LayoutParams layoutParams = view.c.getLayoutParams();
            int i = view.e[0];
            int i2 = view.e[1];
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                i2 -= height;
                width = (view.b.getWidth() / 2) + (i - (width / 2));
                if (width < 0) {
                    width = 0;
                }
                layoutParams2.setMargins(width, i2, 0, 0);
                view.c.setLayoutParams(layoutParams2);
            }
            view.c.removeCallbacks(view.f);
            view.c.postDelayed(view.f, 5000);
        }
    }
}
