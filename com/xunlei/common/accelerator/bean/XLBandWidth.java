package com.xunlei.common.accelerator.bean;

import com.umeng.message.proguard.k;

public class XLBandWidth {
    public long mDownStream = 0;
    public long mUpStream = 0;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("(mUpStream = ");
        stringBuilder.append(this.mUpStream);
        stringBuilder.append(", mDownStream = ");
        stringBuilder.append(this.mDownStream);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
