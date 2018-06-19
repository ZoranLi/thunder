package com.xunlei.common.new_ptl.pay;

import android.content.Context;
import com.xunlei.common.httpclient.BaseHttpClient;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.param.XLAlipayParam;
import com.xunlei.common.new_ptl.pay.param.XLContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPriceParam;
import com.xunlei.common.new_ptl.pay.param.XLWxPayParam;

public class XLPayUtil {
    private static XLPayUtil mInstance;

    private XLPayUtil() {
    }

    private i getProxy() {
        return i.a();
    }

    public static XLPayUtil getInstance() {
        if (mInstance == null) {
            mInstance = new XLPayUtil();
        }
        return mInstance;
    }

    public final Context getContext() {
        return getProxy().d();
    }

    public final BaseHttpClient getHttpClient() {
        return getProxy().e();
    }

    public final String getVersion() {
        return getProxy().f();
    }

    public final int getBusinessType() {
        return getProxy().i();
    }

    public void attachListener(XLOnPayListener xLOnPayListener) {
        getProxy().a(xLOnPayListener);
    }

    public void detachListener(XLOnPayListener xLOnPayListener) {
        getProxy().b(xLOnPayListener);
    }

    public void init(Context context, int i, String str, String str2, String str3, boolean z) {
        getProxy().a(context, i, str, str2, str3, z);
    }

    public void unInit() {
        getProxy().b();
    }

    public void acceptWxPayResult(int i, int i2) {
        getProxy().a(i, i2);
    }

    public int userGetPrice(XLPriceParam xLPriceParam, Object obj) {
        return getProxy().a(xLPriceParam, obj);
    }

    public int userWxPay(XLWxPayParam xLWxPayParam, Object obj) {
        return getProxy().a(xLWxPayParam, obj, null);
    }

    public int userAliPay(XLAlipayParam xLAlipayParam, Object obj) {
        return getProxy().a(xLAlipayParam, obj, null);
    }

    public XLContractor userGetXLContractor(int i) {
        getProxy();
        return i.a(i);
    }

    public int userQueryContract(XLContractParam xLContractParam, Object obj) {
        return getProxy().a(xLContractParam, obj);
    }
}
