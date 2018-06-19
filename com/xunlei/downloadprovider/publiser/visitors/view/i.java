package com.xunlei.downloadprovider.publiser.visitors.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.publiser.visitors.VisitActivity;
import com.xunlei.downloadprovider.publiser.visitors.model.b;

/* compiled from: VisitViewHolder */
public final class i extends g {
    private String a;
    private VisitActivity b;
    private View c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private ImageView k;
    private TextView l;
    private UserInfoTagView m;
    private long n;
    private b o;
    private int p;
    private int q;

    public final void a(f fVar) {
        this.o = (b) fVar.b;
        this.n = this.o.g;
        com.xunlei.downloadprovider.homepage.choiceness.b.a();
        com.xunlei.downloadprovider.homepage.choiceness.b.a(this.o.a(), this.d);
        this.e.setText(this.o.b());
        this.f.setText(DateUtil.formatRelativeTime(this.o.f));
        fVar = this.o.b;
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        this.l.setVisibility(8);
        this.c.setVisibility(0);
        if ((fVar == 1 || fVar == 2) && TextUtils.isEmpty(this.o.a)) {
            fVar = -1;
        }
        if (fVar != -1) {
            switch (fVar) {
                case 1:
                case 2:
                    b bVar = this.o;
                    int i = (bVar.i == null || bVar.i.c != 1) ? 0 : 1;
                    if (i != 0) {
                        this.l.setVisibility(8);
                        this.j.setVisibility(0);
                        this.j.setOnClickListener(new k(this));
                        com.xunlei.downloadprovider.homepage.choiceness.b a = com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        b bVar2 = this.o;
                        a.a(bVar2.i == null ? "" : bVar2.i.b, this.k, null);
                    } else {
                        bVar = this.o;
                        i = bVar.i == null ? 2 : bVar.i.c;
                        if (i != -2) {
                            if (i == 0) {
                                this.l.setText("该视频\n已下线");
                                this.l.setVisibility(0);
                                this.l.setOnClickListener(new l(this));
                            } else if (i != 2) {
                            }
                        }
                        this.l.setText("该视频\n已删除");
                        this.l.setVisibility(0);
                        this.l.setOnClickListener(new m(this));
                    }
                    this.g.setText(fVar == 1 ? this.p : this.q);
                    break;
                case 3:
                    break;
                case 4:
                    this.g.setText(this.q);
                    this.h.setVisibility(0);
                    this.h.setText(this.o.h);
                    this.h.setOnClickListener(new n(this));
                    break;
                default:
                    break;
            }
        }
        this.g.setText(this.q);
        this.i.setVisibility(0);
        if (this.n != 0) {
            if (LoginHelper.a().g.c() != this.n) {
                if (com.xunlei.downloadprovider.homepage.follow.b.a().b(this.n) != null) {
                    this.i.setVisibility(0);
                    this.i.setBackgroundResource(R.drawable.btn_unfollow_selector2);
                    this.i.setText("已关注");
                } else {
                    this.i.setVisibility(0);
                    this.i.setBackgroundResource(R.drawable.btn_follow_selector2);
                    this.i.setText("+ 关注");
                }
                this.i.setOnClickListener(new o(this));
                this.m.setUserInfo(this.o.j);
                this.itemView.setOnClickListener(new j(this));
            }
        }
        this.i.setVisibility(8);
        this.i.setOnClickListener(new o(this));
        this.m.setUserInfo(this.o.j);
        this.itemView.setOnClickListener(new j(this));
    }

    public i(LayoutInflater layoutInflater, ViewGroup viewGroup, String str) {
        boolean z = false;
        super(layoutInflater.inflate(R.layout.visit_list_item, viewGroup, false));
        this.b = (VisitActivity) viewGroup.getContext();
        if (this.b.c == LoginHelper.a().g.c()) {
            z = true;
        }
        this.p = z ? R.string.visit_list_description_video_play : R.string.visit_list_description_video_play_ta;
        this.q = z ? R.string.visit_list_description_other : R.string.visit_list_description_other_ta;
        this.a = str;
        layoutInflater = this.itemView;
        this.c = layoutInflater.findViewById(R.id.layout_visit);
        this.d = (ImageView) layoutInflater.findViewById(R.id.iv_avatar);
        this.e = (TextView) layoutInflater.findViewById(R.id.tv_name);
        this.f = (TextView) layoutInflater.findViewById(R.id.tv_visit_time);
        this.g = (TextView) layoutInflater.findViewById(R.id.tv_description);
        this.h = (TextView) layoutInflater.findViewById(R.id.tv_comment);
        this.i = (TextView) layoutInflater.findViewById(R.id.tv_follow);
        this.j = layoutInflater.findViewById(R.id.layout_video);
        this.k = (ImageView) layoutInflater.findViewById(R.id.iv_video_cover);
        this.l = (TextView) layoutInflater.findViewById(R.id.tv_video_deleted);
        this.m = (UserInfoTagView) layoutInflater.findViewById(R.id.view_user_info_tag);
    }

    static /* synthetic */ void a(i iVar) {
        Context context = iVar.b;
        long j = iVar.n;
        b bVar = iVar.o;
        m.a(context, j, bVar.j == null ? "per" : bVar.j.getKind(), iVar.o.b(), iVar.o.a(), From.VISITOR_LIST);
    }

    static /* synthetic */ void a(i iVar, long j) {
        LoginHelper a = LoginHelper.a();
        if (l.c()) {
            com.xunlei.downloadprovider.homepage.follow.b.a().a(j, true, new p(iVar, j, a));
            return;
        }
        a.a(iVar.b, new q(iVar, j, a), LoginFrom.CHANNEL_FLOW_FOLLOW, null);
        a.a(j, l.c(), "skip_login", null, iVar.a);
    }
}
