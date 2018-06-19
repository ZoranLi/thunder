package com.xunlei.downloadprovider.search.ui.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseRecyAdapter */
public abstract class f<T> extends Adapter<d> implements com.xunlei.downloadprovider.search.ui.a.h.a {
    protected LayoutInflater a;
    public List<T> b = new ArrayList();
    protected a c;

    /* compiled from: BaseRecyAdapter */
    public interface a {
        Context getContext();
    }

    protected abstract int a(int i);

    protected abstract d a(ViewGroup viewGroup, int i);

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        d dVar = (d) viewHolder;
        i = (d.a(this.b) || i < 0 || this.b.size() <= i) ? 0 : this.b.get(i);
        dVar.a(i);
    }

    public f(a aVar) {
        this.c = aVar;
        this.a = LayoutInflater.from(aVar.getContext());
    }

    public int getItemCount() {
        return d.a(this.b) ? 0 : this.b.size();
    }

    public int getItemViewType(int i) {
        return i >= this.b.size() ? -1 : a(i);
    }

    public final T c(int i) {
        if (!d.a(this.b) && i >= 0) {
            if (i <= this.b.size()) {
                return this.b.get(i);
            }
        }
        return null;
    }

    public final void c() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }
}
