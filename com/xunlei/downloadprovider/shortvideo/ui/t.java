package com.xunlei.downloadprovider.shortvideo.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;

/* compiled from: VideoRecommendView */
public final class t {
    public final TextView a;
    public final TextView b;
    public Context c = null;
    public m d = null;
    private final View e;
    private final View f;

    public t(View view) {
        this.c = view.getContext();
        this.a = (TextView) view.findViewById(R.id.tv_recommend_tag);
        this.e = view.findViewById(R.id.line_recommend_tag);
        this.f = view.findViewById(R.id.btn_load_more);
        this.b = (TextView) view.findViewById(R.id.tv_load_more);
        a(8);
        this.f.setOnClickListener(new u(this));
    }

    public final void a(int i) {
        this.a.setVisibility(i);
        this.e.setVisibility(i);
        this.f.setVisibility(i);
    }
}
