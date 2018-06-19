package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

/* compiled from: CustomItemAnimator */
public class k extends DefaultItemAnimator {
    private static final String b = "k";
    public boolean a = false;

    public k() {
        setSupportsChangeAnimations(false);
    }

    public boolean animateRemove(ViewHolder viewHolder) {
        return super.animateRemove(viewHolder);
    }

    public boolean animateAdd(ViewHolder viewHolder) {
        boolean animateAdd = super.animateAdd(viewHolder);
        if (this.a) {
            viewHolder.itemView.setAlpha(1.0f);
        }
        return animateAdd;
    }

    public boolean animateMove(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        return super.animateMove(viewHolder, i, i2, i3, i4);
    }

    public boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        return super.animateChange(viewHolder, viewHolder2, i, i2, i3, i4);
    }

    public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
        return super.canReuseUpdatedViewHolder(viewHolder, list);
    }
}
