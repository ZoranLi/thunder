package com.xunlei.downloadprovider.personal.a.b.a;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.a.b.c.b;
import com.xunlei.downloadprovider.personal.a.b.c.e;
import com.xunlei.downloadprovider.personal.a.b.c.k;
import com.xunlei.downloadprovider.personal.a.b.h;
import java.util.ArrayList;

/* compiled from: UserCenterGridAdapter */
public final class a extends Adapter<com.xunlei.downloadprovider.personal.a.b.c.a> {
    public ArrayList<h> a;
    private FragmentActivity b;
    private UserCenterFragment c;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((com.xunlei.downloadprovider.personal.a.b.c.a) viewHolder).a(this.a.get(i));
    }

    public final /* synthetic */ void onViewAttachedToWindow(ViewHolder viewHolder) {
        com.xunlei.downloadprovider.personal.a.b.c.a aVar = (com.xunlei.downloadprovider.personal.a.b.c.a) viewHolder;
        super.onViewAttachedToWindow(aVar);
        aVar.c();
    }

    public final /* synthetic */ void onViewDetachedFromWindow(ViewHolder viewHolder) {
        com.xunlei.downloadprovider.personal.a.b.c.a aVar = (com.xunlei.downloadprovider.personal.a.b.c.a) viewHolder;
        super.onViewDetachedFromWindow(aVar);
        aVar.d();
    }

    public a(FragmentActivity fragmentActivity, UserCenterFragment userCenterFragment) {
        this.c = userCenterFragment;
        this.b = fragmentActivity;
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int i) {
        return this.a != null ? ((h) this.a.get(i)).b : 0;
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new k(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_one_grid_view, null), this.b);
            case 2:
                return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_one_grid_score_view, null), this.b, this.c, this.a);
            case 3:
                return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_one_grid_dl_view, null), this.b, this.c);
            default:
                return new k(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_one_grid_view, null), this.b);
        }
    }
}
