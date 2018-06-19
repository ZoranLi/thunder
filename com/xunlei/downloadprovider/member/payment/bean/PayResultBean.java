package com.xunlei.downloadprovider.member.payment.bean;

public class PayResultBean {
    private Object extraParam1;
    private Object extraParam2;
    private boolean isSuccess;

    public Object getExtraParam1() {
        return this.extraParam1;
    }

    public void setExtraParam1(Object obj) {
        this.extraParam1 = obj;
    }

    public Object getExtraParam2() {
        return this.extraParam2;
    }

    public void setExtraParam2(Object obj) {
        this.extraParam2 = obj;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
