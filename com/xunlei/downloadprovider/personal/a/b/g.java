package com.xunlei.downloadprovider.personal.a.b;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: UserGridItemDecoration */
public final class g extends ItemDecoration {
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        state = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        rect.left = 0;
        rect.bottom = 0;
        view = recyclerView.getChildLayoutPosition(view);
        if (view % state == null) {
            rect.left = 0;
        }
        View view2 = h.a;
        state = DipPixelUtil.dip2px(5.0f);
        int i = view2 % 3;
        if (i == 0) {
            if (view == view2 - 3 || view == view2 - 2 || view == view2 - 1) {
                rect.bottom = state;
            }
        } else if (i == 1) {
            if (view == view2 - 1 || view == view2 || view == view2 + 1) {
                rect.bottom = state;
            }
        } else if (i == 2 && (view == view2 - 2 || view == view2 - 1 || view == view2)) {
            rect.bottom = state;
        }
    }
}
