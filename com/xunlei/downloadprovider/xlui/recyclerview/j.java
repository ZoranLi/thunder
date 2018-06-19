package com.xunlei.downloadprovider.xlui.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.xunlei.common.stat.base.XLStatCommandID;
import java.util.ArrayList;

/* compiled from: XLRecyclerViewAdapterWrapper */
public final class j extends Adapter<ViewHolder> {
    ArrayList<a> a = new ArrayList();
    private Adapter<ViewHolder> b;

    public j(Adapter<ViewHolder> adapter) {
        this.b = adapter;
        setHasStableIds(adapter.hasStableIds());
    }

    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (XLStatCommandID.XLCID_WX_LOGIN != i) {
            return this.b.onCreateViewHolder(viewGroup, i);
        }
        viewGroup = e.a(viewGroup.getContext());
        viewGroup.setIsRecyclable(0);
        return viewGroup;
    }

    public final int getItemViewType(int i) {
        int a = a(i);
        int i2 = 0;
        if (a != -1) {
            i = this.b.getItemViewType(a);
            if (i >= XLStatCommandID.XLCID_LOGIN) {
                i2 = 1;
            }
            if (i2 == 0) {
                return i;
            }
            throw new IllegalStateException("XLRecyclerView require itemViewType in adapter should be less than 100000");
        }
        i = b(i);
        if (i < 0 || i >= this.a.size()) {
            return 0;
        }
        return ((a) this.a.get(i)).a;
    }

    public final long getItemId(int i) {
        int a = a(i);
        if (a != -1) {
            return this.b.getItemId(a);
        }
        a = b(i);
        return (a < 0 || a >= this.a.size()) ? super.getItemId(i) : (long) ((a) this.a.get(a)).a;
    }

    public final void onBindViewHolder(ViewHolder viewHolder, int i) {
        int a = a(i);
        if (a != -1) {
            this.b.onBindViewHolder(viewHolder, a);
            return;
        }
        i = b(i);
        if (i != -1 && (viewHolder instanceof e)) {
            e eVar = (e) viewHolder;
            a aVar = (a) this.a.get(i);
            if (aVar instanceof a) {
                a aVar2 = (a) aVar;
                eVar.a.setVisibility(aVar2.c);
                eVar.a.setState(aVar2.b);
            }
        }
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.b.onAttachedToRecyclerView(recyclerView);
    }

    public final void onViewAttachedToWindow(ViewHolder viewHolder) {
        if (!(viewHolder instanceof i)) {
            this.b.onViewAttachedToWindow(viewHolder);
        }
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.b.onDetachedFromRecyclerView(recyclerView);
    }

    public final void onViewDetachedFromWindow(ViewHolder viewHolder) {
        if (!(viewHolder instanceof i)) {
            this.b.onViewDetachedFromWindow(viewHolder);
        }
    }

    public final void onViewRecycled(ViewHolder viewHolder) {
        if (!(viewHolder instanceof i)) {
            this.b.onViewRecycled(viewHolder);
        }
    }

    public final boolean onFailedToRecycleView(ViewHolder viewHolder) {
        if (viewHolder instanceof i) {
            return super.onFailedToRecycleView(viewHolder);
        }
        return this.b.onFailedToRecycleView(viewHolder);
    }

    public final void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
        this.b.unregisterAdapterDataObserver(adapterDataObserver);
    }

    public final void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
        this.b.registerAdapterDataObserver(adapterDataObserver);
    }

    private int a(int i) {
        if (i >= 0) {
            if (i < this.b.getItemCount()) {
                return i;
            }
        }
        return -1;
    }

    private int b(int i) {
        if (i >= 0) {
            if (i >= this.b.getItemCount()) {
                return i - this.b.getItemCount();
            }
        }
        return -1;
    }

    public final int getItemCount() {
        return this.b.getItemCount() + this.a.size();
    }
}
