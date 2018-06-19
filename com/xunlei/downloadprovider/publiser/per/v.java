package com.xunlei.downloadprovider.publiser.per;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: HistoryDynamicItemFragment */
final class v extends ItemDecoration {
    final /* synthetic */ int a;
    final /* synthetic */ ColorDrawable b;
    final /* synthetic */ HistoryDynamicItemFragment c;

    v(HistoryDynamicItemFragment historyDynamicItemFragment, int i, ColorDrawable colorDrawable) {
        this.c = historyDynamicItemFragment;
        this.a = i;
        this.b = colorDrawable;
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        state = recyclerView.getChildCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i = 0; i < state; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (recyclerView.getChildAdapterPosition(childAt) < itemCount - 1) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int left = childAt.getLeft() - layoutParams.leftMargin;
                int right = childAt.getRight() + layoutParams.rightMargin;
                int bottom = childAt.getBottom() + layoutParams.bottomMargin;
                this.b.setBounds(left, bottom, right, this.a + bottom);
                this.b.draw(canvas);
            }
        }
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDrawOver(canvas, recyclerView, state);
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        view = recyclerView.getChildAdapterPosition(view);
        state = this.a;
        if (view == null || view == recyclerView.getAdapter().getItemCount() - 1) {
            state = null;
        }
        rect.bottom = state;
    }
}
