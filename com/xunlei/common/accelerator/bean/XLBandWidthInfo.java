package com.xunlei.common.accelerator.bean;

import com.umeng.message.proguard.k;

public class XLBandWidthInfo {
    public String mDialAccount = "";
    public String mProvince = "";
    public String mProvinceName = "";
    public String mServiceProvider = "";
    public String mServiceProviderName = "";

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("(mServiceProvider = ");
        stringBuilder.append(this.mServiceProvider);
        stringBuilder.append("\nmServiceProviderName = ");
        stringBuilder.append(this.mServiceProviderName);
        stringBuilder.append("\nmDialAccount = ");
        stringBuilder.append(this.mDialAccount);
        stringBuilder.append("\n mProvinceName = ");
        stringBuilder.append(this.mProvinceName);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
