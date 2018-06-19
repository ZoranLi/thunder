package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.b.c;
import com.xunlei.downloadprovider.homepage.follow.ui.aa;

/* compiled from: AllLivingHostViewHolder */
public final class a extends ViewHolder {
    private View a;
    private TextView b;
    private ImageView c;
    private aa d;

    public final void a(ap apVar) {
        c cVar = (c) apVar.b;
        int size = cVar.a.size();
        if (size <= 2) {
            this.a.setVisibility(8);
            return;
        }
        this.a.setVisibility(0);
        if (cVar.b) {
            a();
        } else {
            a(size);
        }
        this.a.setOnClickListener(new b(this, cVar, size));
    }

    private void a(int i) {
        TextView textView = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("个你关注的主播正在直播");
        textView.setText(stringBuilder.toString());
        this.c.setImageResource(R.drawable.follow_recommend_unfold_icon);
    }

    private void a() {
        this.b.setText("收起");
        this.c.setImageResource(R.drawable.follow_recommend_fold_icon);
    }

    public a(LayoutInflater layoutInflater, ViewGroup viewGroup, aa aaVar) {
        super(layoutInflater.inflate(R.layout.follow_tab_all_living_host_item, viewGroup, false));
        this.d = aaVar;
        layoutInflater = this.itemView;
        this.a = layoutInflater.findViewById(R.id.layout_all_living_hosts);
        this.b = (TextView) layoutInflater.findViewById(R.id.tv_fold);
        this.c = (ImageView) layoutInflater.findViewById(R.id.iv_fold_status);
    }
}
