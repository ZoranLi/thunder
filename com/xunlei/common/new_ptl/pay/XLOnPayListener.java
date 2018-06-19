package com.xunlei.common.new_ptl.pay;

public interface XLOnPayListener {
    void onAliPay(int i, String str, Object obj, String str2, int i2);

    void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp);

    void onGetPrice(int i, String str, Object obj, int i2, String str2);

    void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp);

    void onWxPay(int i, String str, Object obj, String str2, int i2);
}
