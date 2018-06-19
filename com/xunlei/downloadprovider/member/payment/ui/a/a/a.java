package com.xunlei.downloadprovider.member.payment.ui.a.a;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseAbsRecyclerAdapter */
public abstract class a<T, H extends d> extends Adapter<H> {
    private LinearLayout a;
    private LinearLayout b;
    protected List<T> c = new ArrayList();
    protected Context d;
    protected LayoutInflater e;
    public a f;
    private b g;

    /* compiled from: BaseAbsRecyclerAdapter */
    public interface a {
        void a(a aVar, int i);
    }

    /* compiled from: BaseAbsRecyclerAdapter */
    public interface b {
        boolean a();
    }

    public abstract H a(ViewGroup viewGroup, int i);

    public abstract void a(H h, T t, int i);

    public abstract int b(int i);

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        d dVar = (d) viewHolder;
        switch (dVar.getItemViewType()) {
            case 4097:
                return;
            case 4098:
                return;
            default:
                i -= a();
                a(dVar, this.c.get(i), i);
                return;
        }
    }

    protected a(Context context) {
        this.d = context;
        this.e = LayoutInflater.from(context);
    }

    public final int getItemCount() {
        int i;
        int a = a() + this.c.size();
        if (this.b != null) {
            if (this.b.getChildCount() != 0) {
                i = 1;
                return a + i;
            }
        }
        i = 0;
        return a + i;
    }

    public final int getItemViewType(int i) {
        int a = a();
        if (i < a) {
            return 4097;
        }
        i -= a;
        return i < this.c.size() ? b(i) : 4098;
    }

    public final int a() {
        if (this.a != null) {
            if (this.a.getChildCount() != 0) {
                return 1;
            }
        }
        return 0;
    }

    public final void a(@Nullable List<T> list) {
        this.c.clear();
        if (!(list == null || list.isEmpty())) {
            this.c.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void b(@Nullable List<T> list) {
        if (list != null && !list.isEmpty() && this.c.addAll(list) != null) {
            notifyDataSetChanged();
        }
    }

    public final void a(@Nullable T t) {
        if (t != null && this.c.size() >= 0) {
            this.c.add(0, t);
            notifyItemInserted(0);
        }
    }

    public final void b(@Nullable T t) {
        if (t != null) {
            int indexOf = this.c.indexOf(t);
            if (indexOf != -1 && this.c.remove(t) != null) {
                notifyItemRemoved(indexOf);
            }
        }
    }

    public final T c(@IntRange(from = 0) int i) {
        return (i < 0 || i >= this.c.size()) ? null : this.c.get(i);
    }

    public final boolean b() {
        return this.c.isEmpty();
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 4097:
                viewGroup = new d(this.a);
                break;
            case 4098:
                viewGroup = new d(this.b);
                break;
            default:
                viewGroup = a(viewGroup, i);
                if (viewGroup != null) {
                    i = viewGroup.itemView;
                    if (i != 0) {
                        if (this.f != null) {
                            i.setOnClickListener(new b(this, viewGroup));
                        }
                        if (this.g != null) {
                            i.setOnLongClickListener(new c(this, viewGroup));
                            break;
                        }
                    }
                }
                break;
        }
        viewGroup.c = this;
        return viewGroup;
    }
}
