package com.xunlei.downloadprovider.web.website.a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;

/* compiled from: CollectionUpdateHeaderAdapter */
public final class a extends Adapter<com.xunlei.downloadprovider.web.website.e.a> {
    private c a;

    public final int getItemCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 1;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup);
    }

    public a(c cVar) {
        this.a = cVar;
    }

    public final com.xunlei.downloadprovider.web.website.e.a a(ViewGroup viewGroup) {
        return new com.xunlei.downloadprovider.web.website.e.a(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.download_collection_update_card_layout, viewGroup, false), this.a);
    }
}
