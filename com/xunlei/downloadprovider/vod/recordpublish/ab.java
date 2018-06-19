package com.xunlei.downloadprovider.vod.recordpublish;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.d;

/* compiled from: XlpsHotTopicDivider */
public final class ab extends ItemDecoration {
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (recyclerView.getChildAdapterPosition(view) == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, d.a(BrothersApplication.getApplicationInstance(), 30.0f), 0, 0);
        }
    }
}
