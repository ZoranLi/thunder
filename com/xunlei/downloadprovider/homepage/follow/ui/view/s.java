package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: NotLoginViewHolder */
public final class s extends ViewHolder {
    public final void a(ap apVar) {
    }

    public s(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.following_not_login_item, viewGroup, false));
        layoutInflater = this.itemView;
        TextView textView = (TextView) layoutInflater.findViewById(R.id.tv_login);
        textView.getPaint().setFlags(8);
        textView.getPaint().setAntiAlias(true);
        layoutInflater.setOnClickListener(new t(this, layoutInflater));
    }
}
