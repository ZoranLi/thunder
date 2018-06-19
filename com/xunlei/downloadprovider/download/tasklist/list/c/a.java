package com.xunlei.downloadprovider.download.tasklist.list.c;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.d;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.b.a.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: VipRenewRemindViewHolder */
public final class a extends d implements g {
    f h;
    private com.xunlei.downloadprovider.download.tasklist.list.a i;
    private e j;
    private int k;
    private Context l;
    private final String m;
    private PreferenceHelper n;
    private int o;
    private boolean p;

    public static a a(Context context, ViewGroup viewGroup, com.xunlei.downloadprovider.download.control.a aVar, com.xunlei.downloadprovider.download.tasklist.list.a aVar2) {
        int f = b.f();
        if (f == 0) {
            viewGroup = LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_basic_vip_promotion_card, viewGroup, false);
        } else if (f == 1) {
            viewGroup = LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_basic_vip_promotion_card_style1, viewGroup, false);
        } else {
            viewGroup = LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_basic_vip_promotion_card_style2, viewGroup, false);
        }
        a aVar3 = new a(viewGroup, f);
        aVar3.setDownloadCenterControl(aVar);
        aVar3.setAdapter(aVar2);
        aVar3.l = context;
        return aVar3;
    }

    public final void setAdapter(com.xunlei.downloadprovider.download.tasklist.list.a aVar) {
        this.i = aVar;
    }

    private a(View view, int i) {
        super(view);
        this.k = 0;
        this.m = com.xunlei.downloadprovider.member.payment.f.a(PayFrom.VIP_RENEW_REMIND);
        this.p = false;
        this.p = com.xunlei.downloadprovider.d.d.a().h.j();
        this.o = i;
        if (this.o == 0) {
            this.a.setImageResource(R.drawable.xunlei_vip_default);
        } else {
            this.a.setImageResource(R.drawable.xunlei_vip_default_style1);
        }
        this.c.setText("您的白金会员即将到期");
        this.d.setText("马上续费立享低至8折优惠");
        this.g.setText("优惠");
        this.f.setText("立即续费");
        view.setOnClickListener(new b(this));
        this.e.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
        this.f.setOnClickListener(new e(this));
        LoginHelper.a().a(this);
    }

    private void a() {
        this.i.a(this.j);
        this.j = null;
        this.i.g.o = false;
        this.i.g.g = false;
        this.i.notifyDataSetChanged();
    }

    private void b() {
        if (this.n == null) {
            this.n = new PreferenceHelper(this.l, "vip_renew");
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        PreferenceHelper preferenceHelper = this.n;
        StringBuilder stringBuilder = new StringBuilder("dateAndUser");
        stringBuilder.append(LoginHelper.a().g.c());
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(format);
        stringBuilder3.append(LoginHelper.a().g.c());
        preferenceHelper.setString(stringBuilder2, stringBuilder3.toString());
    }

    public final void fillData(e eVar) {
        if (this.j == null) {
            this.j = eVar;
        }
        this.h = (f) eVar.a(com.xunlei.downloadprovider.member.b.d.class);
        if (this.h != null) {
            this.c.setText(this.h.e);
            this.d.setText(this.h.f);
            this.f.setText(this.h.g);
        }
        eVar = this.p;
        int i = R.drawable.renew_normal_bj_style1_ic;
        eVar = eVar != null ? 2130839170 : R.drawable.xunlei_vip_default_style1;
        int i2 = this.p ? R.drawable.renew_svip_style1_ic : R.drawable.xunlei_vip_super_style1;
        if (!this.p) {
            i = R.drawable.xunlei_vip_platinum_style1;
        }
        if (this.o == 0) {
            if (this.p != null) {
                eVar = R.drawable.renew_svip_style_old_ic;
            } else {
                int i3 = R.drawable.xunlei_vip_super;
            }
            i2 = eVar;
            if (this.p == null) {
                i = R.drawable.xunlei_vip_platinum;
                eVar = R.drawable.xunlei_vip_default;
            } else if (PayUtil.b(j.a().f()) >= 0) {
                i = R.drawable.renew_baijin_style_old_ic;
                eVar = R.drawable.renew_normal_style_old_ic;
            } else {
                eVar = R.drawable.renew_speedup_style_old_ic;
                i = eVar;
            }
        }
        if (LoginHelper.a().s()) {
            this.a.setImageResource(i);
        } else if (LoginHelper.a().t()) {
            this.a.setImageResource(i2);
        } else {
            this.a.setImageResource(eVar);
        }
        long j = (long) this.h.k;
        if (this.k == null) {
            q.a("dl_center_top", j, c());
            this.k++;
        }
        if (this.p == null) {
            this.f.setBackgroundDrawable(this.l.getResources().getDrawable(R.drawable.task_card_button_orange));
            this.f.setTextColor(this.l.getResources().getColor(R.color.task_card_accent_color_orange));
        } else if (this.o == null) {
            eVar = j.a().d();
            long b = PayUtil.b(j.a().f());
            if (5 != eVar) {
                if (b >= 0) {
                    this.f.setBackgroundDrawable(this.l.getResources().getDrawable(R.drawable.renew_red_light_btg));
                    this.f.setTextColor(Color.parseColor("#FFFFFF"));
                }
            }
            this.f.setBackgroundDrawable(this.l.getResources().getDrawable(R.drawable.renew_dark_black_bg));
            this.f.setTextColor(Color.parseColor("#FFDA8C"));
        } else {
            this.f.setBackgroundDrawable(this.l.getResources().getDrawable(R.drawable.renew_dark_black_bg));
            this.f.setTextColor(Color.parseColor("#FFDA8C"));
        }
        if (this.p != null) {
            this.d.setTextColor(Color.parseColor("#FF9600"));
        } else {
            this.d.setTextColor(this.l.getResources().getColor(R.color.task_card_subtitle_color));
        }
    }

    public final void onLogout() {
        LoginHelper.a().b(this);
        this.i.g.p = true;
        a();
    }

    private String c() {
        return this.h != null ? this.h.d : "";
    }

    static /* synthetic */ void e(a aVar) {
        q.a("dl_center_top", "renew", aVar.c(), aVar.h.l.a, aVar.m);
        aVar.b();
        aVar.a();
        com.xunlei.downloadprovider.member.b.b.a(aVar.l, PayFrom.VIP_RENEW_REMIND, aVar.m, aVar.c());
    }
}
