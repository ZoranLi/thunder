package com.xunlei.downloadprovider.member.payment.ui;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.activity.b;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.activity.e;
import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;
import com.xunlei.downloadprovider.member.payment.bean.PayConfigurationParam;
import com.xunlei.downloadprovider.member.payment.bean.PayMealItem;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.paymentfloat.m;
import com.xunlei.downloadprovider.member.payment.paymentfloat.m.a;
import com.xunlei.downloadprovider.member.payment.ui.widget.PayMealAreaView;
import com.xunlei.downloadprovider.member.payment.ui.widget.PaymentTypeView;
import java.util.ArrayList;
import java.util.List;

public class PayOpenFragment extends BasePayPageFragment {
    PayMealAreaView q;
    private int r = -1;
    private View s;
    private boolean t = false;
    private a u = new aj(this);
    private boolean v = false;
    private e w;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pay_open_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m.a().a(this.u);
        PayActivity payActivity = (PayActivity) getActivity();
        int i = this.f;
        e eVar = null;
        if (payActivity.m != null) {
            eVar = (e) payActivity.m.get(i, null);
        }
        this.w = eVar;
        this.s = view.findViewById(R.id.renew_voucher_line);
        this.q = (PayMealAreaView) view.findViewById(R.id.pay_meal_area_view);
        this.q.setPayMealItemSelectListener(new ai(this));
        this.q.setRenewText(Html.fromHtml(getResouceString(R.string.pay_auto_renew_tip_acount, PayUtil.c(this.f))));
        this.q.setPayReporter(((PayActivity) getActivity()).a);
        i();
    }

    protected final void i() {
        m.a().a(this.f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r12, int r13, java.util.List<java.lang.Integer> r14) {
        /*
        r11 = this;
        r0 = -1;
        if (r12 == r0) goto L_0x0006;
    L_0x0003:
        r11.r = r12;
        return;
    L_0x0006:
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        r0 = 1;
        r1 = 0;
        if (r12 == 0) goto L_0x001e;
    L_0x0010:
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        r12 = r12.r();
        if (r12 == 0) goto L_0x001e;
    L_0x001c:
        r12 = r0;
        goto L_0x001f;
    L_0x001e:
        r12 = r1;
    L_0x001f:
        if (r12 == 0) goto L_0x00f8;
    L_0x0021:
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        r12 = r12.q;
        if (r12 != 0) goto L_0x002d;
    L_0x002b:
        goto L_0x00f5;
    L_0x002d:
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        r12 = r12.d;
        r2 = "voucher_amount";
        r12 = r12.b(r2);
        if (r12 == 0) goto L_0x0048;
    L_0x003d:
        r2 = r12 instanceof java.lang.Integer;
        if (r2 == 0) goto L_0x0048;
    L_0x0041:
        r12 = (java.lang.Integer) r12;
        r12 = r12.intValue();
        goto L_0x0049;
    L_0x0048:
        r12 = r1;
    L_0x0049:
        r2 = "supervip";
        r3 = r11.n;
        r2 = android.text.TextUtils.equals(r2, r3);
        r3 = 3;
        r4 = 10;
        r5 = 12;
        if (r2 == 0) goto L_0x00ec;
    L_0x0058:
        r2 = r11.getActivity();
        r2 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r2;
        r2 = r2.q;
        r6 = r2.d;
        if (r6 == 0) goto L_0x00e2;
    L_0x0064:
        r6 = r2.d;
        r6 = r6.isEmpty();
        if (r6 == 0) goto L_0x006e;
    L_0x006c:
        goto L_0x00e2;
    L_0x006e:
        r2 = r2.d;
        r2 = r2.iterator();
    L_0x0074:
        r6 = r2.hasNext();
        if (r6 == 0) goto L_0x00e2;
    L_0x007a:
        r6 = r2.next();
        r6 = (com.xunlei.downloadprovider.member.payment.voucher.Voucher.a) r6;
        r7 = r6.a;
        r8 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.LimitType.pay_biz;
        if (r7 != r8) goto L_0x0074;
    L_0x0086:
        r7 = "supervip";
        r8 = r6.a;
        r9 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.LimitType.pay_biz;
        if (r8 != r9) goto L_0x00de;
    L_0x008e:
        r8 = r6.b;
        r9 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.equal;
        if (r8 != r9) goto L_0x00b4;
    L_0x0094:
        r8 = r6.c;
        r8 = android.text.TextUtils.isEmpty(r8);
        if (r8 != 0) goto L_0x00de;
    L_0x009c:
        r6 = r6.c;
        r8 = ",";
        r6 = r6.split(r8);
        r8 = r6.length;
        r9 = r1;
        r10 = r9;
    L_0x00a7:
        if (r9 >= r8) goto L_0x00df;
    L_0x00a9:
        r10 = r6[r9];
        r10 = android.text.TextUtils.equals(r7, r10);
        if (r10 != 0) goto L_0x00df;
    L_0x00b1:
        r9 = r9 + 1;
        goto L_0x00a7;
    L_0x00b4:
        r8 = r6.b;
        r9 = com.xunlei.downloadprovider.member.payment.voucher.Voucher.Condition.no_equal;
        if (r8 != r9) goto L_0x00de;
    L_0x00ba:
        r8 = r6.c;
        r8 = android.text.TextUtils.isEmpty(r8);
        if (r8 != 0) goto L_0x00de;
    L_0x00c2:
        r6 = r6.c;
        r8 = ",";
        r6 = r6.split(r8);
        r8 = r6.length;
        r9 = r1;
        r10 = r9;
    L_0x00cd:
        if (r9 >= r8) goto L_0x00da;
    L_0x00cf:
        r10 = r6[r9];
        r10 = android.text.TextUtils.equals(r7, r10);
        if (r10 != 0) goto L_0x00da;
    L_0x00d7:
        r9 = r9 + 1;
        goto L_0x00cd;
    L_0x00da:
        if (r10 != 0) goto L_0x00de;
    L_0x00dc:
        r10 = r0;
        goto L_0x00df;
    L_0x00de:
        r10 = r1;
    L_0x00df:
        if (r10 == 0) goto L_0x0074;
    L_0x00e1:
        r1 = r0;
    L_0x00e2:
        if (r1 == 0) goto L_0x00ec;
    L_0x00e4:
        r1 = 20;
        if (r12 < r1) goto L_0x00e9;
    L_0x00e8:
        goto L_0x00ee;
    L_0x00e9:
        if (r12 >= r4) goto L_0x00f4;
    L_0x00eb:
        goto L_0x00f3;
    L_0x00ec:
        if (r12 < r4) goto L_0x00f0;
    L_0x00ee:
        r3 = r5;
        goto L_0x00f4;
    L_0x00f0:
        r1 = 5;
        if (r12 >= r1) goto L_0x00f4;
    L_0x00f3:
        r3 = r0;
    L_0x00f4:
        r1 = r3;
    L_0x00f5:
        if (r1 == 0) goto L_0x00f8;
    L_0x00f7:
        r13 = r1;
    L_0x00f8:
        r11.r = r13;
        r12 = com.xunlei.xllib.b.d.a(r14);
        if (r12 != 0) goto L_0x0127;
    L_0x0100:
        r12 = r11.r;
        r12 = java.lang.Integer.valueOf(r12);
        r12 = r14.contains(r12);
        if (r12 != 0) goto L_0x0127;
    L_0x010c:
        r12 = r14.size();
        r12 = r12 - r0;
    L_0x0111:
        if (r12 < 0) goto L_0x0127;
    L_0x0113:
        r13 = r14.get(r12);
        r13 = (java.lang.Integer) r13;
        r13 = r13.intValue();
        r0 = r11.r;
        if (r13 <= r0) goto L_0x0124;
    L_0x0121:
        r11.r = r13;
        return;
    L_0x0124:
        r12 = r12 + -1;
        goto L_0x0111;
    L_0x0127:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.ui.PayOpenFragment.a(int, int, java.util.List):void");
    }

    private void s() {
        if (this.q != null) {
            float realPayPrice = this.q.getRealPayPrice();
            if (((PayActivity) getActivity()) != null) {
                a(realPayPrice);
                if (this.q.e() && this.o != null) {
                    this.o.b();
                }
                t();
            }
            a(this.q.getRealPayPrice(), this.q.getSaveAmount());
        }
    }

    protected final int k() {
        return this.r;
    }

    protected final boolean l() {
        return (this.q.c() && v()) || this.q.d();
    }

    protected final void a(boolean z) {
        if (z && isAlive()) {
            s();
            a();
        }
    }

    protected final void b() {
        u();
    }

    protected final String d() {
        return this.q.getExt();
    }

    protected final String e() {
        return this.q.getActivityId();
    }

    public void onDestroy() {
        super.onDestroy();
        m.a().b(this.u);
    }

    private boolean v() {
        if (PaymentTypeView.a(this.i.getPayType()) && !((PayActivity) getActivity()).a(com.xunlei.downloadprovider.member.payment.a.a(this.f, this.g.toXLSdkOrderType()))) {
            LoginHelper.a();
            if (l.c()) {
                return true;
            }
        }
        return false;
    }

    final void o() {
        u();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && isAlive()) {
            s();
            a();
        }
    }

    protected final void n() {
        super.n();
        s();
    }

    final boolean p() {
        return this.t;
    }

    protected final void c() {
        s();
    }

    public final int q() {
        return this.q.getRealPayMonth();
    }

    protected final boolean f() {
        String str = ((PayActivity) getActivity()).a;
        int i = ((PayActivity) getActivity()).o;
        PayUtil$OrderType payUtil$OrderType = ((PayActivity) getActivity()).n;
        PayUtil$OrderType payUtil$OrderType2 = this.g;
        d.a aVar = new d.a();
        if (this.q.e()) {
            aVar.a = r();
            aVar.b = 1;
            aVar.c = r0.q.getActivityId();
        }
        int i2 = aVar.b;
        d.a(str, i, payUtil$OrderType, r0.r, r0.f, payUtil$OrderType2, r0.e, r0.d, "5.60.2.5510", m(), l(), aVar.a, i2, r0.t, ((PayActivity) getActivity()).d.c("taskid"));
        return true;
    }

    private void t() {
        if ((this.o.getVisibility() == 0 ? 1 : 0) != 0) {
            this.q.a.setVisibility(8);
            if (this.q.h()) {
                this.s.setVisibility(8);
                return;
            } else {
                this.s.setVisibility(0);
                return;
            }
        }
        if (this.q.h()) {
            this.q.i();
        }
        this.s.setVisibility(8);
    }

    protected final boolean j() {
        String string;
        int i = this.f;
        if (i == 3) {
            string = getString(R.string.pay_open_platinum_back_tip);
        } else if (i == 5) {
            string = getString(R.string.pay_open_super_back_tip);
        } else if (i != 204) {
            string = getString(R.string.pay_open_back_tip, new Object[]{PayUtil.a(this.f)});
        } else {
            string = getString(R.string.pay_open_kuainiao_back_tip);
        }
        a(string);
        return true;
    }

    private void u() {
        Object obj = (v() && this.q.f()) ? 1 : null;
        if (obj == null || this.p) {
            this.q.a();
        } else {
            this.q.b();
        }
        t();
    }

    final java.lang.String r() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.ui.PayOpenFragment.r():java.lang.String");
    }

    static /* synthetic */ void a(PayOpenFragment payOpenFragment, OpenPriceParam openPriceParam) {
        BasePayPageFragment basePayPageFragment = payOpenFragment;
        PayConfigurationParam payConfigurationParam = basePayPageFragment.h;
        if (payConfigurationParam != null) {
            payOpenFragment.h();
            int i = 0;
            List monthList = payConfigurationParam.getMonthList(false);
            if (monthList != null) {
                if (monthList.size() > 0) {
                    b bVar;
                    if (((PayActivity) payOpenFragment.getActivity()).a(com.xunlei.downloadprovider.member.payment.a.a(basePayPageFragment.f, basePayPageFragment.g.toXLSdkOrderType()))) {
                        bVar = null;
                    } else {
                        c a = c.a();
                        int i2 = basePayPageFragment.f;
                        String str = 3 == i2 ? "vip2017bjautorenew" : 5 == i2 ? "vip2017svipautorenew" : "";
                        if (!TextUtils.isEmpty(str)) {
                            e eVar;
                            com.xunlei.downloadprovider.member.payment.activity.a a2 = a.b().a(str);
                            if (a2 == null) {
                                eVar = null;
                            } else {
                                eVar = com.xunlei.downloadprovider.member.payment.activity.m.a(a2);
                            }
                            if (eVar != null) {
                                bVar = eVar.a(i2, 0);
                                if (bVar != null) {
                                    monthList.remove(Integer.valueOf(6));
                                }
                            }
                        }
                        bVar = null;
                        if (bVar != null) {
                            monthList.remove(Integer.valueOf(6));
                        }
                    }
                    List arrayList = new ArrayList();
                    boolean z = basePayPageFragment.w == null && payConfigurationParam.getMode() == 0;
                    float monthPrice = openPriceParam.getMonthPrice();
                    int size = monthList.size();
                    int i3 = -1;
                    int i4 = -1;
                    while (i < size) {
                        int intValue = ((Integer) monthList.get(i)).intValue();
                        Float f = (Float) openPriceParam.getPriceArray().get(intValue);
                        if (f != null) {
                            b a3;
                            if (basePayPageFragment.w != null) {
                                a3 = basePayPageFragment.w.a(basePayPageFragment.f, intValue);
                            } else {
                                a3 = null;
                            }
                            if (a3 != null) {
                                a3.t = z;
                                a3.l = f.floatValue();
                                a3.m = monthPrice;
                                arrayList.add(a3);
                                if ((TextUtils.isEmpty(a3.q) ^ 1) != 0 && basePayPageFragment.r == -1) {
                                    basePayPageFragment.r = intValue;
                                }
                                if (i4 == -1) {
                                    i4 = intValue;
                                }
                            } else if (f.floatValue() >= 0.0f) {
                                PayMealItem payMealItem = new PayMealItem();
                                payMealItem.totalMoney = f.floatValue();
                                payMealItem.month = intValue;
                                payMealItem.monthUnitPrice = monthPrice;
                                payMealItem.isTotalPriceMode = z;
                                arrayList.add(payMealItem);
                            }
                        }
                        i++;
                    }
                    if (bVar != null) {
                        bVar.t = z;
                        bVar.l = (float) bVar.b;
                        bVar.m = (float) bVar.b;
                        arrayList.add(bVar);
                    }
                    if (basePayPageFragment.r == -1) {
                        basePayPageFragment.a(i4, payConfigurationParam.getRecommondMonth(), monthList);
                    }
                    PayMealAreaView payMealAreaView = basePayPageFragment.q;
                    i = basePayPageFragment.r;
                    if (basePayPageFragment.w != null) {
                        i3 = basePayPageFragment.w.b();
                    }
                    payMealAreaView.a(arrayList, i, i3);
                    basePayPageFragment.t = basePayPageFragment.q.d();
                }
            }
            payOpenFragment.g();
        }
        if (((PayActivity) payOpenFragment.getActivity()) != null && !basePayPageFragment.v) {
            PayActivity payActivity = (PayActivity) payOpenFragment.getActivity();
            if (payActivity.o == basePayPageFragment.f) {
                basePayPageFragment.v = true;
                new StringBuilder("PayOpenFragment onPriceLoad---").append(payActivity.n);
                d.a(payActivity.a, payActivity.o, payActivity.n, basePayPageFragment.r, payOpenFragment.m(), payOpenFragment.r(), basePayPageFragment.t, PayUtil$OrderType.OPEN);
            }
        }
    }
}
