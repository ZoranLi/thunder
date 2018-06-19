package com.xunlei.downloadprovider.member.payment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.bean.UpgradePriceParam;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.l;
import com.xunlei.downloadprovider.member.payment.i;
import com.xunlei.downloadprovider.member.payment.ui.widget.RangSeekBar;

public class PayUpgradeFragment extends BasePayPageFragment {
    private int q;
    private TextView r;
    private TextView s;
    private TextView t;
    private UpgradePriceParam u;
    private RangSeekBar v;
    private TextView w;
    private TextView x;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pay_upgrade_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r = (TextView) view.findViewById(R.id.member_expired_date);
        this.s = (TextView) view.findViewById(R.id.upgrade_days);
        this.t = (TextView) view.findViewById(R.id.upgrade_title);
        this.t.setText(PayUtil.a(this.g, this.f));
        this.v = (RangSeekBar) view.findViewById(R.id.upgrade_seek_bar);
        this.w = (TextView) view.findViewById(R.id.upgrade_day_expired_date);
        this.x = (TextView) view.findViewById(R.id.upgrade_day_vip_tip);
    }

    protected final boolean f() {
        if (this.u == null) {
            return false;
        }
        int currentCoordValue = r0.v.getCurrentCoordValue();
        if (currentCoordValue >= 0) {
            if (currentCoordValue <= r0.u.getTdays()) {
                d.a(((PayActivity) getActivity()).a, ((PayActivity) getActivity()).o, ((PayActivity) getActivity()).n, k(), r0.f, r0.g, r0.e, r0.d, "5.60.2.5510", m(), false, "0", 0, false, ((PayActivity) getActivity()).d.c("taskid"));
                return true;
            }
        }
        return false;
    }

    protected final void i() {
        this.q = l.a().a(this.f, this.g.toXLSdkOrderType(), null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r12, java.lang.String r13) {
        /*
        r11 = this;
        r0 = r11.q;
        if (r12 != r0) goto L_0x01e2;
    L_0x0004:
        r12 = com.xunlei.downloadprovider.member.payment.bean.UpgradePriceParam.parseFrom(r13);
        if (r12 != 0) goto L_0x0031;
    L_0x000a:
        r11.g();
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        if (r12 == 0) goto L_0x01e2;
    L_0x0015:
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        r12 = r12.o;
        r13 = r11.getActivity();
        r13 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r13;
        r13 = r13.n;
        r0 = "pullfail";
        r1 = r11.h;
        r1 = r1.getType();
        com.xunlei.downloadprovider.member.payment.d.a(r0, r12, r13, r1);
        return;
    L_0x0031:
        r13 = r12.isSuccess();
        if (r13 == 0) goto L_0x01ce;
    L_0x0037:
        r13 = r12.getTdays();
        if (r13 <= 0) goto L_0x01ce;
    L_0x003d:
        r11.u = r12;
        r11.h();
        r13 = r11.h;
        r0 = r11.j;
        r0 = r0.f();
        r0 = com.xunlei.downloadprovider.member.payment.external.PayUtil.b(r0);
        r2 = com.xunlei.downloadprovider.member.payment.a.j.a();
        r2 = r2.b();
        r3 = 0;
        r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        r3 = 2131888163; // 0x7f120823 float:1.9410954E38 double:1.053292702E-314;
        r4 = 8;
        r6 = 2131888159; // 0x7f12081f float:1.9410945E38 double:1.0532927E-314;
        r7 = 0;
        if (r5 <= 0) goto L_0x006b;
    L_0x0065:
        r8 = 31;
        r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r5 < 0) goto L_0x006d;
    L_0x006b:
        if (r2 == 0) goto L_0x0084;
    L_0x006d:
        r2 = r11.getView();
        r2 = r2.findViewById(r6);
        r2.setVisibility(r4);
        r2 = r11.getView();
        r2 = r2.findViewById(r3);
        r2.setVisibility(r7);
        goto L_0x009a;
    L_0x0084:
        r2 = r11.getView();
        r2 = r2.findViewById(r6);
        r2.setVisibility(r7);
        r2 = r11.getView();
        r2 = r2.findViewById(r3);
        r2.setVisibility(r4);
    L_0x009a:
        r2 = 2131362671; // 0x7f0a036f float:1.834513E38 double:1.0530330746E-314;
        r3 = 1;
        r4 = new java.lang.Object[r3];
        r5 = r12.getTdays();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r7] = r5;
        r2 = r11.getString(r2, r4);
        r4 = r11.s;
        r4.setText(r2);
        r2 = r11.r;
        r4 = new java.lang.Object[r3];
        r5 = java.lang.String.valueOf(r0);
        r4[r7] = r5;
        r5 = 2131362672; // 0x7f0a0370 float:1.8345131E38 double:1.053033075E-314;
        r4 = r11.getString(r5, r4);
        r2.setText(r4);
        r2 = r11.v;
        r4 = java.lang.Integer.valueOf(r7);
        r6 = r12.getTdays();
        r6 = java.lang.Integer.valueOf(r6);
        r2.a(r4, r6);
        r13 = r13.getRecommondUpMonth();
        r2 = -1;
        r4 = 2;
        if (r13 == 0) goto L_0x0136;
    L_0x00e0:
        r6 = r13 * 31;
        r8 = r12.getTdays();
        if (r6 > r8) goto L_0x012b;
    L_0x00e8:
        r8 = r11.v;
        r9 = r6 % 31;
        if (r9 != 0) goto L_0x0128;
    L_0x00ee:
        r9 = r8.c;
        r9 = r9.size();
        if (r9 < r4) goto L_0x0128;
    L_0x00f6:
        r9 = r8.c;
        r10 = r8.c;
        r10 = r10.size();
        r10 = r10 - r3;
        r9 = r9.get(r10);
        r9 = (java.lang.Integer) r9;
        r9 = r9.intValue();
        r10 = r8.c;
        r8 = r8.c;
        r8 = r8.size();
        r8 = r8 - r4;
        r8 = r10.get(r8);
        r8 = (java.lang.Integer) r8;
        r8 = r8.intValue();
        r10 = r9 - r6;
        if (r6 <= r8) goto L_0x0128;
    L_0x0120:
        if (r6 >= r9) goto L_0x0128;
    L_0x0122:
        r8 = 31;
        if (r10 >= r8) goto L_0x0128;
    L_0x0126:
        r8 = r3;
        goto L_0x0129;
    L_0x0128:
        r8 = r7;
    L_0x0129:
        if (r8 == 0) goto L_0x0130;
    L_0x012b:
        r6 = r12.getTdays();
        r13 = r2;
    L_0x0130:
        r2 = r11.v;
        r2.setCurrentCoordValue(r13);
        goto L_0x013f;
    L_0x0136:
        r6 = r12.getTdays();
        r13 = r11.v;
        r13.setCurrentCoordValue(r2);
    L_0x013f:
        r11.a(r12, r6);
        r13 = r11.v;
        r2 = new com.xunlei.downloadprovider.member.payment.ui.aq;
        r2.<init>(r11, r12);
        r13.setOnRangeSeekBarChangeListener(r2);
        r13 = r11.f;
        r13 = com.xunlei.downloadprovider.member.payment.i.b(r13);
        if (r13 != 0) goto L_0x015e;
    L_0x0154:
        r13 = r11.f;
        r2 = 209; // 0xd1 float:2.93E-43 double:1.033E-321;
        if (r13 != r2) goto L_0x015b;
    L_0x015a:
        goto L_0x015e;
    L_0x015b:
        r13 = "白金会员";
        goto L_0x0160;
    L_0x015e:
        r13 = "超级会员";
    L_0x0160:
        r2 = r11.w;
        r6 = new java.lang.Object[r3];
        r0 = java.lang.String.valueOf(r0);
        r6[r7] = r0;
        r0 = r11.getString(r5, r6);
        r2.setText(r0);
        r0 = r11.x;
        r1 = 2131362673; // 0x7f0a0371 float:1.8345133E38 double:1.0530330756E-314;
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r5 = r11.d;
        r5 = com.xunlei.downloadprovider.member.payment.external.PayUtil.b(r5);
        r2[r7] = r5;
        r12 = r12.getTdays();
        r12 = java.lang.Integer.valueOf(r12);
        r2[r3] = r12;
        r2[r4] = r13;
        r12 = r11.getString(r1, r2);
        r12 = android.text.Html.fromHtml(r12);
        r0.setText(r12);
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        if (r12 == 0) goto L_0x01e2;
    L_0x01a0:
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        r13 = r12.o;
        r0 = r11.f;
        if (r13 != r0) goto L_0x01cd;
    L_0x01ac:
        r13 = new java.lang.StringBuilder;
        r0 = "pay upgraonPriceLoad---";
        r13.<init>(r0);
        r0 = r12.n;
        r13.append(r0);
        r1 = r12.a;
        r2 = r12.o;
        r3 = r12.n;
        r4 = r11.k();
        r5 = r11.m();
        r6 = 0;
        r7 = 0;
        r8 = com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType.UPGRADE;
        com.xunlei.downloadprovider.member.payment.d.a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x01cd:
        return;
    L_0x01ce:
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        if (r12 == 0) goto L_0x01e2;
    L_0x01d6:
        com.xunlei.downloadprovider.member.payment.external.g.a();
        r12 = r11.getActivity();
        r12 = (com.xunlei.downloadprovider.member.payment.ui.PayActivity) r12;
        r12.q();
    L_0x01e2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.ui.PayUpgradeFragment.a(int, java.lang.String):void");
    }

    protected final void a(boolean z) {
        if (z && isAlive()) {
            r();
            a();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && isAlive()) {
            r();
            a();
        }
    }

    protected final void n() {
        super.n();
        r();
    }

    private void r() {
        if (this.u != null && this.v != null) {
            a(this.u, this.v.getCurrentCoordValue());
        }
    }

    protected final void c() {
        r();
    }

    private void a(UpgradePriceParam upgradePriceParam, int i) {
        this.e = i;
        float uprateFromMap = upgradePriceParam.getUprateFromMap(i);
        upgradePriceParam = upgradePriceParam.getPayCountOfDays(i.a(this.f) ? 3 : 5, i);
        a((float) upgradePriceParam);
        if (uprateFromMap >= 1065353216) {
            a(upgradePriceParam, 0.0f);
            return;
        }
        if (uprateFromMap > 0.0f) {
            a(upgradePriceParam, (upgradePriceParam / uprateFromMap) - upgradePriceParam);
        }
    }

    protected final boolean j() {
        boolean z = this.u != null && this.u.getUprate() < 1.0f;
        if (!z) {
            return super.j();
        }
        StringBuilder stringBuilder = new StringBuilder("当前升级");
        stringBuilder.append(PayUtil.a(this.f));
        stringBuilder.append("有限时折扣，是否要放弃这次优惠？");
        a(stringBuilder.toString());
        return true;
    }

    protected final int k() {
        if (this.h.getRecommondUpMonth() <= 0 && this.u != null) {
            return this.u.getTdays();
        }
        int recommondUpMonth = this.h.getRecommondUpMonth();
        return recommondUpMonth != 0 ? recommondUpMonth * 31 : 0;
    }
}
