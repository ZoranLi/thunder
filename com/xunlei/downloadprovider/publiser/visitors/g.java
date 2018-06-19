package com.xunlei.downloadprovider.publiser.visitors;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.publiser.visitors.view.a;
import com.xunlei.downloadprovider.publiser.visitors.view.b;
import com.xunlei.downloadprovider.publiser.visitors.view.f;
import com.xunlei.downloadprovider.publiser.visitors.view.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VisitListAdapter */
public final class g extends Adapter<com.xunlei.downloadprovider.publiser.visitors.view.g> {
    List<f> a = new ArrayList();
    private String b;
    private Activity c;
    private LayoutInflater d;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((com.xunlei.downloadprovider.publiser.visitors.view.g) viewHolder).a(a(i));
    }

    public g(Activity activity, String str) {
        this.c = activity;
        this.d = LayoutInflater.from(activity);
        this.b = str;
    }

    public final int getItemCount() {
        return this.a.size();
    }

    private f a(int i) {
        return (f) this.a.get(i);
    }

    public final int getItemViewType(int i) {
        return a(i).a;
    }

    public final void a(String str) {
        this.a.add(new f(2, str));
        notifyItemInserted(this.a.size());
    }

    public final void a() {
        this.a.remove(this.a.size() - 1);
        notifyItemRemoved(this.a.size() - 1);
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new i(this.d, viewGroup, this.b);
        }
        if (i != 3) {
            return a.a(this.d, viewGroup);
        }
        return b.a(this.c, viewGroup, this);
    }
}
