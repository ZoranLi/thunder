package com.xunlei.downloadprovider.homepage.follow.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder.From;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ag;
import com.xunlei.downloadprovider.homepage.follow.ui.view.al;
import com.xunlei.downloadprovider.homepage.follow.ui.view.an;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import com.xunlei.downloadprovider.homepage.follow.ui.view.e;
import com.xunlei.downloadprovider.homepage.follow.ui.view.k;
import com.xunlei.downloadprovider.homepage.follow.ui.view.n;
import com.xunlei.downloadprovider.homepage.follow.ui.view.r;
import com.xunlei.downloadprovider.homepage.follow.ui.view.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FollowListAdapter */
public final class h extends Adapter<ViewHolder> {
    private Context a;
    private LayoutInflater b;
    private List<ap> c = new ArrayList();
    private ab d;

    public final long getItemId(int i) {
        return (long) i;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).a((ap) this.c.get(i));
    }

    public h(Context context, ab abVar) {
        this.a = context;
        this.b = LayoutInflater.from(context);
        this.d = abVar;
    }

    public final int getItemViewType(int i) {
        return ((ap) this.c.get(i)).a;
    }

    public final int getItemCount() {
        return this.c.size();
    }

    public final void a() {
        b();
        super.notifyDataSetChanged();
    }

    public final void a(int i) {
        b();
        super.notifyItemRangeInserted(1, i);
    }

    private void b() {
        ab abVar = this.d;
        abVar.b.clear();
        switch (abVar.a) {
            case 1:
                abVar.f.b = b.a().f;
                abVar.b.add(abVar.e);
                abVar.b.addAll(abVar.c);
                abVar.b.addAll(abVar.d);
                break;
            case 2:
                abVar.b.add(abVar.h);
                abVar.b.addAll(abVar.d);
                break;
            case 3:
                abVar.f.b = 0;
                abVar.b.add(abVar.e);
                abVar.b.add(abVar.g);
                abVar.b.addAll(abVar.d);
                break;
            default:
                break;
        }
        this.c = abVar.b;
    }

    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new an(this.b, viewGroup);
            case 1:
                return new k(this.b, viewGroup);
            case 2:
                return new e(this.b, viewGroup, From.MY_FOLLOWING_LIST);
            case 7:
                return new r(this.b, viewGroup);
            case 8:
                return new s(this.b, viewGroup);
            case 9:
                return new n(this.b, viewGroup);
            case 12:
                return new al(this.b, viewGroup);
            case 13:
                return new ag(viewGroup.getContext(), From.SUB_LIST_REC_FOLLOW);
            default:
                return null;
        }
    }
}
