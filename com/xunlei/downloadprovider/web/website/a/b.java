package com.xunlei.downloadprovider.web.website.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.website.e.d;
import com.xunlei.downloadprovider.web.website.e.e;

/* compiled from: EmptyFootAdapter */
public final class b extends c {
    public final int getItemCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 2;
    }

    public final /* bridge */ /* synthetic */ e a(ViewGroup viewGroup, int i) {
        return a(viewGroup);
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup);
    }

    public b(Context context, int i) {
        super(context, i);
    }

    public static d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.download_collection_empty_card_layout, viewGroup, false));
    }
}
