package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class AgreementResp implements IMessageEntity {
    @a
    private boolean bAgree = false;
    @a
    private int retCode = 0;

    public boolean isAgree() {
        return this.bAgree;
    }

    public void setAgree(boolean z) {
        this.bAgree = z;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }
}
