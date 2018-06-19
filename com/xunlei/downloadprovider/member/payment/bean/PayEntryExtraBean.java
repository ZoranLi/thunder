package com.xunlei.downloadprovider.member.payment.bean;

import java.io.Serializable;

public class PayEntryExtraBean implements Serializable {
    private Object extraParam1;
    private Object extraParam2;
    private Object extraParam3;

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

    public Object getExtraParam3() {
        return this.extraParam3;
    }

    public void setExtraParam3(Object obj) {
        this.extraParam3 = obj;
    }
}
