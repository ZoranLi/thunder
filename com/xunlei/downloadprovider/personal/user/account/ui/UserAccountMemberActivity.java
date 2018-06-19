package com.xunlei.downloadprovider.personal.user.account.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.e.d;
import com.xunlei.downloadprovider.member.login.b.e.f;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.aj;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.xllib.android.b;
import com.xunlei.xllib.b.e;
import java.text.DecimalFormat;

public class UserAccountMemberActivity extends BaseActivity implements OnClickListener {
    public static boolean a = false;
    d c = new aa(this);
    private final int d = 100;
    private final int e = 101;
    private final String f = "flowtotal";
    private final String g = "flowused";
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private Button k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private LoginHelper p = LoginHelper.a();
    private MessageListener q = new x(this);
    private Handler r = new StaticHandler(this.q);
    private h s = new y(this);
    private f t = new z(this);

    protected void onStop() {
        a = false;
        super.onStop();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = new StringBuilder();
        bundle.append(getClass());
        bundle.append("---onCreate ---");
        bundle.append(Thread.currentThread().getId());
        this.p.b();
        setContentView(R.layout.new_payment_userinfo);
        this.h = (LinearLayout) findViewById(R.id.userinfo_bottom_layout);
        ((Button) findViewById(R.id.new_user_center_pay_member_item)).setOnClickListener(this);
        this.i = (TextView) findViewById(R.id.user_account_member_type_tv);
        this.o = (TextView) findViewById(R.id.tv_top_vip_icon);
        this.l = (TextView) findViewById(R.id.userinfo_flow_value_tv);
        this.j = (TextView) findViewById(R.id.tv_center_vip_date);
        this.k = (Button) findViewById(R.id.user_account_renew_pay);
        this.k.setOnClickListener(this);
        if (this.p.l() != null) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(4);
        }
        this.m = (TextView) findViewById(R.id.user_exps_vip);
        this.n = (TextView) findViewById(R.id.tv_user_lixian_space);
        bundle = new TitleBar((Activity) this);
        bundle.mTitle.setText(getResources().getString(R.string.userinfo));
        bundle.mTitle.setOnClickListener(this);
        this.j.setText(PayUtil.a(this.p.o()));
        bundle = this.o;
        StringBuilder stringBuilder = new StringBuilder("LV");
        stringBuilder.append(this.p.m());
        bundle.setText(stringBuilder.toString());
        bundle = this.m;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.p.p());
        stringBuilder.append("/");
        stringBuilder.append(aj.b(this.p.m()));
        bundle.setText(stringBuilder.toString());
        bundle = this.i;
        CharSequence charSequence = "";
        boolean l = this.p.l();
        int f = this.p.g.f();
        if (l) {
            switch (f) {
                case 1:
                    this.h.setVisibility(0);
                    charSequence = getResources().getString(R.string.user_member_type_mini);
                    break;
                case 2:
                    this.h.setVisibility(0);
                    charSequence = getResources().getString(R.string.user_member_type_vip);
                    break;
                case 3:
                    this.h.setVisibility(0);
                    charSequence = getResources().getString(R.string.user_member_type_platinum);
                    break;
                case 4:
                    this.h.setVisibility(8);
                    charSequence = getResources().getString(R.string.user_member_type_diamond);
                    break;
                case 5:
                    this.h.setVisibility(8);
                    charSequence = getResources().getString(R.string.user_member_type_super_vip);
                    break;
                default:
                    break;
            }
        }
        bundle.setText(charSequence);
        this.p.a(this.s);
        bundle = this.p;
        f fVar = this.t;
        bundle = bundle.g;
        if (!(fVar == null || bundle.c.contains(fVar))) {
            bundle.c.add(fVar);
        }
        bundle = this.p;
        d dVar = this.c;
        bundle = bundle.g;
        if (dVar != null && !bundle.d.contains(dVar)) {
            bundle.d.add(dVar);
        }
    }

    public void onResume() {
        super.onResume();
        if (l.c()) {
            a();
        }
        if (l.c() && b.a(this)) {
            a();
            this.p.b();
            i.e(this.p.q);
            com.xunlei.downloadprovider.member.login.b bVar = this.p.a;
            if (bVar == null || bVar.a != 0) {
                i.f(this.p.q);
                return;
            } else {
                a(0, bVar);
                return;
            }
        }
        if (!b.a(this)) {
            CharSequence stringBuilder;
            this.i.setText(com.xunlei.downloadprovider.personal.user.b.a().a("user_member_type", ""));
            this.j.setText(com.xunlei.downloadprovider.personal.user.b.a().a("user_member_date", ""));
            this.o.setText(com.xunlei.downloadprovider.personal.user.b.a().a("user_member_level", ""));
            this.m.setText(com.xunlei.downloadprovider.personal.user.b.a().a("user_member_score", ""));
            long a = com.xunlei.downloadprovider.personal.user.b.a().a("flow_total");
            long a2 = com.xunlei.downloadprovider.personal.user.b.a().a("flow_used");
            String str = "";
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a(e.a(a2, 2)));
                stringBuilder2.append("/");
                stringBuilder2.append(a(e.a(a, 2)));
                stringBuilder = stringBuilder2.toString();
            } catch (Exception e) {
                e.printStackTrace();
                stringBuilder = str;
            }
            this.l.setText(stringBuilder);
            a = com.xunlei.downloadprovider.personal.user.b.a().a("max_space");
            String a3 = e.a(com.xunlei.downloadprovider.personal.user.b.a().a("available_space"), 2);
            String a4 = e.a(a, 2);
            String str2 = "";
            try {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a(a3));
                stringBuilder3.append("/");
                stringBuilder3.append(a(a4));
                stringBuilder = stringBuilder3.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                stringBuilder = str2;
            }
            this.n.setText(stringBuilder);
        }
    }

    protected void onStart() {
        a = true;
        super.onStart();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r2) {
        /*
        r1 = this;
        r2 = r2.getId();
        r0 = 2131886972; // 0x7f12037c float:1.9408538E38 double:1.0532921137E-314;
        if (r2 == r0) goto L_0x0020;
    L_0x0009:
        r0 = 2131888061; // 0x7f1207bd float:1.9410747E38 double:1.0532926517E-314;
        if (r2 == r0) goto L_0x0014;
    L_0x000e:
        r0 = 2131888064; // 0x7f1207c0 float:1.9410753E38 double:1.053292653E-314;
        if (r2 == r0) goto L_0x001a;
    L_0x0013:
        goto L_0x001f;
    L_0x0014:
        r2 = com.xunlei.downloadprovider.member.login.b.l.c();
        if (r2 == 0) goto L_0x001f;
    L_0x001a:
        r2 = com.xunlei.downloadprovider.member.payment.external.PayFrom.ACCOUNT_CENTER;
        com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity.a(r1, r2);
    L_0x001f:
        return;
    L_0x0020:
        r1.onBackPressed();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.user.account.ui.UserAccountMemberActivity.onClick(android.view.View):void");
    }

    private void a(int i, com.xunlei.downloadprovider.member.login.b bVar) {
        if (this.p.l() && i == 0 && bVar != null && bVar.a == 0) {
            if (bVar.d == 0) {
                this.n.setText(R.string.user_highspeed_default);
                return;
            }
            long j = bVar.d - bVar.c;
            long j2 = bVar.d;
            com.xunlei.downloadprovider.personal.user.b.a().a("max_space", j2);
            com.xunlei.downloadprovider.personal.user.b.a().a("available_space", j);
            String a = e.a(j, 2);
            String a2 = e.a(j2, 2);
            bVar = "";
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a(a));
                stringBuilder.append("/");
                stringBuilder.append(a(a2));
                i = stringBuilder.toString();
            } catch (int i2) {
                i2.printStackTrace();
                i2 = bVar;
            }
            this.n.setText(i2);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private String a(String str) {
        String substring = str.substring(str.length() - 2, str.length());
        String substring2 = str.substring(0, str.length() - 2);
        if (TextUtils.isEmpty(substring2)) {
            return substring;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass());
        stringBuilder.append("---totalString---totalString2---Unit---df.format(Double.valueOf(totalString2))+Unit---");
        stringBuilder.append(str);
        stringBuilder.append("---");
        stringBuilder.append(substring2);
        stringBuilder.append("---");
        stringBuilder.append(substring);
        stringBuilder.append("---");
        stringBuilder.append(decimalFormat.format(Double.valueOf(substring2)));
        stringBuilder.append(substring);
        stringBuilder.append("---");
        stringBuilder.append(Thread.currentThread().getId());
        str = new StringBuilder();
        str.append(decimalFormat.format(Double.valueOf(substring2)));
        str.append(substring);
        return str.toString();
    }

    protected void onDestroy() {
        this.p.b(this.s);
        LoginHelper loginHelper = this.p;
        loginHelper.g.c.remove(this.t);
        loginHelper = this.p;
        loginHelper.g.d.remove(this.c);
        super.onDestroy();
    }

    private void a() {
        if (l.c()) {
            int p = this.p.p();
            int b = aj.b(aj.a(p));
            TextView textView = this.m;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(p);
            stringBuilder.append("/");
            stringBuilder.append(b);
            textView.setText(stringBuilder.toString());
            TextView textView2 = this.o;
            StringBuilder stringBuilder2 = new StringBuilder("LV");
            stringBuilder2.append(this.p.m());
            textView2.setText(stringBuilder2.toString());
            this.j.setText(PayUtil.a(this.p.o()));
        }
    }
}
