package com.xunlei.downloadprovider.personal.a;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: UserSpaceItemDecoration */
public final class k extends ItemDecoration {
    private Context a;

    public k(Context context) {
        this.a = context;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        state = recyclerView.getAdapter().getItemCount();
        rect.bottom = DipPixelUtil.dip2px(5.0f);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.top = 0;
        }
        if (recyclerView.getChildLayoutPosition(view) == state - 1) {
            rect.bottom = DipPixelUtil.dip2px(5.0f);
        }
    }
}
