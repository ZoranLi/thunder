package com.xunlei.downloadprovider.xlui.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class XLTaskRecyclerView extends RecyclerView {
    private boolean a;
    private boolean b;
    private boolean c;
    private j d;
    private b e;
    private boolean f;
    private View g;
    private a h;
    private final AdapterDataObserver i;
    private int j;
    private Adapter k;

    public interface b {
        void a();
    }

    private class a extends AdapterDataObserver {
        final /* synthetic */ XLTaskRecyclerView a;

        private a(XLTaskRecyclerView xLTaskRecyclerView) {
            this.a = xLTaskRecyclerView;
        }

        public final void onItemRangeInserted(int i, int i2) {
            this.a.d.notifyItemRangeInserted(i, i2);
        }

        public final void onItemRangeChanged(int i, int i2) {
            this.a.d.notifyItemRangeChanged(i, i2);
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            this.a.d.notifyItemRangeChanged(i, i2, obj);
        }

        public final void onItemRangeRemoved(int i, int i2) {
            this.a.d.notifyItemRangeRemoved(i, i2);
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            this.a.d.notifyItemMoved(i, i2);
        }

        public final void onChanged() {
            Adapter adapter = this.a.getAdapter();
            if (!(adapter == null || this.a.g == null)) {
                if (adapter.getItemCount() != 0 || this.a.c) {
                    this.a.g.setVisibility(8);
                    this.a.setVisibility(0);
                } else {
                    this.a.g.setVisibility(0);
                    this.a.setVisibility(8);
                }
            }
            if (this.a.d != null) {
                this.a.d.notifyDataSetChanged();
            }
        }
    }

    public XLTaskRecyclerView(Context context) {
        this(context, null);
    }

    public XLTaskRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XLTaskRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.i = new a();
        this.j = 6;
        scrollToPosition(0);
        this.h = new a();
        this.h.c = 8;
    }

    public final void a() {
        this.a = false;
        if (this.h != null) {
            this.h.a(1);
        }
        c();
        b();
    }

    private void b() {
        if (this.k != null) {
            this.k.notifyDataSetChanged();
        }
    }

    public void setNoMore(boolean z) {
        this.a = false;
        this.b = z;
        if (this.h) {
            this.h.a(this.b ? 2 : 1);
        }
        b();
    }

    public void setLoadingMoreEnabled(boolean z) {
        this.f = z;
        if (!z) {
            this.h.a(1);
            c();
        }
    }

    private void c() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                ViewHolder childViewHolder = getChildViewHolder(childAt);
                if (childViewHolder != null && (childViewHolder instanceof e)) {
                    ((e) childViewHolder).a.setState(1);
                }
            }
        }
    }

    public void setRestCountForLoadMore(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.j = i;
    }

    public void setEmptyView(View view) {
        this.g = view;
        this.i.onChanged();
    }

    public View getEmptyView() {
        return this.g;
    }

    public void setAdapter(android.support.v7.widget.RecyclerView.Adapter r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.k = r4;
        r0 = new com.xunlei.downloadprovider.xlui.recyclerview.j;
        r0.<init>(r4);
        r3.d = r0;
        r0 = r3.d;
        r1 = r3.h;
        r2 = r0.a;
        r2.remove(r1);
        r2 = r0.a;
        r2.add(r1);
        r0.notifyDataSetChanged();
        r0 = r3.d;
        super.setAdapter(r0);
        r0 = r3.i;	 Catch:{ IllegalStateException -> 0x0024 }
        r4.registerAdapterDataObserver(r0);	 Catch:{ IllegalStateException -> 0x0024 }
    L_0x0024:
        r4 = r3.i;
        r4.onChanged();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.xlui.recyclerview.XLTaskRecyclerView.setAdapter(android.support.v7.widget.RecyclerView$Adapter):void");
    }

    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        StringBuilder stringBuilder = new StringBuilder("onScrollStateChanged ");
        stringBuilder.append(i);
        stringBuilder.append(" mIsLoadingData:");
        stringBuilder.append(this.a);
        stringBuilder.append(" MlOADINGm...");
        stringBuilder.append(this.f);
        if ((i == 0 || i == 2) && this.a == 0 && this.f != 0) {
            int findLastVisibleItemPosition;
            int i2;
            int itemCount;
            StringBuilder stringBuilder2;
            i = getLayoutManager();
            if (i instanceof GridLayoutManager) {
                findLastVisibleItemPosition = ((GridLayoutManager) i).findLastVisibleItemPosition();
            } else if (i instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) i;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                findLastVisibleItemPosition = a(iArr);
            } else {
                findLastVisibleItemPosition = ((LinearLayoutManager) i).findLastVisibleItemPosition();
            }
            if (!(i instanceof StaggeredGridLayoutManager)) {
                if (!(i instanceof LinearLayoutManager)) {
                    i2 = 1;
                    itemCount = i.getItemCount();
                    stringBuilder2 = new StringBuilder("layoutManager.getChildCount() ");
                    stringBuilder2.append(i.getChildCount());
                    stringBuilder2.append(" lastVisibleItemPosition");
                    stringBuilder2.append(findLastVisibleItemPosition);
                    stringBuilder2.append(" itemCount - restCount ");
                    i2 = itemCount - i2;
                    stringBuilder2.append(i2);
                    stringBuilder2.append("itemCount > layoutManager.getChildCount()");
                    stringBuilder2.append(itemCount <= i.getChildCount());
                    stringBuilder2.append("mIsNoMore ");
                    stringBuilder2.append(this.b);
                    if (i.getChildCount() > 0 && findLastVisibleItemPosition >= i2 && itemCount > i.getChildCount() && this.b == 0) {
                        this.a = true;
                        if (this.h != 0) {
                            this.h.a(0);
                        }
                        if (this.e != 0) {
                            this.e.a();
                        }
                        b();
                        return;
                    }
                    return;
                }
            }
            i2 = this.j;
            itemCount = i.getItemCount();
            stringBuilder2 = new StringBuilder("layoutManager.getChildCount() ");
            stringBuilder2.append(i.getChildCount());
            stringBuilder2.append(" lastVisibleItemPosition");
            stringBuilder2.append(findLastVisibleItemPosition);
            stringBuilder2.append(" itemCount - restCount ");
            i2 = itemCount - i2;
            stringBuilder2.append(i2);
            stringBuilder2.append("itemCount > layoutManager.getChildCount()");
            if (itemCount <= i.getChildCount()) {
            }
            stringBuilder2.append(itemCount <= i.getChildCount());
            stringBuilder2.append("mIsNoMore ");
            stringBuilder2.append(this.b);
            if (i.getChildCount() > 0) {
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private static int a(int[] iArr) {
        int i = 0;
        int i2 = iArr[0];
        int length = iArr.length;
        while (i < length) {
            int i3 = iArr[i];
            if (i3 > i2) {
                i2 = i3;
            }
            i++;
        }
        return i2;
    }

    public void setLoadingListener(b bVar) {
        this.e = bVar;
    }
}
