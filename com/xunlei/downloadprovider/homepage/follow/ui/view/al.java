package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;

/* compiled from: RecommendTitleViewHolder */
public final class al extends ViewHolder {
    public final void a(ap apVar) {
    }

    public al(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.follow_recommend_title_item, viewGroup, false));
        layoutInflater = this.itemView;
        layoutInflater.setClickable(false);
        layoutInflater.setOnClickListener(new am(this));
    }
}
