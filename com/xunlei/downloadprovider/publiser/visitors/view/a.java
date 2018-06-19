package com.xunlei.downloadprovider.publiser.visitors.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: FooterViewHolder */
public final class a extends g {
    private TextView a;

    public static a a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(layoutInflater.inflate(R.layout.visit_list_footer_item, viewGroup, false));
    }

    private a(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.tv_foot);
    }

    public final void a(f fVar) {
        this.a.setText((String) fVar.b);
    }
}
