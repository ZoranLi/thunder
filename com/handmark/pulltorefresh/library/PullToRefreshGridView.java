package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.xunlei.common.R;

public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {

    class a extends GridView implements com.handmark.pulltorefresh.library.a.a {
        final /* synthetic */ PullToRefreshGridView a;

        public a(PullToRefreshGridView pullToRefreshGridView, Context context, AttributeSet attributeSet) {
            this.a = pullToRefreshGridView;
            super(context, attributeSet);
        }

        public void setEmptyView(View view) {
            this.a.setEmptyView(view);
        }

        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    @TargetApi(9)
    final class b extends a {
        final /* synthetic */ PullToRefreshGridView b;

        public b(PullToRefreshGridView pullToRefreshGridView, Context context, AttributeSet attributeSet) {
            this.b = pullToRefreshGridView;
            super(pullToRefreshGridView, context, attributeSet);
        }

        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            i5 = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            c.a(this.b, i, i3, i2, i4, z);
            return i5;
        }
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        View bVar;
        if (VERSION.SDK_INT >= 9) {
            bVar = new b(this, context, attributeSet);
        } else {
            bVar = new a(this, context, attributeSet);
        }
        bVar.setId(R.id.gridview);
        return bVar;
    }
}
