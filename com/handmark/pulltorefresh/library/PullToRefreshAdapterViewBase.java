package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import com.handmark.pulltorefresh.library.PullToRefreshBase.a;
import com.handmark.pulltorefresh.library.a.d;
import com.xunlei.common.R;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements OnScrollListener {
    public boolean a = null;
    private boolean b;
    private OnScrollListener c;
    private a d;
    private View e;
    private d f;
    private d g;
    private boolean h;
    private boolean i = true;

    public void a() {
    }

    public void b() {
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, Mode mode) {
        super(context, mode);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public boolean getShowIndicator() {
        return this.h;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.d != null) {
            boolean z = i3 > 0 && i + i2 >= i3 - 2;
            this.b = z;
        }
        a();
        if (getShowIndicatorInternal()) {
            e();
        }
        if (this.c != null) {
            this.c.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.d != null && this.b) {
            this.d.a();
        }
        if (this.c != null) {
            this.c.onScrollStateChanged(absListView, i);
        }
        if (this.a != null) {
            if (isRefreshing() == null) {
                if (this.mRefreshableView.getLastVisiblePosition() >= ((AbsListView) this.mRefreshableView).getCount() - 3 && this.mOnRefreshListener2 != null) {
                    this.mState = State.REFRESHING;
                    this.mOnRefreshListener2.onPullUpToRefresh(this);
                }
            }
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AdapterView) this.mRefreshableView).setAdapter(listAdapter);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        if (this.mRefreshableView instanceof ExpandableListView) {
            ((ExpandableListView) this.mRefreshableView).setAdapter(expandableListAdapter);
        }
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            LayoutParams layoutParams = view.getLayoutParams();
            LayoutParams layoutParams2 = null;
            if (layoutParams != null) {
                layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    layoutParams2.gravity = ((LinearLayout.LayoutParams) layoutParams).gravity;
                } else {
                    layoutParams2.gravity = 17;
                }
            }
            if (layoutParams2 != null) {
                refreshableViewWrapper.addView(view, layoutParams2);
            } else {
                refreshableViewWrapper.addView(view);
            }
        }
        if (this.mRefreshableView instanceof com.handmark.pulltorefresh.library.a.a) {
            ((com.handmark.pulltorefresh.library.a.a) this.mRefreshableView).setEmptyViewInternal(view);
        } else {
            ((AbsListView) this.mRefreshableView).setEmptyView(view);
        }
        this.e = view;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        ((AbsListView) this.mRefreshableView).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(a aVar) {
        this.d = aVar;
    }

    public final void setOnScrollListener(OnScrollListener onScrollListener) {
        this.c = onScrollListener;
    }

    public final void setScrollEmptyView(boolean z) {
        this.i = z;
    }

    public void setShowIndicator(boolean z) {
        this.h = z;
        if (getShowIndicatorInternal()) {
            c();
        } else {
            d();
        }
    }

    protected void onPullToRefresh() {
        super.onPullToRefresh();
        if (getShowIndicatorInternal()) {
            switch (e.a[getCurrentMode().ordinal()]) {
                case 1:
                    this.g.e();
                    return;
                case 2:
                    this.f.e();
                    break;
                default:
                    break;
            }
        }
    }

    protected void onRefreshing(boolean z) {
        super.onRefreshing(z);
        if (getShowIndicatorInternal()) {
            e();
        }
    }

    protected void onReleaseToRefresh() {
        super.onReleaseToRefresh();
        if (getShowIndicatorInternal()) {
            switch (e.a[getCurrentMode().ordinal()]) {
                case 1:
                    this.g.d();
                    return;
                case 2:
                    this.f.d();
                    break;
                default:
                    break;
            }
        }
    }

    protected void onReset() {
        super.onReset();
        if (getShowIndicatorInternal()) {
            e();
        }
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
        this.h = typedArray.getBoolean(R.styleable.PullToRefresh_ptrShowIndicator, isPullToRefreshOverScrollEnabled() ^ 1);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.e != 0 && this.i == 0) {
            this.e.scrollTo(-i, -i2);
        }
    }

    protected void updateUIForMode() {
        super.updateUIForMode();
        if (getShowIndicatorInternal()) {
            c();
        } else {
            d();
        }
    }

    private void c() {
        Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.showHeaderLoadingLayout() && this.f == null) {
            this.f = new d(getContext(), Mode.PULL_FROM_START);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.f, layoutParams);
        } else if (!(mode.showHeaderLoadingLayout() || this.f == null)) {
            refreshableViewWrapper.removeView(this.f);
            this.f = null;
        }
        if (mode.showFooterLoadingLayout() && this.g == null) {
            this.g = new d(getContext(), Mode.PULL_FROM_END);
            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.g, layoutParams2);
            return;
        }
        if (!(mode.showFooterLoadingLayout() || this.g == null)) {
            refreshableViewWrapper.removeView(this.g);
            this.g = null;
        }
    }

    private boolean getShowIndicatorInternal() {
        return this.h && isPullToRefreshEnabled();
    }

    private void d() {
        if (this.f != null) {
            getRefreshableViewWrapper().removeView(this.f);
            this.f = null;
        }
        if (this.g != null) {
            getRefreshableViewWrapper().removeView(this.g);
            this.g = null;
        }
    }

    private void e() {
        if (this.f != null) {
            if (isRefreshing() || !isReadyForPullStart()) {
                if (this.f.a()) {
                    this.f.b();
                }
            } else if (!this.f.a()) {
                this.f.c();
            }
        }
        if (this.g != null) {
            if (isRefreshing() || !isReadyForPullEnd()) {
                if (this.g.a()) {
                    this.g.b();
                }
            } else if (!this.g.a()) {
                this.g.c();
            }
        }
    }

    protected boolean needResetToHeadBegin() {
        int count = this.mRefreshableView == null ? 0 : ((ListAdapter) ((AbsListView) this.mRefreshableView).getAdapter()).getCount();
        if (getMode().showHeaderLoadingLayout()) {
            count--;
        }
        if (getMode().showFooterLoadingLayout()) {
            count--;
        }
        if (count <= 0) {
            return true;
        }
        return false;
    }

    protected boolean isReadyForPullStart() {
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter != null) {
            if (!adapter.isEmpty()) {
                if (((AbsListView) this.mRefreshableView).getFirstVisiblePosition() <= 1) {
                    View childAt = ((AbsListView) this.mRefreshableView).getChildAt(0);
                    if (childAt == null || childAt.getTop() < ((AbsListView) this.mRefreshableView).getTop()) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    protected boolean isReadyForPullEnd() {
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter != null) {
            if (!adapter.isEmpty()) {
                int count = ((AbsListView) this.mRefreshableView).getCount() - 1;
                int lastVisiblePosition = ((AbsListView) this.mRefreshableView).getLastVisiblePosition();
                if (lastVisiblePosition >= count - 1) {
                    View childAt = ((AbsListView) this.mRefreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.mRefreshableView).getFirstVisiblePosition());
                    if (childAt == null || childAt.getBottom() - 1 > ((AbsListView) this.mRefreshableView).getBottom()) {
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
