package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.downloadprovider.member.payment.external.l.b;
import java.util.HashMap;

/* compiled from: DefaultJsInterface */
final class l extends b {
    final /* synthetic */ DefaultJsInterface a;

    public final void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp) {
    }

    public final void onGetPrice(int i, String str, Object obj, int i2, String str2) {
    }

    public final void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp) {
    }

    l(DefaultJsInterface defaultJsInterface) {
        this.a = defaultJsInterface;
    }

    public final void onAliPay(int i, String str, Object obj, String str2, int i2) {
        this.a.detachPayListener();
        if (obj != null && (obj instanceof String) != null) {
            str = new HashMap();
            str.put("errorCode", String.valueOf(i));
            str.put("payment", "alipay");
            this.a.callback((String) obj, str);
        }
    }

    public final void onWxPay(int i, String str, Object obj, String str2, int i2) {
        this.a.detachPayListener();
        if (obj != null && (obj instanceof String) != null) {
            str = new HashMap();
            str.put("errorCode", String.valueOf(i));
            str.put("payment", "weixin");
            this.a.callback((String) obj, str);
        }
    }
}
