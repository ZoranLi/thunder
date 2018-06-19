package com.xunlei.common.accelerator.bean;

public class XLAccelBandInfo {
    public XLBandWidthInfo mBandWidthInfo;
    public int mCanUpgrade;
    public XLBandWidth mCurrentBandWidth;
    public XLBandWidth mMaxBandWidth;

    public XLAccelBandInfo() {
        this.mCanUpgrade = 0;
        this.mCurrentBandWidth = null;
        this.mMaxBandWidth = null;
        this.mBandWidthInfo = null;
        this.mCurrentBandWidth = new XLBandWidth();
        this.mMaxBandWidth = new XLBandWidth();
        this.mBandWidthInfo = new XLBandWidthInfo();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("mCanUpgrade = ");
        stringBuilder.append(this.mCanUpgrade);
        stringBuilder.append("\nmCurrentBandWidth = ");
        stringBuilder.append(this.mCurrentBandWidth);
        stringBuilder.append("\nmMaxBandWidth = ");
        stringBuilder.append(this.mMaxBandWidth);
        stringBuilder.append("\nmBandwidthInfo = ");
        stringBuilder.append(this.mBandWidthInfo);
        return stringBuilder.toString();
    }
}
