package com.xunlei.common.accelerator.bean;

public class AccelInfoResultBean extends BaseResultBean {
    private String dialAccount = "";
    private XLAccelBandInfo xlAccelBandInfo;

    public String getDialAccount() {
        return this.dialAccount;
    }

    public void setDialAccount(String str) {
        this.dialAccount = str;
    }

    public XLAccelBandInfo getXlAccelBandInfo() {
        return this.xlAccelBandInfo;
    }

    public void setXlAccelBandInfo(XLAccelBandInfo xLAccelBandInfo) {
        this.xlAccelBandInfo = xLAccelBandInfo;
    }
}
