package com.xunlei.downloadprovider.xlui.recyclerview;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class XRecyclerView extends RecyclerView {
    public boolean a;
    public boolean b;
    public b c;
    public PullToRefreshHeaderView d;
    public boolean e;
    public final AdapterDataObserver f;
    private boolean g;
    private b h;
    private float i;
    private boolean j;
    private View k;
    private LoadingMoreFooterView l;
    private int m;
    private Adapter n;
    private boolean o;

    public interface b {
        void a();

        void b();
    }

    private class a extends AdapterDataObserver {
        final /* synthetic */ XRecyclerView a;

        private a(XRecyclerView xRecyclerView) {
            this.a = xRecyclerView;
        }

        public final void onItemRangeInserted(int i, int i2) {
            this.a.h.notifyItemRangeInserted(i + this.a.h.a.size(), i2);
        }

        public final void onItemRangeChanged(int i, int i2) {
            this.a.h.notifyItemRangeChanged(i + this.a.h.a.size(), i2);
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            this.a.h.notifyItemRangeChanged(i + this.a.h.a.size(), i2, obj);
        }

        public final void onItemRangeRemoved(int i, int i2) {
            this.a.h.notifyItemRangeRemoved(i + this.a.h.a.size(), i2);
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            this.a.h.notifyItemMoved(i + this.a.h.a.size(), i2 + this.a.h.a.size());
        }

        public final void onChanged() {
            Adapter adapter = this.a.getAdapter();
            if (!(adapter == null || this.a.k == null)) {
                if (adapter.getItemCount() != this.a.getHeaderViewsCount() + this.a.getFooterViewsCount() || this.a.b) {
                    this.a.k.setVisibility(8);
                    this.a.setVisibility(0);
                } else {
                    this.a.k.setVisibility(0);
                    this.a.setVisibility(8);
                }
            }
            if (this.a.h != null) {
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    public static class c implements b {
        public final void a() {
        }

        public void b() {
        }
    }

    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = -1.0f;
        this.e = true;
        this.j = true;
        this.f = new a();
        this.m = 6;
        this.o = false;
        if (this.e != null) {
            this.d = new PullToRefreshHeaderView(getContext());
        }
        scrollToPosition(0);
        this.l = new LoadingMoreFooterView(getContext());
        this.l.setVisibility(8);
    }

    public void setPullingRes(int i) {
        if (this.d != null) {
            this.d.setPullingGif(i);
        }
    }

    public int getHeaderViewsCount() {
        return this.h.a.size();
    }

    public int getFooterViewsCount() {
        return this.h.b.size();
    }

    public final void a(View view) {
        this.h.a(view);
        if (this.n != null) {
            this.n.notifyDataSetChanged();
        }
    }

    public final void b(View view) {
        b bVar = this.h;
        Object obj = null;
        if (view != null) {
            for (int i = 0; i < bVar.a.size(); i++) {
                if (((View) bVar.a.valueAt(i)) == view) {
                    bVar.a.removeAt(i);
                    obj = 1;
                    break;
                }
            }
        }
        if (obj != null && this.n != null) {
            this.n.notifyDataSetChanged();
        }
    }

    public final boolean c(View view) {
        b bVar = this.h;
        if (view != null) {
            for (int i = 0; i < bVar.a.size(); i++) {
                if (((View) bVar.a.valueAt(i)) == view) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a() {
        this.a = false;
        if (this.l != null) {
            this.l.setState(1);
        }
    }

    public void setNoMore(boolean z) {
        this.a = false;
        this.g = z;
        if (this.l) {
            this.l.setState(this.g ? 2 : 1);
        }
    }

    public void setLoadingBackgroundColor(int i) {
        this.l.setLoadingBackgroundColor(i);
    }

    public final void a(int i) {
        if (this.l != null) {
            if (i > 6) {
                this.l.setState(2);
                return;
            }
            this.l.setState(1);
        }
    }

    public final void b() {
        this.b = false;
        PullToRefreshHeaderView pullToRefreshHeaderView = this.d;
        pullToRefreshHeaderView.a(0);
        pullToRefreshHeaderView.a.postDelayed(new f(pullToRefreshHeaderView), 500);
        setNoMore(false);
        this.f.onChanged();
    }

    public void setPullRefreshEnabled(boolean z) {
        this.e = z;
    }

    public void setLoadingMoreEnabled(boolean z) {
        this.j = z;
        if (!z) {
            this.l.setState(1);
        }
    }

    public void setRestCountForLoadMore(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.m = i;
    }

    public void setEmptyView(View view) {
        this.k = view;
        this.f.onChanged();
    }

    public View getEmptyView() {
        return this.k;
    }

    public void setCheckLoadMoreInAllState(boolean z) {
        this.o = z;
    }

    public void setAdapter(android.support.v7.widget.RecyclerView.Adapter r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.n = r5;
        r0 = new com.xunlei.downloadprovider.xlui.recyclerview.b;
        r0.<init>(r5);
        r4.h = r0;
        r0 = r4.h;
        r1 = r4.d;
        r0.a(r1);
        r0 = r4.h;
        r1 = r4.l;
        r2 = r0.b;
        r0 = r0.b;
        r0 = r0.size();
        r3 = 200000; // 0x30d40 float:2.8026E-40 double:9.8813E-319;
        r0 = r0 + r3;
        r2.put(r0, r1);
        r0 = r4.h;
        super.setAdapter(r0);
        r0 = r4.f;	 Catch:{ IllegalStateException -> 0x002d }
        r5.registerAdapterDataObserver(r0);	 Catch:{ IllegalStateException -> 0x002d }
    L_0x002d:
        r5 = r4.f;
        r5.onChanged();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.setAdapter(android.support.v7.widget.RecyclerView$Adapter):void");
    }

    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (!this.o) {
            if (i != 0) {
                i = 0;
                if (i != 0 && this.a == 0 && this.j != 0) {
                    i = getLayoutManager();
                    int findLastVisibleItemPosition;
                    if (i instanceof GridLayoutManager) {
                        findLastVisibleItemPosition = ((GridLayoutManager) i).findLastVisibleItemPosition();
                    } else if (i instanceof StaggeredGridLayoutManager) {
                        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) i;
                        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                        findLastVisibleItemPosition = iArr[0];
                        int i2 = findLastVisibleItemPosition;
                        for (int i3 : iArr) {
                            if (i3 > i2) {
                                i2 = i3;
                            }
                        }
                        findLastVisibleItemPosition = i2;
                    } else {
                        findLastVisibleItemPosition = ((LinearLayoutManager) i).findLastVisibleItemPosition();
                    }
                    int i4 = i instanceof StaggeredGridLayoutManager ? this.m : 1;
                    int itemCount = i.getItemCount() - getHeaderViewsCount();
                    if (i.getChildCount() > 0 && r0 >= itemCount - i4 && itemCount > i.getChildCount() && this.g == 0 && this.d.getState() < 2) {
                        this.a = true;
                        if (this.l != 0) {
                            this.l.setState(0);
                        }
                        if (this.c != 0) {
                            this.c.b();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        i = 1;
        if (i != 0) {
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i == -1.0f) {
            this.i = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            int i = 0;
            if (action != 2) {
                this.i = -1.0f;
                if (e() && this.e) {
                    boolean z;
                    PullToRefreshHeaderView pullToRefreshHeaderView = this.d;
                    if (pullToRefreshHeaderView.getVisibleHeight() <= pullToRefreshHeaderView.d || pullToRefreshHeaderView.b >= 2) {
                        z = false;
                    } else {
                        pullToRefreshHeaderView.setState(2);
                        z = true;
                    }
                    if (pullToRefreshHeaderView.b == 2) {
                        i = pullToRefreshHeaderView.d;
                    }
                    pullToRefreshHeaderView.a(i);
                    if (z) {
                        this.b = true;
                        a();
                        c();
                    }
                }
            } else {
                float rawY = motionEvent.getRawY() - this.i;
                this.i = motionEvent.getRawY();
                if (e() && this.e) {
                    PullToRefreshHeaderView pullToRefreshHeaderView2 = this.d;
                    rawY /= 2.0f;
                    if (pullToRefreshHeaderView2.getVisibleHeight() > 0 || rawY > 0.0f) {
                        action = (int) (rawY + ((float) pullToRefreshHeaderView2.getVisibleHeight()));
                        pullToRefreshHeaderView2.setVisibleHeight(action);
                        if (action > pullToRefreshHeaderView2.d) {
                            pullToRefreshHeaderView2.setState(1);
                            rawY = 1.0f;
                        } else {
                            pullToRefreshHeaderView2.setState(0);
                            rawY = (((float) action) * 1.0f) / ((float) pullToRefreshHeaderView2.d);
                        }
                        if (pullToRefreshHeaderView2.c != null) {
                            if (rawY > 1.0f) {
                                rawY = 1.0f;
                            }
                            pullToRefreshHeaderView2.c.setMovieTime((int) (rawY * ((float) pullToRefreshHeaderView2.c.getDuration())));
                        }
                    }
                    if (this.d.getVisibleHeight() > 0 && this.d.getState() < 2) {
                        return false;
                    }
                }
            }
        }
        this.i = motionEvent.getRawY();
        return super.onTouchEvent(motionEvent);
    }

    public final void c() {
        if (this.c != null) {
            this.c.a();
        }
    }

    private boolean e() {
        return this.d.getParent() != null;
    }

    public void setLoadingListener(b bVar) {
        this.c = bVar;
    }

    public final void d() {
        if (!(this.b || !this.e || this.d.a())) {
            if (this.c != null) {
                this.b = true;
                int visibleHeight = this.d.getVisibleHeight();
                int wrapHeight = this.d.getWrapHeight();
                IntEvaluator intEvaluator = new IntEvaluator();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{visibleHeight, wrapHeight});
                ofInt.addUpdateListener(new k(this, intEvaluator, wrapHeight));
                ofInt.setDuration(300).start();
            }
        }
    }
}
