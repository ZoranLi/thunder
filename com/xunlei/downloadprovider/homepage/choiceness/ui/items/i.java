package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: ChoicenessLiveStoryItemView */
final class i extends ItemDecoration {
    final /* synthetic */ ChoicenessLiveStoryItemView a;

    i(ChoicenessLiveStoryItemView choicenessLiveStoryItemView) {
        this.a = choicenessLiveStoryItemView;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        view = recyclerView.getChildPosition(view);
        recyclerView = (float) DipPixelUtil.dip2px(15.0f);
        if (view == this.a.b.getItemCount() - 1) {
            recyclerView = (float) DipPixelUtil.dip2px(10.0f);
        }
        rect.set((int) (view == null ? (float) DipPixelUtil.dip2px(10.0f) : null), 0, (int) recyclerView, 0);
    }
}
