package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.a.f;
import com.xunlei.common.R;

public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase<ExpandableListView> {
    private boolean b;
    private f c;
    private FrameLayout d;
    private f e;

    class a extends ExpandableListView implements com.handmark.pulltorefresh.library.a.a {
        final /* synthetic */ PullToRefreshExpandableListView a;

        public void smoothScrollToPosition(int i, int i2) {
        }

        public a(PullToRefreshExpandableListView pullToRefreshExpandableListView, Context context, AttributeSet attributeSet) {
            this.a = pullToRefreshExpandableListView;
            super(context, attributeSet);
        }

        public void setEmptyView(View view) {
            this.a.setEmptyView(view);
        }

        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }

        protected void onDetachedFromWindow() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            super.onDetachedFromWindow();	 Catch:{ IllegalArgumentException -> 0x0004 }
            return;
        L_0x0004:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.handmark.pulltorefresh.library.PullToRefreshExpandableListView.a.onDetachedFromWindow():void");
        }
    }

    @TargetApi(9)
    final class b extends a {
        final /* synthetic */ PullToRefreshExpandableListView b;

        public b(PullToRefreshExpandableListView pullToRefreshExpandableListView, Context context, AttributeSet attributeSet) {
            this.b = pullToRefreshExpandableListView;
            super(pullToRefreshExpandableListView, context, attributeSet);
        }

        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            i5 = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            c.a(this.b, i, i3, i2, i4, z);
            return i5;
        }
    }

    public PullToRefreshExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected void onRefreshing(boolean z) {
        ExpandableListAdapter expandableListAdapter = ((ExpandableListView) this.mRefreshableView).getExpandableListAdapter();
        if (this.b && getShowViewWhileRefreshing() && expandableListAdapter != null) {
            if (!expandableListAdapter.isEmpty()) {
                f footerLayout;
                f fVar;
                f fVar2;
                int count;
                int scrollY;
                super.onRefreshing(false);
                switch (k.a[getCurrentMode().ordinal()]) {
                    case 1:
                    case 2:
                        footerLayout = getFooterLayout();
                        fVar = this.e;
                        fVar2 = this.c;
                        count = ((ExpandableListView) this.mRefreshableView).getCount() - 1;
                        scrollY = getScrollY() - getFooterSize();
                        break;
                    default:
                        footerLayout = getHeaderLayout();
                        fVar = this.c;
                        fVar2 = this.e;
                        scrollY = getHeaderSize() + getScrollY();
                        count = 0;
                        break;
                }
                footerLayout.g();
                f.d();
                fVar2.setVisibility(8);
                fVar.setVisibility(0);
                fVar.f();
                if (z) {
                    disableLoadingLayoutVisibilityChanges();
                    setScrollValue(scrollY);
                    ((ExpandableListView) this.mRefreshableView).setSelection(count);
                    smoothScrollTo(0);
                }
                return;
            }
        }
        super.onRefreshing(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onReset() {
        /*
        r6 = this;
        r0 = r6.b;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        super.onReset();
        return;
    L_0x0008:
        r0 = com.handmark.pulltorefresh.library.k.a;
        r1 = r6.getCurrentMode();
        r1 = r1.ordinal();
        r0 = r0[r1];
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 1: goto L_0x0033;
            case 2: goto L_0x0033;
            default: goto L_0x0019;
        };
    L_0x0019:
        r6.getHeaderLayout();
        r0 = r6.c;
        r3 = r6.getHeaderSize();
        r4 = -r3;
        r3 = r6.mRefreshableView;
        r3 = (android.widget.ExpandableListView) r3;
        r3 = r3.getFirstVisiblePosition();
        r3 = r3 - r1;
        r3 = java.lang.Math.abs(r3);
        if (r3 > r2) goto L_0x0055;
    L_0x0032:
        goto L_0x0056;
    L_0x0033:
        r6.getFooterLayout();
        r0 = r6.e;
        r3 = r6.mRefreshableView;
        r3 = (android.widget.ExpandableListView) r3;
        r3 = r3.getCount();
        r3 = r3 - r2;
        r4 = r6.getFooterSize();
        r5 = r6.mRefreshableView;
        r5 = (android.widget.ExpandableListView) r5;
        r5 = r5.getLastVisiblePosition();
        r5 = r5 - r3;
        r5 = java.lang.Math.abs(r5);
        if (r5 > r2) goto L_0x0058;
    L_0x0054:
        goto L_0x0057;
    L_0x0055:
        r2 = r1;
    L_0x0056:
        r3 = r1;
    L_0x0057:
        r1 = r2;
    L_0x0058:
        r2 = r0.getVisibility();
        if (r2 != 0) goto L_0x007a;
    L_0x005e:
        com.handmark.pulltorefresh.library.a.f.h();
        r2 = 8;
        r0.setVisibility(r2);
        if (r1 == 0) goto L_0x007a;
    L_0x0068:
        r0 = r6.getState();
        r1 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.MANUAL_REFRESHING;
        if (r0 == r1) goto L_0x007a;
    L_0x0070:
        r0 = r6.mRefreshableView;
        r0 = (android.widget.ExpandableListView) r0;
        r0.setSelection(r3);
        r6.setScrollValue(r4);
    L_0x007a:
        super.onReset();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.handmark.pulltorefresh.library.PullToRefreshExpandableListView.onReset():void");
    }

    protected b createLoadingLayoutProxy(boolean z, boolean z2) {
        b createLoadingLayoutProxy = super.createLoadingLayoutProxy(z, z2);
        if (this.b) {
            Mode mode = getMode();
            if (z && mode.showHeaderLoadingLayout()) {
                createLoadingLayoutProxy.a(this.c);
            }
            if (z2 && mode.showFooterLoadingLayout()) {
                createLoadingLayoutProxy.a(this.e);
            }
        }
        return createLoadingLayoutProxy;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
        super.handleStyledAttributes(typedArray);
        this.b = typedArray.getBoolean(R.styleable.PullToRefresh_ptrListViewExtrasEnabled, true);
        if (this.b) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            View frameLayout = new FrameLayout(getContext());
            this.c = createLoadingLayout(getContext(), Mode.PULL_FROM_START, typedArray);
            this.c.setVisibility(8);
            frameLayout.addView(this.c, layoutParams);
            ((ExpandableListView) this.mRefreshableView).addHeaderView(frameLayout, null, false);
            this.d = new FrameLayout(getContext());
            this.e = createLoadingLayout(getContext(), Mode.PULL_FROM_END, typedArray);
            this.e.setVisibility(8);
            this.d.addView(this.e, layoutParams);
            if (typedArray.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled) == null) {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
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
