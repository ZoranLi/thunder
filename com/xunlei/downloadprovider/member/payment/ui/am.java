package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLAllContractResp$ContractedResult;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.l.b;
import com.xunlei.xllib.b.d;
import java.util.HashSet;

/* compiled from: PayProblemActivity */
final class am extends b {
    final /* synthetic */ PayProblemActivity a;

    am(PayProblemActivity payProblemActivity) {
        this.a = payProblemActivity;
    }

    public final void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp) {
        if (this.a.j == i2 && i == 0 && xLAllContractResp != null && d.a(xLAllContractResp.mContractedLists) == 0) {
            for (XLAllContractResp$ContractedResult xLAllContractResp$ContractedResult : xLAllContractResp.mContractedLists) {
                if (xLAllContractResp$ContractedResult != null) {
                    if (this.a.k.get(xLAllContractResp$ContractedResult.payType) == null) {
                        this.a.k.append(xLAllContractResp$ContractedResult.payType, new HashSet(4));
                    }
                    ((HashSet) this.a.k.get(xLAllContractResp$ContractedResult.payType)).add(xLAllContractResp$ContractedResult.bizno);
                }
            }
            new StringBuilder("contract map===").append(this.a.k.toString());
        }
    }

    public final void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp) {
        if (this.a.g == i2) {
            this.a.b();
            if (i == 0) {
                this.a.c.setText(this.a.getResources().getString(R.string.pay_cancel_auto_renew_success));
                com.xunlei.downloadprovider.member.payment.d.b(1);
                PayProblemActivity.a(this.a, (int) XLPayType.XL_ALIPAY_CONTRACT);
                return;
            }
            this.a.c.setText(this.a.getResources().getString(R.string.pay_cancel_auto_renew_other_error));
            com.xunlei.downloadprovider.member.payment.d.b(0);
            return;
        }
        if (this.a.h == i2) {
            this.a.b();
            if (i == 0) {
                this.a.c.setText(this.a.getResources().getString(R.string.pay_cancel_auto_renew_success));
                com.xunlei.downloadprovider.member.payment.d.b(1);
                PayProblemActivity.a(this.a, (int) XLPayType.XL_WX_CONTRACT);
                return;
            }
            this.a.c.setText(this.a.getResources().getString(R.string.pay_cancel_auto_renew_other_error));
            com.xunlei.downloadprovider.member.payment.d.b(0);
        }
    }
}
