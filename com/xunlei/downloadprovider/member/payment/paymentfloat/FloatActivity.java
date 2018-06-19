package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.xunlei.common.commonview.SimpleLoadingPageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.d.a;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.ui.BasePayActivity;
import com.xunlei.xllib.android.XLIntent;

public class FloatActivity extends BasePayActivity {
    private FloatFragment j;
    private SimpleLoadingPageView k;

    protected final int a() {
        return R.layout.payment_float_activity;
    }

    protected final int j() {
        return 3;
    }

    protected final void init(View view) {
        this.k = (SimpleLoadingPageView) findViewById(R.id.pay_progress_dig);
        this.k.setTip(getString(R.string.pay_loading_tip));
        view = getSupportFragmentManager().beginTransaction();
        if (this.j == null) {
            this.j = new FloatFragment();
        }
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("PayEntryParam", this.d);
        this.j.setArguments(bundle);
        view.replace(R.id.fl_content, this.j);
        view.commitAllowingStateLoss();
    }

    public static void a(Context context, PayEntryParam payEntryParam) {
        if (context != null) {
            Intent xLIntent = new XLIntent(context, FloatActivity.class);
            xLIntent.putExtra("PayEntryParam", payEntryParam);
            if ((context instanceof Activity) == null) {
                xLIntent.addFlags(268435456);
            }
            context.startActivity(xLIntent);
        }
    }

    private void n() {
        FloatFragment floatFragment = this.j;
        floatFragment.b.clearAnimation();
        floatFragment.c.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(floatFragment.getContext(), R.anim.detail_bottom_out);
        floatFragment.b.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new l(floatFragment));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    protected final void a(int i) {
        if (this.j != 0) {
            this.j.a();
        }
    }

    protected final a b() {
        a aVar;
        if (this.j != null) {
            FloatFragment floatFragment = this.j;
            CharSequence charSequence = this.g;
            aVar = new a();
            if (floatFragment.d.e()) {
                aVar.a = floatFragment.c();
                Object activityId = floatFragment.d.getActivityId();
                if (TextUtils.equals(activityId, charSequence)) {
                    aVar.b = 1;
                } else {
                    aVar.b = 0;
                }
                aVar.d = floatFragment.d.getExt();
                aVar.c = activityId;
            }
        } else {
            aVar = null;
        }
        return aVar == null ? new a() : aVar;
    }

    protected final void d() {
        if (this.k != null) {
            this.k.show();
        }
    }

    protected final void g() {
        if (this.k != null) {
            this.k.hide();
        }
    }

    protected final int h() {
        return this.j != null ? this.j.e : 0;
    }

    protected final PayUtil$OrderType i() {
        return PayUtil$OrderType.OPEN;
    }

    public static void a(Context context, PayFrom payFrom) {
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.a(null);
        a(context, payEntryParam);
    }

    public void onBackPressed() {
        j.a();
        if (l.b()) {
            int i = this.j.e;
            u uVar = new u(this);
            if (i == 3) {
                uVar.a((int) R.string.pay_close_platinum_content);
                uVar.i.setText(R.string.pay_close_privilege);
                uVar.j.setText(R.string.pay_close_platinum_privilege_1);
                uVar.k.setText(R.string.pay_close_platinum_privilege_2);
                uVar.i.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_accel), null, null);
                uVar.j.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_lixian), null, null);
                uVar.k.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_platinum), null, null);
            } else if (i == 5) {
                uVar.a((int) R.string.pay_close_super_content);
                uVar.i.setText(R.string.pay_close_privilege);
                uVar.j.setText(R.string.pay_close_super_privilege_1);
                uVar.k.setText(R.string.pay_close_super_privilege_2);
                uVar.i.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_accel), null, null);
                uVar.j.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_kuainiao), null, null);
                uVar.k.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_game), null, null);
            } else if (i == 204) {
                uVar.a((int) R.string.pay_close_kn_content);
                uVar.i.setText(R.string.pay_close_kn_privilege_1);
                uVar.j.setText(R.string.pay_close_kn_privilege_2);
                uVar.k.setText(R.string.pay_close_kn_privilege_3);
                uVar.i.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_band), null, null);
                uVar.j.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_download), null, null);
                uVar.k.setCompoundDrawablesWithIntrinsicBounds(null, uVar.l.getResources().getDrawable(R.drawable.pay_float_video), null, null);
            }
            uVar.a(getResources().getString(R.string.pay_close_left_tips));
            uVar.b(getResources().getString(R.string.pay_close_right_tips));
            uVar.a(new a(this));
            uVar.b(new b(this));
            uVar.show();
            d.b(this.a);
            return;
        }
        n();
    }

    protected final int c() {
        int i;
        if (this.e != null) {
            i = this.e.g;
        } else {
            i = 0;
        }
        int realPayMonth = this.j != null ? this.j.d.getRealPayMonth() : i;
        if (realPayMonth > i) {
            i = realPayMonth;
        }
        return i == Integer.MAX_VALUE ? 1 : i;
    }
}
