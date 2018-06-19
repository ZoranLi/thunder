package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public abstract class AbstractResp implements IMessageEntity {
    @a
    private String errorReason;
    @a
    private int rtnCode = 0;

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void setRtnCode(int i) {
        this.rtnCode = i;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }
}
