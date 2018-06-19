package com.xunlei.common.new_ptl.pay.js;

import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.js.export.XLPayJSInterface;

/* compiled from: XLPayJSListener */
public final class a implements XLOnPayListener {
    private XLPayJSInterface a = null;

    public final void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp) {
    }

    public final void onGetPrice(int i, String str, Object obj, int i2, String str2) {
    }

    public final void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp) {
    }

    public a(XLPayJSInterface xLPayJSInterface) {
        this.a = xLPayJSInterface;
    }

    public final void onWxPay(int i, String str, Object obj, String str2, int i2) {
        this.a.receiveMessage(i, str, obj, i2);
    }

    public final void onAliPay(int i, String str, Object obj, String str2, int i2) {
        this.a.receiveMessage(i, str, obj, i2);
    }
}
