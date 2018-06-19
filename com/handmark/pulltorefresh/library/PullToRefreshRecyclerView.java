package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {

    final class a extends RecyclerView {
        final /* synthetic */ PullToRefreshRecyclerView a;

        public a(PullToRefreshRecyclerView pullToRefreshRecyclerView, Context context, AttributeSet attributeSet) {
            this.a = pullToRefreshRecyclerView;
            super(context, attributeSet);
        }

        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            i5 = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            c.a(this.a, i, i3, i2, i4, z);
            return i5;
        }
    }

    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected boolean isReadyForPullEnd() {
        Adapter adapter = ((RecyclerView) this.mRefreshableView).getAdapter();
        if (adapter != null) {
            if (adapter.getItemCount() != 0) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ((RecyclerView) this.mRefreshableView).getLayoutManager();
                int itemCount = adapter.getItemCount();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (findLastVisibleItemPosition >= itemCount - 1) {
                    View childAt = ((RecyclerView) this.mRefreshableView).getChildAt(findLastVisibleItemPosition - linearLayoutManager.findFirstVisibleItemPosition());
                    if (childAt == null || childAt.getBottom() - 1 > ((RecyclerView) this.mRefreshableView).getBottom()) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    protected boolean isReadyForPullStart() {
        Adapter adapter = ((RecyclerView) this.mRefreshableView).getAdapter();
        if (adapter != null) {
            if (adapter.getItemCount() != 0) {
                if (((LinearLayoutManager) ((RecyclerView) this.mRefreshableView).getLayoutManager()).findFirstVisibleItemPosition() == 0) {
                    View childAt = ((RecyclerView) this.mRefreshableView).getChildAt(0);
                    if (childAt == null || childAt.getTop() < ((RecyclerView) this.mRefreshableView).getTop()) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        return new a(this, context, attributeSet);
    }
}
