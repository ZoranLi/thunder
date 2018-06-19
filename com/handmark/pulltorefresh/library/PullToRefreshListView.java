package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import com.handmark.pulltorefresh.library.a.f;
import com.xunlei.common.R;

public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {
    boolean b = false;
    private f c;
    private View d;
    private boolean e;
    private boolean f;
    private boolean g = false;

    protected class a extends ListView implements com.handmark.pulltorefresh.library.a.a {
        final /* synthetic */ PullToRefreshListView a;

        public a(PullToRefreshListView pullToRefreshListView, Context context, AttributeSet attributeSet) {
            this.a = pullToRefreshListView;
            super(context, attributeSet);
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
            super.onRestoreInstanceState(onSaveInstanceState());
        }

        public Parcelable onSaveInstanceState() {
            return super.onSaveInstanceState();
        }

        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
            } catch (Canvas canvas2) {
                canvas2.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (MotionEvent motionEvent2) {
                motionEvent2.printStackTrace();
                return null;
            }
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
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
        final /* synthetic */ PullToRefreshListView b;

        public b(PullToRefreshListView pullToRefreshListView, Context context, AttributeSet attributeSet) {
            this.b = pullToRefreshListView;
            super(pullToRefreshListView, context, attributeSet);
        }

        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            i5 = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            c.a(this.b, i, i3, i2, i4, z);
            return i5;
        }
    }

    public PullToRefreshListView(Context context) {
        super(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshListView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshListView(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected void onRefreshing(boolean z) {
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (this.e && getShowViewWhileRefreshing() && adapter != null) {
            if (!adapter.isEmpty()) {
                f footerLayout;
                int scrollY;
                int count;
                f fVar;
                super.onRefreshing(false);
                this.b = false;
                f fVar2 = null;
                switch (m.a[getCurrentMode().ordinal()]) {
                    case 1:
                    case 2:
                        footerLayout = getFooterLayout();
                        scrollY = getScrollY() - getFooterSize();
                        f fVar3 = this.c;
                        count = ((ListView) this.mRefreshableView).getCount() - 1;
                        fVar = null;
                        fVar2 = fVar3;
                        break;
                    default:
                        footerLayout = getHeaderLayout();
                        fVar = this.c;
                        scrollY = getHeaderSize() + getScrollY();
                        count = 0;
                        break;
                }
                footerLayout.g();
                footerLayout.c();
                if (fVar2 != null) {
                    fVar2.setVisibility(8);
                }
                if (fVar != null) {
                    fVar.setVisibility(0);
                    fVar.f();
                }
                if (z) {
                    disableLoadingLayoutVisibilityChanges();
                    setScrollValue(scrollY);
                    ((ListView) this.mRefreshableView).setSelection(count);
                    smoothScrollTo(0);
                }
                return;
            }
        }
        super.onRefreshing(z);
        this.b = true;
    }

    protected boolean needResetToHeadBegin() {
        return this.b;
    }

    protected void onReset() {
        if (this.e) {
            int count;
            f fVar = null;
            int i = 1;
            switch (m.a[getCurrentMode().ordinal()]) {
                case 1:
                case 2:
                    count = ((ListView) this.mRefreshableView).getCount() - 1;
                    getFooterSize();
                    Math.abs(((ListView) this.mRefreshableView).getLastVisiblePosition() - count);
                    count = 0;
                    break;
                default:
                    fVar = this.c;
                    count = -getHeaderSize();
                    if (Math.abs(((ListView) this.mRefreshableView).getFirstVisiblePosition() - 0) <= 1) {
                        break;
                    }
                    break;
            }
            i = 0;
            if (fVar != null && fVar.getVisibility() == 0) {
                fVar.setVisibility(8);
                if (!(i == 0 || getState() == State.MANUAL_REFRESHING)) {
                    ((ListView) this.mRefreshableView).setSelection(0);
                    setScrollValue(count);
                }
            }
            super.onReset();
            return;
        }
        super.onReset();
    }

    protected b createLoadingLayoutProxy(boolean z, boolean z2) {
        z2 = super.createLoadingLayoutProxy(z, z2);
        if (this.e) {
            Mode mode = getMode();
            if (z && mode.showHeaderLoadingLayout()) {
                z2.a(this.c);
            }
        }
        return z2;
    }

    public void setSelection(int i) {
        if (getRefreshableView() instanceof ListView) {
            ((ListView) getRefreshableView()).setSelection(i);
        }
    }

    public void scrollToTopAndRefreshing() {
        c();
    }

    public final void c() {
        if (canForceHeaderScroll()) {
            ((ListView) getRefreshableView()).setSelection(0);
            postDelayed(new l(this), 300);
        }
    }

    public void setSelector(int i) {
        if (getRefreshableView() instanceof ListView) {
            ((ListView) getRefreshableView()).setSelector(i);
        }
    }

    public int getLastVisiblePosition() {
        return getRefreshableView() instanceof ListView ? ((ListView) getRefreshableView()).getLastVisiblePosition() : -1;
    }

    public int getCount() {
        return ((ListView) getRefreshableView()).getCount();
    }

    public f getHeaderLoadingView() {
        return this.c;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
        super.handleStyledAttributes(typedArray);
        this.e = typedArray.getBoolean(R.styleable.PullToRefresh_ptrListViewExtrasEnabled, true);
        if (this.e) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            View frameLayout = new FrameLayout(getContext());
            this.c = createLoadingLayout(getContext(), Mode.PULL_FROM_START, typedArray);
            this.c.setVisibility(8);
            frameLayout.addView(this.c, layoutParams);
            ((ListView) this.mRefreshableView).addHeaderView(frameLayout, null, false);
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.common_pull_up_refresh_item, null);
            if (typedArray.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled) == null) {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
    }

    public void setFooterNeedShow(boolean z) {
        this.f = z;
        if (z) {
            a();
        } else {
            b();
        }
    }

    public final void a() {
        if (this.f && !this.g) {
            ((ListView) this.mRefreshableView).addFooterView(this.d, null, false);
            this.g = true;
        }
    }

    public final void b() {
        if (this.g) {
            ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
            if (adapter != null && (adapter instanceof HeaderViewListAdapter)) {
                ((ListView) this.mRefreshableView).removeFooterView(this.d);
            }
            this.g = false;
        }
    }

    public void onRefreshComplete() {
        super.onRefreshComplete();
        b();
    }

    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        View bVar;
        if (VERSION.SDK_INT >= 9) {
            bVar = new b(this, context, attributeSet);
        } else {
            bVar = new a(this, context, attributeSet);
        }
        bVar.setId(16908298);
        return bVar;
    }
}
