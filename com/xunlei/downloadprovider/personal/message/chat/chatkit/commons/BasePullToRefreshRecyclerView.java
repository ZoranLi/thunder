package com.xunlei.downloadprovider.personal.message.chat.chatkit.commons;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public abstract class BasePullToRefreshRecyclerView<T extends RecyclerView> extends PullToRefreshBase<T> {
    public BasePullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public BasePullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public BasePullToRefreshRecyclerView(Context context, AttributeSet attributeSet) {
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
}
