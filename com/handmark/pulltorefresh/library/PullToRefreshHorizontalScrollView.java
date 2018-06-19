package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.xunlei.common.R;

public class PullToRefreshHorizontalScrollView extends PullToRefreshBase<HorizontalScrollView> {

    @TargetApi(9)
    final class a extends HorizontalScrollView {
        final /* synthetic */ PullToRefreshHorizontalScrollView a;

        public a(PullToRefreshHorizontalScrollView pullToRefreshHorizontalScrollView, Context context, AttributeSet attributeSet) {
            this.a = pullToRefreshHorizontalScrollView;
            super(context, attributeSet);
        }

        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            c.a(this.a, i, i3, i2, i4, getChildCount() > 0 ? Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight())) : 0, z);
            return overScrollBy;
        }
    }

    public PullToRefreshHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.HORIZONTAL;
    }

    protected boolean isReadyForPullStart() {
        return ((HorizontalScrollView) this.mRefreshableView).getScrollX() == 0;
    }

    protected boolean isReadyForPullEnd() {
        View childAt = ((HorizontalScrollView) this.mRefreshableView).getChildAt(0);
        if (childAt == null || ((HorizontalScrollView) this.mRefreshableView).getScrollX() < childAt.getWidth() - getWidth()) {
            return false;
        }
        return true;
    }

    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        View aVar;
        if (VERSION.SDK_INT >= 9) {
            aVar = new a(this, context, attributeSet);
        } else {
            aVar = new HorizontalScrollView(context, attributeSet);
        }
        aVar.setId(R.id.scrollview);
        return aVar;
    }
}
