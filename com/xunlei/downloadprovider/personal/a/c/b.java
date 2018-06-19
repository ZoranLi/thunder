package com.xunlei.downloadprovider.personal.a.c;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.a.d.c;
import com.xunlei.downloadprovider.personal.a.f.a;
import com.xunlei.downloadprovider.personal.a.j;

/* compiled from: UserCard1ViewHolder */
public class b extends a {
    private static final String a = "b";
    private RelativeLayout b;
    private RelativeLayout c;
    private RelativeLayout d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private ImageView k;
    private TextView l;
    private ImageView m;
    private c n;
    private FragmentActivity o;

    static /* synthetic */ void a() {
    }

    public b(View view, FragmentActivity fragmentActivity) {
        super(view);
        this.o = fragmentActivity;
        this.b = (RelativeLayout) view.findViewById(R.id.rl_card_contain1);
        this.h = (TextView) view.findViewById(R.id.tv_title1);
        this.e = (TextView) view.findViewById(R.id.tv_description1);
        this.i = (ImageView) view.findViewById(R.id.iv_icon1);
        this.c = (RelativeLayout) view.findViewById(R.id.rl_card_contain2);
        this.j = (TextView) view.findViewById(R.id.tv_title2);
        this.f = (TextView) view.findViewById(R.id.tv_description2);
        this.k = (ImageView) view.findViewById(R.id.iv_icon2);
        this.d = (RelativeLayout) view.findViewById(R.id.rl_card_contain3);
        this.l = (TextView) view.findViewById(R.id.tv_title3);
        this.g = (TextView) view.findViewById(R.id.tv_description3);
        this.m = (ImageView) view.findViewById(R.id.iv_icon3);
        this.b.setOnClickListener(new c(this));
        this.c.setOnClickListener(new d(this));
        this.d.setOnClickListener(new e(this));
    }

    public final void a(Object obj) {
        this.n = (c) obj;
        new StringBuilder("UserCard1ViewHolder bindData ").append(this.n.a);
        j.a("bar", this.n.a);
        obj = this.n.b;
        this.h.setText(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(0)).a);
        this.e.setText(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(0)).b);
        a.a(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(0)).c, this.i);
        this.j.setText(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(1)).a);
        this.f.setText(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(1)).b);
        a.a(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(1)).c, this.k);
        this.l.setText(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(2)).a);
        this.g.setText(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(2)).b);
        a.a(((com.xunlei.downloadprovider.personal.a.d.b) obj.get(2)).c, this.m);
    }
}
