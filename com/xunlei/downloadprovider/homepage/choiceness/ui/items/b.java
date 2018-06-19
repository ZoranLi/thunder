package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: ChoicenessLiveGroupItemView */
final class b extends ItemDecoration {
    final /* synthetic */ ChoicenessLiveGroupItemView a;

    b(ChoicenessLiveGroupItemView choicenessLiveGroupItemView) {
        this.a = choicenessLiveGroupItemView;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        view = recyclerView.getChildPosition(view);
        recyclerView = (float) DipPixelUtil.dip2px(5.0f);
        if (view == this.a.b.getItemCount() - 1) {
            recyclerView = (float) DipPixelUtil.dip2px(13.0f);
        }
        rect.set((int) (view == null ? (float) DipPixelUtil.dip2px(12.0f) : null), 0, (int) recyclerView, 0);
    }
}
