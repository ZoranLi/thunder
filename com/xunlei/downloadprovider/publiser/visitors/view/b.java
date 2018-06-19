package com.xunlei.downloadprovider.publiser.visitors.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.visitors.VisitActivity;
import com.xunlei.downloadprovider.publiser.visitors.g;

/* compiled from: UnfollowFooterViewHolder */
public final class b extends g {
    private VisitActivity a;
    private g b;
    private TextView c;
    private long d = this.a.c;
    private String e = this.a.a;

    public final void a(f fVar) {
    }

    public static b a(Activity activity, ViewGroup viewGroup, g gVar) {
        return new b(activity, LayoutInflater.from(activity).inflate(R.layout.visit_list_footer_unfollow_item, viewGroup, false), gVar);
    }

    private b(Activity activity, View view, g gVar) {
        super(view);
        this.a = (VisitActivity) activity;
        this.b = gVar;
        this.c = (TextView) view.findViewById(R.id.tv_follow);
        this.c.setOnClickListener(new c(this));
    }

    static /* synthetic */ void a(b bVar, long j) {
        bVar.c.setEnabled(false);
        com.xunlei.downloadprovider.homepage.follow.b.a().a(j, true, new d(bVar));
    }

    static /* synthetic */ void b(b bVar, long j) {
        a.a("visit", bVar.d, 0, "skip_login", "", o.a(bVar.e), "", 0);
        LoginHelper.a().a(bVar.a, new e(bVar, j), LoginFrom.VISIT_LIST, 0);
    }
}
