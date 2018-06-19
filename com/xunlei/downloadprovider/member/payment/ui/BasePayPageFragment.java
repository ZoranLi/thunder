package com.xunlei.downloadprovider.member.payment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.bean.PayConfigurationParam;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.external.l$a;
import com.xunlei.downloadprovider.member.payment.i;
import com.xunlei.downloadprovider.member.payment.ui.widget.PayAmoutSaveView;
import com.xunlei.downloadprovider.member.payment.ui.widget.PaymentTypeView;
import com.xunlei.downloadprovider.member.payment.voucher.Voucher;
import com.xunlei.downloadprovider.member.payment.voucher.VoucherBizNo;
import com.xunlei.downloadprovider.member.payment.voucher.VoucherItemView;
import com.xunlei.downloadprovider.member.payment.voucher.a;
import com.xunlei.downloadprovider.member.payment.voucher.c;
import com.xunlei.thunder.commonui.dialog.b;
import java.util.Collections;

public abstract class BasePayPageFragment extends BaseFragment {
    View a;
    View b;
    View c;
    float d;
    int e;
    int f = -1;
    PayUtil$OrderType g;
    PayConfigurationParam h;
    protected PaymentTypeView i;
    protected j j;
    protected PayAmoutSaveView k;
    View l;
    protected boolean m = false;
    protected String n;
    VoucherItemView o;
    protected boolean p = false;
    private TextView q;
    private c r;
    private a s = new w(this);
    private VoucherItemView.a t = new x(this);
    private b u;

    protected abstract void a(boolean z);

    protected void b() {
    }

    protected abstract void c();

    protected String d() {
        return "";
    }

    protected String e() {
        return "";
    }

    protected abstract boolean f();

    protected abstract void i();

    protected boolean j() {
        return false;
    }

    protected abstract int k();

    protected boolean l() {
        return false;
    }

    void o() {
    }

    boolean p() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = j.a();
        PayActivity payActivity = (PayActivity) getActivity();
        payActivity.s();
        this.r = payActivity.p;
        bundle = getArguments();
        if (bundle != null) {
            this.f = bundle.getInt("VasType");
            this.g = (PayUtil$OrderType) bundle.getSerializable("RealOrderType");
            this.h = (PayConfigurationParam) bundle.getSerializable("extra_pay_config");
            if (!(i.b(this.f) == null || this.j.b() == null || (this instanceof PayUpgradeFragment) == null)) {
                this.f = 209;
            }
            this.n = com.xunlei.downloadprovider.member.payment.a.a(this.f, this.g.toXLSdkOrderType());
            this.r.a(this.n, this.s);
        }
        this.r.a(VoucherBizNo.getVoucherBizNo(this.n));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.q = (TextView) view.findViewById(R.id.pay_privilege_tv);
        bundle = this.f;
        if (bundle != 204) {
            switch (bundle) {
                case 2:
                    bundle = null;
                    break;
                case 3:
                case 4:
                    bundle = getResouceString(R.string.pay_platinum_privilege_tip);
                    break;
                case 5:
                    bundle = getResouceString(R.string.pay_svip_privilege_tip);
                    break;
                default:
                    bundle = getResouceString(R.string.pay_svip_privilege_tip);
                    break;
            }
        }
        bundle = getResouceString(R.string.pay_kn_privilege_tip);
        this.q.setText(bundle);
        this.b = view.findViewById(R.id.pay_progress);
        this.a = view.findViewById(R.id.pay_fail_layout);
        this.a.findViewById(R.id.tv_retry).setOnClickListener(new s(this));
        this.c = view.findViewById(R.id.pay_meal_layout);
        this.k = (PayAmoutSaveView) view.findViewById(R.id.pay_amount_layout);
        this.k.a(14).b(14).d(14).c(16);
        TextView textView = (TextView) view.findViewById(R.id.pay_btn);
        StringBuilder stringBuilder = new StringBuilder("立即");
        stringBuilder.append(this.g.getText());
        textView.setText(stringBuilder.toString());
        textView.setOnClickListener(new y(this));
        view.findViewById(R.id.member_server_protocol).setOnClickListener(new t(this));
        view.findViewById(R.id.pay_appear_problem).setOnClickListener(new u(this));
        this.i = (PaymentTypeView) view.findViewById(R.id.payment_type_view);
        this.i.setOnPaymentTypeSelectListener(new v(this));
        this.l = view.findViewById(R.id.pay_area_layout);
        this.l.setVisibility(8);
        this.o = (VoucherItemView) view.findViewById(R.id.vouchers_layout);
        this.o.setOnVoucherChangeListener(this.t);
        this.o.a = this.r;
    }

    protected final void a(float f) {
        VoucherItemView voucherItemView = this.o;
        int i = this.e;
        String str = this.n;
        if (voucherItemView.a == null) {
            throw new IllegalArgumentException("IVoucherProcessor is null, please check!");
        }
        voucherItemView.c = f;
        voucherItemView.d = i;
        voucherItemView.e = str;
        voucherItemView.b = voucherItemView.a.a(f, i, str);
        voucherItemView.a();
    }

    protected final void g() {
        this.a.setVisibility(0);
        this.b.setVisibility(4);
        this.c.setVisibility(8);
        this.l.setVisibility(8);
    }

    protected final void h() {
        this.a.setVisibility(4);
        this.b.setVisibility(4);
        this.c.setVisibility(0);
        this.l.setVisibility(0);
    }

    protected final int m() {
        return (int) this.o.getVoucherPrice();
    }

    protected void n() {
        if (this.r != null) {
            this.r.a(this.o.getVoucherCode());
        }
        this.m = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && intent != null) {
            i = intent.getStringExtra("extra:bizno");
            if (TextUtils.equals(i, com.xunlei.downloadprovider.member.payment.a.a(this.f, null)) != 0) {
                ((PayActivity) getActivity()).h.remove(i);
                this.p = true;
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.r != null) {
            this.r.b(this.n, this.s);
            this.s = null;
        }
        if (this.o != null) {
            this.o.setOnVoucherChangeListener(null);
        }
        if (this.u != null) {
            this.u.dismiss();
        }
    }

    @CallSuper
    public void onStart() {
        super.onStart();
        if (this.i != null) {
            this.i.a();
        }
    }

    protected final void a() {
        if (((PayActivity) getActivity()).q != null) {
            VoucherItemView voucherItemView = this.o;
            Voucher voucher = ((PayActivity) getActivity()).q;
            if (!(voucher == null || voucherItemView.b == null)) {
                if (!voucherItemView.b.isEmpty()) {
                    int size = voucherItemView.b.size();
                    Object obj = null;
                    int i = 0;
                    while (i < size) {
                        Voucher voucher2 = (Voucher) voucherItemView.b.get(i);
                        if (voucher2.a == voucher.a) {
                            if (!TextUtils.equals(voucher2.b, voucher.b)) {
                                voucherItemView.b.set(i, voucher);
                            }
                            obj = 1;
                            if (obj == null) {
                                voucherItemView.b.add(voucher);
                                Collections.sort(voucherItemView.b);
                            }
                            voucherItemView.a(voucher);
                        } else {
                            i++;
                        }
                    }
                    if (obj == null) {
                        voucherItemView.b.add(voucher);
                        Collections.sort(voucherItemView.b);
                    }
                    voucherItemView.a(voucher);
                }
            }
        }
    }

    protected final void a(float f, float f2) {
        f -= (float) m();
        this.d = f;
        this.k.b(f);
        this.k.a(f2 + ((float) m()));
    }

    protected final void a(String str) {
        String str2 = ((PayActivity) getActivity()).a;
        if (this.u == null) {
            b b = new b(getActivity()).b(getResouceString(R.string.pay_cancel_str));
            CharSequence resouceString = getResouceString(R.string.pay_confirm_str);
            if (b.a.e != null) {
                if (TextUtils.isEmpty(resouceString)) {
                    b.a.e.setText(com.xunlei.thunder.commonui.R.string.dialog_button_text_confirm);
                } else {
                    b.a.e.setText(resouceString);
                }
            }
            b = b.a(true);
            b.d = new aa(this, str2);
            b.b = new z(this, str2);
            this.u = b;
        }
        this.u.a((CharSequence) str);
        this.u.show();
        d.b(str2);
    }

    public int q() {
        return this.e;
    }

    static /* synthetic */ void a(BasePayPageFragment basePayPageFragment) {
        if (com.xunlei.xllib.android.b.a(basePayPageFragment.getActivity())) {
            l$a com_xunlei_downloadprovider_member_payment_external_l_a = new l$a(basePayPageFragment.i.getPayType(), basePayPageFragment.f, basePayPageFragment.g, basePayPageFragment.e, basePayPageFragment.d, basePayPageFragment.l());
            com_xunlei_downloadprovider_member_payment_external_l_a.c = basePayPageFragment.e();
            com_xunlei_downloadprovider_member_payment_external_l_a.b = basePayPageFragment.d();
            Object voucherCode = basePayPageFragment.o.getVoucherCode();
            float voucherPrice = basePayPageFragment.o.getVoucherPrice();
            if (TextUtils.isEmpty(voucherCode)) {
                com_xunlei_downloadprovider_member_payment_external_l_a.a = null;
                com_xunlei_downloadprovider_member_payment_external_l_a.j = 0.0f;
            }
            com_xunlei_downloadprovider_member_payment_external_l_a.a = voucherCode;
            com_xunlei_downloadprovider_member_payment_external_l_a.j = voucherPrice;
            if (((PayActivity) basePayPageFragment.getActivity()).d != null) {
                com_xunlei_downloadprovider_member_payment_external_l_a.k = ((PayActivity) basePayPageFragment.getActivity()).d.d;
            }
            ((PayActivity) basePayPageFragment.getActivity()).a(com_xunlei_downloadprovider_member_payment_external_l_a);
            return;
        }
        XLToast.showNoNetworkToast(basePayPageFragment.getActivity());
    }
}
