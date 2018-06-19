package com.xunlei.downloadprovider.personal.user.account.address.a;

import android.content.Context;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: RecyclerAbsAdapter */
public abstract class a<M, VH extends d> extends Adapter<d> {
    protected View a;
    protected View b;
    protected Context c;
    public a d;

    /* compiled from: RecyclerAbsAdapter */
    public interface a {
        void a(View view, int i);
    }

    public abstract d a(int i);

    public abstract void a(VH vh, int i);

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        d dVar = (d) viewHolder;
        switch (dVar.getItemViewType()) {
            case 1024:
            case InputDeviceCompat.SOURCE_GAMEPAD /*1025*/:
                return;
            default:
                a(dVar, i);
                return;
        }
    }

    public a(Context context) {
        this.c = context;
    }

    public final void a(View view) {
        if (view != null) {
            this.a = view;
            notifyDataSetChanged();
        }
    }

    public final int b() {
        int i = this.a != null ? 1 : 0;
        return this.b != null ? i + 1 : i;
    }

    public final int c() {
        return this.a == null ? 0 : 1;
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1024) {
            return new d(this.a);
        }
        if (i == InputDeviceCompat.SOURCE_GAMEPAD) {
            return new d(this.b);
        }
        viewGroup = a(i);
        if (viewGroup != null) {
            i = viewGroup.itemView;
            if (!(i == 0 || this.d == null)) {
                i.setOnClickListener(new b(this, viewGroup));
            }
        }
        return viewGroup;
    }
}
