package com.xunlei.downloadprovider.personal.a.a;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.a.c.b;
import com.xunlei.downloadprovider.personal.a.c.f;
import com.xunlei.downloadprovider.personal.a.c.h;
import com.xunlei.downloadprovider.personal.a.c.i;
import com.xunlei.downloadprovider.personal.a.c.s;
import com.xunlei.downloadprovider.personal.a.d.d;

/* compiled from: UserCenterListAdapter */
public final class a extends Adapter<com.xunlei.downloadprovider.personal.a.c.a> {
    private d a = d.a();
    private UserCenterFragment b;
    private FragmentActivity c;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        com.xunlei.downloadprovider.personal.a.c.a aVar = (com.xunlei.downloadprovider.personal.a.c.a) viewHolder;
        d dVar = this.a;
        if (dVar.b != null) {
            i = ((com.xunlei.downloadprovider.personal.a.d.a) dVar.b.get(i)).b;
        } else {
            i = 0;
        }
        aVar.a(i);
    }

    public final /* synthetic */ void onViewAttachedToWindow(ViewHolder viewHolder) {
        com.xunlei.downloadprovider.personal.a.c.a aVar = (com.xunlei.downloadprovider.personal.a.c.a) viewHolder;
        super.onViewAttachedToWindow(aVar);
        aVar.c();
    }

    public final /* synthetic */ void onViewDetachedFromWindow(ViewHolder viewHolder) {
        com.xunlei.downloadprovider.personal.a.c.a aVar = (com.xunlei.downloadprovider.personal.a.c.a) viewHolder;
        super.onViewDetachedFromWindow(aVar);
        aVar.d();
    }

    public a(FragmentActivity fragmentActivity, UserCenterFragment userCenterFragment) {
        this.b = userCenterFragment;
        this.c = fragmentActivity;
    }

    public final int getItemCount() {
        new StringBuilder("UserCenterListAdapter getItemCount() = ").append(this.a.b());
        return this.a.b();
    }

    public final int getItemViewType(int i) {
        StringBuilder stringBuilder = new StringBuilder("UserCenterListAdapter getItemViewType() position, type == ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(this.a.a(i));
        return this.a.a(i);
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new s(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_info_item, viewGroup, false), this.c, this.b);
        }
        switch (i) {
            case 3:
                return new i(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_fixed_btn_item, viewGroup, false), this.c, this.b);
            case 4:
                return new h(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_dynamic_grid_item, viewGroup, false), this.c, this.b);
            case 5:
                return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_card_style1_item, viewGroup, false), this.c);
            case 6:
                return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_card_style2_item, viewGroup, false), this.c);
            default:
                return null;
        }
    }
}
