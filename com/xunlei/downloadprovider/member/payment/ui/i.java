package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.downloadprovider.member.payment.external.l.b;

/* compiled from: BasePayActivity */
final class i extends b {
    final /* synthetic */ BasePayActivity a;

    i(BasePayActivity basePayActivity) {
        this.a = basePayActivity;
    }

    public final void onWxPay(int i, String str, Object obj, String str2, int i2) {
        this.a.a(i, str, obj, str2, 2);
    }

    public final void onAliPay(int i, String str, Object obj, String str2, int i2) {
        this.a.a(i, str, obj, str2, 1);
    }

    public final void onGetPrice(int i, String str, Object obj, int i2, String str2) {
        this.a.a(obj, i2, str2);
    }

    public final void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp) {
        BasePayActivity.a(this.a, i, str, obj, i2);
    }

    public final void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp) {
        this.a.n = i != 0;
        BasePayActivity.a(this.a, i, xLAllContractResp, i2);
        BasePayActivity.a(this.a, i, str, i2);
        if (this.a.i != i2) {
            this.a.g();
        }
    }
}
