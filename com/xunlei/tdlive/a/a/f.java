package com.xunlei.tdlive.a.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

/* compiled from: RecyclerViewHolder */
public class f extends ViewHolder implements OnClickListener, OnLongClickListener {
    private final SparseArray<View> a;
    private View b;
    protected OnClickListener c = new OnClickListener(this) {
        final /* synthetic */ f a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            if (this.a.e != null) {
                this.a.e.a(view, this.a.getAdapterPosition());
            }
        }
    };
    private c d;
    private d e;
    private e f;

    public f(View view, c cVar, d dVar) {
        super(view);
        this.b = view;
        this.b.setOnClickListener(this);
        this.d = cVar;
        this.e = dVar;
        this.a = new SparseArray();
    }

    public <T extends View> T a(int i) {
        View view = (View) this.a.get(i);
        if (view != null) {
            return view;
        }
        T findViewById = this.b.findViewById(i);
        this.a.put(i, findViewById);
        return findViewById;
    }

    public void onClick(View view) {
        if (this.d != null) {
            this.d.a(view, getAdapterPosition());
        }
    }

    public boolean onLongClick(View view) {
        return this.f != null ? this.f.a(view, getAdapterPosition()) : null;
    }
}
