package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.a.a;

public class ResponseHeader implements IMessageEntity {
    @a
    protected int statusCode;

    public ResponseHeader(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
