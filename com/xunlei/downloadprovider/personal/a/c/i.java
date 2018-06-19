package com.xunlei.downloadprovider.personal.a.c;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.widget.as;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.a.b;
import com.xunlei.downloadprovider.personal.a.b.h;
import com.xunlei.downloadprovider.personal.a.b.i$b;
import com.xunlei.downloadprovider.personal.a.d.d;
import com.xunlei.downloadprovider.personal.a.f.a;
import com.xunlei.downloadprovider.personal.a.j;
import com.xunlei.downloadprovider.personal.liked.LikeContentActivity;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.playrecord.PlayRecordActivity;
import com.xunlei.xllib.android.XLIntent;
import java.util.List;

/* compiled from: UserFixedBtnViewHolder */
public final class i extends a implements b {
    ImageView a;
    private RelativeLayout b;
    private LinearLayout c;
    private LinearLayout d;
    private View e;
    private TextView f;
    private ImageView g;
    private RelativeLayout h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private LinearLayout m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private FragmentActivity r;
    private String s;
    @Nullable
    private as t = new as();
    private as.b u = new j(this);

    public i(View view, FragmentActivity fragmentActivity, UserCenterFragment userCenterFragment) {
        super(view);
        userCenterFragment.a(this, "kye_user_fixed_view");
        this.r = fragmentActivity;
        this.b = (RelativeLayout) view.findViewById(R.id.rl_me_tab_download_manager);
        this.c = (LinearLayout) view.findViewById(R.id.ll_me_tab_play_recoder);
        this.d = (LinearLayout) view.findViewById(R.id.ll_me_tab_my_favor_recorder);
        this.a = (ImageView) view.findViewById(R.id.collect_update_red_point);
        this.e = view.findViewById(R.id.ll_me_tab_lixian_space);
        this.n = (ImageView) view.findViewById(R.id.iv_lx_icon);
        this.o = (TextView) view.findViewById(R.id.tv_lx_title);
        this.p = (TextView) view.findViewById(R.id.tv_lx_des);
        this.q = (ImageView) view.findViewById(R.id.iv_lx_red_point);
        this.f = (TextView) view.findViewById(R.id.tv_me_tab_download_num);
        this.g = (ImageView) view.findViewById(R.id.iv_me_tab_download_num_3length);
        this.h = (RelativeLayout) view.findViewById(R.id.rl_me_tab_member_center);
        this.i = (ImageView) view.findViewById(R.id.iv_member_center_icon);
        this.j = (TextView) view.findViewById(R.id.tv_member_center_title);
        this.k = (TextView) view.findViewById(R.id.tv_member_center_des);
        this.l = (ImageView) view.findViewById(R.id.iv_score_red_point);
        this.m = (LinearLayout) view.findViewById(R.id.ll_me_tab_my_liked);
        com.xunlei.downloadprovider.web.website.g.b.a();
        if (com.xunlei.downloadprovider.web.website.g.b.d() != null) {
            this.a.setVisibility(null);
            j.b("collect");
        } else {
            this.a.setVisibility(8);
        }
        this.b.setOnClickListener(new k(this));
        this.c.setOnClickListener(new l(this));
        this.d.setOnClickListener(new m(this));
        this.e.setOnClickListener(new n(this));
        this.h.setOnClickListener(new o(this));
        this.m.setOnClickListener(new p(this));
    }

    private static h a(String str) {
        List list = d.a().a;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (TextUtils.equals(str, ((h) list.get(i)).c)) {
                    return (h) list.get(i);
                }
            }
        }
        return null;
    }

    private void e() {
        com.xunlei.downloadprovider.download.tasklist.task.h.e();
        int unfinishedUnIllegalCount = com.xunlei.downloadprovider.download.tasklist.task.h.c().getUnfinishedUnIllegalCount();
        if (unfinishedUnIllegalCount == 0) {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        CharSequence valueOf = String.valueOf(unfinishedUnIllegalCount);
        int length = valueOf.length();
        int a = a.a(length);
        this.f.setText(valueOf);
        if (length >= 3) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.f.setBackgroundResource(a);
    }

    public final void a() {
        e();
    }

    public final void b() {
        if (this.t != null) {
            this.t.d();
        }
    }

    public final void a(Object obj) {
        e();
        if (this.t != null) {
            this.t.b = this.u;
            this.t.a();
        }
        obj = a("member_center");
        com.xunlei.downloadprovider.personal.a.b.i a = com.xunlei.downloadprovider.personal.a.b.i.a.a();
        if (obj == null) {
            obj = null;
        } else {
            CharSequence charSequence = obj.c;
            if (!TextUtils.isEmpty(charSequence) && a.a.containsKey(charSequence)) {
                List<i$b> list = (List) a.a.get(charSequence);
                com.xunlei.downloadprovider.member.payment.a.j.a();
                if (!l.b()) {
                    for (i$b com_xunlei_downloadprovider_personal_a_b_i_b : list) {
                        if (TextUtils.equals(MessageInfo.ORIGINAL, com_xunlei_downloadprovider_personal_a_b_i_b.h)) {
                            break;
                        }
                    }
                }
                int g = com.xunlei.downloadprovider.member.payment.a.j.a().g();
                boolean l = com.xunlei.downloadprovider.member.payment.a.j.a().a.l();
                if (com.xunlei.downloadprovider.member.payment.a.j.a().d() != 0) {
                    if (g > 0) {
                        if (!l) {
                            if (g > 0) {
                                for (i$b com_xunlei_downloadprovider_personal_a_b_i_b2 : list) {
                                    if (TextUtils.equals("expried_member_user", com_xunlei_downloadprovider_personal_a_b_i_b2.h)) {
                                        break;
                                    }
                                }
                            }
                        }
                        for (i$b com_xunlei_downloadprovider_personal_a_b_i_b22 : list) {
                            if (TextUtils.equals("member_user", com_xunlei_downloadprovider_personal_a_b_i_b22.h)) {
                                break;
                            }
                        }
                    }
                }
                for (i$b com_xunlei_downloadprovider_personal_a_b_i_b222 : list) {
                    if (TextUtils.equals("new_user", com_xunlei_downloadprovider_personal_a_b_i_b222.h)) {
                        break;
                    }
                }
            }
            i$b com_xunlei_downloadprovider_personal_a_b_i_b2222 = null;
            if (com_xunlei_downloadprovider_personal_a_b_i_b2222 != null) {
                if (!TextUtils.isEmpty(com_xunlei_downloadprovider_personal_a_b_i_b2222.a)) {
                    obj.d = com_xunlei_downloadprovider_personal_a_b_i_b2222.a;
                }
                if (!TextUtils.isEmpty(com_xunlei_downloadprovider_personal_a_b_i_b2222.b)) {
                    obj.e = com_xunlei_downloadprovider_personal_a_b_i_b2222.b;
                }
                if (!TextUtils.isEmpty(com_xunlei_downloadprovider_personal_a_b_i_b2222.c)) {
                    obj.f = com_xunlei_downloadprovider_personal_a_b_i_b2222.c;
                }
            }
        }
        if (obj != null) {
            String str = obj.f;
            CharSequence charSequence2 = obj.d;
            CharSequence charSequence3 = obj.e;
            this.s = obj.g;
            int i = obj.k;
            String str2 = obj.l;
            obj = obj.m;
            a.a(str, this.i, R.drawable.ic_user_center_default_gray);
            this.j.setText(charSequence2);
            if (TextUtils.isEmpty(charSequence3)) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.k.setText(charSequence3);
            }
            if (i != 1 || com.xunlei.downloadprovider.personal.a.a.a().a("member_center", str2, obj) == null) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
        } else {
            this.i.setBackgroundResource(R.drawable.ic_user_center_member);
            this.j.setText("会员中心");
            this.k.setVisibility(8);
        }
        obj = a("offline_space");
        if (obj != null) {
            int i2 = obj.k;
            String str3 = obj.l;
            String str4 = obj.m;
            this.o.setText(obj.d);
            a.a(obj.f, this.n, R.drawable.ic_user_center_lixian_space);
            if (com.xunlei.downloadprovider.personal.lixianspace.a.a()) {
                this.p.setVisibility(0);
                this.p.setText(obj.e);
                if (i2 != 1 || com.xunlei.downloadprovider.personal.a.a.a().a("offline_space", str3, str4) == null) {
                    this.q.setVisibility(8);
                    return;
                } else {
                    this.q.setVisibility(0);
                    return;
                }
            }
            this.q.setVisibility(8);
            this.p.setVisibility(8);
            return;
        }
        this.o.setText("离线空间");
        this.p.setVisibility(8);
        this.n.setBackgroundResource(R.drawable.ic_user_center_lixian_space);
    }

    static /* synthetic */ void b(i iVar) {
        j.a("bar_dl_center", iVar.l.getVisibility() == 0);
        com.xunlei.downloadprovider.download.a.a(iVar.r, DLCenterEntry.personal_center.toString());
    }

    static /* synthetic */ void c(i iVar) {
        j.a("bar_play_his", iVar.l.getVisibility() == 0);
        iVar.r.startActivity(new XLIntent(iVar.r, PlayRecordActivity.class));
    }

    static /* synthetic */ void d(i iVar) {
        j.a("bar_collect", iVar.a.getVisibility() == 0);
        com.xunlei.downloadprovider.download.a.a(iVar.r);
    }

    static /* synthetic */ void e(i iVar) {
        j.a("bar_lixian", iVar.l.getVisibility() == 0);
        com.xunlei.downloadprovider.personal.lixianspace.a.a(iVar.r);
        if (iVar.q.getVisibility() == 0) {
            iVar.q.setVisibility(8);
            com.xunlei.downloadprovider.personal.a.a.a().b("offline_space");
        }
    }

    static /* synthetic */ void f(i iVar) {
        j.a("bar_vip_center", iVar.l.getVisibility() == 0);
        if (TextUtils.isEmpty(iVar.s)) {
            com.xunlei.downloadprovider.personal.a.i.a(iVar.r, "http://act.vip.xunlei.com/vip/2015/shoulei_v2/", iVar.r.getString(R.string.xunlei_member_center), "per_cl");
        } else {
            com.xunlei.downloadprovider.personal.a.i.a(iVar.r, iVar.s, iVar.r.getString(R.string.xunlei_member_center), "per_cl");
        }
        if (iVar.l.getVisibility() == 0) {
            iVar.l.setVisibility(8);
            com.xunlei.downloadprovider.personal.a.a.a().b("member_center");
        }
    }

    static /* synthetic */ void g(i iVar) {
        j.a("bar_my_like", iVar.l.getVisibility() == 0);
        q.e();
        LoginHelper.a();
        if (l.c()) {
            LikeContentActivity.a(iVar.itemView.getContext());
        } else {
            LoginHelper.a().a(iVar.itemView.getContext(), new q(iVar), LoginFrom.MY_LIKE_CONTENT, null);
        }
    }
}
