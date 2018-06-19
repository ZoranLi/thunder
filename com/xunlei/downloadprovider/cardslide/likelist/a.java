package com.xunlei.downloadprovider.cardslide.likelist;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: CardLikeItemDecoration */
final class a extends ItemDecoration {
    private Context a;

    a(Context context) {
        this.a = context;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        state = recyclerView.getAdapter().getItemCount();
        rect.bottom = DipPixelUtil.dip2px(0.0f);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.top = 0;
        }
        if (recyclerView.getChildLayoutPosition(view) == state - 1) {
            rect.bottom = DipPixelUtil.dip2px(5.0f);
        }
    }
}
