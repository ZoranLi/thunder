package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.b.b;

/* compiled from: TitleViewHolder */
public final class an extends ViewHolder {
    private TextView a;
    private TextView b;

    public final void a(ap apVar) {
        b bVar = (b) apVar.b;
        this.a.setText(bVar.a);
        if (bVar.b > 0) {
            TextView textView = this.b;
            StringBuilder stringBuilder = new StringBuilder(k.s);
            stringBuilder.append(bVar.b);
            stringBuilder.append(k.t);
            textView.setText(stringBuilder.toString());
            this.b.setVisibility(0);
            return;
        }
        this.b.setVisibility(8);
    }

    public an(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.follow_list_title, viewGroup, false));
        layoutInflater = this.itemView;
        this.a = (TextView) layoutInflater.findViewById(R.id.tv_title);
        this.b = (TextView) layoutInflater.findViewById(R.id.tv_count);
        layoutInflater.setOnClickListener(new ao(this));
    }
}
