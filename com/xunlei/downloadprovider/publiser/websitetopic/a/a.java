package com.xunlei.downloadprovider.publiser.websitetopic.a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.websitetopic.b.b;
import com.xunlei.downloadprovider.publiser.websitetopic.c.c;
import com.xunlei.downloadprovider.publiser.websitetopic.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WebsiteTopicAdapter */
public final class a extends Adapter<com.xunlei.downloadprovider.publiser.websitetopic.b.a<c>> {
    public int a = 0;
    public List<c> b = new ArrayList();
    public c c;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        com.xunlei.downloadprovider.publiser.websitetopic.b.a aVar = (com.xunlei.downloadprovider.publiser.websitetopic.b.a) viewHolder;
        this.c = a(i);
        aVar.a(a(i));
        if (a() == null) {
            g.a(a(i));
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final int getItemViewType(int i) {
        return ((c) this.b.get(i)).a;
    }

    private c a(int i) {
        return (c) this.b.get(i);
    }

    public final boolean a() {
        return this.a == 2;
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new com.xunlei.downloadprovider.publiser.websitetopic.b.c(viewGroup.getContext());
            case 2:
                viewGroup = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.common_pull_up_refresh_item, null);
                viewGroup.setLayoutParams(new LayoutParams(-1, -2));
                return new b(viewGroup);
            default:
                return null;
        }
    }
}
