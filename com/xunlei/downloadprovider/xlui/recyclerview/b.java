package com.xunlei.downloadprovider.xlui.recyclerview;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.common.stat.base.XLStatCommandID;

/* compiled from: HeaderAndFooterAdapterWrapper */
public final class b extends Adapter<ViewHolder> {
    SparseArrayCompat<View> a = new SparseArrayCompat();
    SparseArrayCompat<View> b = new SparseArrayCompat();
    private Adapter<ViewHolder> c;

    /* compiled from: HeaderAndFooterAdapterWrapper */
    private interface a {
        int a(GridLayoutManager gridLayoutManager, SpanSizeLookup spanSizeLookup, int i);
    }

    public b(Adapter<ViewHolder> adapter) {
        this.c = adapter;
        setHasStableIds(adapter.hasStableIds());
    }

    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.a.get(i) != null) {
            viewGroup = new i((View) this.a.get(i));
            viewGroup.setIsRecyclable(false);
            return viewGroup;
        } else if (this.b.get(i) == null) {
            return this.c.onCreateViewHolder(viewGroup, i);
        } else {
            viewGroup = new i((View) this.b.get(i));
            viewGroup.setIsRecyclable(false);
            return viewGroup;
        }
    }

    public final int getItemViewType(int i) {
        if (a(i)) {
            return this.a.keyAt(i);
        }
        if (b(i)) {
            return this.b.keyAt((i - this.a.size()) - this.c.getItemCount());
        }
        i = this.c.getItemViewType(i - this.a.size());
        if ((i >= XLStatCommandID.XLCID_LOGIN ? 1 : null) == null) {
            return i;
        }
        throw new IllegalStateException("XRecyclerView require itemViewType in adapter should be less than 100000 ");
    }

    public final long getItemId(int i) {
        if (a(i)) {
            return (long) (-(XLStatCommandID.XLCID_LOGIN + i));
        }
        if (b(i)) {
            return (long) (-(((XLStatCommandID.XLCID_MOB_REG + i) - this.a.size()) - this.c.getItemCount()));
        }
        return this.c.getItemId(i - this.a.size());
    }

    public final void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (!a(i) && !b(i)) {
            this.c.onBindViewHolder(viewHolder, i - this.a.size());
        }
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Adapter adapter = this.c;
        a cVar = new c(this);
        adapter.onAttachedToRecyclerView(recyclerView);
        recyclerView = recyclerView.getLayoutManager();
        if (recyclerView instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView;
            gridLayoutManager.setSpanSizeLookup(new d(cVar, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public final void onViewAttachedToWindow(ViewHolder viewHolder) {
        int layoutPosition = viewHolder.getLayoutPosition();
        if (!a(layoutPosition)) {
            if (!b(layoutPosition)) {
                if (!(viewHolder instanceof i)) {
                    this.c.onViewAttachedToWindow(viewHolder);
                }
                return;
            }
        }
        viewHolder = viewHolder.itemView.getLayoutParams();
        if (viewHolder != null && (viewHolder instanceof LayoutParams)) {
            ((LayoutParams) viewHolder).setFullSpan(true);
        }
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.c.onDetachedFromRecyclerView(recyclerView);
    }

    public final void onViewDetachedFromWindow(ViewHolder viewHolder) {
        if (!(viewHolder instanceof i)) {
            this.c.onViewDetachedFromWindow(viewHolder);
        }
    }

    public final void onViewRecycled(ViewHolder viewHolder) {
        if (!(viewHolder instanceof i)) {
            this.c.onViewRecycled(viewHolder);
        }
    }

    public final boolean onFailedToRecycleView(ViewHolder viewHolder) {
        if (viewHolder instanceof i) {
            return super.onFailedToRecycleView(viewHolder);
        }
        return this.c.onFailedToRecycleView(viewHolder);
    }

    public final void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
    }

    public final void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    public final void a(View view) {
        this.a.put(this.a.size() + XLStatCommandID.XLCID_LOGIN, view);
    }

    public final int getItemCount() {
        return (this.a.size() + this.b.size()) + this.c.getItemCount();
    }

    private boolean a(int i) {
        return i < this.a.size();
    }

    private boolean b(int i) {
        return i >= this.a.size() + this.c.getItemCount();
    }
}
