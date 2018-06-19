package com.xunlei.common.accelerator.bean;

public class XLAccelTryInfo {
    public int mNumOfTry = 0;
    public int mRemainTime = -1;
    public int mTryDuration = 0;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("mNumOfTry = ");
        stringBuilder.append(this.mNumOfTry);
        stringBuilder.append("\n mTryDuration = ");
        stringBuilder.append(this.mTryDuration);
        return stringBuilder.toString();
    }
}
