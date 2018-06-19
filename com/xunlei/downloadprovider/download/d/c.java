package com.xunlei.downloadprovider.download.d;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: AppSelectItemSpaceDecoration */
public final class c extends ItemDecoration {
    private int a;

    public c(int i) {
        this.a = i;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (recyclerView.getChildLayoutPosition(view) != null) {
            rect.left = this.a;
        }
    }
}
