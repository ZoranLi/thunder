package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.activity.e;
import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;
import com.xunlei.downloadprovider.member.payment.bean.PayMealItem;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.external.l$a;
import com.xunlei.downloadprovider.member.payment.f;
import com.xunlei.downloadprovider.member.payment.i;
import com.xunlei.downloadprovider.member.payment.paymentfloat.m.a;
import com.xunlei.downloadprovider.member.payment.ui.widget.PayAmoutSaveView;
import com.xunlei.downloadprovider.member.payment.ui.widget.PayMealAreaView;
import com.xunlei.downloadprovider.member.payment.ui.widget.PaymentTypeView;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;

public class FloatFragment extends BaseFragment implements OnClickListener {
    private static final int[] o = new int[]{12, 3, 1};
    private final int A = 5;
    private PayEntryParam B;
    private d C;
    private SparseArray<OpenPriceParam> D;
    private a E = new d(this);
    public PaymentTypeView a;
    LinearLayout b;
    RelativeLayout c;
    PayMealAreaView d;
    int e = this.z;
    private View f;
    private View g;
    private View h;
    private ImageView i;
    private ImageView j;
    private RelativeLayout k;
    private RelativeLayout l;
    private PayAmoutSaveView m;
    private OpenPriceParam n = null;
    private float p;
    private j q = j.a();
    private String r;
    private int s;
    private int t = 3;
    private PayUtil$OrderType u = PayUtil$OrderType.OPEN;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private SparseArray<e> y;
    private int z = this.t;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m.a().a(this.E);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.payment_float_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.B = (PayEntryParam) bundle.getParcelable("PayEntryParam");
            if (this.B != null) {
                bundle = this.B.b;
            } else {
                bundle = f.a(null);
            }
            this.r = bundle;
            if (this.r.equals(PayBaseConstants.KN_CARD_PARM1) == null && this.r.equals(PayBaseConstants.KN_CARD_PARM2) == null) {
                if (this.r.equals(PayBaseConstants.KN_CARD_PARM3) == null) {
                    bundle = null;
                    if (bundle != null) {
                        this.t = 204;
                        this.z = 204;
                    }
                }
            }
            bundle = 1;
            if (bundle != null) {
                this.t = 204;
                this.z = 204;
            }
        }
        if (this.y == null) {
            this.y = new SparseArray();
        }
        this.y.clear();
        bundle = (h() == null || (h().isFromRedPacket() == null && h() != PayFrom.LIXIAN_SPACE)) ? null : 1;
        if (bundle == null) {
            e a = c.a().a(this.r, this.z);
            e a2 = c.a().a(this.r, 5);
            boolean a3 = a(a, this.e);
            if (a3) {
                this.y.append(this.e, a);
                this.t = this.z;
            }
            if (a(a2, 5)) {
                this.y.append(5, a2);
                if (!a3 || a.e() > a2.e()) {
                    this.t = 5;
                }
            }
        }
        if (com.xunlei.downloadprovider.d.d.a().h.e(this.r) != null) {
            this.t = 5;
        }
        this.d = (PayMealAreaView) view.findViewById(R.id.pay_meal_area_view);
        this.d.setPayMealItemSelectListener(new c(this));
        this.d.setRenewTextSize(11);
        this.f = view.findViewById(R.id.pay_bottom_content);
        this.g = view.findViewById(R.id.pay_fail_layout);
        this.h = view.findViewById(R.id.pay_progress);
        ((TextView) view.findViewById(R.id.tv_retry)).setOnClickListener(new e(this));
        this.m = (PayAmoutSaveView) view.findViewById(R.id.pay_amount_layout);
        this.m.a(12).b(12).d(12).c(15);
        this.c = (RelativeLayout) view.findViewById(R.id.rl_view_shadow);
        this.b = (LinearLayout) view.findViewById(R.id.fl_content);
        this.a = (PaymentTypeView) view.findViewById(R.id.payment_type_view);
        bundle = this.a;
        int dimensionPixelOffset = bundle.getResources().getDimensionPixelOffset(R.dimen.payment_48_dp);
        bundle.d.setLayoutParams(new LayoutParams(-1, dimensionPixelOffset));
        bundle.c.setLayoutParams(new LayoutParams(-1, dimensionPixelOffset));
        bundle.a.setVisibility(8);
        bundle.b.setVisibility(8);
        this.a.setOnPaymentTypeSelectListener(new f(this));
        this.c.setOnClickListener(new g(this));
        view.findViewById(R.id.iv_float_close).setOnClickListener(new h(this));
        ((TextView) view.findViewById(R.id.pay_btn)).setOnClickListener(new i(this));
        bundle = new AnimationSet(true);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.detail_bottom_in);
        this.b.setAnimation(loadAnimation);
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_0_1);
        loadAnimation2.setDuration(400);
        loadAnimation2.setFillAfter(true);
        this.c.setAnimation(loadAnimation2);
        bundle.addAnimation(loadAnimation);
        bundle.addAnimation(loadAnimation2);
        bundle.start();
        loadAnimation.setAnimationListener(new k(this));
        this.k = (RelativeLayout) view.findViewById(R.id.tab_1);
        this.k.findViewById(R.id.tab_remomend_tv).setVisibility(8);
        this.i = (ImageView) this.k.findViewById(R.id.pay_tab_select_flag_iv);
        TextView textView = (TextView) this.k.findViewById(R.id.tab_title);
        textView.setText(PayUtil.b(this.e));
        int i = this.t;
        int i2 = R.drawable.ic_pay_tab_platimun;
        if (i != 3) {
            if (i == 204) {
                i2 = R.drawable.ic_pay_tab_kn;
            }
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i2), null, null, null);
        this.k.setOnClickListener(this);
        this.l = (RelativeLayout) view.findViewById(R.id.tab_2);
        this.l.findViewById(R.id.tab_remomend_tv).setVisibility(0);
        this.j = (ImageView) this.l.findViewById(R.id.pay_tab_select_flag_iv);
        this.j.setVisibility(8);
        TextView textView2 = (TextView) this.l.findViewById(R.id.tab_title);
        textView2.setText(getResouceString(R.string.pay_super_vip));
        textView2.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_pay_tab_svip), null, null, null);
        this.l.setOnClickListener(this);
        this.e = this.t;
        g();
    }

    public void onDestroy() {
        super.onDestroy();
        m.a().b(this.E);
        if (this.C != null) {
            LoginHelper.a().b(this.C);
        }
    }

    private void d() {
        if (getActivity() != null) {
            if (b.a(getActivity())) {
                l$a com_xunlei_downloadprovider_member_payment_external_l_a = new l$a(this.a.getPayType(), this.e, PayUtil$OrderType.OPEN, this.s, this.d.getRealPayPrice(), b());
                com_xunlei_downloadprovider_member_payment_external_l_a.b = this.d.getExt();
                com_xunlei_downloadprovider_member_payment_external_l_a.c = this.d.getActivityId();
                if (this.B != null) {
                    com_xunlei_downloadprovider_member_payment_external_l_a.k = this.B.d;
                }
                ((FloatActivity) getActivity()).a(com_xunlei_downloadprovider_member_payment_external_l_a);
            } else {
                XLToast.showNoNetworkToast(getActivity());
            }
        }
    }

    final void a() {
        if (f()) {
            this.d.b();
        } else {
            this.d.a();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_1:
                if (this.e != this.z) {
                    this.e = this.z;
                    g();
                    return;
                }
                return;
            case R.id.tab_2:
                if (i.b(this.e) == null) {
                    this.e = 5;
                    g();
                    break;
                }
                return;
            default:
                break;
        }
    }

    private void a(OpenPriceParam openPriceParam) {
        float monthPrice = openPriceParam.getMonthPrice();
        List arrayList = new ArrayList();
        int i = 3;
        for (int i2 : o) {
            Float f = (Float) openPriceParam.getPriceArray().get(i2);
            if (f != null) {
                com.xunlei.downloadprovider.member.payment.activity.b bVar;
                e eVar = (e) this.y.get(this.e);
                if (eVar == null) {
                    bVar = null;
                } else {
                    bVar = eVar.a(this.e, i2);
                }
                if (bVar != null) {
                    bVar.l = f.floatValue();
                    bVar.m = monthPrice;
                    bVar.t = false;
                    arrayList.add(bVar);
                    i = i2;
                } else if (f.floatValue() >= 0.0f) {
                    PayMealItem payMealItem = new PayMealItem();
                    payMealItem.totalMoney = f.floatValue();
                    payMealItem.month = i2;
                    payMealItem.monthUnitPrice = monthPrice;
                    payMealItem.isTotalPriceMode = false;
                    arrayList.add(payMealItem);
                }
            }
        }
        e eVar2 = (e) this.y.get(this.e);
        this.d.a(arrayList, i, eVar2 != null ? eVar2.b() : -1);
        this.d.setRenewText(Html.fromHtml(getResouceString(R.string.pay_auto_renew_tip_acount, PayUtil.c(this.e))));
        this.h.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        if (this.v == null) {
            com.xunlei.downloadprovider.member.payment.d.a(this.r, this.t, this.u, 3, -1, c(), false, PayUtil$OrderType.OPEN);
            this.v = true;
        }
    }

    final boolean b() {
        boolean z = this.d != null && this.d.c();
        return z && f();
    }

    private void a(int i) {
        com.xunlei.downloadprovider.member.payment.d.a(PayBaseConstants.PAY_PAGE_SHOW_FAIL, this.t, this.u, i);
    }

    private void e() {
        if (this.D == null || this.D.get(this.e) == null) {
            this.h.setVisibility(0);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        }
    }

    final java.lang.String c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.d;
        r0 = r0.getExt();
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 0;
        if (r1 == 0) goto L_0x000e;
    L_0x000d:
        return r2;
    L_0x000e:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x001a }
        r1.<init>(r0);	 Catch:{ Exception -> 0x001a }
        r0 = "actid";	 Catch:{ Exception -> 0x001a }
        r0 = r1.optString(r0);	 Catch:{ Exception -> 0x001a }
        return r0;
    L_0x001a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.paymentfloat.FloatFragment.c():java.lang.String");
    }

    private boolean f() {
        if (PaymentTypeView.a(this.a.getPayType()) && this.d.f() && !((FloatActivity) getActivity()).a(com.xunlei.downloadprovider.member.payment.a.a(this.e, 0))) {
            LoginHelper.a();
            if (l.c()) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        int i = 0;
        boolean z = this.e == this.z;
        this.l.setSelected(z ^ 1);
        this.k.setSelected(z);
        this.i.setVisibility(z ? 0 : 8);
        ImageView imageView = this.j;
        if (z) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.a.a();
        if (this.D != null) {
            if (this.D.get(this.e) != null) {
                a((OpenPriceParam) this.D.get(this.e));
                com.xunlei.downloadprovider.member.payment.d.a(this.t, this.e);
            }
        }
        e();
        m.a().a(this.e);
        com.xunlei.downloadprovider.member.payment.d.a(this.t, this.e);
    }

    private static boolean a(e eVar, int i) {
        if (eVar == null || (eVar.a(i, 1) == null && eVar.a(i, 3) == null && eVar.a(i, 12) == null)) {
            return null;
        }
        return true;
    }

    private PayFrom h() {
        return this.B != null ? this.B.a : null;
    }

    static /* synthetic */ void c(FloatFragment floatFragment) {
        floatFragment.p = floatFragment.d.getRealPayPrice();
        floatFragment.m.b(floatFragment.p);
        floatFragment.m.a(floatFragment.d.getSaveAmount());
    }

    static /* synthetic */ void k(FloatFragment floatFragment) {
        if (l.b()) {
            floatFragment.d();
            return;
        }
        if (floatFragment.C == null) {
            floatFragment.C = new j(floatFragment);
        }
        LoginHelper.a().a(floatFragment.C);
        LoginHelper.a().a(floatFragment.getActivity(), null, LoginFrom.PAY_FLOAT, null);
    }

    static /* synthetic */ com.xunlei.downloadprovider.member.payment.d.a l(FloatFragment floatFragment) {
        com.xunlei.downloadprovider.member.payment.d.a aVar = new com.xunlei.downloadprovider.member.payment.d.a();
        if (floatFragment.d.e()) {
            aVar.a = floatFragment.c();
            aVar.b = 1;
            aVar.c = floatFragment.d.getActivityId();
        }
        return aVar;
    }

    static /* synthetic */ void u(FloatFragment floatFragment) {
        floatFragment.h.setVisibility(8);
        floatFragment.f.setVisibility(8);
        floatFragment.g.setVisibility(0);
        if (floatFragment.e == floatFragment.t && !floatFragment.w) {
            floatFragment.w = true;
            floatFragment.a(1);
        }
        if (i.b(floatFragment.e) && !floatFragment.x) {
            floatFragment.x = true;
            floatFragment.a(2);
        }
    }
}
