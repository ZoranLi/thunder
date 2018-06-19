package com.xunlei.downloadprovider.cardslide.likelist.a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cardslide.likelist.CardSlideLikeActivity;
import com.xunlei.downloadprovider.cardslide.likelist.b.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CardLikeListAdapter */
public final class a extends Adapter<com.xunlei.downloadprovider.cardslide.likelist.b.a<com.xunlei.downloadprovider.cardslide.likelist.c.a>> {
    public List<com.xunlei.downloadprovider.cardslide.likelist.c.a> a = new ArrayList();
    private CardSlideLikeActivity b;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((com.xunlei.downloadprovider.cardslide.likelist.b.a) viewHolder).a((com.xunlei.downloadprovider.cardslide.likelist.c.a) this.a.get(i));
    }

    public a(CardSlideLikeActivity cardSlideLikeActivity) {
        this.b = cardSlideLikeActivity;
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int i) {
        return ((com.xunlei.downloadprovider.cardslide.likelist.c.a) this.a.get(i)).a;
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return null;
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_like_user_item, viewGroup, false), this.b);
    }
}
