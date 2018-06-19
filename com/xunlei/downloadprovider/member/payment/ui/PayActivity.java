package com.xunlei.downloadprovider.member.payment.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.common.commonview.SimpleLoadingPageView;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.a.f;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.bean.PayConfigurationParam;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.external.g;
import com.xunlei.downloadprovider.member.payment.external.l;
import com.xunlei.downloadprovider.member.payment.voucher.Voucher;
import com.xunlei.downloadprovider.member.payment.voucher.b;
import com.xunlei.downloadprovider.member.payment.voucher.c;
import com.xunlei.xllib.android.XLIntent;
import java.util.List;

public final class PayActivity extends BasePayPagerActivity implements OnClickListener {
    PayUtil$OrderType n;
    int o;
    c p;
    Voucher q;
    private SimpleLoadingPageView r;
    private View s;
    private int t;
    private f u = f.a();
    private PayConfigurationParam v;
    private LocalBroadcastManager w;
    private MyBroadcastReceiver x;
    private View y;
    private b z = new ah(this);

    public final class MyBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ PayActivity a;

        public MyBroadcastReceiver(PayActivity payActivity) {
            this.a = payActivity;
        }

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals("action.type.activation.pay.success", intent.getAction()) != null) {
                this.a.finish();
            }
        }
    }

    protected final int a() {
        return R.layout.pay_activity;
    }

    protected final /* synthetic */ BaseFragment b(int i) {
        return c(i);
    }

    protected final void init(View view) {
        super.init(view);
        findViewById(R.id.white_button_line).setVisibility(8);
        findViewById(R.id.xreader_common_divide).setVisibility(8);
        d.a();
        g.b();
        view = new TitleBar((Activity) this);
        findViewById(R.id.titlebar_left).setOnClickListener(this);
        ((TextView) findViewById(R.id.titlebar_title)).setText(getResources().getString(R.string.member_pay));
        view.mRight1.setVisibility(0);
        view.mRight1.setText(getResources().getString(R.string.activation_code_pay));
        view.mRight1.setTextColor(getResources().getColor(R.color.global_text_color_2));
        view.mRight1.setOnClickListener(this);
        this.s = findViewById(R.id.pay_content);
        this.s.setVisibility(8);
        this.r = (SimpleLoadingPageView) findViewById(R.id.pay_progress_dig);
        this.r.setTip(getString(R.string.pay_loading_tip));
        d();
        s();
        try {
            this.w = LocalBroadcastManager.getInstance(getApplicationContext());
            this.x = new MyBroadcastReceiver(this);
            view = new IntentFilter();
            view.addAction("action.type.activation.pay.success");
            this.w.registerReceiver(this.x, view);
        } catch (View view2) {
            view2.toString();
        }
        if (TextUtils.equals(getIntent().getStringExtra("from"), "download_noti") != null) {
            a.a("download_in", "in_vip_speedup");
        }
    }

    protected final void a(int i) {
        if (this.i != i) {
            i = this.k.getCount();
            for (int i2 = 0; i2 < i; i2++) {
                BasePayPageFragment c = c(i2);
                if (c != null) {
                    c.o();
                }
            }
        } else if (r() == 0 || TextUtils.isEmpty(this.f) != 0) {
            t();
        } else {
            this.p.a(this.f, this.z);
        }
    }

    protected final void d() {
        if (this.r != null) {
            this.r.show();
        }
    }

    protected final void g() {
        if (this.r != null) {
            this.r.hide();
        }
    }

    protected final int h() {
        return this.o;
    }

    protected final PayUtil$OrderType i() {
        return this.n;
    }

    private BasePayPageFragment c(int i) {
        return (BasePayPageFragment) super.b(i);
    }

    protected final void a(Object obj, int i, String str) {
        if (this.t == i && (obj instanceof l.c)) {
            this.u.a(new af(this, ((l.c) obj).b, str));
            return;
        }
        obj = this.k.getCount();
        for (int i2 = 0; i2 < obj; i2++) {
            BasePayPageFragment c = c(i2);
            if (c != null && (c instanceof PayUpgradeFragment)) {
                ((PayUpgradeFragment) c).a(i, str);
            }
        }
    }

    private void u() {
        q();
        if (!com.xunlei.xllib.b.d.a(this.l)) {
            ae aeVar = (ae) this.l.get(this.j.getCurrentItem());
            this.n = (PayUtil$OrderType) aeVar.c.getSerializable("RealOrderType");
            this.o = aeVar.c.getInt("VasType");
        }
        g();
        this.s.setVisibility(0);
        v();
    }

    private void v() {
        if (this.y == null) {
            this.y = findViewById(R.id.login_prompt_layout);
        }
        j.a();
        if (com.xunlei.downloadprovider.member.login.b.l.b()) {
            this.y.setVisibility(8);
        } else {
            this.y.setVisibility(0);
        }
    }

    public final void onClick(View view) {
        view = view.getId();
        if (view != R.id.titlebar_left) {
            if (view == R.id.titlebar_right_1) {
                j.a();
                if (com.xunlei.downloadprovider.member.login.b.l.b() != null) {
                    d.c();
                    view = new XLIntent(this, ActivationActivity.class);
                    view.putExtra(PayBaseConstants.PAY_FROM, this.a);
                    startActivity(view);
                    return;
                }
                w();
            }
            return;
        }
        x();
    }

    public final void onBackPressed() {
        x();
    }

    protected final List<ae> p() {
        if (this.v == null) {
            return g.a(this.c, this.a);
        }
        return g.a(this.v, this.c);
    }

    public final void onClickGotoLogin(View view) {
        w();
    }

    private void w() {
        LoginHelper.a().a(LoginPageType.LOGIN_FLOAT, getApplicationContext(), null, LoginFrom.PAY_PAGE, 268435456, null);
    }

    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    protected final void onDestroy() {
        try {
            this.w.unregisterReceiver(this.x);
        } catch (Exception e) {
            e.toString();
        }
        f fVar = this.u;
        fVar.c = null;
        if (fVar.b != null) {
            fVar.a.removeCallbacks(fVar.b);
        }
        this.z = null;
        super.onDestroy();
    }

    final boolean r() {
        return this.c != null && this.c.isFromRedPacket();
    }

    final void s() {
        if (this.p == null) {
            this.p = new com.xunlei.downloadprovider.member.payment.voucher.d();
        }
    }

    protected final void a(boolean z) {
        super.a(z);
        if (z && !isFinishing()) {
            t();
            v();
        }
    }

    protected final void m() {
        super.m();
        t();
        v();
    }

    protected final d.a b() {
        d.a aVar;
        BasePayPageFragment basePayPageFragment = (BasePayPageFragment) super.o();
        if (basePayPageFragment instanceof PayOpenFragment) {
            PayOpenFragment payOpenFragment = (PayOpenFragment) basePayPageFragment;
            CharSequence charSequence = this.g;
            aVar = new d.a();
            if (payOpenFragment.q.e()) {
                aVar.a = payOpenFragment.r();
                Object activityId = payOpenFragment.q.getActivityId();
                if (TextUtils.equals(activityId, charSequence)) {
                    aVar.b = 1;
                } else {
                    aVar.b = 0;
                }
                aVar.d = payOpenFragment.q.getExt();
                aVar.c = activityId;
            }
        } else {
            aVar = null;
        }
        return aVar == null ? new d.a() : aVar;
    }

    protected final int c() {
        int i;
        if (this.e != null) {
            i = this.e.g;
        } else {
            i = 0;
        }
        BasePayPageFragment basePayPageFragment = (BasePayPageFragment) super.o();
        int q = basePayPageFragment != null ? basePayPageFragment.q() : i;
        if (q > i) {
            i = q;
        }
        return i == Integer.MAX_VALUE ? 1 : i;
    }

    protected final int j() {
        BasePayPageFragment basePayPageFragment = (BasePayPageFragment) super.o();
        return basePayPageFragment != null ? basePayPageFragment.k() : 0;
    }

    private void t() {
        if (this.c != null && this.c.isFromKuaiNiao()) {
            this.v = null;
            u();
        } else if (BasePayActivity.l()) {
            this.t = l.a().a(5, 1, null);
        } else {
            this.u.a(new ag(this));
        }
    }

    private void x() {
        BasePayPageFragment basePayPageFragment = (BasePayPageFragment) super.o();
        if (basePayPageFragment != null) {
            d.a(this.o, this.n, basePayPageFragment.p(), this.a, basePayPageFragment.k());
        }
        j.a();
        if (!com.xunlei.downloadprovider.member.login.b.l.b() || basePayPageFragment == null || !basePayPageFragment.j()) {
            finish();
        }
    }

    protected final void n() {
        BasePayPageFragment basePayPageFragment = (BasePayPageFragment) super.o();
        if (basePayPageFragment != null) {
            d.a(this.o, basePayPageFragment.f);
        }
    }

    protected final void k() {
        int count = this.k.getCount();
        for (int i = 0; i < count; i++) {
            BasePayPageFragment c = c(i);
            if (c != null) {
                c.n();
            }
        }
    }

    protected final /* bridge */ /* synthetic */ BaseFragment o() {
        return (BasePayPageFragment) super.o();
    }
}
