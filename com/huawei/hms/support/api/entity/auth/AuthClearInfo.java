package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class AuthClearInfo implements IMessageEntity {
    public static final int TYPE_CLEAR_ALL = 1;
    public static final int TYPE_CLEAR_APP = 0;
    @a
    private String appID;
    @a
    private int type = 0;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String str) {
        this.appID = str;
    }
}
